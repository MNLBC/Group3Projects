package com.oocl.mnlbc.dao;

public interface UserDAO {
	public void create(String userName, String password, String fullName, String mobileNo, String emailAdd);
}
