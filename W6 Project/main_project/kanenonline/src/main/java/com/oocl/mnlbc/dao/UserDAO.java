package com.oocl.mnlbc.dao;

import java.util.List;
import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author John Benedict Vergara
 *
 */
public interface UserDAO extends GenericDAO<User> {

	boolean userExists(String username);

	User validateAccount(String username, String password);

	boolean registerUser(User user);

	List<User> getBannedUsers();

	boolean emailExists(String email);
	
	boolean changePassword(User user, String newPassword);

}
