package cdac.OnlineCarBookingBackEnd.pojo;

import java.io.Serializable;
import java.util.ArrayList;


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
		private ArrayList<Phone> mobileNo = new ArrayList<Phone>();
		private String password;
		private boolean active=true;
		
		


		public Customer(long id, String firstName, String lastName, String username, String email, ArrayList<Phone>mobileNo, String password) {
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
		@Column(name="Customer_Id")
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


		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "Customer_MobileNo", joinColumns = { @JoinColumn(name = "Customer_Id") }, inverseJoinColumns = { @JoinColumn(name = "PHONE_ID") })
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
					+ ", mobileno=" + mobileNo + ", password=" + password;
		}
		
		
		
		
		
		
		
}
