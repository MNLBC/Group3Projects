/**
 * 
 */
package com.oocl.mnlbc.model;

import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 */
public class UserAndMembership {

	private User user;
	private String membershipType;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the membershipType
	 */
	public String getMembershipType() {
		return membershipType;
	}

	/**
	 * @param membershipType
	 *            the membershipType to set
	 */
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAndMembership [user=" + user + ", membershipType=" + membershipType + "]";
	}

}
