package com.ps.customermngsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.customermngsystem.entity.School;
import com.ps.customermngsystem.service.SchoolService;

@RestController
@RequestMapping("/schools")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/addSchool")
	public School addSchool(@RequestBody School school) {
		return schoolService.addSchool(school);
	}
	@DeleteMapping("/deleteSchool/{regNo}")
	public String deleteSchool(@PathVariable("regNo") int regNo) {
		return schoolService.deleteSchool(regNo);
	}
//	@PutMapping("/updateSchool/{regNo}")
//	public School updateSchool(@PathVariable("regNo") int regNo, @RequestBody School school) {
//		return schoolService.updateSchool(regNo,school);
//	}
}
