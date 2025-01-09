package com.itvedant.vehicle.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.vehicle.dao.UpdateDAO;
import com.itvedant.vehicle.dao.VehicleDAO;
import com.itvedant.vehicle.entity.Vehicle;

@Service
public class VehicleService {
	private Map<Integer, Vehicle> vehicles=new HashMap<Integer, Vehicle>();
	private AtomicInteger counter = new AtomicInteger();
	
	public Vehicle createVehicle(VehicleDAO vehicleDAO) {
		Vehicle vehicle = new Vehicle();
		vehicle.setvId(counter.incrementAndGet());
		vehicle.setBrand(vehicleDAO.getBrand());
		vehicle.setModel(vehicleDAO.getModel());
		vehicle.setType(vehicleDAO.getType());
		
		this.vehicles.put(vehicle.getvId(), vehicle);
		
		return vehicle;
	}
	public Collection<Vehicle> getAll(){
		Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
		
		vehicle=this.vehicles.values();
		return vehicle;
		
	}
	
	public Vehicle getById(Integer id) {
		Vehicle vehicle = new Vehicle();
		vehicle=this.vehicles.get(id);
		return vehicle;
	}
	
	public Vehicle updateVehicle(UpdateDAO updateDAO,Integer id) {
		Vehicle vehicle = new Vehicle();
		vehicle=this.getById(id);
		
		if(updateDAO.getBrand() !=null) {
			vehicle.setBrand(updateDAO.getBrand());
		}
		if(updateDAO.getModel()!=null) {
			vehicle.setModel(updateDAO.getModel());
		}
		if (updateDAO.getType() !=null) {
			vehicle.setType(updateDAO.getType());
		}
		
		return vehicle;
	}
}
