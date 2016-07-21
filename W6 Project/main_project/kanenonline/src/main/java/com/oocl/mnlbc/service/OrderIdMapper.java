package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oocl.mnlbc.model.OrderBean;

/**
 * 
 * @author ITAGroup3
 *
 */
public class OrderIdMapper implements RowMapper<OrderBean>{
	@Override
	public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderBean order = new OrderBean();
		order.setOrderId(rs.getLong("ORDER_ID"));

	      return order;
	}
}
