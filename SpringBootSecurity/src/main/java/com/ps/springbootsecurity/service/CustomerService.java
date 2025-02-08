package com.ps.springbootsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ps.springbootsecurity.entity.Customer;
import com.ps.springbootsecurity.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	public Customer getCustomer(int custid) {
		return customerRepository.findById(custid).get();
	}
	public void deleteCustomer(int custid) {
		customerRepository.deleteById(custid);
		
	}
	public Customer updateCustomer(int custid, Customer newCustomer) {
		Customer customerDb=getCustomer(custid);
		customerDb.setCustEmail(newCustomer.getCustEmail());
		customerDb.setCustMobile(newCustomer.getCustMobile());
		customerDb.setCustName(newCustomer.getCustName());
		return customerRepository.save(customerDb);
	}
	public List<Customer> addMultipleCustomers(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	public List<Customer> getCustomersByEmail(String email) {
		return customerRepository.findByCustEmailContaining(email);
	}
	public List<Customer> getCustomersByIdGreaterThan(int threshold) {
		return customerRepository.itvFindById(threshold);
	}
	public List<Customer> getCustomersByName(String searchString) {
		return customerRepository.findByCustName(searchString);
	}
	public List<Customer> getAllCustomersByGender(String searchGender) {
		return customerRepository.findByCustGender(searchGender);
	}
	
	public List<String> getAllGenders()
	{
		return customerRepository.getAllGenders();
	}
	public List<Customer> getCustomersByNameAndGender(String searchName, String searchGender) {
		return customerRepository.findByCustNameAndCustGender(searchName,searchGender);
	}
	public List<Customer> getAllCustomersSortedCustomers(String sfield) {
		return customerRepository.findAll(Sort.by(Sort.Direction.DESC, sfield));
	}

}