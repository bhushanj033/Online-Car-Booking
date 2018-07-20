package cdac.OnlineCarBookingBackEnd.Dao;

import java.util.List;

import cdac.OnlineCarBookingBackEnd.pojo.Customer;

public interface CustomerDao {

	List<Customer> listCustomers();
	String deleteCustomerDetails(Customer c);
	String addCustomerDetails(Customer c);
	String updateCustomerDetails(Customer c);
	Customer getCustomerDetails(int id);
	
	
}
