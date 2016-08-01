/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;

import com.oocl.mnlbc.entity.CartItem;

/**
 * @author VERGAJO
 *
 */
public class CartItemList {

	private long userId;
	private List<CartItem> items;
	
	/**
	 * @param userId
	 * @param items
	 */
	public CartItemList(long userId, List<CartItem> items) {
		super();
		this.userId = userId;
		this.items = items;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the items
	 */
	public List<CartItem> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	
	
}
