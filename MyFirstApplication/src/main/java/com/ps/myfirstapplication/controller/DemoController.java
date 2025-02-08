package com.ps.myfirstapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/about")
	public String aboutUs() {
		return "aboutus"; 
	}

	@GetMapping("/contact")
	public String contactUs() {
		return "contactus"; 
	}
}
