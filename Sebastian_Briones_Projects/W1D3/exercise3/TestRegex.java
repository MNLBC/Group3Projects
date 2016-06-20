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
		
		//replace A
		System.out.println(reg.replaceWithA("The cat with a hat"));
		
		//get Month
		System.out.println(reg.getMonth("Tue Jun 14 21:30:31 CST 2016"));
	}
}
