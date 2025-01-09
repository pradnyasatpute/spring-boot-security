package com.itvedant.product.dao;

public class UpdateProductDAO {
	private String product_name;
	private Float price;
	private String category;
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "UpdateProductDAO [product_name=" + product_name + ", price=" + price + ", category=" + category + "]";
	}
	
	
}
