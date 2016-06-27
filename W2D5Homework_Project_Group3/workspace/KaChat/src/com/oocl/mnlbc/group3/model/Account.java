package com.oocl.mnlbc.group3.model;
/**
 * 
 * 
 * @author BRIONSE
 *
 */
public class Account {

	private int accountId;
	
	private String username;
	
	private String password;

	private String fullname;
	
	/**
	 * Constructor
	 */
	

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 * @param username
	 * @param password
	 */
	public Account(int accountId, String username, String password, String fullname) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the user name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the user name to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	
}
