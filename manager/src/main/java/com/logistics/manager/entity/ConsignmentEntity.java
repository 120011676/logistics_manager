package com.logistics.manager.entity;

import java.util.Date;
import java.util.List;

public class ConsignmentEntity {

	private Date datetime;// 日期

	private String startCity;

	private String arrivalCity;

	private String modeOfTransportation;// 运输方式

	private String serviceMode;// 服务方式

	private String payment;// 付款方式

	private CompanyEntity consignor;// 托运人

	private CompanyEntity consignee;// 收货人

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

	private UserEntity createUser;

	private List<CargoEntity> cargos;

	public List<CargoEntity> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoEntity> cargos) {
		this.cargos = cargos;
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

	public CompanyEntity getConsignor() {
		return consignor;
	}

	public void setConsignor(CompanyEntity consignor) {
		this.consignor = consignor;
	}

	public CompanyEntity getConsignee() {
		return consignee;
	}

	public void setConsignee(CompanyEntity consignee) {
		this.consignee = consignee;
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

	public UserEntity getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UserEntity createUser) {
		this.createUser = createUser;
	}

}
