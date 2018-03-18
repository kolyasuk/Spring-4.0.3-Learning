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
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("home");
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		request.getSession().setAttribute("user", user);
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
