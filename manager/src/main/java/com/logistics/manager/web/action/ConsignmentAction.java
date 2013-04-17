package com.logistics.manager.web.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.qq120011676.snow.properties.ProjectProperties;
import org.qq120011676.snow.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.logistics.manager.entity.ConsignmentEntity;
import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.IConsignmentService;
import com.logistics.manager.utils.HSSFCellHelper;
import com.logistics.manager.utils.MoneyUtils;
import com.logistics.manager.utils.ResultSetHelper;
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
										.getString("status"));
								consignment.setEnable(resultSet
										.getBoolean("enable"));
								return consignment;
							}
						}, BaseAction.getNowPage(), BaseAction.getOnePageRows()));
		return "consignment/list";
	}

	@RequestMapping("toUpdate")
	public String toUpdate(Integer id) {
		if (id != null) {
			BaseAction.getHttpServletRequest().setAttribute("consignment",
					get(id));
		}
		BaseAction.getHttpServletRequest().setAttribute("collection",
				ProjectProperties.getConfigToDouble("collection"));
		return "consignment/update";
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
						consignment.setStatus(resultSet.getString("status"));
						consignment.setOrderNumber(resultSet
								.getString("order_number"));
						return consignment;
					}
				});
	}

	@RequestMapping("update")
	public String update(ConsignmentEntity consignment) {
		Map<String, Object> map = new HashMap<>();
		map.put("orderNumber", consignment.getOrderNumber());
		map.put("status", consignment.getStatus());
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
		map.put("returnPrice", consignment.getReturnPrice());
		if (consignment.getId() == null) {
			map.put("createUserId", BaseAction.getLoginUser().getId());
			this.consignmentService.update("saveConsignment", map);
		} else {
			map.put("id", consignment.getId());
			this.consignmentService.update("updateConsignment", map);
		}
		return "redirect：/consignment/list.htm";
	}

	@RequestMapping("delete")
	public String delete(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("enable", false);
		this.consignmentService.update("updateConsignmentByEnable", map);
		return "redirect：/consignment/list.htm";
	}

	@RequestMapping("recovery")
	public String recovery(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("enable", true);
		this.consignmentService.update("updateConsignmentByEnable", map);
		return "redirect：/consignment/list.htm";
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
		return "/consignment/look";
	}

	@RequestMapping("delivery")
	public String delivery(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("status", 1);
		this.consignmentService.update("updateConsignmentByEnable", map);
		return "redirect：/consignment/list.htm";
	}

	@RequestMapping("ajaxCheck")
	@ResponseBody
	public String ajaxCheck(String orderNumber, Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("orderNumber", orderNumber);
		if (id != null) {
			map.put("id", id);
		}
		SqlRowSet sqlRowSet = this.consignmentService.queryForRowSet(
				"ajaxCheckConsignmentByOrderNumber", map);
		if (sqlRowSet.next()) {
			if (sqlRowSet.getInt("c") > 0) {
				return "false";
			}
		}
		return "true";
	}

	@RequestMapping("alert/shipper")
	public String shipper(String shipper) {
		Map<String, Object> map = new HashMap<>();
		if (!StringUtils.isNull(shipper)) {
			map.put("shipper", "%" + shipper + "%");
			BaseAction.getHttpServletRequest().setAttribute("shipper", shipper);
		}
		BaseAction.getHttpServletRequest().setAttribute(
				"page",
				this.consignmentService.queryMySqlPage("queryShipper", map,
						new RowMapper<ConsignmentEntity>() {
							@Override
							public ConsignmentEntity mapRow(ResultSet rs,
									int arg1) throws SQLException {
								ConsignmentEntity consignment = new ConsignmentEntity();
								consignment.setShipper(rs.getString("shipper"));
								consignment.setShipperAddress(rs
										.getString("shipper_address"));
								consignment.setShipperPhone(rs
										.getString("shipper_phone"));
								consignment.setShipperUnit(rs
										.getString("shipper_unit"));
								return consignment;
							}
						}, BaseAction.getNowPage(), BaseAction.getOnePageRows()));
		return "consignment/alert/shipper";
	}

	@RequestMapping("alert/consignee")
	public String consignee(String consignee) {
		Map<String, Object> map = new HashMap<>();
		if (!StringUtils.isNull(consignee)) {
			map.put("consignee", "%" + consignee + "%");
			BaseAction.getHttpServletRequest().setAttribute("consignee",
					consignee);
		}
		BaseAction.getHttpServletRequest().setAttribute(
				"page",
				this.consignmentService.queryMySqlPage("queryConsignee", map,
						new RowMapper<ConsignmentEntity>() {
							@Override
							public ConsignmentEntity mapRow(ResultSet rs,
									int arg1) throws SQLException {
								ConsignmentEntity consignment = new ConsignmentEntity();
								consignment.setConsignee(rs
										.getString("consignee"));
								consignment.setConsigneeAddress(rs
										.getString("consignee_address"));
								consignment.setConsigneePhone(rs
										.getString("consignee_phone"));
								consignment.setConsigneeUnit(rs
										.getString("consignee_unit"));
								return consignment;
							}
						}, BaseAction.getNowPage(), BaseAction.getOnePageRows()));
		return "consignment/alert/consignee";
	}

	@RequestMapping("download")
	public void download(int id, HttpServletResponse response)
			throws IOException {
		ConsignmentEntity c = get(id);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		int r = 0;
		HSSFRow row = sheet.createRow(r);
		HSSFCell cell = row.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(r, r, 0, 9));
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 12);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("成都道成物流有限公司");
		r = 1;
		row = sheet.createRow(r);
		cell = row.createCell(0);
		cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cell.setCellStyle(cellStyle);
		sheet.addMergedRegion(new CellRangeAddress(r, r, 0, 9));
		StringBuilder stringBuilder = new StringBuilder();
		String temp = "     ";
		stringBuilder.append(
				new SimpleDateFormat("yyyy年MM月dd日").format(c.getDatetime()))
				.append(temp);
		stringBuilder.append("发站：" + c.getStartCity()).append(temp);
		stringBuilder.append("到站：" + c.getArrivalCity()).append(temp);
		stringBuilder.append("运输方式：" + c.getModeOfTransportation())
				.append(temp);
		stringBuilder.append("服务方式：" + c.getServiceMode()).append(temp);
		stringBuilder.append("付款方式：" + c.getPayment()).append(temp);
		cell.setCellValue(stringBuilder.toString().trim());
		r = 2;
		row = sheet.createRow(r);
		cell = row.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(r, 5, 0, 0));
		cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("发\r\n货\r\n人");
		sheet.addMergedRegion(new CellRangeAddress(r, 5, 5, 5));
		row.createCell(1).setCellValue("托 运  人：" + c.getShipper());
		sheet.addMergedRegion(new CellRangeAddress(r, r, 1, 4));
		HSSFCell c25 = row.createCell(5);
		c25.setCellStyle(cellStyle);
		c25.setCellValue("收\r\n货\r\n人");
		row.createCell(6).setCellValue("收 货  人：" + c.getConsignee());
		sheet.addMergedRegion(new CellRangeAddress(r, r, 6, 9));
		r = 3;
		row = sheet.createRow(r);
		sheet.addMergedRegion(new CellRangeAddress(r, r, 1, 4));
		row.createCell(1).setCellValue("托运单位：" + c.getShipperUnit());
		sheet.addMergedRegion(new CellRangeAddress(r, r, 6, 9));
		row.createCell(6).setCellValue("收货单位：" + c.getConsigneeUnit());
		r = 4;
		row = sheet.createRow(r);
		sheet.addMergedRegion(new CellRangeAddress(r, r, 1, 4));
		row.createCell(1).setCellValue("地      址：" + c.getShipperAddress());
		sheet.addMergedRegion(new CellRangeAddress(r, r, 6, 9));
		row.createCell(6).setCellValue("地      址：" + c.getConsigneeAddress());
		r = 5;
		row = sheet.createRow(r);
		sheet.addMergedRegion(new CellRangeAddress(r, r, 1, 4));
		row.createCell(1).setCellValue("电      话：" + c.getShipperPhone());
		sheet.addMergedRegion(new CellRangeAddress(r, r, 6, 9));
		row.createCell(6).setCellValue("电      话：" + c.getConsigneePhone());
		cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		r = 6;
		row = sheet.createRow(r);
		new HSSFCellHelper(row.createCell(0)).setCellStyle(cellStyle)
				.setCellValue("品名");
		new HSSFCellHelper(row.createCell(1)).setCellStyle(cellStyle)
				.setCellValue("包装");
		new HSSFCellHelper(row.createCell(2)).setCellStyle(cellStyle)
				.setCellValue("件数");
		new HSSFCellHelper(row.createCell(3)).setCellStyle(cellStyle)
				.setCellValue("重量(KG)");
		new HSSFCellHelper(row.createCell(4)).setCellStyle(cellStyle)
				.setCellValue("体积(M)");
		new HSSFCellHelper(row.createCell(5)).setCellStyle(cellStyle)
				.setCellValue("声明价值(元)");
		sheet.addMergedRegion(new CellRangeAddress(r, r, 6, 8));
		row.createCell(6).setCellValue("计费方式：" + c.getChargingWays());
		row.createCell(9).setCellValue("单价：" + c.getUnitPrice());
		r = 7;
		row = sheet.createRow(r);
		new HSSFCellHelper(row.createCell(0)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityNameOne());
		new HSSFCellHelper(row.createCell(1)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityPackageOne());
		new HSSFCellHelper(row.createCell(2)).setCellStyle(cellStyle)
				.setCellValue(formatInteger(c.getCommodityPackageNumberOne()));
		new HSSFCellHelper(row.createCell(3)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWeightOne()));
		new HSSFCellHelper(row.createCell(4)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityVolumeOne()));
		new HSSFCellHelper(row.createCell(5)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWorthOne()));
		new HSSFCellHelper(row.createCell(6)).setCellStyle(cellStyle)
				.setCellValue("运  费");
		new HSSFCellHelper(row.createCell(7)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getTransportPrice()));
		new HSSFCellHelper(row.createCell(8)).setCellStyle(cellStyle)
				.setCellValue("装卸费");
		new HSSFCellHelper(row.createCell(9)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getLoadUnloadPrice()));
		r = 8;
		row = sheet.createRow(r);
		new HSSFCellHelper(row.createCell(0)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityNameTwo());
		new HSSFCellHelper(row.createCell(1)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityPackageTwo());
		new HSSFCellHelper(row.createCell(2)).setCellStyle(cellStyle)
				.setCellValue(formatInteger(c.getCommodityPackageNumberTwo()));
		new HSSFCellHelper(row.createCell(3)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWeightTwo()));
		new HSSFCellHelper(row.createCell(4)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityVolumeTwo()));
		new HSSFCellHelper(row.createCell(5)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWorthTwo()));
		new HSSFCellHelper(row.createCell(6)).setCellStyle(cellStyle)
				.setCellValue("取货费");
		new HSSFCellHelper(row.createCell(7)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getTakeCargoPrice()));
		new HSSFCellHelper(row.createCell(8)).setCellStyle(cellStyle)
				.setCellValue("其他费");
		new HSSFCellHelper(row.createCell(9)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getOtherPrice()));
		r = 9;
		row = sheet.createRow(r);
		new HSSFCellHelper(row.createCell(0)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityNameThree());
		new HSSFCellHelper(row.createCell(1)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityPackageThree());
		new HSSFCellHelper(row.createCell(2))
				.setCellStyle(cellStyle)
				.setCellValue(formatInteger(c.getCommodityPackageNumberThree()));
		new HSSFCellHelper(row.createCell(3)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWeightThree()));
		new HSSFCellHelper(row.createCell(4)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityVolumeThree()));
		new HSSFCellHelper(row.createCell(5)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWorthThree()));
		new HSSFCellHelper(row.createCell(6)).setCellStyle(cellStyle)
				.setCellValue("送货费");
		new HSSFCellHelper(row.createCell(7)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCarryCargoPrice()));
		new HSSFCellHelper(row.createCell(8)).setCellStyle(cellStyle)
				.setCellValue("代收款");
		new HSSFCellHelper(row.createCell(9)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCollectionMoney()));
		r = 10;
		row = sheet.createRow(r);
		new HSSFCellHelper(row.createCell(0)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityNameFour());
		new HSSFCellHelper(row.createCell(1)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityPackageFour());
		new HSSFCellHelper(row.createCell(2)).setCellStyle(cellStyle)
				.setCellValue(formatInteger(c.getCommodityPackageNumberFour()));
		new HSSFCellHelper(row.createCell(3)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWeightFour()));
		new HSSFCellHelper(row.createCell(4)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityVolumeFour()));
		new HSSFCellHelper(row.createCell(5)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWorthFour()));
		new HSSFCellHelper(row.createCell(6)).setCellStyle(cellStyle)
				.setCellValue("保险费");
		new HSSFCellHelper(row.createCell(7)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getInsurancePrice()));
		HSSFCellStyle cellStyleTemp = wb.createCellStyle();
		cellStyleTemp.cloneStyleFrom(cellStyle);
		cellStyleTemp.setWrapText(true);
		new HSSFCellHelper(row.createCell(8)).setCellStyle(cellStyleTemp)
				.setCellValue("代收款\r\n手续费");
		new HSSFCellHelper(row.createCell(9)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCollectionMoneyCharge()));
		r = 11;
		row = sheet.createRow(r);
		new HSSFCellHelper(row.createCell(0)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityNameFive());
		new HSSFCellHelper(row.createCell(1)).setCellStyle(cellStyle)
				.setCellValue(c.getCommodityPackageFive());
		new HSSFCellHelper(row.createCell(2)).setCellStyle(cellStyle)
				.setCellValue(formatInteger(c.getCommodityPackageNumberFive()));
		new HSSFCellHelper(row.createCell(3)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWeightFive()));
		new HSSFCellHelper(row.createCell(4)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityVolumeFive()));
		new HSSFCellHelper(row.createCell(5)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getCommodityWorthFive()));
		new HSSFCellHelper(row.createCell(6)).setCellStyle(cellStyle)
				.setCellValue("包装费");
		new HSSFCellHelper(row.createCell(7)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getPackPrice()));
		cellStyleTemp = wb.createCellStyle();
		cellStyleTemp.cloneStyleFrom(cellStyle);
		cellStyleTemp.setWrapText(true);
		new HSSFCellHelper(row.createCell(8)).setCellStyle(cellStyleTemp)
				.setCellValue("返    单\r\n手续费");
		new HSSFCellHelper(row.createCell(9)).setCellStyle(cellStyle)
				.setCellValue(formatDouble(c.getReturnPrice()));
		r = 12;
		row = sheet.createRow(r);
		sheet.addMergedRegion(new CellRangeAddress(r, r, 0, 9));
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
		row.createCell(0)
				.setCellValue(
						"费用总计："
								+ MoneyUtils.digitUppercase(bigDecimal
										.doubleValue())
								+ "                                                                         "
								+ "￥"
								+ String.format("%.2f",
										bigDecimal.doubleValue()) + "元");
		response.setHeader("Content-disposition", "attachment;filename="
				+ URLEncoder.encode(c.getOrderNumber() + ".xls", "UTF-8"));
		response.setContentType("application/msexcel;charset=UTF-8");
		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	private String formatInteger(Integer value) {
		return value == null ? "" : value + "";
	}

	private String formatDouble(Double value) {
		return value == null ? "" : value + "";
	}
}
