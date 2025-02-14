package com.ps.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ps.application.config.UserWithNoPassword;
import com.ps.application.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	 List<UserWithNoPassword> findAllBy();

    
}
