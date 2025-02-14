package com.ps.dellclonepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ps.dellclonepro.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT COUNT(p) FROM Product p")
	long countTotalProducts();

	
	
	@Query("SELECT COUNT(p) FROM Product p WHERE p.productCategory = :category")
	long countProductsByCategory(@Param("category") String category);

}
