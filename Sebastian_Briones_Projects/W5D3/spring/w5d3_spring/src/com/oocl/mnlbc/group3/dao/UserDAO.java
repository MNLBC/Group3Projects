package com.oocl.mnlbc.group3.dao;

import java.util.List;
import com.oocl.mnlbc.group3.model.User;

public interface UserDAO {

	public boolean userExists(String username);

	public User validateAccount(String username, String password);
	
	public boolean registerUser(User user);
	
	public List<User> getBannedUsers();

	boolean emailExists(String email);

}
