/**
 * 
 */
package com.oocl.mnlbc.group3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author group3
 * 
 * CartBean models the actual ShoppingCart
 *
 */
public class CartBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private List<ItemsBean> items;

	public CartBean() {
		super();
		this.items = new ArrayList<ItemsBean>();
	}

	public List<ItemsBean> getItems() {
		return items;
	}

	public void setItems(List<ItemsBean> items) {
		this.items = items;
	}

	/**
	 * Empty the shopping cart.
	 */
	public void clearCart() {
		this.items.clear();
	}

	public boolean addItemToCart(int productId, double productPrice) {
		for (ItemsBean item : items) {
			if (item.getProductId() == productId) {
				item.setQuantity(item.getQuantity() + 1);
				return false;
			}

		}

		items.add(new ItemsBean(0, productId, "", 1, productPrice));
		return true;
	}

}
