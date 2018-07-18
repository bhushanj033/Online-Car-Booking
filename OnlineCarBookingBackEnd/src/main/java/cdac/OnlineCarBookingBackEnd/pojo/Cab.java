package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
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

	@Column(name="owner_name")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name="cost_pr_km")
	public double getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	}

}