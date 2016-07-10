/**
 * 
 */
package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.group3.connection.DBConnection;
import com.oocl.mnlbc.group3.model.ItemsBean;
import com.oocl.mnlbc.group3.model.OrderBean;
import com.oocl.mnlbc.group3.model.UserBean;

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

		String sql = "Insert into ORDERS(" + "USER_ID," + "ORDER_DATE," + "TOTAL_COST," + "ORDER_STATUS) "
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
	public boolean saveCart(ItemsBean items, long orderId) {
		String id = Long.toString(orderId);
		String orderDate = Integer.toString(items.getProductId());
		String quantity = Integer.toString(items.getQuantity());
		String orderPrice = Double.toString(items.getItemPrice());

		int i = 0;

		String sql = "Insert into ORDER_ITEM(" + "ORDER_ID," + "PRODUCT_ID," + "QUANTITY," + "ORDERED_PRICE) "
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
	public List<OrderBean> getTransactions(int userId) {
		String userid= Integer.toString(userId);
		String sql = "SELECT * FROM ORDERS WHERE USER_ID=?";
		List<OrderBean> orderList=new ArrayList<OrderBean>();
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				long orderId=Long.parseLong(rs.getString("order_id"));
				 userId= Integer.parseInt(rs.getString("user_id"));
				String orderDate= rs.getString("order_date");
				double total= Double.parseDouble(rs.getString("total_cost"));
				String status= rs.getString("order_status");
				 
				 orderList.add(new OrderBean(orderId,userId,orderDate,total,status,
						 null));
			}
		} catch (SQLSyntaxErrorException se) {
			System.out.println("User does not exist.");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		
		return orderList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oocl.mnlbc.group3.dao.OrderDAO#getItems(com.oocl.mnlbc.group3.model.
	 * ItemsBean)
	 */
	@Override
	public List<ItemsBean> getItems(long orderId) {
		String id= Long.toString(orderId);
		String sql = "SELECT * FROM ORDER_ITEM WHERE ORDER_ID=?";
		List<ItemsBean> itemList=new ArrayList<ItemsBean>();
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
//				int orderItemId=Integer.parseInt( rs.getString("order_item_id"));
				int productId= Integer.parseInt(rs.getString("product_id"));
				int quantity=Integer.parseInt(rs.getString("quantity")) ;
				double price= Double.parseDouble(rs.getString("ordered_price"));
				itemList.add(new ItemsBean(orderId,productId,quantity,price));
			}
		} catch (SQLSyntaxErrorException se) {
			System.out.println("User does not exist.");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return itemList;
		
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
