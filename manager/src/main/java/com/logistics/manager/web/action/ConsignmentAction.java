package com.logistics.manager.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.qq120011676.snow.util.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.logistics.manager.entity.ConsignmentEntity;
import com.logistics.manager.service.interfaces.IConsignmentService;
import com.logistics.manager.web.action.base.BaseAction;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping("consignment")
public class ConsignmentAction extends SimpleFormController {

	@Autowired
	private IConsignmentService consignmentService;

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
		// BaseAction.getHttpServletRequest().setAttribute(
		// "page",
		// this.consignmentService.queryMySqlPage("queryConsignment", map,
		// new RowMapper<ConsignmentEntity>() {
		// @Override
		// public ConsignmentEntity mapRow(
		// ResultSet resultSet, int arg1)
		// throws SQLException {
		// ConsignmentEntity consignment = new ConsignmentEntity();
		// // consignment.setId(resultSet.getInt("id"));
		// // consignment.setDate(resultSet.getDate("date"));
		// // consignment.setConsignor(new
		// // CompanyEntity());
		// // consignment.getConsignor().setPersonalName(
		// // resultSet.getString("personal_name"));
		// // consignment.getConsignor().setPhone(
		// // resultSet.getInt("phone"));
		// // consignment.setConsignee(new
		// // CompanyEntity());
		// // consignment
		// // .getConsignee()
		// // .setPersonalName(
		// // resultSet
		// // .getString("ce_personal_name"));
		// // consignment.getConsignee().setPhone(
		// // resultSet.getInt("ce_phone"));
		// // consignment.setCreateUser(new UserEntity());
		// // consignment.getCreateUser().setName(
		// // resultSet.getString("name"));
		// // consignment.setCreateDatetime(resultSet
		// // .getTimestamp("create_datetime"));
		// return consignment;
		// }
		// }, BaseAction.getNowPage(), BaseAction.getOnePageRows()));
		return "consignment/list";
	}

	@RequestMapping("toUpdate")
	public String toUpdate() {
		return "consignment/update";
	}

	@RequestMapping("update")
	public String update(ConsignmentEntity consignment) {
		Map<String, Object> map = new HashMap<>();
		map.put("datetime", consignment.getDatetime());
		map.put("startCity", consignment.getStartCity());
		map.put("arrivalCity", consignment.getArrivalCity());
		map.put("modeOfTransportation", consignment.getModeOfTransportation());
		map.put("serviceMode", consignment.getServiceMode());
		map.put("payment", consignment.getPayment());
		map.put("shipper", consignment.getShipper());
		map.put("shipperUnit", consignment.getShipperUnit());
		map.put("shipperAddress", consignment.getShipperAddress());
		map.put("shipperPhone", consignment.getShipperPhone());
		map.put("consignee", consignment.getConsignee());
		map.put("consigneeUnit", consignment.getConsigneeUnit());
		map.put("consigneeAddress", consignment.getConsigneeAddress());
		map.put("consigneePhone", consignment.getConsigneePhone());
		map.put("commodityNameOne", consignment.getCommodityNameOne());
		map.put("commodityNameTwo", consignment.getCommodityNameTwo());
		map.put("commodityNameThree", consignment.getCommodityNameThree());
		map.put("commodityNameFour", consignment.getCommodityNameFour());
		map.put("commodityNameFive", consignment.getCommodityNameFive());
		map.put("commodityPackageOne", consignment.getCommodityPackageOne());
		map.put("commodityPackageTwo", consignment.getCommodityPackageTwo());
		map.put("commodityPackageThree", consignment.getCommodityPackageThree());
		map.put("commodityPackageFour", consignment.getCommodityPackageFour());
		map.put("commodityPackageFive", consignment.getCommodityPackageFive());
		map.put("commodityPackageNumberOne",
				consignment.getCommodityPackageNumberOne());
		map.put("commodityPackageNumberTwo",
				consignment.getCommodityPackageNumberTwo());
		map.put("commodityPackageNumberThree",
				consignment.getCommodityPackageNumberThree());
		map.put("commodityPackageNumberFour",
				consignment.getCommodityPackageNumberFour());
		map.put("commodityPackageNumberFive",
				consignment.getCommodityPackageNumberFive());
		map.put("commodityWeightOne", consignment.getCommodityWeightOne());
		map.put("commodityWeightTwo", consignment.getCommodityWeightTwo());
		map.put("commodityWeightThree", consignment.getCommodityWeightThree());
		map.put("commodityWeightFour", consignment.getCommodityWeightFour());
		map.put("commodityWeightFive", consignment.getCommodityWeightFive());
		map.put("commodityVolumeOne", consignment.getCommodityVolumeOne());
		map.put("commodityVolumeTwo", consignment.getCommodityVolumeTwo());
		map.put("commodityVolumeThree", consignment.getCommodityVolumeThree());
		map.put("commodityVolumeFour", consignment.getCommodityVolumeFour());
		map.put("commodityVolumeFive", consignment.getCommodityVolumeFive());
		map.put("commodityWorthOne", consignment.getCommodityWorthOne());
		map.put("commodityWorthTwo", consignment.getCommodityWorthTwo());
		map.put("commodityWorthThree", consignment.getCommodityWorthThree());
		map.put("commodityWorthFour", consignment.getCommodityWorthFour());
		map.put("commodityWorthFive", consignment.getCommodityWorthFive());
		map.put("commodityWorthOne", consignment.getCommodityWorthOne());
		map.put("commodityWorthTwo", consignment.getCommodityWorthTwo());
		map.put("commodityWorthThree", consignment.getCommodityWorthThree());
		map.put("commodityWorthFour", consignment.getCommodityWorthFour());
		map.put("commodityWorthFive", consignment.getCommodityWorthFive());
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
		map.put("createUserId", BaseAction.getLoginUser().getId());
		this.consignmentService.update("saveConsignment", map);
		return this.list();
	}
}
