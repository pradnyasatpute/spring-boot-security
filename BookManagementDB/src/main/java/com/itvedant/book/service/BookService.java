package com.itvedant.book.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.book.FileStorageProperties;
import com.itvedant.book.dao.AddBookDAO;
import com.itvedant.book.dao.UpdateDAO;
import com.itvedant.book.entity.Book;
import com.itvedant.book.exception.StorageException;
import com.itvedant.book.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	private final Path rootLocation;
	
	
	
	
	public BookService(FileStorageProperties fileStorageProperties) {
		super();
		this.rootLocation = Paths.get(fileStorageProperties.getUploadDir());
		
		try {
			Files.createDirectories(rootLocation);
		} catch (Exception e) {
			throw new StorageException("Directory creation failed !!!");
		}
	}

	public Book create(AddBookDAO addBookDAO) {
		Book book = new Book();
		
		book.setBook_name(addBookDAO.getBook_name());
		book.setAuthor(addBookDAO.getAuthor());
		book.setPrice(addBookDAO.getPrice());
		this.bookRepository.save(book);
		
		return book;
	}
	
	public List<Book> readAllBooks(){
		List<Book> books = new ArrayList<Book>();
		
		books=this.bookRepository.findAll();
		return books;
	}
	public Book getBookById(Integer id) {
		Book book = new Book();
		book=this.bookRepository.findById(id).orElse(null);
		
		return book;
	}
	
	public Book updateBook(UpdateDAO updateDAO, Integer id) {
		Book book = new Book();
		book= this.getBookById(id);
		
		if(updateDAO.getBook_name() !=null) {
			book.setBook_name(updateDAO.getBook_name());
		}
		if(updateDAO.getAuthor() !=null) {
			book.setAuthor(updateDAO.getAuthor());
		}
		if(updateDAO.getPrice()!=null) {
			book.setPrice(updateDAO.getPrice());
		}
		
		
		this.bookRepository.save(book);
		return book;
		
	}
	
	public String delBook(Integer id) {
		this.bookRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	public String storeFile(Integer id, MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("file is empty");
			}
			Path destinationfile=this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
			
			try(InputStream inputStream=file.getInputStream()) {
				Files.copy(inputStream, destinationfile, StandardCopyOption.REPLACE_EXISTING);
			} 
			
			Book book = this.bookRepository.findById(id).orElse(null);
			
			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
									.path("/books/download/")
									.path(file.getOriginalFilename())
									.toUriString();
			book.setImageUrl(fileUploadUri);
			this.bookRepository.save(book);
		} catch (Exception e) {
			throw new StorageException("file not saved !!!");
		}
		
		return "File stored !!!";
	}
	
		
		
	
}
