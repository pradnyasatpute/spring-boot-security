package com.ps.customermngsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int regNo;
	private String schoolName;
	private String yoe;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "regNo",referencedColumnName = "regNo")
	private List<Teacher> teachers;
	
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getschoolName() {
		return schoolName;
	}
	public void setschoolName(String schoolName) {
		schoolName = schoolName;
	}
	public String getYoe() {
		return yoe;
	}
	public void setYoe(String yoe) {
		this.yoe = yoe;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	

}
