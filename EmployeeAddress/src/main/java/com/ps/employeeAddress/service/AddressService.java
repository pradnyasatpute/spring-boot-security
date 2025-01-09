package com.ps.employeeAddress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.employeeAddress.dao.AddDAO;
import com.ps.employeeAddress.dao.UpdateDAO;
import com.ps.employeeAddress.entity.EmployeeAddress;
import com.ps.employeeAddress.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public EmployeeAddress createAddress(AddDAO addDAO) {
		EmployeeAddress employeeAddress = new EmployeeAddress();
		
		employeeAddress.setCity(addDAO.getCity());
		employeeAddress.setState(addDAO.getState());
		employeeAddress.setCountry(addDAO.getCountry());
		
		this.addressRepository.save(employeeAddress);
		return employeeAddress;
	}
	
	public List<EmployeeAddress> getAll(){
		List<EmployeeAddress> address = new ArrayList<EmployeeAddress>();
		
		address=this.addressRepository.findAll();
		return address;
	}
	
	public EmployeeAddress getById(Integer id) {
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress=this.addressRepository.findById(id).orElse(null);
		return employeeAddress;
	}
	
	public EmployeeAddress updateAddress(UpdateDAO updateDAO, Integer id) {
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress = this.getById(id);
		
		if(updateDAO.getCity() !=null) {
			employeeAddress.setCity(updateDAO.getCity());
		}
		if(updateDAO.getState() !=null) {
			employeeAddress.setState(updateDAO.getState());
		}
		if(updateDAO.getCountry() !=null) {
			employeeAddress.setCountry(updateDAO.getCountry());
		}
		this.addressRepository.save(employeeAddress);
		return employeeAddress;
	}
	public String delAdd(Integer id) {
		EmployeeAddress employeeAddress=new EmployeeAddress();
		employeeAddress=this.getById(id);
		this.addressRepository.delete(employeeAddress);
		
		return "Address deleted Successfully";
	}
}
