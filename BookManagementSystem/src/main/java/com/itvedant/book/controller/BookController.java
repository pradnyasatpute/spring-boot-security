package com.itvedant.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itvedant.book.dao.AddBookDAO;
import com.itvedant.book.dao.UpdateDAO;
import com.itvedant.book.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@PostMapping("")
	public ResponseEntity<?> createBook(@RequestBody AddBookDAO addBookDAO){
		return ResponseEntity.ok(this.bookService.createBook(addBookDAO));
	}
	@GetMapping("")
	public ResponseEntity<?> read(){
		return ResponseEntity.ok(this.bookService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Integer id){
		return ResponseEntity.ok(this.bookService.getById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@RequestBody UpdateDAO updateDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.bookService.updateBook(updateDAO, id));
	}
}
