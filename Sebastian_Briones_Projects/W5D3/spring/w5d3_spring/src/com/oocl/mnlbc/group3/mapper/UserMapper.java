package com.oocl.mnlbc.group3.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.group3.model.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("USER_ID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setUserPassword(rs.getString("USER_PASSWORD"));
		user.setFullName(rs.getString("FULL_NAME"));
		user.setEmail(rs.getString("EMAIL"));
		user.setAddress(rs.getString("ADDRESS"));
		user.setMobileNumber(rs.getString("MOBILE_NUMBER"));
		user.setUserRole(rs.getString("USER_ROLE"));
		user.setIsBanned("IS_BLACKLISTED");
		return user;

	}

}