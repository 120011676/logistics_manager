package com.logistics.manager.web.action;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.qq120011676.snow.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logistics.manager.entity.ConsignmentEntity;
import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.IConsignmentService;
import com.logistics.manager.utils.ResultSetHelper;
import com.logistics.manager.web.action.base.BaseAction;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
@Controller
@RequestMapping("all")
public class AllAction {

	@Autowired
	private IConsignmentService consignmentService;

	@RequestMapping("list")
	public String list(String orderNumber, String consignee) {
		Map<String, Object> map = new HashMap<>();
		if (!StringUtils.isNull(orderNumber)) {
			map.put("orderNumber", "%" + orderNumber + "%");
			BaseAction.getHttpServletRequest().setAttribute("orderNumber",
					orderNumber);
		}
		if (!StringUtils.isNull(consignee)) {
			map.put("consignee", "%" + consignee + "%");
			BaseAction.getHttpServletRequest().setAttribute("consignee",
					consignee);
		}
		BaseAction.getHttpServletRequest().setAttribute(
				"page",
				this.consignmentService.queryMySqlPage("queryConsignment", map,
						new RowMapper<ConsignmentEntity>() {
							@Override
							public ConsignmentEntity mapRow(
									ResultSet resultSet, int arg1)
									throws SQLException {
								ConsignmentEntity consignment = new ConsignmentEntity();
								consignment.setOrderNumber(resultSet
										.getString("order_number"));
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
								consignment.setStatus(resultSet
										.getInt("status"));
								consignment.setEnable(resultSet
										.getBoolean("enable"));
								return consignment;
							}
						}, BaseAction.getNowPage(), BaseAction.getOnePageRows()));
		return "all/list";
	}

	@RequestMapping("delete")
	public String delete(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("enable", false);
		this.consignmentService.update("updateConsignmentByEnable", map);
		return "redirect:/all/list.htm";
	}

	@RequestMapping("recovery")
	public String recovery(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("enable", true);
		this.consignmentService.update("updateConsignmentByEnable", map);
		return "redirect:/all/list.htm";
	}

	@RequestMapping("look")
	public String look(Integer id) {
		ConsignmentEntity c = get(id);
		BaseAction.getHttpServletRequest().setAttribute("consignment", c);
		BigDecimal bigDecimal = new BigDecimal(0);
		if (c.getTransportPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getTransportPrice()));
		}
		if (c.getTakeCargoPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getTakeCargoPrice()));
		}
		if (c.getCarryCargoPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getCarryCargoPrice()));
		}
		if (c.getInsurancePrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getInsurancePrice()));
		}
		if (c.getPackPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getPackPrice()));
		}
		if (c.getLoadUnloadPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getLoadUnloadPrice()));
		}
		if (c.getOtherPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getOtherPrice()));
		}
		if (c.getCollectionMoneyCharge() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c
					.getCollectionMoneyCharge()));
		}
		if (c.getReturnPrice() != null) {
			bigDecimal = bigDecimal.add(new BigDecimal(c.getReturnPrice()));
		}
		BaseAction.getHttpServletRequest().setAttribute("total",
				bigDecimal.doubleValue());
		return "all/look";
	}

	private ConsignmentEntity get(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return this.consignmentService.queryForObject("queryConsignment", map,
				new RowMapper<ConsignmentEntity>() {
					@Override
					public ConsignmentEntity mapRow(ResultSet rs, int arg1)
							throws SQLException {
						ResultSetHelper resultSet = new ResultSetHelper(rs);
						ConsignmentEntity consignment = new ConsignmentEntity();
						consignment.setId(resultSet.getInt("id"));
						consignment.setDatetime(resultSet.getDate("datetime"));
						consignment.setStartCity(resultSet
								.getString("start_city"));
						consignment.setArrivalCity(resultSet
								.getString("arrival_city"));
						consignment.setModeOfTransportation(resultSet
								.getString("mode_of_transportation"));
						consignment.setServiceMode(resultSet
								.getString("service_mode"));
						consignment.setPayment(resultSet.getString("payment"));
						consignment.setShipper(resultSet.getString("shipper"));
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

						consignment.setCommodityPackageNumberOne(resultSet
								.getInt("commodity_package_number_one"));
						consignment.setCommodityPackageNumberTwo(resultSet
								.getInt("commodity_package_number_two"));
						consignment.setCommodityPackageNumberThree(resultSet
								.getInt("commodity_package_number_three"));
						consignment.setCommodityPackageNumberFour(resultSet
								.getInt("commodity_package_number_four"));
						consignment.setCommodityPackageNumberFive(resultSet
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
						consignment.setReturnPrice(resultSet
								.getDouble("return_price"));
						consignment.setCreateUser(new UserEntity());
						consignment.getCreateUser().setId(
								resultSet.getInt("create_user_id"));
						consignment.getCreateUser().setName(
								resultSet.getString("name"));
						consignment.setCreateDatetime(resultSet
								.getTimestamp("create_datetime"));
						consignment.setStatus(resultSet.getInt("status"));
						consignment.setSignShipper(resultSet
								.getString("sign_shipper"));
						consignment.setSignCarrier(resultSet
								.getString("sign_carrier"));
						consignment.setSignConsignee(resultSet
								.getString("sign_consignee"));
						consignment.setSignDatetime(resultSet
								.getDate("sign_datetime"));
						return consignment;
					}
				});
	}
}
