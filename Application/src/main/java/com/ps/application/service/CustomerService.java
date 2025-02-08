package com.ps.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.application.entity.Customer;
import com.ps.application.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
		
	}

	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	public Customer updateCustomer(Customer customer, Integer id) {
		Customer c = getCustomerById(id);
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		c.setEmail(customer.getEmail());
		c.setAddress(customer.getAddress());
		return customerRepository.save(c);
	}

	public void deleteCustomer(Integer id) {
		Customer customer = getCustomerById(id);
		 customerRepository.delete(customer);
		
	}
	
	

}
