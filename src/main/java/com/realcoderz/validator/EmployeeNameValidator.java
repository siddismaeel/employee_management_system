package com.realcoderz.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeNameValidator implements ConstraintValidator<EmployeeNameValidatorVal, String>{

	@Override
	public void initialize(EmployeeNameValidatorVal constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String employeeName, ConstraintValidatorContext context) {
		
		System.out.println("validator called");
		if(employeeName == null)
		{
			return false;
		}
		
		if(employeeName.length() <= 3)
		{
			return false;
		}
		else 
		{
			return true;
		}
		
		
	}

}
