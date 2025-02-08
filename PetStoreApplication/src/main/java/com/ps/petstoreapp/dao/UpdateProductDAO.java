package com.ps.petstoreapp.dao;

public class UpdateProductDAO {
	private String name;
	private String manufacture;
	private Double price;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UpdateProductDAO [name=" + name + ", manufacture=" + manufacture + ", price=" + price + ", description="
				+ description + "]";
	}
	
	
}
