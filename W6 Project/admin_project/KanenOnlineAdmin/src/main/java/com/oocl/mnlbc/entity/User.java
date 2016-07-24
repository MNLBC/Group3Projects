package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Melvin Yu
 *
 */
@Entity(name = "user")
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_ID")
	private long userId;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	@Column(name = "FULL_NAME")
	private String fullName;
	@Column(name = "USER_ROLE")
	private String userRole;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "userId", fetch = FetchType.LAZY)
	private UserMembershipAsn userMembershipId;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userId", fetch = FetchType.LAZY)
	private List<Order> orderId;

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param username
	 * @param userPassword
	 * @param fullName
	 * @param userRole
	 * @param userMembershipId
	 */
	public User(long userId, String username, String userPassword, String fullName, String userRole,
			UserMembershipAsn userMembershipId) {
		super();
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.fullName = fullName;
		this.userRole = userRole;
		this.userMembershipId = userMembershipId;
	}

	/**
	 * @return the orderList
	 */
	public List<Order> getOrderList() {
		return orderId;
	}

	/**
	 * @param orderList
	 *            the orderList to set
	 */
	public void setOrderList(List<Order> orderId) {
		this.orderId = orderId;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the userMembershipId
	 */
	public UserMembershipAsn getUserMembershipId() {
		return userMembershipId;
	}

	/**
	 * @param userMembershipId
	 *            the userMembershipId to set
	 */
	public void setUserMembershipId(UserMembershipAsn userMembershipId) {
		this.userMembershipId = userMembershipId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", userPassword=" + userPassword + ", fullName="
				+ fullName + ", userRole=" + userRole + ", userMembershipId=" + userMembershipId + ", orderList="
				+ orderId + "]";
	}

}
