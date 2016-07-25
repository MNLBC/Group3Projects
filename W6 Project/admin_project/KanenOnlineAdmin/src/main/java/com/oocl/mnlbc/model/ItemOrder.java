/**
 * 
 */
package com.oocl.mnlbc.model;

import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author Melvin Yu
 *
 *This Model is for the response of all the order_items and orderId
 */
public class ItemOrder {
	
	private long orderId;
	private OrderItem item;
	private String productname;
	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}
	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}
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
