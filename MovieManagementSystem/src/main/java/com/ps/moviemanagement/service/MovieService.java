package com.ps.moviemanagement.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ps.moviemanagement.FileStorage;
import com.ps.moviemanagement.Repository.MovieRepository;
import com.ps.moviemanagement.dao.MovieDAO;
import com.ps.moviemanagement.dao.MovieUpdateDAO;
import com.ps.moviemanagement.entity.Movie;
import com.ps.moviemanagement.exception.StorageException;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	private final Path rootLocation;
	
	public MovieService(FileStorage fileStorage) {
		super();
		this.rootLocation=Paths.get(fileStorage.getUploadDir());
		
		try {
			Files.createDirectories(rootLocation);
		} catch (Exception e) {
			throw new StorageException("Directory not created !!!");
		}
	}

	public Movie createMovie(MovieDAO movieDAO) {
		Movie movie = new Movie();
		movie.setTitle(movieDAO.getTitle());
		movie.setRelease_date(movieDAO.getRelease_date());
		movie.setGenere(movieDAO.getGenere());
		movie.setDirector(movieDAO.getDirector());
		this.movieRepository.save(movie);
		return movie;
	}
	
	public List<Movie> getAll(){
		List<Movie> movies = new ArrayList<Movie>();
		movies=this.movieRepository.findAll();
		return movies;
		
	}
	public Movie getById(Integer id) {
		Movie movie = new Movie();
		movie=this.movieRepository.findById(id).orElse(null);
		return movie;
	}
	
	public Movie updateMovie(MovieUpdateDAO movieUpdateDAO, Integer id) {
		Movie movie= new Movie();
		movie=this.getById(id);
		
		if(movieUpdateDAO.getTitle() !=null) {
			movie.setTitle(movieUpdateDAO.getTitle());
		}
		if(movieUpdateDAO.getRelease_date() !=null) {
			movie.setRelease_date(movieUpdateDAO.getRelease_date());
		}
		if(movieUpdateDAO.getGenere() !=null) {
			movie.setGenere(movieUpdateDAO.getGenere());
		}
		if(movieUpdateDAO.getDirector() !=null) {
			movie.setDirector(movieUpdateDAO.getDirector());
		}
		
		this.movieRepository.save(movie);
		return movie;
	}
	
	public String delMovie(Integer id) {
		Movie movie = new Movie();
		movie=this.getById(id);
		this.movieRepository.delete(movie);
		
		return "Movie data deleted for movieId : "+id;
	}
	
	public String storeFile(Integer id,MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("file is empty");
			}
			Path Destinationfile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
			
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream,Destinationfile,StandardCopyOption.REPLACE_EXISTING);
			}
			Movie movie= this.getById(id);
			
			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/movies/")
					.path(file.getOriginalFilename())
					.toUriString();
			movie.setMovie_poster(fileUploadUri);
			
			this.movieRepository.save(movie);
		} catch (Exception e) {
			throw new StorageException("file not save");
		}
		return "File Stored !!!";
	}
	public Resource loadAsResource(String fileName) {
		Path file=this.rootLocation.resolve(fileName);
		
		try {
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists() && resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageException("File couldn't read");
			}
		} catch (Exception e) {
			throw new StorageException("File couldn't read");
		}
	}
}
