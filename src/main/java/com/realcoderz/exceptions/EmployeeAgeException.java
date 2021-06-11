package com.realcoderz.exceptions;

public class EmployeeAgeException extends Exception {

	@Override
	public String getMessage() {
		
		return "Employee age should be greater than 25";
	}

	
	
}
