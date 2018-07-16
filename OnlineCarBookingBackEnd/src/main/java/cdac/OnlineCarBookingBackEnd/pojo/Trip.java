package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;

public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String source;
	String destination;
	String customerId;
	String driverId;
	Double amount;
	String status;
	String carType;
	String FriendMobileNumber,FriendName;
	
	public Trip(String source, String destination, String customerId, String driverId,
			Double amount, String status,String carType, String friendMobileNumber, String friendName)
	{
		super();
		this.source = source;
		this.destination = destination;
		this.customerId = customerId;
		this.driverId = driverId;
		this.amount = amount;
		this.status = status;
		this.carType = carType;
		FriendMobileNumber = friendMobileNumber;
		FriendName = friendName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getFriendMobileNumber() {
		return FriendMobileNumber;
	}

	public void setFriendMobileNumber(String friendMobileNumber) {
		FriendMobileNumber = friendMobileNumber;
	}

	public String getFriendName() {
		return FriendName;
	}

	public void setFriendName(String friendName) {
		FriendName = friendName;
	}

	
}
