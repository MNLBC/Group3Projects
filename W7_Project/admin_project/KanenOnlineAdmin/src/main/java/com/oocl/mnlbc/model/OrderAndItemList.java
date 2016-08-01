/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author Melvin Yu
 *
 *	this model handles the list of Orders and Items response
 */
public class OrderAndItemList {

	private boolean success;
	private List<OrderUser> orderList;
	private List<ItemOrder> itemList;

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the orderList
	 */
	public List<OrderUser> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList
	 *            the orderList to set
	 */
	public void setOrderList(List<OrderUser> orderList) {
		this.orderList = orderList;
	}

	/**
	 * @return the itemList
	 */
	public List<ItemOrder> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList
	 *            the itemList to set
	 */
	public void setItemList(List<ItemOrder> itemList) {
		this.itemList = itemList;
	}

}
