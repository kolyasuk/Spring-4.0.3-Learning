package iful.edu.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import iful.edu.spring.objects.User;

@Controller
@SessionAttributes("user") // save user to session
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@ModelAttribute
	public User createNewUser(HttpServletRequest request) {
		return new User();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (!bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("redirect", "FlashAttribute");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/mainpage");
			return mv;
		}

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public String goMain(HttpServletRequest request) {
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			logger.info("redirect!");
		} else {
			logger.info("refresh");
		}
		return "main";
	}

	@RequestMapping("/failed")
	public ModelAndView checkLogin() {
		return new ModelAndView("failed", "message", "Error bitch!");
	}

}
