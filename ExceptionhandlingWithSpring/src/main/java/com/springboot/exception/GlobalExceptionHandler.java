package com.springboot.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	// Global Exception Handling for NullPointerException
	@ExceptionHandler(NullPointerException.class)
	public String handleGlobalNullPointer(NullPointerException ex, Model model) {
		model.addAttribute("error", "Global-Level: " + ex.getMessage());
		return "globalerror"; // Redirect to error page
	}

	// Catch-all Exception Handler
	@ExceptionHandler(Exception.class)
	public String handleGlobalException(Exception ex, Model model) {
		model.addAttribute("error", "Global-Level (Generic): " + ex.getMessage());
		return "globalerror";
	}

}
