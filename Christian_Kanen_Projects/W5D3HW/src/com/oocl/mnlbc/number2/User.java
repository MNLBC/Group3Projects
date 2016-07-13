package com.oocl.mnlbc.number2;

public class User {
	private String fname;
	private String lname;
	private String username;
	private String password;

	public User(String fname, String lname, String username, String password) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}

	public User() {
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPassword() {
		return password;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}