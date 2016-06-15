package com.w1d3;

public class TestRegex {

	public static void main(String [] args){
		Regex reg = new Regex();
		
		//email
		System.out.println(reg.isValidEmail("brionse@corp.oocl.com"));
		System.out.println(reg.isValidEmail("brionsasdfasfd"));
		
		//mobile phone number
		System.out.println(reg.isValidMobileNumber("09064667035"));
		System.out.println(reg.isValidMobileNumber("123123"));
		
	}
}
