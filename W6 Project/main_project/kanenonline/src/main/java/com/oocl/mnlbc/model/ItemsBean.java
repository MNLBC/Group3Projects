/**
 * 
 */
package com.oocl.mnlbc.model;

import java.io.Serializable;

/**
 * @author YUME
 *
 */
public class ItemsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long orderId;
	private int productId;
	private int quantity;
	private double itemPrice;

	public ItemsBean(long orderId, int productId,  int quantity, double itemPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public ItemsBean() {
		// TODO Auto-generated constructor stub
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
