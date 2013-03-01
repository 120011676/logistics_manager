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

import com.logistics.manager.entity.ConsignmentEntity;
import com.logistics.manager.entity.UserEntity;
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
								consignment.setStartCity(resultSet
										.getString("start_city"));
								consignment.setArrivalCity(resultSet
										.getString("arrival_city"));
								consignment.setModeOfTransportation(resultSet
										.getString("mode_of_transportation"));
								consignment.setServiceMode(resultSet
										.getString("service_mode"));
								consignment.setPayment(resultSet
										.getString("payment"));
								consignment.setShipper(resultSet
										.getString("shipper"));
								consignment.setShipperUnit(resultSet
										.getString("shipper_unit"));
								consignment.setShipperAddress(resultSet
										.getString("shipper_address"));
								consignment.setShipperPhone(resultSet
										.getString("shipper_phone"));
								consignment.setConsignee(resultSet
										.getString("consignee"));
								consignment.setConsigneeUnit(resultSet
										.getString("consignee_unit"));
								consignment.setConsigneeAddress(resultSet
										.getString("consignee_address"));
								consignment.setConsigneePhone(resultSet
										.getString("consignee_phone"));
								consignment.setCreateUser(new UserEntity());
								consignment.getCreateUser().setId(
										resultSet.getInt("create_user_id"));
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
	public String toUpdate(Integer id) {
		if (id != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			BaseAction.getHttpServletRequest().setAttribute(
					"consignment",
					this.consignmentService.queryForObject("queryConsignment",
							map, new RowMapper<ConsignmentEntity>() {
								@Override
								public ConsignmentEntity mapRow(
										ResultSet resultSet, int arg1)
										throws SQLException {
									ConsignmentEntity consignment = new ConsignmentEntity();
									consignment.setId(resultSet.getInt("id"));
									consignment.setDatetime(resultSet
											.getDate("datetime"));
									consignment.setStartCity(resultSet
											.getString("start_city"));
									consignment.setArrivalCity(resultSet
											.getString("arrival_city"));
									consignment.setModeOfTransportation(resultSet
											.getString("mode_of_transportation"));
									consignment.setServiceMode(resultSet
											.getString("service_mode"));
									consignment.setPayment(resultSet
											.getString("payment"));
									consignment.setShipper(resultSet
											.getString("shipper"));
									consignment.setShipperUnit(resultSet
											.getString("shipper_unit"));
									consignment.setShipperAddress(resultSet
											.getString("shipper_address"));
									consignment.setShipperPhone(resultSet
											.getString("shipper_phone"));
									consignment.setConsignee(resultSet
											.getString("consignee"));
									consignment.setConsigneeUnit(resultSet
											.getString("consignee_unit"));
									consignment.setConsigneeAddress(resultSet
											.getString("consignee_address"));
									consignment.setConsigneePhone(resultSet
											.getString("consignee_phone"));
									consignment.setCommodityNameOne(resultSet
											.getString("commodity_name_one"));
									consignment.setCommodityNameTwo(resultSet
											.getString("commodity_name_two"));
									consignment.setCommodityNameThree(resultSet
											.getString("commodity_name_three"));
									consignment.setCommodityNameFour(resultSet
											.getString("commodity_name_four"));
									consignment.setCommodityNameFive(resultSet
											.getString("commodity_name_five"));
									consignment.setCommodityPackageOne(resultSet
											.getString("commodity_package_one"));
									consignment.setCommodityPackageTwo(resultSet
											.getString("commodity_package_two"));
									consignment.setCommodityPackageThree(resultSet
											.getString("commodity_package_three"));
									consignment.setCommodityPackageFour(resultSet
											.getString("commodity_package_four"));
									consignment.setCommodityPackageFive(resultSet
											.getString("commodity_package_five"));
									consignment
											.setCommodityPackageNumberOne(resultSet
													.getInt("commodity_package_number_one"));
									consignment
											.setCommodityPackageNumberTwo(resultSet
													.getInt("commodity_package_number_two"));
									consignment
											.setCommodityPackageNumberThree(resultSet
													.getInt("commodity_package_number_three"));
									consignment
											.setCommodityPackageNumberFour(resultSet
													.getInt("commodity_package_number_four"));
									consignment
											.setCommodityPackageNumberFive(resultSet
													.getInt("commodity_package_number_five"));
									consignment.setCommodityWeightOne(resultSet
											.getDouble("commodity_weight_one"));
									consignment.setCommodityWeightTwo(resultSet
											.getDouble("commodity_weight_two"));
									consignment.setCommodityWeightThree(resultSet
											.getDouble("commodity_weight_three"));
									consignment.setCommodityWeightFour(resultSet
											.getDouble("commodity_weight_four"));
									consignment.setCommodityWeightFive(resultSet
											.getDouble("commodity_weight_five"));
									consignment.setCommodityVolumeOne(resultSet
											.getDouble("commodity_volume_one"));
									consignment.setCommodityVolumeTwo(resultSet
											.getDouble("commodity_volume_two"));
									consignment.setCommodityVolumeThree(resultSet
											.getDouble("commodity_volume_three"));
									consignment.setCommodityVolumeFour(resultSet
											.getDouble("commodity_volume_four"));
									consignment.setCommodityVolumeFive(resultSet
											.getDouble("commodity_volume_five"));
									consignment.setCommodityWorthOne(resultSet
											.getDouble("commodity_worth_one"));
									consignment.setCommodityWorthTwo(resultSet
											.getDouble("commodity_worth_two"));
									consignment.setCommodityWorthThree(resultSet
											.getDouble("commodity_worth_three"));
									consignment.setCommodityWorthFour(resultSet
											.getDouble("commodity_worth_four"));
									consignment.setCommodityWorthFive(resultSet
											.getDouble("commodity_worth_five"));
									consignment.setChargingWays(resultSet
											.getString("charging_ways"));
									consignment.setUnitPrice(resultSet
											.getDouble("unit_price"));
									consignment.setTransportPrice(resultSet
											.getDouble("transport_price"));
									consignment.setTakeCargoPrice(resultSet
											.getDouble("take_cargo_price"));
									consignment.setCarryCargoPrice(resultSet
											.getDouble("carry_cargo_price"));
									consignment.setInsurancePrice(resultSet
											.getDouble("insurance_price"));
									consignment.setPackPrice(resultSet
											.getDouble("pack_price"));
									consignment.setLoadUnloadPrice(resultSet
											.getDouble("load_unload_price"));
									consignment.setOtherPrice(resultSet
											.getDouble("other_price"));
									consignment.setCollectionMoney(resultSet
											.getDouble("collection_money"));
									consignment.setCollectionMoneyCharge(resultSet
											.getDouble("collection_money_charge"));
									consignment.setCreateUser(new UserEntity());
									consignment.getCreateUser().setId(
											resultSet.getInt("create_user_id"));
									consignment.getCreateUser().setName(
											resultSet.getString("name"));
									consignment.setCreateDatetime(resultSet
											.getTimestamp("create_datetime"));
									return consignment;
								}
							}));
		}
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
		if (consignment.getId() == null) {
			map.put("createUserId", BaseAction.getLoginUser().getId());
			this.consignmentService.update("saveConsignment", map);
		} else {

		}
		return this.list();
	}
}
