package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.UserBean;
/**
 * 
 * @author ITAGroup3
 *
 */
public class ItemsMapper implements RowMapper<ItemsBean> {
/**
 * IemsBean Mapper for Service
 */
	@Override
	public ItemsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemsBean item = new ItemsBean();
		item.setOrderId(rs.getLong("ORDER_ID"));
		item.setProductId(rs.getInt("PRODUCT_ID"));
		item.setQuantity(rs.getInt("QUANTITY"));
		item.setItemPrice(rs.getDouble("ORDERED_PRICE"));
		

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

