package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="Customer")
public class Customer implements Serializable { 
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private long id;
		private String firstName;
		private String lastName;
		private String username;
		private String email;
		private String mobileNo;
		private String password;
		private boolean active=true;
		private List<Trip> trips = new ArrayList<Trip>();
		


		public Customer(long id, String firstName, String lastName, String username, String email,String mobileNo, String password) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.mobileNo = mobileNo;
			this.password = password;
		}
	

		@Id
		@GeneratedValue
		@Column(name="customer_Id")
		public long getId() {
			return id;
		}
	
	
		@Column(name="Customer_FirstName", nullable=false,length=100)
		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		@Column(name="Customer_LastName", nullable=false,length=100)
		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		@Column(name="Customer_UserName", nullable=false,length=100)
		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}

		@Column(name="Customer_Email", nullable=false)
		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		
		@Column(name="mobile_no",nullable=false)
		public String getMobileNo() {
			return this.mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo= mobileNo;
		}

		@Column(name="password",nullable=false)
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		@Column(name="active")
		public boolean isActive() {
			return active;
		}


		public void setActive(boolean active) {
			this.active = active;
		}

		
		@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL)
		public List<Trip> getTrips() {
			return trips;
		}


		public void setTrips(List<Trip> trip) {
			this.trips = trip;
		}


		//Convenience method
		
				public void AddTrip(Trip trip)
				{
					trips.add(trip);
					trip.setCustomer(this);
				}
				
				public void removeTrip(Trip trip)
				{
					trips.remove(trip);
				}
				
		
		
		@Override
		public String toString() {
			return "Customer id=" + id + ", username=" + username + ", email=" + email 
					+ ", mobileno=" + mobileNo + ", password=" + password;
		}
		
		
		
		
		
		
		
		
}
