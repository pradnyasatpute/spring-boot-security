package com.ps.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps.application.config.UserWithNoPassword;
import com.ps.application.entity.Customer;
import com.ps.application.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
//	@GetMapping("")
//	public List<Customer> getAllCustomers(){
//		return customerService.getAllCustomers();
//	}
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Integer id){
		return customerService.getCustomerById(id);
	}
	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Integer id) {
		return customerService.updateCustomer(customer,id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		 customerService.deleteCustomer(id);
		 return "Customer deleted successfully !!!";
	}
	
	@GetMapping("/getSortedCustomers/{field}")
	public List<Customer> getSortedCustomers(@PathVariable("field") String field)
	{
		return customerService.getSortedCustomers(field);
	}
	
//	pagination
//	@GetMapping("")
//	public Page<Customer> getSortedCustomers(@RequestParam(defaultValue = "0") int pageNo,@RequestParam(defaultValue = "5") int pageSize)
//	{
//		return   customerService.getCustomersByPagination(pageSize,pageNo);
//	
//	}
	
//	pagination & sorting
	@GetMapping("")
	public Page<Customer> getSortedCustomersn(@RequestParam(defaultValue = "0") int pageNo,@RequestParam(defaultValue = "5") int pageSize,@RequestParam(defaultValue = "customerid") String field)
	{
		
		
		return   customerService.getCustomersByPaginationAndSorting(pageSize,pageNo,field);
	
	}
	
	 @GetMapping("/nopassword")
	    public List<UserWithNoPassword> getCustomersWithoutPassword() {
	        return customerService.getAllCustomersWithoutPassword();
	    }
	

}

