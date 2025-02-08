package com.ps.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.dashboard.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	 Student findByEmail(String email); // Fetch student by email
}
