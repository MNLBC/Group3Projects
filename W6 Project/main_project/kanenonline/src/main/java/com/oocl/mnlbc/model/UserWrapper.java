package com.oocl.mnlbc.model;

import java.util.ArrayList;
import java.util.List;

public class UserWrapper<T> {

	private boolean userHasCart;
	private List<T> items;

	/**
	 * @return the userHasCart
	 */
	public boolean isUserHasCart() {
		return userHasCart;
	}

	/**
	 * @param userHasCart
	 *            the userHasCart to set
	 */
	public void setUserHasCart(boolean userHasCart) {
		this.userHasCart = userHasCart;
	}

	/**
	 * @return the items
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<T> items) {
		this.items = items;
	}

	public UserWrapper() {
		this.items = new ArrayList<T>();
	}

}
