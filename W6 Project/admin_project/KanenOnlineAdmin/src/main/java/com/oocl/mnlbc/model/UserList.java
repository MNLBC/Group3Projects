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

	private List<UpdatedUsers> userList;

	/**
	 * @return the userList
	 */
	public List<UpdatedUsers> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UpdatedUsers> userList) {
		this.userList = userList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserList [userList=" + userList + "]";
	}

	

}
