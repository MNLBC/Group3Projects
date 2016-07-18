package com.oocl.mnlbc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERS_ID")
	private Integer usersId;
	@Column(name = "USERS_NAME")
	private String usersName;
	@Column(name = "USERS_PASSWORD")
	private String usersPassword;
	@Column(name = "USERS_FULLNAME")
	private String usersFullName;
	@Column(name = "USERS_CONTACTNUMBER")
	private String usersContactNumber;

	public Users() {
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersPassword() {
		return usersPassword;
	}

	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}

	public String getUsersFullName() {
		return usersFullName;
	}

	public void setUsersFullName(String usersFullName) {
		this.usersFullName = usersFullName;
	}

	public String getUsersContactNumber() {
		return usersContactNumber;
	}

	public void setUsersContactNumber(String usersContactNumber) {
		this.usersContactNumber = usersContactNumber;
	}

	public Users(Integer usersId, String usersName, String usersPassword, String usersFullName,
			String usersContactNumber) {
		super();
		this.usersId = usersId;
		this.usersName = usersName;
		this.usersPassword = usersPassword;
		this.usersFullName = usersFullName;
		this.usersContactNumber = usersContactNumber;
	}

}
