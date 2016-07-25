/**
 * 
 */
package com.oocl.mnlbc.model;

import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 * this class is the model of the login response
 */
public class Login {
	
	private User user;
	private boolean success;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
