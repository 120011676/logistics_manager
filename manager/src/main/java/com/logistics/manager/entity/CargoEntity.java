package com.logistics.manager.entity;

public class CargoEntity {

	private Integer id;

	private String commodityName;

	private String pack;

	private Integer numberOfPackages;

	private Double weight;

	private Double volume;

	private Double statementValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public Integer getNumberOfPackages() {
		return numberOfPackages;
	}

	public void setNumberOfPackages(Integer numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getStatementValue() {
		return statementValue;
	}

	public void setStatementValue(Double statementValue) {
		this.statementValue = statementValue;
	}
	
}
