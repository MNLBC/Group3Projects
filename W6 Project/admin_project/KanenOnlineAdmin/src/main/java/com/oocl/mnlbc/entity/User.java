package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Melvin Yu This is the Entitiy of the User table
 */
@Entity(name = "User")
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "USER_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long userId;
	@Column(name = "USERNAME")
	private String username;
	@JsonIgnore
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	@Column(name = "FULL_NAME")
	private String fullName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "IS_BLACKLISTED")
	private String isBlacklisted;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private UserMembershipAsn userMembershipId;

	User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param username
	 * @param userPassword
	 * @param fullName
	 * @param email
	 * @param address
	 * @param mobileNumber
	 * @param userRole
	 * @param isBlacklisted
	 */
	public User(long userId, String username, String userPassword, String fullName, String email, String address,
			String mobileNumber, String userRole) {
		super();
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.userRole = userRole;
		this.isBlacklisted = isBlacklisted;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	 * @return the isBlacklisted
	 */
	public String getIsBlacklisted() {
		return isBlacklisted;
	}

	/**
	 * @param isBlacklisted
	 *            the isBlacklisted to set
	 */
	public void setIsBlacklisted(String isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

	
	
	/**
	 * @return the userMembershipId
	 */
	public UserMembershipAsn getUserMembershipId() {
		return userMembershipId;
	}

	/**
	 * @param userMembershipId the userMembershipId to set
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
				+ fullName + ", email=" + email + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", userRole=" + userRole + ", isBlacklisted=" + isBlacklisted + "]";
	}

}
