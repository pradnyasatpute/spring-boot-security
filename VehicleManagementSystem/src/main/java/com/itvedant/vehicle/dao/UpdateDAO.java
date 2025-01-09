package com.itvedant.vehicle.dao;

public class UpdateDAO {
	private String brand;
	private String model;
	private String type;
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
		return "UpdateDAO [brand=" + brand + ", model=" + model + ", type=" + type + "]";
	}
	
}
