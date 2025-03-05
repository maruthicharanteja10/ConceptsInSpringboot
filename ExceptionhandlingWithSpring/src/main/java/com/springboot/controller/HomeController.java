package com.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.exception.UserCustomException;


@Controller
public class HomeController {
	@GetMapping("/")
	public String getUserById( Model model) {
		String id=null;
		//Handling using userCustomException
		if (id == null) {
			throw new UserCustomException("User ID cannot be null");
		}	
		id.length();
		return "user"; // View name
	}

	// **Controller-Based Exception Handling for NullPointerException**
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex, Model model) {
		model.addAttribute("error", "Error occurred(Controller ExceptionHandler):" + ex.getMessage());
		return "error";
	}
	
	//Works when userCustomException is created
	@ExceptionHandler(UserCustomException.class)
	public String handleNullPointerException(UserCustomException ex, Model model) {
		model.addAttribute("error", "Error occurred(CustomException):" + ex.getMessage());
		return "error";
	}

}
