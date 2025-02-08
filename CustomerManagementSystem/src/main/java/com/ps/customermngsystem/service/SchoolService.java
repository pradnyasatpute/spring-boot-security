package com.ps.customermngsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.customermngsystem.entity.School;
import com.ps.customermngsystem.repository.SchoolRepo;

@Service
public class SchoolService {
	@Autowired
	private SchoolRepo schoolRepo;

	public School addSchool(School school) {
		return schoolRepo.save(school);
	}

	public String deleteSchool(int regNo) {
		// TODO Auto-generated method stub
		schoolRepo.deleteById(regNo);
		return "School data deleted successfully !!!";
	}

//	public School updateSchool(int regNo, School newSchool) {
//		
//		School school= new School();
//		school=schoolRepo.findById(regNo).get();
//		
//		
//	}

	
	
	
}
