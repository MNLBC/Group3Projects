/**
 * 
 */
package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VERGAJO
 *
 */

@Entity(name = "CartItem")
@Table(name = "CART_ITEM")
public class CartItem {

	@Id
	@Column(name = "CART_ITEM_ID")
	@SequenceGenerator(name = "CART_ITEM_ID_SEQ", sequenceName = "CART_ITEM_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "CART_ITEM_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long cartItemId;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "PRODUCT_ID")
	private long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "PRODUCT_PRICE")
	private long productPrice;

	@Column(name = "PRODUCT_IMAGE_PATH")
	private String imagePath;

	public CartItem() {

	}

	/**
	 * @param cartItemId
	 * @param userId
	 * @param productId
	 * @param productName
	 * @param productDescription
	 * @param quantity
	 * @param productPrice
	 * @param imagePath
	 */
	public CartItem(long cartItemId, long userId, long productId, String productName, String productDescription,
			int quantity, long productPrice, String imagePath) {
		super();
		this.cartItemId = cartItemId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.imagePath = imagePath;
	}

	/**
	 * @return the cartItemId
	 */
	public long getCartItemId() {
		return cartItemId;
	}

	/**
	 * @param cartItemId
	 *            the cartItemId to set
	 */
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription
	 *            the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the productPrice
	 */
	public long getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 *            the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartItemId ^ (cartItemId >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (cartItemId != other.cartItemId)
			return false;
		return true;
	}

}
