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

@Entity(name = "WishList")
@Table(name = "WISH_LIST")
public class WishList {

	@Id
	@Column(name = "WISH_LIST_ID")
	@SequenceGenerator(name = "WISH_LIST_ID_SEQ", sequenceName = "WISH_LIST_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "WISH_LIST_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long wishListId;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "PRODUCT_ID")
	private long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "PRODUCT_PRICE")
	private long productPrice;

	@Column(name = "PRODUCT_IMAGE_PATH")
	private String imagePath;

	public WishList() {

	}

	/**
	 * @param wishListId
	 * @param userId
	 * @param productId
	 * @param productName
	 * @param productDescription
	 * @param productPrice
	 * @param imagePath
	 */
	public WishList(long wishListId, long userId, long productId, String productName, String productDescription,
			long productPrice, String imagePath) {
		super();
		this.wishListId = wishListId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.imagePath = imagePath;
	}

	/**
	 * @return the wishListId
	 */
	public long getWishListId() {
		return wishListId;
	}

	/**
	 * @param wishListId
	 *            the wishListId to set
	 */
	public void setWishListId(long wishListId) {
		this.wishListId = wishListId;
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
		result = prime * result + (int) (wishListId ^ (wishListId >>> 32));
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
		WishList other = (WishList) obj;
		if (wishListId != other.wishListId)
			return false;
		return true;
	}

}
