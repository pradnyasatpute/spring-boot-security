package com.itvedant.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.product.dao.AddProductDAO;
import com.itvedant.product.dao.UpdateProductDAO;
import com.itvedant.product.entity.Product;

@Service
public class ProductService {
	private Map<Integer, Product> products=new HashMap<Integer,Product>();
	private AtomicInteger counter = new AtomicInteger();
	
	public Product createProduct(AddProductDAO addproductdao) {
		Product product=new Product();
		product.setId(counter.getAndIncrement());
		product.setProduct_name(addproductdao.getProduct_name());
		product.setPrice(addproductdao.getPrice());
		product.setCategory(addproductdao.getCategory());
		this.products.put(product.getId(),product);
		return product;
	}
	//read all data
	
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
		if(updateProductDAO.getProduct_name() !=null) {
			product.setProduct_name(updateProductDAO.getProduct_name());
		}
		if(updateProductDAO.getPrice() !=null) {
			product.setPrice(updateProductDAO.getPrice());
		}
		if(updateProductDAO.getCategory() !=null) {
			product.setCategory(updateProductDAO.getCategory());
		}
		return product;
	}
}
