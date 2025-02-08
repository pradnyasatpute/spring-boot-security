package com.ps.petstoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.petstoreapp.entity.Customer;
import com.ps.petstoreapp.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("")
	public ResponseEntity<?> createProduct(@Valid @RequestBody Customer customer) {
		return ResponseEntity.ok(this.customerService.create(customer));
	}

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.customerService.readAllCustomer());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.customerService.readById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
		return ResponseEntity.ok(this.customerService.updateCustomer(customer, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return ResponseEntity.ok(this.customerService.del(id));
	}
	@GetMapping("/findByFirstName/{fname}")
	public List<Customer> findByFirstName(@PathVariable String fname){
		return customerService.findByFirstName(fname);
	}
	@GetMapping("/findByLastName/{lname}")
	public List<Customer> findByLastName(@PathVariable String lname){
		return customerService.findByLastName(lname);
	}
	@GetMapping("/findByEmail/{email}")
	public List<Customer> findByEmail(@PathVariable String email){
		return customerService.findByEmail(email);
	}
	@GetMapping("/findBySalaryBetween/{salaryS}/{salaryE}")
	public List<Customer> findBySalaryBetween(@PathVariable Double salaryS,@PathVariable Double salaryE){
		return customerService.findBySalaryBetween(salaryS,salaryE);
	}
	@GetMapping("/findBySalaryGreaterThan/{salary}")
	public List<Customer> findBySalaryGreaterThan(@PathVariable Double salary){
		return customerService.findBySalaryGreaterThan(salary);
	}
	@GetMapping("/findByFirstNameStartingWith/{fname}")
	public List<Customer> findByFirstNameStartingWith(@PathVariable String fname){
		return customerService.findByFirstNameStartingWith(fname);
	}
	
	@GetMapping("/findByEmailContaining/{email}")
	public List<Customer> findByEmailContaining(@PathVariable String email){
		return customerService.findByEmailContaining(email);
	}
}
