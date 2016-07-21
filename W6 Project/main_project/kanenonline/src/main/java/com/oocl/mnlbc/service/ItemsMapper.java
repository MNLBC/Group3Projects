package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.ItemsBean;

/**
 * 
 * @author Jerica Flores
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

		return item;
	}

}
