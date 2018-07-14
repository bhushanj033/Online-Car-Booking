package cdac.OnlineCarBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

		@RequestMapping(value= {"/","/home","/login"})
		public ModelAndView login()
		{
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("greetings","Welcome to Spring MVC");
			return mv;
			
		}
	
}
