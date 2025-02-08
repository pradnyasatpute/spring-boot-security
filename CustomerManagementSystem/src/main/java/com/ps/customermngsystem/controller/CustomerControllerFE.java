package com.ps.customermngsystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ps.customermngsystem.entity.Customer;
import com.ps.customermngsystem.service.CustomerService;

@Controller
//@RequestMapping("/cms/v1")
public class CustomerControllerFE {
	
	@Autowired
	CustomerService customerService;
	
//	@GetMapping("/welcomefe")
//	public String welcome(Model model)
//	{
//		String s1="Rohit Sharma";
//		Customer customer =new Customer();
//		customer.setCustEmail("alice@gmail.com");
//		customer.setCustID(101);
//		customer.setCustMobile("9890123123");
//		customer.setCustName("Alice");
//		
//		model.addAttribute("c1",customer);
//		return "welcome";
//	}
	
//	@GetMapping("/home")
//	public String displayAllCustomers(Model model)
//	{
//		List<Customer> customers=customerService.getAllCustomers();
//		model.addAttribute("customers",customers);
//		return "customer-list";
//	}
	@RequestMapping("/registerCustomer")
	public String registerCustomer(Model model)
	{
		Customer c=new Customer();
		model.addAttribute("mycust",c);
		return "register-customer-form";
	}
	
	
	@PostMapping("/addCustomerByRequestBody")
	public String addCustomer(@ModelAttribute Customer itvcustomer)
	{
		
		customerService.addCustomer(itvcustomer);
		return "redirect:/cms/v1/home";
	}
	@RequestMapping("/deleteCustomer/{custid}")
	public String deleteCustomer(@PathVariable("custid") int custid)
	{
		customerService.deleteCustomer(custid);
		return "redirect:/cms/v1/home";
	}
	
	
	@GetMapping("/home")
	public String displayAllCustomers(@RequestParam(name = "searchCustomerName", required = false, defaultValue = "") String searchName ,
			@RequestParam(name = "gender", required = false, defaultValue = "") String searchGender ,Model model)
	{
		List<Customer> customers;
		if (searchName.isEmpty() && searchGender.isEmpty()) {
	        customers = customerService.getAllCustomers();
	    } else {
	        // If only search by name
	        if (!searchName.isEmpty() && !searchGender.isEmpty()) {
	            customers = customerService.getCustomersByNameAndGender(searchName, searchGender);
	        } else if (!searchName.isEmpty()) {
	            customers = customerService.getCustomersByName(searchName);
	        } else if (!searchGender.isEmpty()) {
	            customers = customerService.getAllCustomersByGender(searchGender);
	        } else {
	            customers = customerService.getAllCustomers();
	        }
	    }
		model.addAttribute("customers",customers);
		model.addAttribute("categories", customerService.getAllGenders()); 
		return "customer-list";
	}
	
	
//	@RequestMapping("/registerCustomer")
//	public String registerCustomer(Model model)
//	{
//		Customer c=new Customer();
//		model.addAttribute("mycust",c);
//		return "register-customer-form";
//	}
	
//	@PostMapping("/addCustomerByRequestBody")
//	public String addCustomer(@ModelAttribute Customer itvcustomer)
//	{
//		
//		customerService.addCustomer(itvcustomer);
//		return "redirect:/home";
//	}
	
//	@RequestMapping("/deleteCustomer/{custid}")
//	public String deleteCustomer(@PathVariable("custid") int custid)
//	{
//		customerService.deleteCustomer(custid);
//		return "redirect:/home";
//	}
	
	@RequestMapping("/updateCustomerForm/{custid}")
	public String updateCustomerForm(@PathVariable("custid") int custid,Model model)
	{
		Customer customer=customerService.getCustomer(custid);
		model.addAttribute("customer",customer);
		return "update-customer-form";
	}
	
	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int custid,@ModelAttribute Customer customer)
	{
		customerService.updateCustomer(customer,custid);
		return "redirect:/home";
	}
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
