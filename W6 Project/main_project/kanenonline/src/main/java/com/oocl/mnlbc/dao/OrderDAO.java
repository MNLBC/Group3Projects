package com.oocl.mnlbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.Order;
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

	public boolean createOrder(Order cart, List<OrderItem> orderItems);

	public boolean saveCart(OrderItem items, long orderId);

	public List<Order> getTransactions(long userId);

	public List<CartItemBean> getItems(long orderId);

	public long getOrderId();
}
