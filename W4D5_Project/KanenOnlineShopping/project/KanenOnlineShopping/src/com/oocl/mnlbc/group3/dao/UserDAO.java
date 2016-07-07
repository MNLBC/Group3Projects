package com.oocl.mnlbc.group3.dao;


public interface UserDAO {

	public boolean userExists(String username);
	
	public boolean validateAccount(String username, String password);
	
	public boolean registerUser(String username, String userPassword, String fullName, String email, 
			String address, String mobileNumber,String userRole,double userBalance);
	
}
