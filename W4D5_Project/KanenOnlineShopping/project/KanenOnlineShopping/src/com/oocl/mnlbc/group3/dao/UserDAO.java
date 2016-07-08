package com.oocl.mnlbc.group3.dao;

import java.util.List;

import com.oocl.mnlbc.group3.model.UserBean;

public interface UserDAO {

	public boolean userExists(String username);

	public UserBean validateAccount(String username, String password);
	

	public boolean registerUser(UserBean user);
	
	public List<UserBean> getBannedUsers();

}
