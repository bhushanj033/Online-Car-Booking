package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;
import java.sql.Date; //util or sql confused

import javax.persistence.*;

@Entity
@Table(name="Trips")

public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int tripId;
	Location source,destination;
	Customer customer;
	Driver driver;
	Double amount;
	String cabType;
	Date Start,End;
	boolean active,isCancelled;
	
	public Trip(Location source, Location destination,Double amount,String cabType,Date start,Date end)
	{
		super();
		this.source = source;
		this.destination = destination;
		this.amount = amount;
		this.cabType = cabType;
		this.Start=start;
		this.End=end;
		this.active=true;
		this.isCancelled=false;
	}

	
	@Column(name="start_time")
	public Date getStart() {
		return Start;
	}



	public void setStart(Date start) {
		Start = start;
	}


	@Column(name="end_time")
	public Date getEnd() {
		return End;
	}



	public void setEnd(Date end) {
		End = end;
	}


	@Id
	@GeneratedValue
	@Column(name="TripId")
	public int getTripId() {
		return tripId;
	}


	@Embedded
	public Location getSource() {
		return source;
	}

	
	public void setSource(Location source) {
		this.source = source;
	}

	@Embedded
	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	@ManyToOne
	@JoinColumn(name="customer_Id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name="driver_Id")
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Column(name="amount")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	@Column(name="cab_type")
	public String getcabType() {
		return cabType;
	}

	public void setcabType(String cabType) {
		this.cabType = cabType;
	}


	@Column(name="active")
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}


	
	@Column(name="cancelled")
	public boolean isCancelled() {
		return isCancelled;
	}



	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}


	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", source=" + source + ", destination=" + destination + ", customer="
				+ customer + ", driver=" + driver + ", amount=" + amount + ", cabType=" + cabType + ", Start=" + Start
				+ ", End=" + End + "]";
	}

	
	
	
	
}
