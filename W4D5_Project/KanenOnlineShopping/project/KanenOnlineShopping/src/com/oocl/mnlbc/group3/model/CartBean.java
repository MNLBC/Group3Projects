/**
 * 
 */
package com.oocl.mnlbc.group3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public void removeItem(int productId){
		Iterator<CartItemBean>iter = items.iterator();
		while(iter.hasNext()){
			CartItemBean item = iter.next();
			if(item.getProductId()==productId){
				// if the item is found remove it
				items.remove(item);
				return;
			}
		}
	}
	
	public boolean update(int id, int quantity){
		
		// find the item in the cart
		
		Iterator <CartItemBean>	iter = items.iterator();
		while(iter.hasNext()){
			CartItemBean item = iter.next();
			if(item.getProductId()==id){
				item.setQuantity(quantity);
				return true;	
			}
		}
		// if the item is not found
		return false;
	}

}
