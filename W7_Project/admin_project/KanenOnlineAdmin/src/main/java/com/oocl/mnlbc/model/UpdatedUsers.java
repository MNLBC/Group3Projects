/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * @author Melvin Yu
 *
 */
public class UpdatedUsers {
	

	private long userId;
	private String userRole;
	private String isBlacklisted;
	private String membershipType;
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
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * @return the isBlacklisted
	 */
	public String getIsBlacklisted() {
		return isBlacklisted;
	}
	/**
	 * @param isBlacklisted the isBlacklisted to set
	 */
	public void setIsBlacklisted(String isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}
	/**
	 * @return the membershipType
	 */
	public String getMembershipType() {
		return membershipType;
	}
	/**
	 * @param membershipType the membershipType to set
	 */
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
	

}
