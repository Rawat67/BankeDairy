package com.banke.dairy.validator;

public class AdminValidator {
	
	public static Boolean validateEmail(String email) {
		if(email==null) {
			return false;
		}
		return email.matches("[A-Za-z0-9_]+@[A-Za-z]+[.]com");
	}
	
}
