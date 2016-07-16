package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oocl.mnlbc.model.OrderBean;

public class OrderMapper implements RowMapper<OrderBean>{
	@Override
	public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderBean order = new OrderBean();
		order.setOrderId(rs.getInt("orderId"));
		order.setUserId(rs.getInt("userId"));
		order.setOrderDate(rs.getString("orderDate"));
		order.setTotalCost(rs.getDouble("totalCost"));
		order.setOrderStatus(rs.getString("orderStatus"));
	      return order;
	}
}
