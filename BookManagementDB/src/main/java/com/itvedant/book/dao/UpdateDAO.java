package com.itvedant.book.dao;

public class UpdateDAO {
	private String book_name;
	private String author;
	private Float price;
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "UpdateDAO [book_name=" + book_name + ", author=" + author + ", price=" + price + "]";
	}
	
	
}
