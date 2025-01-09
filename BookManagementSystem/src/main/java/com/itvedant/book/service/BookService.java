package com.itvedant.book.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.book.dao.AddBookDAO;
import com.itvedant.book.dao.UpdateDAO;
import com.itvedant.book.entity.Book;

@Service
public class BookService {
	private Map<Integer, Book> books= new HashMap<Integer,Book>();
	private AtomicInteger counter = new AtomicInteger();
	
	public Book createBook(AddBookDAO addBookDAO) {
		Book book = new Book();
		book.setBook_Id(counter.incrementAndGet());
		book.setTitle(addBookDAO.getTitle());
		book.setAuthor(addBookDAO.getAuthor());
		book.setPrice(addBookDAO.getPrice());
		this.books.put(book.getBook_Id(), book);
		return book;
	}
	
	public Collection<Book> getAll(){
		Collection<Book> book = new ArrayList<Book>();
		book=this.books.values();
		return book;
		
	}
	public Book getById(Integer id) {
		Book book=new Book();
		book=this.books.get(id);
		return book;
	}
	
	public Book updateBook(UpdateDAO updateDAO,Integer id) {
		Book book = new Book();
		book=this.getById(id);
		
		if (updateDAO.getTitle() !=null) {
			book.setTitle(updateDAO.getTitle());
		}
		if (updateDAO.getAuthor() !=null) {
			book.setAuthor(updateDAO.getAuthor());
		}
		if (updateDAO.getPrice() !=null) {
			book.setPrice(updateDAO.getPrice());
		}
		return book;
	}
}
