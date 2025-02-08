package com.ps.petstoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.petstoreapp.dao.UpdateProductDAO;
import com.ps.petstoreapp.dao.ProductAddDAO;
import com.ps.petstoreapp.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("")
	public ResponseEntity<?> createProduct(@RequestBody ProductAddDAO productAddDAO){
		return ResponseEntity.ok(this.productService.create(productAddDAO));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.productService.readAllProduct());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.readById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UpdateProductDAO updateProductDAO ,@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.updateProduct(updateProductDAO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.del(id));
	}
}
