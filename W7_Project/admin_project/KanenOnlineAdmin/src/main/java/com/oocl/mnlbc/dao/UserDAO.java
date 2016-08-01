/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 */
public interface UserDAO {
	
	  public List<User> getList();
	  public User validateUser(String username, String password);
	  public  User findById(long id);
	  public  User updateUser(User user);
	  boolean registerUser(User user);
	  boolean emailExists(String email);
	  boolean userExists(String username);

}
