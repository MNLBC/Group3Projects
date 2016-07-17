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

	private String cUserId;
	private String cTotalCost;
	private String cOrderStatus;
	private List<CartItemBean> cItems;

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

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean createOrder(OrderBean cart) {
		TransactionTemplate tt = new TransactionTemplate(getTransactionManager());
		cUserId = Long.toString(cart.getUserId());

		cTotalCost = Double.toString(cart.getTotalCost());

		cItems = cart.getItems();
		boolean result = false;
		try {
			result = tt.execute(new TransactionCallback() {

				public Object doInTransaction(TransactionStatus status) {

					JdbcTemplate jt = new JdbcTemplate(dataSource);
					int i = 0;
					String sql = "Insert into ORDERS(" + "USER_ID," + "ORDER_DATE," + "TOTAL_COST," + "ORDER_STATUS) "
							+ "values(?,SYSDATE,?,?)";
					i = jt.update(sql, cUserId, cTotalCost, "On-Delivery");

					if (!(i == 0)) {
						long orderId = getOrderId();

						for (CartItemBean item : cItems) {
							if (saveCart(item, orderId)) {
							} else {
								return false;
							}
						}

						return true;
					}
					return false;
				}

			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public boolean saveCart(CartItemBean items, long orderId) {
		String id = Long.toString(orderId);
		String orderDate = Integer.toString(items.getProductId());
		String quantity = Integer.toString(items.getQuantity());
		String orderPrice = Double.toString(items.getProductPrice());

		// int i = 0;

		String sql = "Insert into ORDER_ITEM(" + "ORDER_ID," + "PRODUCT_ID," + "QUANTITY,"
				+ "ORDERED_PRICE) " + "values(?,?,?,?)";
		try {
			jdbcTemplateObject.update(sql, id, orderDate, quantity, orderPrice);
			return true;
		} catch (DataAccessException de) {
			de.printStackTrace();
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
	public List<CartItemBean> getItems(long orderId) {
		String sql = "SELECT OI.ORDER_ID, P.PRODUCT_ID, P.PRODUCT_NAME, OI.QUANTITY, P.PRODUCT_DESCRIPTION, P.PRODUCT_PRICE FROM ORDER_ITEM OI INNER JOIN PRODUCT P ON P.PRODUCT_ID = OI.PRODUCT_ID WHERE OI.ORDER_ID =?";
		List<CartItemBean> itemList = jdbcTemplateObject.query(sql, new Object[] { orderId }, new OrderDetailsMapper());

		return itemList;

	}

	@Override
	public long getOrderId() {
		String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		OrderBean orderId = jdbcTemplateObject.queryForObject(sql, new OrderIdMapper());

		return orderId.getOrderId();

	}
}
