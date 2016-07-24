package com.oocl.mnlbc.entity;

import java.util.List;
/**
 * Wrapper for order list
 * @author BRIONSE
 *
 */
public class OrderList {
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
