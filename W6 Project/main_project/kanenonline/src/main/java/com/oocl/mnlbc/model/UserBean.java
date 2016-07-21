package com.oocl.mnlbc.model;

import java.io.Serializable;

/**
 * 
 * User Class Model
 * 
 * @author Group3
 *
 */
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userId;
	private String userName;
	private String userPassword;
	private String fullName;
	private String email;
	private String address;
	private String mobileNumber;
	private String userRole;
	private String isBanned;

	public UserBean() {

	}

	public UserBean(long userId, String userName, String userPassword, String fullName, String email, String address,
			String mobileNumber, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.userRole = userRole;
		this.isBanned = "no";
	}

	public UserBean(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getIsBanned() {
		return isBanned;
	}
	public void setIsBanned(String isBanned) {
		this.isBanned = isBanned;
	}

}
