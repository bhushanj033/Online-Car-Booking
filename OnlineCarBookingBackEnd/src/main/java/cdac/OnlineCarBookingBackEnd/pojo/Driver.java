package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="Driver")
public class Driver implements Serializable {

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
		private Cab cab;
		private boolean active=true;
		private Location location;
		private byte[] photo; 
		private List<Trip> trips = new ArrayList<Trip>();
		


		public Driver(long id, String firstName, String lastName, String username, String email, String mobileNo, String password,Cab cab,Location location,
				byte[] photo) 
		{
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.mobileNo = mobileNo;
			this.password = password;
			this.cab=cab;
			this.location=location;
			this.photo=photo;
		}
	

		@Id
		@GeneratedValue
		@Column(name="driver_id")
		public long getId() {
			return id;
		}
	
	
		@Column(name="firstname", nullable=false,length=100)
		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		@Column(name="lastname", nullable=false,length=100)
		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		@Column(name="username", nullable=false,length=100)
		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}

		@Column(name="driver_email", nullable=false)
		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		
		@Column(name="mobileNO")
		public String getMobileNo() {
			return this.mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo= mobileNo;
		}

		@Column(name="password")
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		@Embedded
		public Cab getCab() {
			return cab;
		}


		public void setCab(Cab cab) {
			this.cab = cab;
		}
		
		
		

		@Embedded
		public Location getLocation() {
			return location;
		}


		public void setLocation(Location location) {
			this.location = location;
		}

		@Column(name="photo")
		public byte[] getPhoto() {
			return photo;
		}


		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}
		
		
		@Column(name="active_status")
		public boolean isActive() {
			return active;
		}


		public void setActive(boolean active) {
			this.active = active;
		}
		
		@OneToMany(mappedBy = "driver",cascade=CascadeType.ALL)
		public List<Trip> getTrips() {
			return trips;
		}


		public void setTrips(List<Trip> trips) {
			this.trips = trips;
		}

		//Convenience method
		
		public void AddTrip(Trip trip)
		{
			trips.add(trip);
			trip.setDriver(this);
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
