package cdac.OnlineCarBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cdac.OnlineCarBookingBackEnd.Dao.CustomerDaoImpl;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDaoImpl customerDAO;
	
		@RequestMapping(value= {"/","/home","/login"})
		public ModelAndView login()
		{
			ModelAndView mv = new ModelAndView("login");
			return mv;
			
		}
		
		@RequestMapping(value= {"/listCustomer"})
		public ModelAndView CustomerList()
		{
			ModelAndView mv = new ModelAndView("CustomerList");
			mv.addObject("Customers",customerDAO.listCustomers());
			return mv;
		}
}
