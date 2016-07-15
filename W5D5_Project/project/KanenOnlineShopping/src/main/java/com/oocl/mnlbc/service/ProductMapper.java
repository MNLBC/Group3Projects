package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.ProductBean;

public class ProductMapper implements RowMapper<ProductBean> {

	@Override
	public ProductBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductBean product = new ProductBean();
		product.setProductId(rs.getInt("productId"));
		product.setProductName(rs.getString("productName"));
		product.setProductDescription(rs.getString("productDescription"));
		product.setProductPrice(rs.getDouble("productPrice"));
		product.setProductStockQuantity(rs.getInt("productStockQuantity"));
		product.setImagePath(rs.getString("imagePath"));
	      return product;
	}

}
