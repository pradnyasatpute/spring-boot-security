//package com.ps.customermngsystem.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ps.customermngsystem.entity.Customer;
//import com.ps.customermngsystem.service.CustomerService;
//
//@RestController
//@RequestMapping("/Customers")
//public class CustomerController {
//	@Autowired
//	private CustomerService customerService;
//	@PostMapping("")
//	public Customer addCust(@RequestBody Customer customer) {
//		return customerService.addCustomer(customer);
//	}
//	
//	@PostMapping("/addMultipleCustomers")
//	public List<Customer> addMultipleCustomers(@RequestBody List<Customer> customers)
//	{
//		return customerService.addMultipleCustomers(customers);
//	}
//	
//	@GetMapping("/getAllCustomers")
//	public List<Customer> getAllCustomers(){
//		return customerService.getAllCustomers();
//	}
//	
//	@GetMapping("/getCustomer/{custid}")
//	public Customer getCustomer(@PathVariable ("custid") int custid) {
//		return customerService.getCustomer(custid);
//	}
//	
//	@DeleteMapping("/deleteCustomer/{custid}")
//	public String deleteCustomer(@PathVariable("custid") int custid) {
//		return customerService.deleteCustomer(custid);
//	}
//	
//	@PutMapping("/updateCustomer/{custid}")
//	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("custid") int custid) {
//		return customerService.updateCustomer(customer,custid);
//	}
//
//	
//}
