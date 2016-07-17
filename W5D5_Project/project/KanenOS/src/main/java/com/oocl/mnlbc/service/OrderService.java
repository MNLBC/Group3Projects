package com.oocl.mnlbc.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.OrderBean;

public class OrderService implements OrderDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private PlatformTransactionManager transactionManager;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	String cUserId;
	String cTotalCost;
	String cOrderStatus;
	List<CartItemBean> cItems;

	@SuppressWarnings("unchecked")
	@Override
	public boolean createOrder(OrderBean cart) {
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
	public List<OrderBean> getTransactions(long userId) {
		String sql = "SELECT * FROM ORDERS WHERE USER_ID='" + userId + "'";
		List<OrderBean> orderList = jdbcTemplateObject.query(sql, new OrderMapper());
		return orderList;
	}

	@Override
	public List<ItemsBean> getItems(long orderId) {
		String sql = "SELECT * FROM ORDER_ITEM WHERE ORDER_ID=?";
		List<ItemsBean> itemList = jdbcTemplateObject.query(sql, new Object[] { orderId }, new ItemsMapper());

		return itemList;

	}

	@Override
	public long getOrderId() {
		String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		OrderBean orderId = jdbcTemplateObject.queryForObject(sql, new OrderIdMapper());

		return orderId.getOrderId();

	}
}
