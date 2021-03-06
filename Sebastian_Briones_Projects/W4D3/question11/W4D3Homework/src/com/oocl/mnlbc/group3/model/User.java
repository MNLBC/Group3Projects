package com.oocl.mnlbc.group3.model;

/**
 * 
 * User Class Model
 * 
 * @author BRIONSE
 *
 */
public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String fullName;
	private String email;
	private String address;
	private String mobileNumber;
	private String userRole;
	private double userBalance;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public User(int userId, String userName, String userPassword, String fullName, String email, String address,
			String mobileNumber, String userRole, double userBalance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.userRole = userRole;
		this.userBalance = userBalance;
	}

}
