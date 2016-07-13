package com.oocl.mnlbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.User;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setFullName(rs.getString("fullName"));
		user.setMobileNo(rs.getString("mobileNo"));
		user.setEmailAdd(rs.getString("emailAdd"));

		return user;
	}
}
