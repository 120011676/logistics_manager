package com.logistics.manager.web.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.logistics.manager.entity.CargoEntity;
import com.logistics.manager.entity.CompanyEntity;
import com.logistics.manager.entity.ConsignmentEntity;
import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.ICargoService;
import com.logistics.manager.service.interfaces.ICompanyService;
import com.logistics.manager.service.interfaces.IConsignmentService;
import com.logistics.manager.web.action.base.BaseAction;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping("consignment")
public class ConsignmentAction extends SimpleFormController {

	@Autowired
	private ICompanyService companyService;

	@Autowired
	private IConsignmentService consignmentService;

	@Autowired
	private ICargoService cargoService;

	@InitBinder
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
		super.initBinder(request, binder);

	}

	@RequestMapping("list")
	public String list() {
		BaseAction.getHttpServletRequest().setAttribute("current",
				"consignment");
		BaseAction.getHttpServletRequest().setAttribute("show",
				"consignment_show");
		BaseAction.getHttpServletRequest().setAttribute("subShow",
				"consignment_show_acceptance");
		Map<String, Object> map = new HashMap<>();
		BaseAction.getHttpServletRequest().setAttribute(
				"page",
				this.consignmentService.queryMySqlPage("queryConsignment", map,
						new RowMapper<ConsignmentEntity>() {
							@Override
							public ConsignmentEntity mapRow(
									ResultSet resultSet, int arg1)
									throws SQLException {
								ConsignmentEntity consignment = new ConsignmentEntity();
								consignment.setId(resultSet.getInt("id"));
								consignment.setDatetime(resultSet
										.getDate("datetime"));
								consignment.setConsignor(new CompanyEntity());
								consignment.getConsignor().setPersonalName(
										resultSet.getString("personal_name"));
								consignment.getConsignor().setPhone(
										resultSet.getInt("phone"));
								consignment.setConsignee(new CompanyEntity());
								consignment
										.getConsignee()
										.setPersonalName(
												resultSet
														.getString("ce_personal_name"));
								consignment.getConsignee().setPhone(
										resultSet.getInt("ce_phone"));
								consignment.setCreateUser(new UserEntity());
								consignment.getCreateUser().setName(
										resultSet.getString("name"));
								consignment.setCreateDatetime(resultSet
										.getTimestamp("create_datetime"));
								return consignment;
							}
						}, BaseAction.getNowPage(), BaseAction.getOnePageRows()));
		return "consignment/list";
	}

	@RequestMapping("toUpdate")
	public String toUpdate() {
		return "consignment/update";
	}

	@RequestMapping("update")
	public String update(ConsignmentEntity consignment) {
		Map<String, Object> map = new HashMap<>();
		map.put("personalName", consignment.getConsignor().getPersonalName());
		map.put("companyName", consignment.getConsignor().getCompanyName());
		map.put("address", consignment.getConsignor().getAddress());
		map.put("phone", consignment.getConsignor().getPhone());
		int consignorId = this.companyService.updateReturnPrimaryKey(
				"saveCompany", "id", map);
		map.clear();
		map.put("personalName", consignment.getConsignee().getPersonalName());
		map.put("companyName", consignment.getConsignee().getCompanyName());
		map.put("address", consignment.getConsignee().getAddress());
		map.put("phone", consignment.getConsignee().getPhone());
		int consigneeId = this.companyService.updateReturnPrimaryKey(
				"saveCompany", "id", map);
		map.clear();
		map.put("datetime", consignment.getDatetime());
		map.put("startCity", consignment.getStartCity());
		map.put("arrivalCity", consignment.getArrivalCity());
		map.put("modeOfTransportation", consignment.getModeOfTransportation());
		map.put("serviceMode", consignment.getServiceMode());
		map.put("payment", consignment.getPayment());
		map.put("consignorId", consignorId);
		map.put("consigneeId", consigneeId);
		map.put("chargingWays", consignment.getChargingWays());
		map.put("unitPrice", consignment.getUnitPrice());
		map.put("transportPrice", consignment.getTransportPrice());
		map.put("takeCargoPrice", consignment.getTakeCargoPrice());
		map.put("carryCargoPrice", consignment.getCarryCargoPrice());
		map.put("insurancePrice", consignment.getInsurancePrice());
		map.put("packPrice", consignment.getPackPrice());
		map.put("loadUnloadPrice", consignment.getLoadUnloadPrice());
		map.put("otherPrice", consignment.getOtherPrice());
		map.put("collectionMoney", consignment.getCollectionMoney());
		map.put("collectionMoneyCharge", consignment.getCollectionMoneyCharge());
		map.put("returnPrice", consignment.getReturnPrice());
		map.put("createUserId", BaseAction.getLoginUser().getId());
		int consignmentId = this.consignmentService.updateReturnPrimaryKey(
				"saveConsignment", "id", map);
		for (CargoEntity cargo : consignment.getCargos()) {
			map.clear();
			map.put("consignmentId", consignmentId);
			map.put("commodityName", cargo.getCommodityName());

			map.put("pack", cargo.getPack());
			map.put("numberOfPackages", cargo.getNumberOfPackages());
			map.put("weight", cargo.getWeight());
			map.put("weight", cargo.getWeight());
			map.put("volume", cargo.getVolume());
			map.put("statementValue", cargo.getStatementValue());
			this.cargoService.update("saveCargo", map);
		}
		return this.list();
	}
}
