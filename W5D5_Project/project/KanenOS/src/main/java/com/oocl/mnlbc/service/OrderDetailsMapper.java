package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.CartItemBean;
/**
 * 
 * @author ITAGroup3
 *
 */
public class OrderDetailsMapper implements RowMapper<CartItemBean> {

	/**
	 * OrderDetailsMapper for the Order Service
	 */
	@Override
	public CartItemBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartItemBean item = new CartItemBean();
		item.setOrderId(rs.getLong("ORDER_ID"));
		item.setProductId(rs.getInt("PRODUCT_ID"));
		item.setProductName(rs.getString("PRODUCT_NAME"));
		item.setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
		item.setQuantity(rs.getInt("QUANTITY"));
		item.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
		
	      return item;
		
	}

}

