package com.app.pojo;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="booked_rides")
public class BookedRides {
	
	@Id
	@Column(name = "ride_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rideId;

	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "start_time")
	@Temporal(TemporalType.DATE)
	private Date startTime;
	
	@Column(name = "End_time")
	@Temporal(TemporalType.DATE)
	private Date endTime;
	
	@ManyToOne
	@JoinColumn(name="cab_Id")
	private Cab cab;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;
	
	@Column(name="feedbeck")
	private String feedback;
	
	@Column (name="ratings")
	@Min(1)
	@Max(5)
	private int ratings;

	public BookedRides(String source, String destination, Date startTime, Date endTime, Cab cab, User user) {
		super();
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cab = cab;
		this.user = user;
	}

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
}
