package com.ps.gamestop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.gamestop.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
