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

	private List<CartItemBean> items;

	public CartBean() {
		super();
		this.items = new ArrayList<CartItemBean>();
	}

	public List<CartItemBean> getItems() {
		return items;
	}

	public void setItems(List<CartItemBean> items) {
		this.items = items;
	}

	/**
	 * Empty the shopping cart.
	 */
	public void clearCart() {
		this.items.clear();
	}

	public boolean addItemToCart(int productId, String productName, String productDescription, double productPrice, String imagePath) {
		for (CartItemBean item : items) {
			if (item.getProductId() == productId) {
				item.setQuantity(item.getQuantity() + 1);
				return false;
			}

		}
		
		items.add(new CartItemBean(productId, productName, productDescription, 1, productPrice,imagePath));
		return true;
	}

}
