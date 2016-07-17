package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.UserBean;

public class ItemsMapper implements RowMapper<ItemsBean> {

	@Override
	public ItemsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemsBean item = new ItemsBean(1,1,1,1);
//		user.setUserId(rs.getInt("USER_ID"));
//		user.setUserName(rs.getString("USERNAME"));
//		user.setUserPassword(rs.getString("USER_PASSWORD"));
//		user.setFullName(rs.getString("FULL_NAME"));
//		user.setEmail(rs.getString("EMAIL"));
//		user.setAddress(rs.getString("ADDRESS"));
//		user.setMobileNumber(rs.getString("MOBILE_NUMBER"));
//		user.setUserRole(rs.getString("USER_ROLE"));
//		user.setIsBanned(rs.getString("IS_BLACKLISTED"));	
	      return item;
	}

}

