package com.ps.petstoreapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.petstoreapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public List<Customer> findByFirstName(String s);
	public List<Customer> findByLastName(String s);
	public List<Customer> findByEmail(String email);
	public List<Customer> findBySalaryGreaterThan(Double salary);
	public List<Customer> findBySalaryBetween(Double salaryS, Double salaryE);
	public List<Customer> findByFirstNameStartingWith(String fname);
	public List<Customer> findByEmailContaining(String email);
}
