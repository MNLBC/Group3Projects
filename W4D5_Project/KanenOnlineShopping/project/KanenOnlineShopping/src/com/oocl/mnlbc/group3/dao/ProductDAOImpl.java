package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.group3.connection.DBConnection;
import com.oocl.mnlbc.group3.model.ProductBean;

public class ProductDAOImpl implements ProductDAO {

	private final static ProductDAOImpl productDAO = new ProductDAOImpl();
	Connection conn;
	PreparedStatement pstmt;

	/**
	 * The constructor is set to private because there is no need to instantiate
	 * the Class every time. We only need one instance.
	 */
	private ProductDAOImpl() {
		conn = DBConnection.getConnection();
	}

	/**
	 * returns the instance of the class.
	 * 
	 * @return ProductDAOImpl
	 */
	public static ProductDAOImpl getInstance() {
		return productDAO;
	}

	@Override
	public List<ProductBean> getProductList() {
		List<ProductBean> prod = new ArrayList<ProductBean>();
		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				prod.add(new ProductBean(Integer.parseInt(rs.getString("PRODUCT_ID")), rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"), Double.parseDouble(rs.getString("PRODUCT_PRICE")),
						Integer.parseInt(rs.getString("PRODUCT_STOCK_QUANTITY")), rs.getString("PRODUCT_IMAGE_PATH")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	@Override
	public boolean updateProductList(ProductBean prod) {
		
		return false;
	}

}
