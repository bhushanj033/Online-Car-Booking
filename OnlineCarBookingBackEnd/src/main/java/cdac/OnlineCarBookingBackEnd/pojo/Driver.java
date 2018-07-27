package com.app.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Embeddable
public class Driver {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		private String firstName;
		private String lastName;
		private String email;
		private String mobileNo;
	
	
		


		public Driver(String firstName, String lastName, String email, String mobileNo) {
			super();
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobileNo = mobileNo;
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
		

		@Column(name="driver_email", nullable=false,unique=true)
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


}
