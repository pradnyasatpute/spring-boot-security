package com.itvedant.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itvedant.book.dao.AddBookDAO;
import com.itvedant.book.dao.UpdateDAO;
import com.itvedant.book.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddBookDAO addBookDAO){
		return ResponseEntity.ok(this.bookService.create(addBookDAO));
	}
	@GetMapping
	public ResponseEntity<?> read(){
		return ResponseEntity.ok(this.bookService.readAllBooks());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id){
		return ResponseEntity.ok(this.bookService.getBookById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@RequestBody UpdateDAO updateDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.bookService.updateBook(updateDAO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> del(@PathVariable Integer id){
		return ResponseEntity.ok(this.bookService.delBook(id));
	}
	@PostMapping("/{id}/upload")
	public ResponseEntity<?> fileUpload(@PathVariable Integer id, @RequestParam("file") MultipartFile file){
		return ResponseEntity.ok(this.bookService.storeFile(id, file));
	}
	
}
