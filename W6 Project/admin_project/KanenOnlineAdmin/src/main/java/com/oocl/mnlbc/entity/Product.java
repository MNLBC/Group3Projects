/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Melvin Yu and Christian Kanen This is the Entitiy of the PRODUCT
 *         table
 */
@Entity(name = "products")
@Table(name = "PRODUCT")
// @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(generator = "PRODUCT_ID_SEQ")
	@SequenceGenerator(name = "PRODUCT_ID_SEQ", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 111)
	private long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "PRODUCT_PRICE")
	private double productPrice;

	@Column(name = "PRODUCT_STOCK_QUANTITY")
	private int productStockQuantity;

	@Column(name = "PRODUCT_IMAGE_PATH")
	private String productImagePath;
	
	/**
	 * @param productId
	 * @param productName
	 * @param productDescription
	 * @param productPrice
	 * @param productStockQuantity
	 * @param productImagePath
	 */
	public Product(long productId, String productName, String productDescription, double productPrice,
			int productStockQuantity, String productImagePath) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStockQuantity = productStockQuantity;
		this.productImagePath = productImagePath;
	}
	
	public Product(){
		
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
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productStockQuantity
	 */
	public int getProductStockQuantity() {
		return productStockQuantity;
	}

	/**
	 * @param productStockQuantity
	 *            the productStockQuantity to set
	 */
	public void setProductStockQuantity(int productStockQuantity) {
		this.productStockQuantity = productStockQuantity;
	}

	/**
	 * @return the productImagePath
	 */
	public String getProductImagePath() {
		return productImagePath;
	}

	/**
	 * @param productImagePath
	 *            the productImagePath to set
	 */
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productStockQuantity="
				+ productStockQuantity + ", productImagePath=" + productImagePath + "]";
	}
	
	
}