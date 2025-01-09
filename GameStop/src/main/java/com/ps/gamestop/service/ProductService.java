package com.ps.gamestop.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ps.gamestop.FileStorageProperties;
import com.ps.gamestop.dao.AddProductDAO;
import com.ps.gamestop.dao.UpdateProductDAO;
import com.ps.gamestop.entity.Product;
import com.ps.gamestop.exception.StorageException;
import com.ps.gamestop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	private final Path rootLocation;
	
	
	
	
	public ProductService(FileStorageProperties fileStorageProperties) {
		super();
		this.rootLocation = Paths.get(fileStorageProperties.getUploadDir());
		
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("Couldn't initialize directory !!!");
		}
	}
	public Product createProduct(AddProductDAO addProductDAO) {
		Product product = new Product();
		product.setProduct_name(addProductDAO.getProduct_name());
		product.setDescription(addProductDAO.getDescription());
		product.setManufacturer(addProductDAO.getManufacturer());
		product.setPrice(addProductDAO.getPrice());
		
		this.productRepository.save(product);
		return product;
	}
	public List<Product> getAll(){
		List<Product> products = new ArrayList<Product>();
		products=this.productRepository.findAll();
		return products;
	}
	
	public Product getById(Integer id) {
		Product product = new Product();
		product=this.productRepository.findById(id).orElse(null);
		return product;
	}
	
	public Product updateProduct(UpdateProductDAO updateProductDAO,Integer id) {
		Product product = new Product();
		product=this.getById(id);
		
		if(updateProductDAO.getProduct_name()!=null) {
			product.setProduct_name(updateProductDAO.getProduct_name());
		}
		if(updateProductDAO.getDescription() !=null) {
			product.setDescription(updateProductDAO.getDescription());
		}
		if(updateProductDAO.getManufacturer() !=null) {
			product.setManufacturer(updateProductDAO.getManufacturer());
		}
		if(updateProductDAO.getPrice() !=null) {
			product.setPrice(updateProductDAO.getPrice());
		}
		this.productRepository.save(product);
		return product;
	}
	
	public String delProduct(Integer id) {
		Product product = new Product();
		product=this.getById(id);
		
		this.productRepository.deleteById(id);
		
		return "Product deleted Successfully !!!";
	}
	
	public String storeFile(Integer id, MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("File is empty");
			}
			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
			
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);
			}
			
			Product product = this.productRepository.findById(id).orElse(null);
			
			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
									.path("/products/download/")
									.path(file.getOriginalFilename())
									.toUriString();
			product.setImage_url(fileUploadUri);
			this.productRepository.save(product);
			
		} catch (Exception e) {
			throw new StorageException("File couldn't be saved");
		}
		return "File Stored !!!";
	}
}
