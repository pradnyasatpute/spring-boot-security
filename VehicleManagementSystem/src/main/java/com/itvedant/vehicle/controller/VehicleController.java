package com.itvedant.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.vehicle.dao.UpdateDAO;
import com.itvedant.vehicle.dao.VehicleDAO;
import com.itvedant.vehicle.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("")
	public ResponseEntity<?> createV(@RequestBody VehicleDAO vehicleDAO){
		return ResponseEntity.ok(this.vehicleService.createVehicle(vehicleDAO));
	}
	@GetMapping("")
	public ResponseEntity<?> getV(){
		return ResponseEntity.ok(this.vehicleService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(this.vehicleService.getById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateV(@RequestBody UpdateDAO updateDAO,@PathVariable Integer id) {
		return ResponseEntity.ok(this.vehicleService.updateVehicle(updateDAO, id));
	}
}
