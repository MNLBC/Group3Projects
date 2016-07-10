/**
 * 
 */
package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

import com.oocl.mnlbc.group3.connection.DBConnection;
import com.oocl.mnlbc.group3.model.OrderBean;
import com.oocl.mnlbc.group3.model.ItemsBean;

/**
 * @author YUME
 *
 */
public class OrderDAOImpl implements OrderDAO {

	private final static OrderDAOImpl orderDAO = new OrderDAOImpl();
	Connection conn;
	PreparedStatement pstmt;

	/**
	 * The constructor is set to private because there is no need to instantiate
	 * the Class every time. We only need one instance.
	 */
	private OrderDAOImpl() {
		conn = DBConnection.getConnection();
	}

	/**
	 * returns the instance of the class.
	 * 
	 * @return UserDAOImpl
	 */
	public static OrderDAOImpl getInstance() {
		return orderDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oocl.mnlbc.group3.dao.OrderDAO#createOrder(com.oocl.mnlbc.group3.
	 * model.CartBean)
	 */
	@Override
	public boolean createOrder(OrderBean cart) {

		String userId = Integer.toString(cart.getUserId());
		String orderDate = cart.getOrderDate();
		String totalCost = Double.toString(cart.getTotalCost());
		String orderStatus = cart.getOrderStatus();
		List<ItemsBean> items = cart.getItems();

		int i = 0;

		String sql = "Insert into ORDERS(" 
					+ "USER_ID," 
					+ "ORDER_DATE," 
					+ "TOTAL_COST," 
					+ "ORDER_STATUS) "
					+ "values(?,?,?,?);";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, orderDate);
			pstmt.setString(3, totalCost);
			pstmt.setString(4, orderStatus);

			i = pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!(i == 0)) {
			int orderId = getOrderId();

			for (ItemsBean item : items) {
				if (saveCart(item, orderId)) {
				} else {
					return false;
				}
			}

			return true;
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oocl.mnlbc.group3.dao.OrderDAO#saveCart(com.oocl.mnlbc.group3.model.
	 * ItemsBean)
	 */
	@Override
	public boolean saveCart(ItemsBean items, int orderId) {
		String id = Integer.toString(orderId);
		String orderDate = Integer.toString(items.getProductId());
		String quantity = Integer.toString(items.getQuantity());
		String orderPrice = Double.toString(items.getItemPrice());

		int i = 0;

		String sql = "Insert into ORDER_ITEM(" 
					+ "ORDER_ID," 
					+ "PRODUCT_ID," 
					+ "QUANTITY," 
					+ "ORDERED_PRICE) "
					+ "values(?,?,?,?);";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, orderDate);
			pstmt.setString(3, quantity);
			pstmt.setString(4, orderPrice);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oocl.mnlbc.group3.dao.OrderDAO#getTransactions(com.oocl.mnlbc.group3.
	 * model.CartBean)
	 */
	@Override
	public List<OrderBean> getTransactions(OrderBean cart) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oocl.mnlbc.group3.dao.OrderDAO#getItems(com.oocl.mnlbc.group3.model.
	 * ItemsBean)
	 */
	@Override
	public List<ItemsBean> getItems(ItemsBean items) {
		return null;
	}

	@Override
	public int getOrderId() {
		String sql = "SELECT MAX(ORDER_ID) FROM ORDERS";
		int orderId = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				orderId = Integer.parseInt(rs.getString("ORDER_ID"));
			}

		} catch (SQLSyntaxErrorException se) {
			System.out.println("User does not exist.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
	}

}
