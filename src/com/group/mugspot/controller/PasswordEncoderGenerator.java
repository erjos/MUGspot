package com.group.mugspot.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {
		String password = "myfavoritePassword";
		System.out.println(encodePassword(password));
	}
	
	//creating a static method that takes a string and encodes it seing the BCryptPasswordEncoder
	public static String encodePassword(String password){
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashPassword = passwordEncoder.encode(password);
			
			return hashPassword; 
		}
}
