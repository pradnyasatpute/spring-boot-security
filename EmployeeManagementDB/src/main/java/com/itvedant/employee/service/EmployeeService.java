package com.itvedant.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.employee.dao.AddEmpDAO;
import com.itvedant.employee.dao.UpdateEmpDAO;
import com.itvedant.employee.entity.Employee;
import com.itvedant.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee createEmp(AddEmpDAO addEmpDAO) {
		Employee employee = new Employee();
		
		employee.setName(addEmpDAO.getName());
		employee.setDepartment(addEmpDAO.getDepartment());
		employee.setSalary(addEmpDAO.getSalary());
		
		this.employeeRepository.save(employee);
		return employee;
	}
	
	public List<Employee> getAll(){
		List<Employee> employees = new ArrayList<Employee>();
		
		employees=this.employeeRepository.findAll();
		
		return employees;
	}
	public Employee getById(Integer id) {
		Employee employee=new Employee();
		employee=this.employeeRepository.findById(id).orElse(null);
		return employee;
	}
	
	public Employee updateEmployee(UpdateEmpDAO updateEmpDAO, Integer id) {
		Employee employee = new Employee();
		employee=this.employeeRepository.getById(id);
		
		if(updateEmpDAO.getName() !=null) {
			employee.setName(updateEmpDAO.getName());
		}
		if(updateEmpDAO.getDepartment() !=null) {
			employee.setDepartment(updateEmpDAO.getDepartment());
		}
		if(updateEmpDAO.getSalary() !=null) {
			employee.setSalary(updateEmpDAO.getSalary());;
		}
		
		this.employeeRepository.save(employee);
		
		return employee;
	}
	public String deleteEmp(Integer id) {
		Employee employee = new Employee();
		employee=this.getById(id);
		
		this.employeeRepository.delete(employee);
		
		return "Data Deleted !!!";
	}
}
