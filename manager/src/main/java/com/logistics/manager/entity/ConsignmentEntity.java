package com.logistics.manager.entity;

import java.util.Date;

public class ConsignmentEntity {

	private Integer id;
	
	private Date datetime;// 日期

	private String startCity;//发站

	private String arrivalCity;//到站

	private String modeOfTransportation;// 运输方式

	private String serviceMode;// 服务方式

	private String payment;// 付款方式

	private String shipper;//托运人
	
	private String shipperUnit;//托运单位
	
	private String shipperAddress;//托运人地址
	
	private String shipperPhone;//托运人电话
	
	private String consignee;//收货人
	
	private String consigneeUnit;//收货单位
	
	private String consigneeAddress;//收货地址
	
	private String consigneePhone;//收货电话
	
	private String commodityNameOne;//品名1
	
	private String commodityNameTwo;//品名2
	
	private String commodityNameThree;//品名3
	
	private String commodityNameFour;//品名4
	
	private String commodityNameFive;//品名5
	
	private String commodityPackageOne;//包装1
	
	private String commodityPackageTwo;//包装2
	
	private String commodityPackageThree;//包装3
	
	private String commodityPackageFour;//包装4
	
	private String commodityPackageFive;//包装5
	
	private Integer commodityPackageNumberOne;//件数1
	
	private Integer commodityPackageNumberTwo;//件数2
	
	private Integer commodityPackageNumberThree;//件数3
	
	private Integer commodityPackageNumberFour;//件数4
	
	private Integer commodityPackageNumberFive;//件数5
	
	private Double commodityWeightOne;//重量1
	
	private Double commodityWeightTwo;//重量2
	
	private Double commodityWeightThree;//重量3
	
	private Double commodityWeightFour;//重量4
	
	private Double commodityWeightFive;//重量5
	
	private Double commodityVolumeOne;//体积1
	
	private Double commodityVolumeTwo;//体积2
	
	private Double commodityVolumeThree;//体积3
	
	private Double commodityVolumeFour;//体积4
	
	private Double commodityVolumeFive;//体积5
	
	private Double commodityWorthOne;//声明价值1
	
	private Double commodityWorthTwo;//声明价值2
	
	private Double commodityWorthThree;//声明价值3
	
	private Double commodityWorthFour;//声明价值4
	
	private Double commodityWorthFive;//声明价值5
	
	private String chargingWays;// 计费方式

	private Double unitPrice;// 单价

	private Double transportPrice;// 运费

	private Double takeCargoPrice;// 取货费

	private Double carryCargoPrice;// 送货费

	private Double insurancePrice;// 保险费

	private Double packPrice;// 包装费

	private Double loadUnloadPrice;// 装卸费

	private Double otherPrice;// 其他费

	private Double collectionMoney;// 代收款

	private Double collectionMoneyCharge;// 代收款手续费

	private Double returnPrice;// 返单手续费
	
	private Date createDatetime;

	private UserEntity createUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getModeOfTransportation() {
		return modeOfTransportation;
	}

	public void setModeOfTransportation(String modeOfTransportation) {
		this.modeOfTransportation = modeOfTransportation;
	}

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getShipperUnit() {
		return shipperUnit;
	}

	public void setShipperUnit(String shipperUnit) {
		this.shipperUnit = shipperUnit;
	}

	public String getShipperAddress() {
		return shipperAddress;
	}

	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}

	public String getShipperPhone() {
		return shipperPhone;
	}

	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeUnit() {
		return consigneeUnit;
	}

	public void setConsigneeUnit(String consigneeUnit) {
		this.consigneeUnit = consigneeUnit;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getCommodityNameOne() {
		return commodityNameOne;
	}

	public void setCommodityNameOne(String commodityNameOne) {
		this.commodityNameOne = commodityNameOne;
	}

	public String getCommodityNameTwo() {
		return commodityNameTwo;
	}

	public void setCommodityNameTwo(String commodityNameTwo) {
		this.commodityNameTwo = commodityNameTwo;
	}

	public String getCommodityNameThree() {
		return commodityNameThree;
	}

	public void setCommodityNameThree(String commodityNameThree) {
		this.commodityNameThree = commodityNameThree;
	}

	public String getCommodityNameFour() {
		return commodityNameFour;
	}

	public void setCommodityNameFour(String commodityNameFour) {
		this.commodityNameFour = commodityNameFour;
	}

	public String getCommodityNameFive() {
		return commodityNameFive;
	}

	public void setCommodityNameFive(String commodityNameFive) {
		this.commodityNameFive = commodityNameFive;
	}

	public String getCommodityPackageOne() {
		return commodityPackageOne;
	}

	public void setCommodityPackageOne(String commodityPackageOne) {
		this.commodityPackageOne = commodityPackageOne;
	}

	public String getCommodityPackageTwo() {
		return commodityPackageTwo;
	}

	public void setCommodityPackageTwo(String commodityPackageTwo) {
		this.commodityPackageTwo = commodityPackageTwo;
	}

	public String getCommodityPackageThree() {
		return commodityPackageThree;
	}

	public void setCommodityPackageThree(String commodityPackageThree) {
		this.commodityPackageThree = commodityPackageThree;
	}

	public String getCommodityPackageFour() {
		return commodityPackageFour;
	}

	public void setCommodityPackageFour(String commodityPackageFour) {
		this.commodityPackageFour = commodityPackageFour;
	}

	public String getCommodityPackageFive() {
		return commodityPackageFive;
	}

	public void setCommodityPackageFive(String commodityPackageFive) {
		this.commodityPackageFive = commodityPackageFive;
	}

	public Integer getCommodityPackageNumberOne() {
		return commodityPackageNumberOne;
	}

	public void setCommodityPackageNumberOne(Integer commodityPackageNumberOne) {
		this.commodityPackageNumberOne = commodityPackageNumberOne;
	}

	public Integer getCommodityPackageNumberTwo() {
		return commodityPackageNumberTwo;
	}

	public void setCommodityPackageNumberTwo(Integer commodityPackageNumberTwo) {
		this.commodityPackageNumberTwo = commodityPackageNumberTwo;
	}

	public Integer getCommodityPackageNumberThree() {
		return commodityPackageNumberThree;
	}

	public void setCommodityPackageNumberThree(Integer commodityPackageNumberThree) {
		this.commodityPackageNumberThree = commodityPackageNumberThree;
	}

	public Integer getCommodityPackageNumberFour() {
		return commodityPackageNumberFour;
	}

	public void setCommodityPackageNumberFour(Integer commodityPackageNumberFour) {
		this.commodityPackageNumberFour = commodityPackageNumberFour;
	}

	public Integer getCommodityPackageNumberFive() {
		return commodityPackageNumberFive;
	}

	public void setCommodityPackageNumberFive(Integer commodityPackageNumberFive) {
		this.commodityPackageNumberFive = commodityPackageNumberFive;
	}

	public Double getCommodityWeightOne() {
		return commodityWeightOne;
	}

	public void setCommodityWeightOne(Double commodityWeightOne) {
		this.commodityWeightOne = commodityWeightOne;
	}

	public Double getCommodityWeightTwo() {
		return commodityWeightTwo;
	}

	public void setCommodityWeightTwo(Double commodityWeightTwo) {
		this.commodityWeightTwo = commodityWeightTwo;
	}

	public Double getCommodityWeightThree() {
		return commodityWeightThree;
	}

	public void setCommodityWeightThree(Double commodityWeightThree) {
		this.commodityWeightThree = commodityWeightThree;
	}

	public Double getCommodityWeightFour() {
		return commodityWeightFour;
	}

	public void setCommodityWeightFour(Double commodityWeightFour) {
		this.commodityWeightFour = commodityWeightFour;
	}

	public Double getCommodityWeightFive() {
		return commodityWeightFive;
	}

	public void setCommodityWeightFive(Double commodityWeightFive) {
		this.commodityWeightFive = commodityWeightFive;
	}

	public Double getCommodityVolumeOne() {
		return commodityVolumeOne;
	}

	public void setCommodityVolumeOne(Double commodityVolumeOne) {
		this.commodityVolumeOne = commodityVolumeOne;
	}

	public Double getCommodityVolumeTwo() {
		return commodityVolumeTwo;
	}

	public void setCommodityVolumeTwo(Double commodityVolumeTwo) {
		this.commodityVolumeTwo = commodityVolumeTwo;
	}

	public Double getCommodityVolumeThree() {
		return commodityVolumeThree;
	}

	public void setCommodityVolumeThree(Double commodityVolumeThree) {
		this.commodityVolumeThree = commodityVolumeThree;
	}

	public Double getCommodityVolumeFour() {
		return commodityVolumeFour;
	}

	public void setCommodityVolumeFour(Double commodityVolumeFour) {
		this.commodityVolumeFour = commodityVolumeFour;
	}

	public Double getCommodityVolumeFive() {
		return commodityVolumeFive;
	}

	public void setCommodityVolumeFive(Double commodityVolumeFive) {
		this.commodityVolumeFive = commodityVolumeFive;
	}

	public Double getCommodityWorthOne() {
		return commodityWorthOne;
	}

	public void setCommodityWorthOne(Double commodityWorthOne) {
		this.commodityWorthOne = commodityWorthOne;
	}

	public Double getCommodityWorthTwo() {
		return commodityWorthTwo;
	}

	public void setCommodityWorthTwo(Double commodityWorthTwo) {
		this.commodityWorthTwo = commodityWorthTwo;
	}

	public Double getCommodityWorthThree() {
		return commodityWorthThree;
	}

	public void setCommodityWorthThree(Double commodityWorthThree) {
		this.commodityWorthThree = commodityWorthThree;
	}

	public Double getCommodityWorthFour() {
		return commodityWorthFour;
	}

	public void setCommodityWorthFour(Double commodityWorthFour) {
		this.commodityWorthFour = commodityWorthFour;
	}

	public Double getCommodityWorthFive() {
		return commodityWorthFive;
	}

	public void setCommodityWorthFive(Double commodityWorthFive) {
		this.commodityWorthFive = commodityWorthFive;
	}

	public String getChargingWays() {
		return chargingWays;
	}

	public void setChargingWays(String chargingWays) {
		this.chargingWays = chargingWays;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTransportPrice() {
		return transportPrice;
	}

	public void setTransportPrice(Double transportPrice) {
		this.transportPrice = transportPrice;
	}

	public Double getTakeCargoPrice() {
		return takeCargoPrice;
	}

	public void setTakeCargoPrice(Double takeCargoPrice) {
		this.takeCargoPrice = takeCargoPrice;
	}

	public Double getCarryCargoPrice() {
		return carryCargoPrice;
	}

	public void setCarryCargoPrice(Double carryCargoPrice) {
		this.carryCargoPrice = carryCargoPrice;
	}

	public Double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public Double getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(Double packPrice) {
		this.packPrice = packPrice;
	}

	public Double getLoadUnloadPrice() {
		return loadUnloadPrice;
	}

	public void setLoadUnloadPrice(Double loadUnloadPrice) {
		this.loadUnloadPrice = loadUnloadPrice;
	}

	public Double getOtherPrice() {
		return otherPrice;
	}

	public void setOtherPrice(Double otherPrice) {
		this.otherPrice = otherPrice;
	}

	public Double getCollectionMoney() {
		return collectionMoney;
	}

	public void setCollectionMoney(Double collectionMoney) {
		this.collectionMoney = collectionMoney;
	}

	public Double getCollectionMoneyCharge() {
		return collectionMoneyCharge;
	}

	public void setCollectionMoneyCharge(Double collectionMoneyCharge) {
		this.collectionMoneyCharge = collectionMoneyCharge;
	}

	public Double getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(Double returnPrice) {
		this.returnPrice = returnPrice;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public UserEntity getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UserEntity createUser) {
		this.createUser = createUser;
	}

}
