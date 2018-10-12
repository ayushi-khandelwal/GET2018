package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = { "/","/login**" }, method = RequestMethod.GET)
	public String welcome() {
		return "login";
	}

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String loginSuccessfull(HttpServletRequest request) {
		System.out.println("vaibhav");
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/dashboard";
		} 
		if (request.isUserInRole("ROLE_EMPLOYEE")) {
			return "redirect:/employee/dashboard";
		}
		return "redirect:/error";
	}
	
	@GetMapping("/error")
	public String errorPage() {
		return "error";
	}
}