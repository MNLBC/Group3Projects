package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VERGAJO User JPA MOdel
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
	@GeneratedValue(generator = "USER_ID_SEQ")
	@SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 111)
	private long userId;

	@Column(name = "USERNAME")
	private String username;

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

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch =
	// FetchType.LAZY)
	// private List<Orders> orderList;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch =
	// FetchType.LAZY)
	// private List<CartItem> cartItems;
	//
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch =
	// FetchType.LAZY)
	// private List<UserMembershipAssn> userMembershipAssns;

	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "userId", fetch = FetchType.LAZY)
	private UserMembershipAsn userMembershipId;

	public User() {
	}

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
		// this.orderList = orderList;
		// this.cartItems = cartItems;
		// this.userMembershipAssns = userMembershipAssns;
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

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIsBlacklisted() {
		return this.isBlacklisted;
	}

	public void setIsBlacklisted(String isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// public List<Orders> getOrders() {
	// return this.orderList;
	// }
	//
	// public void setOrders(List<Orders> orderList) {
	// this.orderList = orderList;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

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

}