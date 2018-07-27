package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.*;
import com.app.pojo.*;

@Service
@Transactional
public class OnDemandCabServiceImp implements OnDemandCabService {
	@Autowired
	private OnDemandCabDao dao;

	@Override
	public long registerUser(User user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	
	@Override
	public int bookRide(long userId) {
		// TODO Auto-generated method stub
		return dao.bookRide(userId);
	}

	@Override
	public User userDetail(long userId) {
		// TODO Auto-generated method stub
		return dao.userDetail(userId);
	}

	@Override
	public List<BookedRides> bookingDetail(long userId) {
		// TODO Auto-generated method stub
		return dao.bookingDetail(userId);
	}

	@Override
	public String adminRegister(AdminDetail adminDetail) {
		// TODO Auto-generated method stub
		return dao.adminRegister(adminDetail);
	}

	@Override
	public Boolean changePassword(long userId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return dao.changePassword(userId, oldPassword, newPassword);
	}

	@Override
	public Boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public Integer cancelBooking(Integer bookId) {
		// TODO Auto-generated method stub
		return dao.cancelBooking(bookId);
	}


	@Override
	public User rideDetail(long rideid) {
		return dao.rideDetail(rideid);
	}


	@Override
	public User validateLogin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
