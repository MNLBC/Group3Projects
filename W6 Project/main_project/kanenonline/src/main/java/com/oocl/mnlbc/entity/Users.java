/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

/**
 * @author VERGAJO User JPA MOdel
 */

@Entity(name = "User")
@Table(name = "USERS")
public class Users implements Serializable {

	@Id
	@Column(name = "USER_ID")
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private List<Order> orderList;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
//	private List<CartItem> cartItems;
//
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
//	private List<UserMembershipAssn> userMembershipAssns;

	public Users() {
	}

	public Users(long userId, String username, String userPassword, String fullName, String email, String address,
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
		//this.orderList = orderList;
		//this.cartItems = cartItems;
		//this.userMembershipAssns = userMembershipAssns;
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

	public List<Order> getOrders() {
		return this.orderList;
	}

	public void setOrders(List<Order> orderList) {
		this.orderList = orderList;
	}

}