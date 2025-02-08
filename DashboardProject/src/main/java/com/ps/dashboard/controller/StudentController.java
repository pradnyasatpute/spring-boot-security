package com.ps.dashboard.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.dashboard.entity.Student;
import com.ps.dashboard.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	  // Show the login/register page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("mystudent", new Student());
        return "sign-in";  // This should match the name of your Thymeleaf template
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student,Model model) {
        studentService.registerStudent(student);
        model.addAttribute("message", "Registration successful!");
        return "redirect:/home";  // Redirect to the same page after registration
    }
    // Show login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("mystudent", new Student());
        return "login";  // This should match the name of your Thymeleaf template
    }

    // Handle login authentication
    @PostMapping("/login")
    public String loginStudent(@RequestParam String email, @RequestParam String password, Model model) {
        Student authenticatedStudent = studentService.authenticate(email, password);
        if (authenticatedStudent != null) {
            return "redirect:/home";  // Redirect to home page on successful login
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";  // Show login page with error message
        }
    } 
    
    
    @GetMapping("/home")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students",students);
		return "student-list";
	}
//	
//	
	
}
