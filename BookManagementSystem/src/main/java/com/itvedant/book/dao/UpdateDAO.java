package com.itvedant.book.dao;

public class UpdateDAO {
	private String Title;
	private String Author;
	private Integer price;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "UpdateDAO [Title=" + Title + ", Author=" + Author + ", price=" + price + "]";
	}
	
	
}
