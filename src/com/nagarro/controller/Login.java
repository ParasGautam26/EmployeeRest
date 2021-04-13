package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.services.LoginService;

@Controller
public class Login {

	@Autowired
	private LoginService userService;

	@RequestMapping("/Login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password) {
		ModelAndView modelView = new ModelAndView();
		if (!userService.validateUser(username, password)) {
			modelView.setViewName("index");
			return modelView;
		}
		modelView.addObject("username", username);
		modelView.setViewName("redirect:/employee");
		return modelView;
	}

	@RequestMapping("/Signup")
	public ModelAndView signUp(@RequestParam String userName, @RequestParam String password) {
		ModelAndView modelView = new ModelAndView();
		userService.addUser(userName, password);
		modelView.addObject("userName", userName);
		modelView.setViewName("redirect:/employee");
		return modelView;
	}

	@RequestMapping("/Logout")
	public ModelAndView logOut() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("userName", null);
		modelView.setViewName("index");
		return modelView;
	}
}
