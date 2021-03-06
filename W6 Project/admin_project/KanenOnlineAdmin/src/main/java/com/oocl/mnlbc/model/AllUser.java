/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 *         Response Model to get and pass all users
 */
public class AllUser {

	private List<UserAndMembership> userList;
	private boolean success;
	/**
	 * @return the userList
	 */
	public List<UserAndMembership> getUserList() {
		return userList;
	}
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserAndMembership> userList) {
		this.userList = userList;
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
