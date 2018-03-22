package iful.edu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iful.edu.spring.objects.Calculator;
import iful.edu.spring.objects.User;

@Controller
// @SessionAttributes("user") // save user to session
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		User user = new User();
		ModelAndView mv = new ModelAndView();
		user.setName("123");
		user.setPassword("123");
		mv.setViewName("login");
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("login");
		}

		request.getSession().setAttribute("user", user);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		mv.addObject("user", request.getSession().getAttribute("user"));

		mv.addObject("calc", new Calculator());

		return mv;
	}

	@RequestMapping(value = "/calculator", method = RequestMethod.POST)
	public ModelAndView calcul(@ModelAttribute("calc") Calculator calc) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		int result = calc.getArg1() + calc.getArg2();

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping("/failed")
	public ModelAndView checkLogin() {
		return new ModelAndView("failed", "message", "Error bitch!");
	}

}
