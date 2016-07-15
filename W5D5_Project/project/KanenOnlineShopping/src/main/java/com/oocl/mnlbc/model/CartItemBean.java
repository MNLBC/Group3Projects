/**
 * 
 */
package com.oocl.mnlbc.model;

import java.io.Serializable;

/**
 * @author GROUP3
 * Model Class of an item in the shopping cart
 */
public class CartItemBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int productId;
	private String productName;
	private String productDescription;
	private String imagePath;
	private int quantity;
	private double productPrice;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public CartItemBean(int productId, String productName, String productDescription, int quantity, double productPrice, String imagePath) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.imagePath = imagePath;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public void setproductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
