package com.oocl.mnlbc.service;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;

public class OrderService implements OrderDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private final static OrderService orderDAO = new OrderService();

	public static OrderService getInstance() {
		return orderDAO;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createOrder(OrderBean cart) {
		String userId = Integer.toString(cart.getUserId());
		// int userId = cart.getUserId();

		// String orderDate = cart.getOrderDate();
		String totalCost = Double.toString(cart.getTotalCost());
		// double totalCost = cart.getTotalCost();
		String orderStatus = cart.getOrderStatus();
		List<CartItemBean> items = cart.getItems();

		String sql = "Insert into ORDERS(" + "USER_ID," + "ORDER_DATE," + "TOTAL_COST," + "ORDER_STATUS) "
				+ "values(?,SYSDATE,?,?)";
		try {
			jdbcTemplateObject.update(sql, userId, totalCost, orderStatus, items);
			return true;
			// i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// long orderId = getOrderId();
		//
		// for (CartItemBean item : items) {
		// if (saveCart(item, orderId)) {
		// } else {
		// return false;
		// }
		// }

		return false;
	}

	@Override
	public boolean saveCart(CartItemBean items, long orderId) {
		String id = Long.toString(orderId);
		String orderDate = Integer.toString(items.getProductId());
		String quantity = Integer.toString(items.getQuantity());
		String orderPrice = Double.toString(items.getProductPrice());

		// int i = 0;

		String sql = "Insert into ORDER_ITEM(" + "ORDER_ID," + "PRODUCT_ID," + "QUANTITY," + "ORDERED_PRICE) "
				+ "values(?,?,?,?)";
		try {
			jdbcTemplateObject.update(sql, id, orderDate, quantity, orderPrice);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// if (!(i == 0)) {
		// }
		return false;
	}

	@Override
	public List<OrderBean> getTransactions(int userId) {
		String sql = "SELECT * FROM ORDERS WHERE USER_ID=?";
		List<OrderBean> orderList = jdbcTemplateObject.query(sql,new Object[] {userId}, new OrderMapper());
		return orderList;
	}

	@Override
	public List<ItemsBean> getItems(long orderId) {
		String sql = "SELECT * FROM ORDER_ITEM WHERE ORDER_ID=?";
		List<ItemsBean> itemList =  jdbcTemplateObject.query(sql, new Object[] {orderId},new ItemsMapper());
		
		return itemList;

	}

	@Override
	public long getOrderId() {
		String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		OrderBean orderId = jdbcTemplateObject.queryForObject(sql, new OrderMapper());
		
		
		return orderId.getOrderId();

	}
}
