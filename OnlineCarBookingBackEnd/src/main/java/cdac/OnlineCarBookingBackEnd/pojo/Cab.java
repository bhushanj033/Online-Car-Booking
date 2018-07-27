package com.app.pojo;


import java.util.List;

import javax.persistence.*;


@Embeddable
public class Cab {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabNumber;
	private String cabType;
	private String cabName;
	private double costPerKm;
	private Driver driver;
	private List<BookedRides> bookedRides;
	

	public Cab(String cabNumber, String cabType, String cabName, double costPerKm,Driver driver) {
		super();
		this.cabNumber = cabNumber;
		this.cabType = cabType;
		this.cabName = cabName;
		this.costPerKm = costPerKm;
		this.driver=driver;
	}

	@Column(name="cab_number")
	public String getCabNumber() {
		return cabNumber;
	}
	
	
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	
	@Column(name="cab_type")
	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	@Column(name="cab_name")
	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}
	
	
	@Column(name="cost_pr_km")
	public double getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	}

	@Embedded
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@OneToMany(mappedBy = "cab")
	public List<BookedRides> getBookedRides() {
		return bookedRides;
	}

	public void setBookedRides(List<BookedRides> bookedRides) {
		this.bookedRides = bookedRides;
	}
	
	
	
}