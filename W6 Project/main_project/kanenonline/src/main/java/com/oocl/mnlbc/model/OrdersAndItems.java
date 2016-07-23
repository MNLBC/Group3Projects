package com.oocl.mnlbc.model;

import java.util.List;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

public class OrdersAndItems {

	private List<Order> orders;
	private List<CartItemBean> items;

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * @return the items
	 */
	public List<CartItemBean> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<CartItemBean> items) {
		this.items = items;
	}

}
