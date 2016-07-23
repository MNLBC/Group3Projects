/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * @author Melvin Yu
 *
 */
public class UserRequest {
	
	private String fullname;
	private long userId;
	private String currentType;
	private String requestType;
	private int forApproval;
	private int isApproved;
	/**
	 * @param fullname
	 * @param userId
	 * @param currentType
	 * @param requestType
	 * @param forApproval
	 * @param isApproved
	 */
	public UserRequest(String fullname, long userId, String currentType, String requestType, int forApproval,
			int isApproved) {
		super();
		this.fullname = fullname;
		this.userId = userId;
		this.currentType = currentType;
		this.requestType = requestType;
		this.forApproval = forApproval;
		this.isApproved = isApproved;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the currentType
	 */
	public String getCurrentType() {
		return currentType;
	}
	/**
	 * @param currentType the currentType to set
	 */
	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}
	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}
	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	/**
	 * @return the forApproval
	 */
	public int getForApproval() {
		return forApproval;
	}
	/**
	 * @param forApproval the forApproval to set
	 */
	public void setForApproval(int forApproval) {
		this.forApproval = forApproval;
	}
	/**
	 * @return the isApproved
	 */
	public int getIsApproved() {
		return isApproved;
	}
	/**
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}
	
}
