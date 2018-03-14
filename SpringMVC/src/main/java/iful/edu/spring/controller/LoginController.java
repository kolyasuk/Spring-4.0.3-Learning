package iful.edu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iful.edu.spring.objects.User;

@Controller
public class LoginController {
		
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("home", "user", new User());
	}
	
	@RequestMapping(value="/check-user", method = RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("user") User user) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		
		mv.addObject("user", user);
		
		return mv;
		
	}
}
