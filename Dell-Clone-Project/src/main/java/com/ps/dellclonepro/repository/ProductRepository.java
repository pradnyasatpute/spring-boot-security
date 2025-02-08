package com.ps.dellclonepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.dellclonepro.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
