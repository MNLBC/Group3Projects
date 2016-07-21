package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.OrderBean;

/**
 * 
 * @author ITAGroup3
 *
 */
public interface OrderDAO {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	public boolean createOrder(OrderBean cart);

	public boolean saveCart(CartItemBean items, long orderId);

	public List<OrderBean> getTransactions(long userId);

	public List<CartItemBean> getItems(long orderId);

	public long getOrderId();
}
