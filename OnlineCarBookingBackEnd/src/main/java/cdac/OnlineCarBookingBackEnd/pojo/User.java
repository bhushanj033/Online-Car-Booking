 package com.app.pojo;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;




@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId; 
	
	@Column(name = "user_name",unique=true)
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "account_status")
	private boolean accountStatus;
	
	@Column(name = "registration_date")
	@Temporal(TemporalType.DATE)
	private Date registrationDate;

	@OneToMany(mappedBy = "user")
	private List<BookedRides> bookedRides;
	
	/* `static private DateTimeFormatter dtf;
	
	
	
	static { DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		  }    
*/

	public User() {
		System.out.println("user def constr");
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String firstName, String lastName, String email, String contactNo, String gender,
			boolean accountStatus) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.gender = gender;
		this.accountStatus = accountStatus;
		this.registrationDate = new Date();
	}

	
	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	public List<BookedRides> getBookedRides() {
		return bookedRides;
	}

	public void setBookedRides(List<BookedRides> bookedRides) {
		this.bookedRides = bookedRides;
	}

	public void addbookedRideDetail(BookedRides brd) {
		if (bookedRides == null) {
			bookedRides = new ArrayList<>();
		}
		bookedRides.add(brd);
		brd.setUser(this);
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", accountStatus=" + accountStatus
				+ ", registrationDate=" + registrationDate + "]";
	}

}
