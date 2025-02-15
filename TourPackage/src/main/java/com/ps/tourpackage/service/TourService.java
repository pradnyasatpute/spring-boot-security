package com.ps.tourpackage.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ps.tourpackage.FileStorageProperties;
import com.ps.tourpackage.dao.AddTourDAO;
import com.ps.tourpackage.dao.UpdateTourDAO;
import com.ps.tourpackage.entity.TourPackage;
import com.ps.tourpackage.exception.StorageException;
import com.ps.tourpackage.repository.TourRepository;

@Service
public class TourService {
	@Autowired
	private TourRepository tourRepository;
	private final Path rootLocation;
	
	
	
	public TourService(FileStorageProperties fileStorageProperties) {
		super();
		this.rootLocation=Paths.get(fileStorageProperties.getUploadDir());
		
		try {
			Files.createDirectories(rootLocation);
		} catch (Exception e) {
			throw new StorageException("Could not initialize directory");
		}
	}

	public TourPackage create(AddTourDAO addTourDAO) {
		TourPackage tourPackage = new TourPackage();
		tourPackage.setPackageName(addTourDAO.getPackageName());
		tourPackage.setDescription(addTourDAO.getDescription());
		tourPackage.setDestination(addTourDAO.getDestination());
		tourPackage.setDuration(addTourDAO.getDuration());
		tourPackage.setPricePerPerson(addTourDAO.getPricePerPerson());
		
		this.tourRepository.save(tourPackage);
		return tourPackage;
	}
	
	public List<TourPackage> getAll(){
		List<TourPackage> pkgs = new ArrayList<TourPackage>();
		pkgs=this.tourRepository.findAll();
		return pkgs;
	}
	
	public TourPackage getById(Integer id) {
		TourPackage tourPackage = new TourPackage();
		tourPackage=this.tourRepository.findById(id).orElse(null);
		return tourPackage;
	}
	
	public TourPackage updateTour(UpdateTourDAO updateTourDAO, Integer id) {
		TourPackage tourPackage = new TourPackage();
		tourPackage=this.getById(id);
		
		if(updateTourDAO.getPackageName() !=null) {
			tourPackage.setPackageName(updateTourDAO.getPackageName());
		}
		if(updateTourDAO.getDescription() !=null) {
			tourPackage.setDescription(updateTourDAO.getDescription());
		}
		if(updateTourDAO.getDestination() !=null) {
			tourPackage.setDestination(updateTourDAO.getDestination());
		}
		if(updateTourDAO.getDuration() !=null) {
			tourPackage.setDuration(updateTourDAO.getDuration());
		}
		if(updateTourDAO.getPricePerPerson() !=null) {
			tourPackage.setPricePerPerson(updateTourDAO.getPricePerPerson());
		}
		
		this.tourRepository.save(tourPackage);
		return tourPackage;
		
	}
	
	public String delTour(Integer id) {
		TourPackage tourPackage = new TourPackage();
		tourPackage=this.getById(id);
		this.tourRepository.delete(tourPackage);
		
		return "Tour deleted successfully for ID "+id;
	}
	
	public String storeFile(Integer id,MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("File is empty");
			}
			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
			
			try(InputStream inputStream=file.getInputStream()){
				Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);
			}
			TourPackage tourPackage=this.tourRepository.findById(id).orElse(null);
			
			String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/tourpackages/download")
					.path(file.getOriginalFilename())
					.toUriString();
			tourPackage.setImage_url(fileUploadUri);
			this.tourRepository.save(tourPackage);
			
		} catch (Exception e) {
			throw new StorageException("File not saved");
		}
		return "File Stored !!!";
	}
}
