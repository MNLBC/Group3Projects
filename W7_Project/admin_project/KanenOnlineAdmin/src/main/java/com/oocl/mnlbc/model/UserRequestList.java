/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;

/**
 * @author Melvin Yu
 *
 *	This model handles the response of the list of User Request
 */
public class UserRequestList {
	
	private List<UserRequest> userRequest;

	/**
	 * @return the userRequest
	 */
	public List<UserRequest> getUserRequest() {
		return userRequest;
	}

	/**
	 * @param userRequest the userRequest to set
	 */
	public void setUserRequest(List<UserRequest> userRequest) {
		this.userRequest = userRequest;
	}
	
	

}
