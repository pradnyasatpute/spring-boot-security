package com.itvedant.vehicle.entity;

public class Vehicle {
	private Integer vId;
	private String brand;
	private String model;
	private String type;
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Vehicle [vId=" + vId + ", brand=" + brand + ", model=" + model + ", type=" + type + "]";
	}
	
	
}
