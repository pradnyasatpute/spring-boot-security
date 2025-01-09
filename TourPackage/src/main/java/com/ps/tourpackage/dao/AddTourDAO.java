package com.ps.tourpackage.dao;

public class AddTourDAO {
	private String packageName;
	private String description;
	private String destination;
	private String duration;
	private Float pricePerPerson;
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Float getPricePerPerson() {
		return pricePerPerson;
	}
	public void setPricePerPerson(Float pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}
	
	
}
