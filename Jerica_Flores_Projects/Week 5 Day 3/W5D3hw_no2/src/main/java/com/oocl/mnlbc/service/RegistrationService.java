package com.oocl.mnlbc.service;

 
 public class RegistrationService { 
 
	public boolean testingRegistration(String userName, String password, String fullName, String mobileNo, 
 			String emailAdd) { 
		return (userName != "" && password != "" && fullName != "" && mobileNo != "" 
				&& emailAdd != ""); 
 	} 
 	 
 } 
