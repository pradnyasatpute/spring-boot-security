package com.ps.petstoreapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.petstoreapp.entity.Customer;
import com.ps.petstoreapp.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	AtomicInteger counter = new AtomicInteger();
	
	public Customer create(Customer customer) {
//		Customer c = new Customer();
//		c.setC_id(counter.incrementAndGet());
//		c.setFirstName(customer.getFirstName());
//		c.setLastName(customer.getLastName());
//		c.setEmail(customer.getEmail());
//		c.setPassword(customer.getPassword());
//		c.setConfirmPassword(customer.getConfirmPassword());
//		c.setMobileNo(customer.getMobileNo());
//		c.setSalary(customer.getSalary());
//		
//		if (!customer.getPassword().equals(customer.getConfirmPassword())) {
//            throw new IllegalArgumentException("Password and Confirm Password do not match");
//        }
//
//		this.customers.put(c.getC_id(), c);
//		return c;
		return customerRepository.save(customer);
	}

	public Collection<Customer> readAllCustomer() {

		
		return customerRepository.findAll();
	}

	public Customer readById(Integer id) {
		Customer c = new Customer();
		c = this.customers.get(id);
		return c;
	}

	public Customer updateCustomer(Customer customer, Integer id) {
		Customer c = new Customer();
		c = customerRepository.findById(id).get();
		if (customer.getFirstName() != null) {
			c.setFirstName(customer.getFirstName());
		}
		if (customer.getLastName() != null) {
			c.setLastName(customer.getLastName());
		}
		if (customer.getEmail() != null) {
			c.setEmail(customer.getEmail());
		}
		if (customer.getPassword() != null) {
			c.setPassword(customer.getPassword());
		}
		if (customer.getConfirmPassword() != null) {
			c.setConfirmPassword(customer.getConfirmPassword());
		}
		if (customer.getMobileNo() != null) {
			c.setMobileNo(customer.getMobileNo());
		}
		if (customer.getSalary() != null) {
			c.setSalary(customer.getSalary());
		}
//		return this.customers.put(id, c);
		return customerRepository.save(c);
	}

	public String del(Integer id) {
	    this.customers.remove(id);
	    return "Customer deleted successfully";
	}

	public List<Customer> findByFirstName(String fname) {
		List<Customer> c= new ArrayList<>();
		c=customerRepository.findByFirstName(fname);
		return c;
	}

	public List<Customer> findByLastName(String lname) {
		List<Customer> c= new ArrayList<>();
		c=customerRepository.findByLastName(lname);
		return c;
	}

	public List<Customer> findByEmail(String email) {
		List<Customer> c= new ArrayList<>();
		c=customerRepository.findByEmail(email);
		return c;
	}

	public List<Customer> findBySalaryGreaterThan(Double salary) {
		return customerRepository.findBySalaryGreaterThan(salary);
	}

	public List<Customer> findBySalaryBetween(Double salaryS, Double salaryE) {
		return customerRepository.findBySalaryBetween(salaryS,salaryE);
	}

	public List<Customer> findByFirstNameStartingWith(String fname) {
		// TODO Auto-generated method stub
		return customerRepository.findByFirstNameStartingWith(fname);
	}

	public List<Customer> findByEmailContaining(String email) {
		return customerRepository.findByEmailContaining(email);
	}

}
