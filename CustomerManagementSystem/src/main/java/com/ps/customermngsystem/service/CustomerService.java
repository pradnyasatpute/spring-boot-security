package com.ps.customermngsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.customermngsystem.entity.Customer;
import com.ps.customermngsystem.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	public Customer addCustomer(Customer customer) {
		Customer c =  new Customer();
		c.setCustName(customer.getCustName());
		c.setCustEmail(customer.getCustEmail());
		c.setCustMobile(customer.getCustMobile());
		c.setCustGender(customer.getCustGender());
		return customerRepo.save(c);
	}
	public List<Customer> addMultipleCustomers(List<Customer> customers) {
		return customerRepo.saveAll(customers);
	}
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	public Customer getCustomer(int custid) {
		// TODO Auto-generated method stub
		return customerRepo.findById(custid).get();
	}
	public String deleteCustomer(int custid) {
		customerRepo.deleteById(custid);
		return "customer deleted successfully !!!";
	}
	public Customer updateCustomer(Customer customer, int custid) {
		Customer c = getCustomer(custid);
		
		c.setCustName(customer.getCustName());
		c.setCustEmail(customer.getCustEmail());
		c.setCustMobile(customer.getCustMobile());
		return customerRepo.save(c);
	}
	
//	public Customer updateCustomer(int custid, Customer newCustomer) {
//		Customer customerDb=getCustomer(custid);
//		customerDb.setCustEmail(newCustomer.getCustEmail());
//		customerDb.setCustMobile(newCustomer.getCustMobile());
//		customerDb.setCustName(newCustomer.getCustName());
//		return customerRepository.save(customerDb);
//	}
	public List<Customer> getCustomersByEmail(String email) {
		return customerRepo.findByCustEmailContaining(email);
	}
	public List<Customer> getCustomersByIdGreaterThan(int threshold) {
		return customerRepo.itvFindById(threshold);
	}
	public List<Customer> getCustomersByName(String searchString) {
		return customerRepo.findByCustName(searchString);
	}
	public List<Customer> getAllCustomersByGender(String searchGender) {
		return customerRepo.findByCustGender(searchGender);
	}
	
	public List<String> getAllGenders()
	{
		return customerRepo.getAllGenders();
	}
	public List<Customer> getCustomersByNameAndGender(String searchName, String searchGender) {
		return customerRepo.findByCustNameAndCustGender(searchName,searchGender);
	}

}
