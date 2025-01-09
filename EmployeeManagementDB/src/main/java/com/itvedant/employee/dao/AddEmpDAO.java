package com.itvedant.employee.dao;

public class AddEmpDAO {
	private String name;
	private String department;
	private Float salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "AddEmpDAO [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
	
	
}
