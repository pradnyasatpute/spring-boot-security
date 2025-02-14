package com.ps.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ps.application.config.UserWithNoPassword;
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

	public List<Customer> getSortedCustomers(String field) {
		return customerRepository.findAll(Sort.by(field));
	}

	public Page<Customer> getCustomersByPagination(int pageSize,int pageNo) {
		Pageable pageable= PageRequest.of(pageNo, pageSize);
		return customerRepository.findAll(pageable);

	}

	public Page<Customer> getCustomersByPaginationAndSorting(int pageSize, int pageNo, String field) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(field));
	    return customerRepository.findAll(pageable);
	}
	
	public List<UserWithNoPassword> getAllCustomersWithoutPassword() {
        return customerRepository.findAllBy();
    }

}
