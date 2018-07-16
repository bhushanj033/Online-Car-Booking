package cdac.OnlineCarBookingBackEnd.pojo;

@Entity
@Table(name="Customer")
public class Customer {

		private long id;
		private String firstName;
		private String lastName;
		private String username;
		private String email;
		private Address address;
		private String mobileno;
		private String password;
		private boolean active=true;
		
		


		public Customer(long id, String firstName, String lastName, String username, String email, Address address, String mobileno, String password) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.address = address;
			this.mobileno = mobileno;
			this.password = password;
		}
	

		@Id
		@GeneratedValue
		@Column(name="Customer_ID")
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

		
		@ManyToOne(cascade = CascadeType.ALL)
		public Address getAddress() {
			return address;
		}


		public void setAddress(Address address) {
			this.address = address;
		}

		@Column(name="Customer_Mobile", nullable=false)
		public String getMobileno() {
			return mobileno;
		}


		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
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
					+ ", mobileno=" + mobileno + ", password=" + password + ", address=" + address;
		}
		
		
		
		
		
		
		
}
