package com.ps.tourpackage.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ps.tourpackage.dao.AddTourDAO;
import com.ps.tourpackage.dao.UpdateTourDAO;
import com.ps.tourpackage.service.TourService;

@Controller
@RequestMapping("/tourpackages")
public class TourController {
	@Autowired
	private TourService tourService;
	@PostMapping("")
	public ResponseEntity<?> createTour(@RequestBody AddTourDAO addTourDAO){
		return ResponseEntity.ok(this.tourService.create(addTourDAO));
	}
	@GetMapping("")
	public ResponseEntity<?> readAll(){
		return ResponseEntity.ok(this.tourService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id){
		return ResponseEntity.ok(this.tourService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTour(@RequestBody UpdateTourDAO updateTourDAO,@PathVariable Integer id){
		return ResponseEntity.ok(this.tourService.updateTour(updateTourDAO,id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delTourById(@PathVariable Integer id){
		return ResponseEntity.ok(this.tourService.delTour(id));
	}
	@PostMapping("/{id}/upload")
	public ResponseEntity<?> upload(@PathVariable Integer id, @RequestParam MultipartFile file ){
		return ResponseEntity.ok(this.tourService.storeFile(id, file));
	}
}
