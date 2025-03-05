package com.springboot.exception;

public class UserCustomException extends RuntimeException {
	public UserCustomException(String message) {
		super(message);
		System.out.println("Error message in UsercustomException"+message);
	}
}
