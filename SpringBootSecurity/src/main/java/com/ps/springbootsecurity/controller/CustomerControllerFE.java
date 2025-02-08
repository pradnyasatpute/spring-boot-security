package com.ps.springbootsecurity.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ps.springbootsecurity.entity.Customer;
import com.ps.springbootsecurity.service.CustomerService;

@Controller
//@RequestMapping("/cms/v1")
public class CustomerControllerFE {
	
	@Autowired
	CustomerService customerService;
	
//	@GetMapping("/home")
//	public String displayAllCustomers(Model model)
//	{
//		List<Customer> customers=customerService.getAllCustomers();
//		model.addAttribute("customers",customers);
//		return "customer-list";
//	}
//	
//	@GetMapping("/home")
//	public String displayAllCustomers(@RequestParam(name = "searchCustomerName", required = false, defaultValue = "") String searchString ,Model model)
//	{
//		List<Customer> customers;
//		if(searchString.isEmpty())
//		customers=customerService.getAllCustomers();
//		else
//		customers=customerService.getCustomersByName(searchString);
//		
//		model.addAttribute("customers",customers);
//		model.addAttribute("searchCustomerName",searchString);
//		return "customer-list";
//	}
	
	@RequestMapping("/home/{sortingField}")
	public String displayAllCustomers(@PathVariable("sortingField") String sfield, @RequestParam(name = "searchCustomerName", required = false, defaultValue = "") String searchName ,
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
	            customers = customerService.getAllCustomersSortedCustomers(sfield);
	        }
	    }
		model.addAttribute("customers",customers);
		model.addAttribute("categories", customerService.getAllGenders()); 
		return "customer-list";
	}
	
	
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
		return "redirect:/home";
	}
	
	@RequestMapping("/deleteCustomer/{custid}")
	public String deleteCustomer(@PathVariable("custid") int custid)
	{
		customerService.deleteCustomer(custid);
		return "redirect:/home";
	}
	
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
		customerService.updateCustomer(custid, customer);
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
