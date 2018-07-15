
	package cdac.OnlineCarBookingBackEnd.pojo;

	public class Address {

		private String addressline;
		private String city;
		private String State;
		private String country;
		private int pincode;
		
		
		public Address(String addressline, String city, String state, String country, int pincode) {
			super();
			this.addressline = addressline;
			this.city = city;
			State = state;
			this.country = country;
			this.pincode = pincode;
		}


		public String getAddressline() {
			return addressline;
		}


		public void setAddressline(String addressline) {
			this.addressline = addressline;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return State;
		}


		public void setState(String state) {
			State = state;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public int getPincode() {
			return pincode;
		}


		public void setPincode(int pincode) {
			this.pincode = pincode;
		}


		@Override
		public String toString() {
			return "Addresss:  " + addressline + ", city=" + city + ", State=" + State + ", country=" + country
					+ ", pincode=" + pincode + "]";
		}
		
		
		
		
	}
