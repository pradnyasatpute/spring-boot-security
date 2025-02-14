package com.ps.dellclonepro.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ps.dellclonepro.FileStorageProperties;
import com.ps.dellclonepro.entity.Product;
import com.ps.dellclonepro.exception.StorageException;
import com.ps.dellclonepro.repository.ProductRepository;

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

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

//	public Product addProduct(Product product) {
//
//		return productRepository.save(product);
//	}

	public List<Product> displayAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product getProduct(int productId) {
		return productRepository.findById((long) productId).get();

	}

	public Product updateProduct(Product product, int productId) {
		Product p = getProduct(productId);

		p.setProductName(product.getProductName());
		p.setProductCategory(product.getProductCategory());
		p.setDescription(product.getDescription());
		p.setLaunchDate(product.getLaunchDate());
		p.setPrice(product.getPrice());

		return productRepository.save(p);

	}

	public void deleteProduct(int productId) {
		productRepository.deleteById((long) productId);

	}

	public String storeFile(Integer id, MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new StorageException("File is empty");
			}
			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));

			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}

			Product product = this.productRepository.findById((long) id).orElse(null);

			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/products/download/")
					.path(file.getOriginalFilename()).toUriString();
			product.setImageUrl(fileUploadUri);
			this.productRepository.save(product);

		} catch (Exception e) {
			throw new StorageException("File couldn't be saved");
		}
		return "File Stored !!!";
	}

	public Resource loadAsResource(String fileName) {
		Path file = this.rootLocation.resolve(fileName);

		try {
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() && resource.isReadable()) {
				return resource;
			} else {
				throw new StorageException("File couldn't read");
			}
		} catch (Exception e) {
			throw new StorageException("File couldn't read");
		}
	}

//	public Product  addProduct(Long id, MultipartFile file) {
//		Product product;
//		try {
//			if(file.isEmpty()) {
//				throw new StorageException("File is empty");
//			}
//			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
//			
//		
//			try(InputStream inputStream = file.getInputStream()){
//				Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);
//			}
//			
//			 product = this.productRepository.findById((long)id).orElse(null);
//			
//			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//									.path("/products/download/")
//									.path(file.getOriginalFilename())
//									.toUriString();
//			product.setImageUrl(fileUploadUri);
//			this.productRepository.save(product);
//			
//		} catch (Exception e) {
//			throw new StorageException("File couldn't be saved");
//		}
//		return productRepository.save(product);
//		
//	}

	public Product addProduct(Long id, MultipartFile file) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		try {
			if (file.isEmpty()) {
				throw new StorageException("File is empty");
			}

			// Save file to storage
			Path destinationFile = rootLocation.resolve(Paths.get(file.getOriginalFilename()));
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}

			// Generate image URL and update product
			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/products/download/")
					.path(file.getOriginalFilename()).toUriString();
			product.setImageUrl(fileUploadUri);
			return productRepository.save(product);
		} catch (Exception e) {
			throw new StorageException("File couldn't be saved");
		}
	}

	public long getTotalProducts() {
		return productRepository.countTotalProducts();
	}

	public long getProductCountByCategory(String category) {
	    return productRepository.countProductsByCategory(category);
	}
}
