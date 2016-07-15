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
		String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_STOCK_QUANTITY, PRODUCT_IMAGE_PATH  FROM PRODUCT";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("PRODUCT_ID"));
				String prodname = rs.getString("PRODUCT_NAME");
				String desc = rs.getString("PRODUCT_DESCRIPTION");
				double price = Double.parseDouble(rs.getString("PRODUCT_PRICE"));
				int stock = Integer.parseInt(rs.getString("PRODUCT_STOCK_QUANTITY"));
				String img = rs.getString("PRODUCT_IMAGE_PATH");
				
				prod.add(new ProductBean(id,prodname,desc, price,stock,img));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	@Override
	public boolean updateProductList(ProductBean prod) {
		String id = Integer.toString(prod.getProductId());
		String quantity = Integer.toString(prod.getProductStockQuantity());

		int i = 0;

		String sql = "UPDATE product SET PRODUCT_STOCK_QUANTITY= ?" 
					+ "WHERE PRODUCT_ID=? ";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, quantity);
			pstmt.setString(2, id);

			i = pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!(i == 0)) {
			return true;
		}
		return false;
	}

}
