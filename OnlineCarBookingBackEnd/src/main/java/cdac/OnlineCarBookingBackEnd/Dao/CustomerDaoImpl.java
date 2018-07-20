package cdac.OnlineCarBookingBackEnd.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cdac.OnlineCarBookingBackEnd.pojo.Customer;


@Repository("customerDAO")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Customer> listCustomers() {
		String jpql = "select c from Customer c";
		List<Customer> list=new ArrayList<>();
		list.add(new Customer(101, "Bhushan", "Jadhav", "bj", "bj@gmail", "123456", "123456789"));
		list.add(new Customer(101, "Bhushan", "Jadhav", "bj", "bj@gmail", "123456", "123456789"));
		list.add(new Customer(101, "Bhushan", "Jadhav", "bj", "bj@gmail", "123456", "123456789"));
		list.add(new Customer(101, "Bhushan", "Jadhav", "bj", "bj@gmail", "123456", "123456789"));
		return list;
		//return sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();	
	}

	@Override
	public String deleteCustomerDetails(Customer c) {
		sf.getCurrentSession().delete(c);
		return "Customer details deleted successfully for ID " +c.getId();
	}

	@Override
	public String addCustomerDetails(Customer c) {
		sf.getCurrentSession().persist(c);
		return "Vendor details added successfully with ID " +c.getId();
	}

	@Override
	public String updateCustomerDetails(Customer c) {
		//v -- detached pojo containing updated dtls
		sf.getCurrentSession().update(c);
		return "Customer details Updated successfully with ID " +c.getId();
	}

	@Override
	public Customer getCustomerDetails(int id) {
		
		return (Customer) sf.getCurrentSession().get(Customer.class, id);
	}

	
}
