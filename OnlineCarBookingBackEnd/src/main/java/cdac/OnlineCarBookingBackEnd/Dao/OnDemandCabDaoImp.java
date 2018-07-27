package com.app.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojo.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OnDemandCabDaoImp implements OnDemandCabDao {
	@Autowired
	private SessionFactory sf;

	
	@Override
	public long registerUser(User user) {
		long userId;
		Session hs = sf.getCurrentSession();
			userId= (long)hs.save(user);
			return userId;
	}

	

	@Override
	public User userDetail(long userId) {
		User user = null;
		Session hs = sf.getCurrentSession();
		user = hs.get(User.class, userId);
		return user;
	}


	@Override
	public List<BookedRides> bookingDetail(long userId) {
		String jpql = "select brd from BookedRides brd where brd.user = :user";
		Session hs = sf.getCurrentSession();
		ArrayList<BookedRides> list = null;
		User u = hs.get(User.class, userId);
		list = (ArrayList<BookedRides>) hs.createQuery(jpql, BookedRides.class).setParameter("user", u)
				.getResultList();
		System.out.println(list);
		return list;
	}



	@Override
	public String adminRegister(AdminDetail adminDetail) {
		String userName;
		Session hs = sf.getCurrentSession();
		userName = (String) hs.save(adminDetail);
		return userName;
	}

	@Override
	public Integer cancelBooking(Integer bookId) {
		Session hs = sf.getCurrentSession();
		BookedRides bookedRideDetails = hs.get(BookedRides.class, bookId);
		return 0;
	}

	@Override
	public Boolean updateUser(User user) {
		Session hs = sf.getCurrentSession();
		hs.saveOrUpdate(user);
		return true;
	}

	@Override
	public Boolean changePassword(long userId, String oldPassword, String newPassword) {
		boolean flag = false;
		Session hs = sf.getCurrentSession();
		User user;
		user = hs.get(User.class, userId);
		if (user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
			flag = true;
		}
		return flag;
	}





	@Override
	public int bookRide(long userId) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public User rideDetail(long rideid) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
