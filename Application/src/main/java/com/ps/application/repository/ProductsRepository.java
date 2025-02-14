package com.ps.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.application.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
