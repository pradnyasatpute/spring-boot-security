package com.itvedant.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.employee.dao.AddEmpDAO;
import com.itvedant.employee.dao.UpdateEmpDAO;
import com.itvedant.employee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("")
	public ResponseEntity<?> createEmp(@RequestBody AddEmpDAO addEmpDAO){
		return ResponseEntity.ok(this.employeeService.createEmp(addEmpDAO));
	}
	
	@GetMapping("")
	public ResponseEntity<?> readAll(){
		return ResponseEntity.ok(this.employeeService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id){
		return ResponseEntity.ok(this.employeeService.getById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmp(@RequestBody UpdateEmpDAO updateEmpDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.employeeService.updateEmployee(updateEmpDAO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delEmp(@PathVariable Integer id){
		return ResponseEntity.ok(this.employeeService.deleteEmp(id));
	}
}
