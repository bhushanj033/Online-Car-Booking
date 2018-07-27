package com.app.service;

import java.util.ArrayList;
import java.util.List;
import com.app.pojo.AdminDetail;
import com.app.pojo.BookedRides;
import com.app.pojo.User;


public interface OnDemandCabService {
	public long registerUser(User user);

	public User userDetail(long userId);

	public List<BookedRides> bookingDetail(long userId);


	public String adminRegister(AdminDetail adminDetail);

	public Boolean changePassword(long userId, String oldPassword, String newPassword);

	public Boolean updateUser(User user);


	public Integer cancelBooking(Integer bookId);

	int bookRide(long userId);

	User rideDetail(long rideid);

	public User validateLogin(User user);

}
