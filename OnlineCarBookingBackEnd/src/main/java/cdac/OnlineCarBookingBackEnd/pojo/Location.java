package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable
public class Location implements Serializable {

	
	double latitude;
	double longitude;
	public Location(double latitude, double longitude) 
	{
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Column
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	@Column
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}	
	
}
