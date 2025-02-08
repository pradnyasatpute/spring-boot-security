package com.ps.moviemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

import com.ps.moviemanagement.dao.MovieDAO;
import com.ps.moviemanagement.dao.MovieUpdateDAO;
import com.ps.moviemanagement.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MovieDAO movieDAO){
		return ResponseEntity.ok(this.movieService.createMovie(movieDAO));
	}
	@GetMapping("")
	public ResponseEntity<?> showAll(){
		return ResponseEntity.ok(this.movieService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> showById(@PathVariable Integer id){
		return ResponseEntity.ok(this.movieService.getById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateShow(@RequestBody MovieUpdateDAO movieUpdateDAO, @PathVariable Integer id){
		return ResponseEntity.ok(this.movieService.updateMovie(movieUpdateDAO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delShow(@PathVariable Integer id){
		return ResponseEntity.ok(this.movieService.delMovie(id));
	}
	@PostMapping("/{id}/upload")
	public ResponseEntity<?> poster(@PathVariable Integer id, @RequestParam("file") MultipartFile file){
		return ResponseEntity.ok(this.movieService.storeFile(id, file));
	}
	@GetMapping("/download/{fileName}")
	public ResponseEntity<?> download(@PathVariable String fileName){
		Resource resource = this.movieService.loadAsResource(fileName);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\"" +fileName+ "\"").body(resource);
	}
}
