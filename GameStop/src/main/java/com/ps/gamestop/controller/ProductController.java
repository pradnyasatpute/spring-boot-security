package com.ps.gamestop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

import com.ps.gamestop.dao.AddProductDAO;
import com.ps.gamestop.dao.UpdateProductDAO;
import com.ps.gamestop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddProductDAO addProductDAO){
		return ResponseEntity.ok(this.productService.createProduct(addProductDAO));
	}
	@GetMapping("")
	public ResponseEntity<?> getAllGames(){
		return ResponseEntity.ok(this.productService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.getById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePro(@RequestBody UpdateProductDAO updateProductDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.updateProduct(updateProductDAO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.delProduct(id));
	}
	@PostMapping("/{id}/upload")
	public ResponseEntity<?> uploadFile(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
		return ResponseEntity.ok(this.productService.storeFile(id, file));
	}
	@GetMapping("/download/{fileName}")
	public ResponseEntity<?> download(@PathVariable String fileName){
		Resource resource = this.productService.loadAsResource(fileName);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\"" +fileName+ "\"").body(resource);
	}
}
