/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * @author Melvin Yu
 *
 */
public class LoggedInUser {

	private long userId;
	private String userName;

	public LoggedInUser() {

	}

	/**
	 * @param userId
	 * @param userName
	 */
	public LoggedInUser(String userId, String userName) {
		this.userId = Long.valueOf(userId);
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
