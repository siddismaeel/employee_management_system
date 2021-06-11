package com.realcoderz.util;

import static org.junit.Assert.assertTrue;

import java.util.Date;

public class DateCalculation {
	
	public static long getAge(Date date) {
		long age = 0;
		
		long differenceDate = new Date().getTime() - date.getTime();
		
		age = (differenceDate / (1000l * 60 * 60 * 24 * 365));

		System.out.println(differenceDate);
		return age;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
	}
}
