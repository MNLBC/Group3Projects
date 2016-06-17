package com.oocl.mnlbc.group3.model;

/**
 * Customer Model Class
 * 
 * @author Brionse
 * @author2 Group3
 * @version 1
 */
public class Customer {
	
    private int customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String emailAddress;
	private String mobileNumber;
	
	private double balance;

	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * 
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

/**
 * getting the firstname
 * @return firstName
 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * setting the firstname
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
/**
 * getting the lastname
 * @return lastName
 */

	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setting the lastname
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getting the Username
	 * @return userName
	 */

	public String getUserName() {
		return userName;
	}
/**
 * setting the username
 * @param userName
 */

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
/**
 * getting the emailAddress
 * @return emailAddress
 */
	public String getEmailAddress() {
		return emailAddress;
	}

/**
 * setting the emailAddress
 * @param emailAddress
 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

/**
 * getting the mobile number
 * @return mobileNumber
 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * setting the mobile number
	 * @param mobileNumber
	 */

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

/**
 * getting the balance
 * @return balance
 */
	public double getBalance() {
		return balance;
	}


	/**
	 * setting the balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

/**
 * this is the Constructor for the customer class model
 * @param customerId
 * @param firstName
 * @param lastName
 * @param userName
 * @param emailAddress
 * @param mobileNumber
 * @param balance
 */
	public Customer(int customerId, String firstName, String lastName,
			String userName, String emailAddress, String mobileNumber,
			double balance) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
	}
	
	/**
	 * this is just to return a simple string value of the customer
	 */
   public String toString(){
	   return "Welcome! " + this.userName + "\nCurrent balance: " + this.balance;
   }

}
