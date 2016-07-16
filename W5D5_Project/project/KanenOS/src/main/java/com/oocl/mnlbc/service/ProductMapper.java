package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.ProductBean;

public class ProductMapper implements RowMapper<ProductBean> {

	@Override
	public ProductBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductBean product = new ProductBean();
		product.setProductId(rs.getInt("PRODUCT_ID"));
		product.setProductName(rs.getString("PRODUCT_NAME"));
		product.setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
		product.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
		product.setProductStockQuantity(rs.getInt("PRODUCT_STOCK_QUANTITY"));
		product.setImagePath(rs.getString("PRODUCT_IMAGE_PATH"));
	      return product;
	}

}
