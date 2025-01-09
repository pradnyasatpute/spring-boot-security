package com.itvedant.book.entity;

public class Book {
	private Integer Book_Id;
	private String Title;
	private String Author;
	private Integer price;
	public Integer getBook_Id() {
		return Book_Id;
	}
	public void setBook_Id(Integer book_Id) {
		Book_Id = book_Id;
	}
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
		return "Book [Book_Id=" + Book_Id + ", Title=" + Title + ", Author=" + Author + ", price=" + price + "]";
	}
	
	
	
	
	
}
