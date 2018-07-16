package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;
import java.util.ArrayList;


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
		private Address address;
		private ArrayList<Phone> mobileNo = new ArrayList<Phone>();
		private String password;
		private boolean active=true;
		
		


		public Driver(long id, String firstName, String lastName, String username, String email, Address address, ArrayList<Phone>mobileNo, String password) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.address=address;
			this.mobileNo = mobileNo;
			this.password = password;
		}
	

		@Id
		@GeneratedValue
		@Column(name="Driver_Id")
		public long getId() {
			return id;
		}
	
	
		@Column(name="Driver_FirstName", nullable=false,length=100)
		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		@Column(name="Driver_LastName", nullable=false,length=100)
		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		@Column(name="Driver_UserName", nullable=false,length=100)
		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}

		@Column(name="Driver_Email", nullable=false)
		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		@OneToOne 
		public Address getAddress() {
			return address;
		}


		public void setAddress(Address address) {
			this.address = address;
		}


		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "Driver_MobileNo", joinColumns = { @JoinColumn(name = "Driver_Id") }, inverseJoinColumns = { @JoinColumn(name = "PHONE_ID") })
		public ArrayList<Phone> getMobileNo() {
			return this.mobileNo;
		}

		public void setMobileNo(ArrayList<Phone> mobileNo) {
			this.mobileNo= mobileNo;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isActive() {
			return active;
		}


		public void setActive(boolean active) {
			this.active = active;
		}


		@Override
		public String toString() {
			return "Customer id=" + id + ", username=" + username + ", email=" + email 
					+ ", mobileno=" + mobileNo + ", password=" + password+" ,Address= "+address;
		}
		
		
		
		
		
		
		
}
