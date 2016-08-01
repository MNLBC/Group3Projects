package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.model.CartItemBean;

/**
 * 
 * @author VERGAJO
 *
 */
public interface OrderDAO{

	public boolean createOrder(Order cart, List<OrderItem> orderItems);

	public boolean saveCart(OrderItem items, long orderId);

	public List<Order> getTransactions(long userId);

	public List<CartItemBean> getItems(long orderId);

}
