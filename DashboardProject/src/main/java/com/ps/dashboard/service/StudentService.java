package com.ps.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dashboard.entity.Student;
import com.ps.dashboard.repository.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	public Student registerStudent(Student student) {
//		Student s = new Student();
//		s.setEmail(student.getEmail());
//		s.setUsername(student.getUsername());
//		s.setPhone(student.getPhone());
//		s.setPassword(student.getPassword());
		// Hash the password before saving
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return studentRepository.save(student);
		
	}
	public Student authenticate(String email, String password) {
		Student student = studentRepository.findByEmail(email);
		// Check if student exists and verify password
		if (student != null && passwordEncoder.matches(password, student.getPassword())) {
			return student; // Authentication successful
		}
		return null; // Authentication failed
	}
}
