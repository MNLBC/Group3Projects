package com.oocl.mnlbc.service;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.model.ProductBean;

public class ProductService implements ProductDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	// private final static ProductService productDAO = new ProductService();
	//
	// public static ProductService getInstance() {
	// return productDAO;
	// }

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ProductBean> getProductList() {
		// List<ProductBean> prod = new ArrayList<ProductBean>();
		String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_STOCK_QUANTITY, PRODUCT_IMAGE_PATH  FROM PRODUCT";
		List<ProductBean> products = jdbcTemplateObject.query(sql, new ProductMapper());
		if (products.isEmpty()) {
			return null;
		} else {
			
			return products;
		}
	}

	@Override
	public boolean updateProductList(ProductBean prod) {
		String id = Integer.toString(prod.getProductId());
		String quantity = Integer.toString(prod.getProductStockQuantity());

		int i = 0;

		String sql = "UPDATE product SET PRODUCT_STOCK_QUANTITY= ?" + "WHERE PRODUCT_ID=? ";

		jdbcTemplateObject.update(sql, quantity, id);

		if (!(i == 0)) {
			return true;
		}
		return false;
	}

}
