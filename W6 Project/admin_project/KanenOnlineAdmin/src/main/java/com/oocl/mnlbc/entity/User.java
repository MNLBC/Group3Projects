package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @Id
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "USER_ROLE")
    private String userRole;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userId", fetch = FetchType.LAZY)
//    private List<Order> orderList;

    public User() {
		// TODO Auto-generated constructor stub
	}

    
    
	public User(Integer userId, String username, String userPassword, String fullName, String userRole) {
	super();
	this.userId = userId;
	this.username = username;
	this.userPassword = userPassword;
	this.fullName = fullName;
	this.userRole = userRole;
}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", userPassword=" + userPassword + ", fullName="
				+ fullName + ", userRole=" + userRole + "]";
	}
    
	
}
