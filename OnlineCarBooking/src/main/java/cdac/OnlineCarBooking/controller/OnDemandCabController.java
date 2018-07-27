

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.NoResultException;
import javax.servlet.http.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdac.OnDemandCabBackEnd.service.OnDemandCabServiceImp;


@RestController
@RequestMapping("/User")
public class OnDemandCabController {
	@Autowired
	private OnDemandCabServiceImp service;
	/*
	 * @Autowired private JavaMailSender mailSender;
	 */
	@Autowired
	private HttpSession hs = null;

	@PostConstruct
	public void init() {
		System.out.println("in init : controller ");
	}

/*	@GetMapping("/search/{source}/{destination}/{date}")
	public ResponseEntity<?> searchRide(@PathVariable String source, @PathVariable String destination,
			@PathVariable String date) {
		try {
			System.out.println("search");
			if (service.searchRide(source, destination, date).size() != 0) {
				return new ResponseEntity<List<OfferedRide>>(service.searchRide(source, destination, date),
						HttpStatus.OK);
			} else {

				return new ResponseEntity<String>("No ride found between these location on selected date.",
						HttpStatus.NO_CONTENT);
			}
		} catch (NoResultException e) {
			return new ResponseEntity<String>("No ride found between these location on selected date.",
					HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/offer")
	public ResponseEntity<?> offerRide(@RequestBody OfferedRide offeredRide, HttpServletRequest request) {
		hs = request.getSession();
		System.out.println(request.getSession().getId());
		User u = (User) hs.getAttribute("user");
		try {
			return new ResponseEntity<Integer>(service.offerRide(u.getUserName(), offeredRide), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Please login!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> createAccount(@RequestBody RigesterHandler Handler) {
		try {
			System.out.println(Handler);
			return new ResponseEntity<String>(service.registerUser(Handler.getUser(), Handler.getLogin()),
					HttpStatus.OK);
		} catch (DuplicateKeyException e) {
			return new ResponseEntity<String>("Username already present", HttpStatus.NO_CONTENT);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			return new ResponseEntity<String>("Email/MobileNo. already present",
					HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return new ResponseEntity<String>("Email/MobileNo. already present",
					HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
*/
	@PostMapping("/login")
	public ResponseEntity<?> validate(@RequestBody User user , HttpServletRequest request) {
		try {
			System.out.println(user);
			System.out.println(request.getSession().getId());
			User validateUser = service.validateLogin(user);
			if (user == null) {
				return new ResponseEntity<String>("Invalid Password. Please retry!!", HttpStatus.NO_CONTENT);
			} else {
				hs = request.getSession();
				System.out.println(hs.getId());
				hs.setAttribute("user", validateUser);
				return new ResponseEntity<String>(validateUser.getUserName(), HttpStatus.OK);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Invalid Username. Please retry!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
/*
	@GetMapping("/profile")
	public ResponseEntity<?> getUserProfile(HttpServletRequest request) {
		try {
			HttpSession hs = request.getSession();
			User user = (User) hs.getAttribute("user");
			return new ResponseEntity<User>(service.userDetail(user.getUserName()), HttpStatus.OK);
		} catch (NullPointerException e) {
			// HttpHeaders headers = new HttpHeaders();
			// headers.setLocation(URI.create("localhost:4200/login"));
			// return new ResponseEntity<HttpHeaders>(headers,
			// HttpStatus.MOVED_PERMANENTLY);
			return new ResponseEntity<String>("Please Login!!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/bookride")
	public ResponseEntity<?> book(@RequestBody BookRideHandler bookRideHandler, HttpServletRequest request) {
		try {
			hs = request.getSession();
			User u = (User) hs.getAttribute("user");
			int i = service.bookRide(u.getUserName(), bookRideHandler.getRideId(), bookRideHandler.getNoOfSeats());
			User user = service.rideDetail(bookRideHandler.getRideId());
			System.out.println("mail bhejna start");
			// SimpleMailMessage message = new SimpleMailMessage();
			// message.setTo(u.getEmail());
			// message.setSubject("Ride Booked");
			// message.setText("Your ride Has been booked with id"
			// + i
			// + " Please Contact User");
			// mailSender.send(message);
			// System.out.println("mail bhej diya");
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("****************", "*****************");
				}
			});

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("********************"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getEmail()));
				message.setSubject("Ride Booked");
				message.setText("Hi, Your ride has been booked successfully with ride id " + i
						+ " Please Contact ride provide for more information." + user.getFirstName() + " "
						+ user.getLastName() + "Phone No. " + user.getContactNo() + " Email:" + user.getEmail());
				Transport.send(message);
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
				message.setSubject("Ride Booked");
				message.setText("Hi, a user successfully booked ride with ride id " + i
						+ " Please Contact ride provide for more information." + u.getFirstName() + " "
						+ u.getLastName() + " Phone No. " + u.getContactNo() + " Email:" + u.getEmail());
				Transport.send(message);
				System.out.println("Sent message successfully....");

			} catch (MessagingException e) {
				// ;
			}
			return new ResponseEntity<Integer>(i, HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Please Login!!!", HttpStatus.NO_CONTENT);
		} catch (StackOverflowError e) {
			return new ResponseEntity<String>("not booked", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listedrides")
	public ResponseEntity<?> rideDetails(HttpServletRequest request) {
		hs = request.getSession();
		User u = (User) hs.getAttribute("user");
		try {
			return new ResponseEntity<List<OfferedRide>>(service.rideDetail(u.getUserName()), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Please Login!!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/bookingdetails")
	public ResponseEntity<?> bookingDetails(HttpServletRequest request) {
		hs = request.getSession();
		User u = (User) hs.getAttribute("user");
		try {
			return new ResponseEntity<List<BookedRideDetails>>(service.bookingDetail(u.getUserName()), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<String>("Please Login!!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/driverdetails")
	public ResponseEntity<?> addOfferRiderDetail(@RequestBody OfferRiderDetail offerRiderDetail,
			HttpServletRequest request) {
		try {
			if (offerRiderDetail.getUserName().equals(request.getSession().getAttribute("user")))
				return new ResponseEntity<String>(service.addOfferRiderDetail(offerRiderDetail), HttpStatus.OK);
			else
				return new ResponseEntity<String>("Please Login!!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/adminregister")
	public ResponseEntity<?> adminRegister(@RequestBody AdminHandler adminHandler) {
		try {
			return new ResponseEntity<String>(
					service.adminRegister(adminHandler.getAdminDetail(), adminHandler.getAdminLogin()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/verifyuser")
	public ResponseEntity<?> verifyUser(@RequestBody VerifyUserHandler verifyUserHandler, HttpServletRequest request) {
		try {
			hs = request.getSession();
			String AdminUserName = (String) hs.getAttribute("adminUserName");
			return new ResponseEntity<Integer>(service.verifyUser(AdminUserName, verifyUserHandler.getUserName(),
					verifyUserHandler.getVerifiedUser()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ResponseEntity<String>("Logout Successfully!!", HttpStatus.OK);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> changepassword(@RequestBody UpdatePasswordHandler updatePasswordHandler,
			HttpServletRequest request) {
		hs = request.getSession();
		User u = (User) hs.getAttribute("user");
		try {
			if (service.changePassword(u.getUserName(), "" + updatePasswordHandler.getOldPassword().hashCode(),
					"" + updatePasswordHandler.getNewPassword().hashCode())) {
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "465");
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("****************", "*****************");
					}
				});
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("***************"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getEmail()));
				message.setSubject("Ride Booked");
				message.setText("Hi, Your password Has been changed. New Password is : "
						+ updatePasswordHandler.getNewPassword());
				Transport.send(message);
				return new ResponseEntity<String>("Password Updated Successfully", HttpStatus.OK);
			} else
				return new ResponseEntity<String>("Unable to Update Password", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/updateuser")
	public ResponseEntity<?> updateUser(@RequestBody User user, HttpServletRequest request) {

		try {
			if (user.getUserName().equals(((User) request.getSession().getAttribute("user")).getUserName())) {
				if (service.updateUser(user))
					return new ResponseEntity<String>("User Details Update Successfully", HttpStatus.OK);
				else
					return new ResponseEntity<String>("Unable to Update User", HttpStatus.OK);
			} else
				return new ResponseEntity<String>("Please Login!!!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/cancelBooking")
	public ResponseEntity<?> cancelBooking(@RequestBody CancelBookingHandler cancelBookingHandler,
			HttpServletRequest request) {
		try {
			if ((User) request.getSession().getAttribute("user") != null) {
				int BookingId = service.cancelBooking(cancelBookingHandler.getBookId(),
						cancelBookingHandler.getCancelSeat());
				if (BookingId != 0)
					return new ResponseEntity<String>("Ride with " + BookingId + " is cancelled", HttpStatus.OK);
				else
					return new ResponseEntity<String>("Unable to Process Request", HttpStatus.NO_CONTENT);
			} else
				return new ResponseEntity<String>("Please Login!!!", HttpStatus.NOT_ACCEPTABLE);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/userdetail/{userName}")
	public ResponseEntity<?> offerUser(@PathVariable String userName) {
		try {
			return new ResponseEntity<User>(service.offerUser(userName), HttpStatus.OK);
		} catch (NullPointerException e) {
			// TODO: handle exception
			return new ResponseEntity<String>("User not found", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/admin")
	public ResponseEntity<?> validateAdmin(@RequestBody AdminLogin adminLogin) {
		System.out.println(adminLogin);
		if (service.adminLogin(adminLogin))
			return new ResponseEntity<String>(adminLogin.getAdminName(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Not Found", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/unverifieduser")
	public ResponseEntity<?> userList() {
		return new ResponseEntity<ArrayList<OfferRiderDetail>>(service.unVerifiedUser(), HttpStatus.OK);
	}

	@PostMapping("/verifyusers")
	public ResponseEntity<?> verify(@RequestBody LinkedHashMap<String, Boolean> list) {
		try {
			Object[] s = list.keySet().toArray();
			System.out.println(s);
			return new ResponseEntity<String>(service.adminVerification((String) s[0]), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}