package com.ps.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.application.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

