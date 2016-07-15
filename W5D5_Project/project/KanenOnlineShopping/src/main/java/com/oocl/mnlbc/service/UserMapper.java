package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oocl.mnlbc.model.UserBean;

public class UserMapper implements RowMapper<UserBean> {

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean user = new UserBean();
		user.setUserId(rs.getInt("userId"));
		user.setUserName(rs.getString("userName"));
		user.setUserPassword(rs.getString("userPassword"));
		user.setFullName(rs.getString("fullName"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setMobileNumber(rs.getString("mobileNumber"));
		user.setUserRole(rs.getString("userRole"));
		user.setIsBanned(rs.getString("isBanned"));	
	      return user;
	}

}
