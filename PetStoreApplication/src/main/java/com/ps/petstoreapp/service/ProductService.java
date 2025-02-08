package com.ps.petstoreapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ps.petstoreapp.dao.ProductAddDAO;
import com.ps.petstoreapp.dao.UpdateProductDAO;
import com.ps.petstoreapp.entity.Product;

@Service
public class ProductService {
	Map<Integer, Product> products = new HashMap<Integer, Product>();
	AtomicInteger counter = new AtomicInteger();
	
	public Product create(ProductAddDAO productAddDAO) {
		Product product = new Product();
		product.setId(counter.incrementAndGet());
		product.setName(productAddDAO.getName());
		product.setManufacture(productAddDAO.getManufacture());
		product.setPrice(productAddDAO.getPrice());
		product.setDescription(productAddDAO.getDescription());
		
		this.products.put(product.getId(), product);
		return product;
	}
	
	public Collection<Product> readAllProduct(){
		
		Collection<Product> prod=new ArrayList<Product>();
		
		prod=this.products.values();
		return prod;
		}
		public Product readById(Integer id) {
			Product product=new Product();
			product=this.products.get(id);
			return product;
		}
		
		public Product updateProduct(UpdateProductDAO updateProductDAO,Integer id) {
			Product product=new Product();
			product=this.readById(id);
			if(updateProductDAO.getName() !=null) {
				product.setName(updateProductDAO.getName());
			}
			if(updateProductDAO.getManufacture() !=null) {
				product.setManufacture(updateProductDAO.getManufacture());
			}
			if(updateProductDAO.getPrice() !=null) {
				product.setPrice(updateProductDAO.getPrice());
			}
			if(updateProductDAO.getDescription() !=null) {
				product.setDescription(updateProductDAO.getDescription());
			}
			return product;
		}
		
		public String del(Integer id) {
			Product product = new Product();
			product=this.readById(id);
			this.products.remove(product);
			
			return "product deleted";
		}
}
