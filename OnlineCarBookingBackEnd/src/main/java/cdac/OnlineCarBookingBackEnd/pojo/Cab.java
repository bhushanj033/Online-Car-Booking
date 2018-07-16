package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;

public class Cab implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cabNumber;
	String cabType;
	String cabName;
	double costPerKm;
	String ownerName;

	public Cab(String cabNumber, String cabType, String cabName,String ownerName, double costPerKm) {
		super();
		this.cabNumber = cabNumber;
		this.cabType = cabType;
		this.cabName = cabName;
		this.ownerName = ownerName;
		this.costPerKm = costPerKm;
	}

	public String getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	}

}