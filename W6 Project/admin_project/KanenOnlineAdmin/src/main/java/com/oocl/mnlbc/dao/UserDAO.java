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

}