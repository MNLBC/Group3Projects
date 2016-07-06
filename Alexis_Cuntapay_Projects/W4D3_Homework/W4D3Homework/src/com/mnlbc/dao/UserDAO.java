package com.mnlbc.dao;

import com.mnlbc.model.User;


public interface UserDAO {

	boolean registerAccount(User user);

	public boolean checkIfUserExist(String username);

	

}
