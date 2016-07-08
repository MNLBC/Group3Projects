/**
 * 
 */
package com.oocl.mnlbc.group3.model;

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
	private int orderId;
	private int productId;
	private String orderDate;
	private int quantity;
	private double itemPrice;
	public ItemsBean(int orderId, int productId, String orderDate, int quantity, double itemPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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
