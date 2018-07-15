package cdac.OnlineCarBookingBackEnd.pojo;

public class Customer {

		private int id;
		private String username;
		private String email;
		private Address address;
		private String mobileno;
		private String password;
		private boolean active=true;
		
		


		public Customer(int id, String username, String email, Address address, String mobileno, String password) {
			super();
			this.id = id;
			this.username = username;
			this.email = email;
			this.address = address;
			this.mobileno = mobileno;
			this.password = password;
		}


		
		


		public int getId() {
			return id;
		}

		
		public String getUsername() {
			return username;
		}






		public void setUsername(String username) {
			this.username = username;
		}






		public String getEmail() {
			return email;
		}






		public void setEmail(String email) {
			this.email = email;
		}






		public Address getAddress() {
			return address;
		}






		public void setAddress(Address address) {
			this.address = address;
		}






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
