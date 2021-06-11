package com.realcoderz.util;

import java.util.Random;

import org.apache.log4j.Logger;

public class IDGenerator {

	private static final Logger LOGGER = Logger.getLogger(IDGenerator.class);
	

	/*
	 * public static String generateUserId() {
	 * LOGGER.info("starts generateUserId method"); String userId= "UID"; Random
	 * rand = new Random(); String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
	 * 
	 * for(int i = 0; i< 8; i++) { userId +=
	 * chars.charAt(rand.nextInt(chars.length())); }
	 * 
	 * 
	 * return userId; }
	 */
	
	public static String generatePassword()
	{
		
		LOGGER.info("starts generatePassword method");
		Random rand = new Random();
		
		String chars = "0123456789";
		String password = "";
		
		for(int i =0; i< 6; i++)
		{
			password += chars.charAt(rand.nextInt(chars.length()));
		}
		
		LOGGER.info("Ends generatePassword method");
		return password;
	}
	
	

	
	
}
