/**
 * 
 */
package com.oocl.mnlbc.model;

import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author Melvin Yu
 *
 */
public class ItemOrder {
	
	private long orderId;
	private OrderItem item;
	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the item
	 */
	public OrderItem getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(OrderItem item) {
		this.item = item;
	}

}
