/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;

import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 */
public class UserList {

	private List<User> userList;

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
