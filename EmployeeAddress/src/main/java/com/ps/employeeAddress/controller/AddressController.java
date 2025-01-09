package com.ps.employeeAddress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.employeeAddress.dao.AddDAO;
import com.ps.employeeAddress.dao.UpdateDAO;
import com.ps.employeeAddress.service.AddressService;

@Controller
@RequestMapping("/employeeAddresses")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@PostMapping("")
	public ResponseEntity<?> createAdd(@RequestBody AddDAO addDAO){
		return ResponseEntity.ok(this.addressService.createAddress(addDAO));
	}
	@GetMapping("")
	public ResponseEntity<?> viewAll(){
		return ResponseEntity.ok(this.addressService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(this.addressService.getById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAdd(@RequestBody UpdateDAO updateDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.addressService.updateAddress(updateDAO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delById(@PathVariable Integer id){
		return ResponseEntity.ok(this.addressService.delAdd(id));
	}
}
