/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author VERGAJO
 *
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Products implements Serializable {

	@Id
	@Column(name = "PRODUCT_ID")
	private long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "PRODUCT_PRICE")
	private BigDecimal productPrice;	

	@Column(name = "PRODUCT_STOCK_QUANTITY")
	private BigDecimal productStockQuantity;

	@Column(name = "PRODUCT_IMAGE_PATH")
	private String productImagePath;

	@OneToMany(mappedBy = "productId")
	private OrderItem orderItem;

	public Products() {
	}

	public Products(long productId, String productName, String productDescription, BigDecimal productPrice,
			BigDecimal productStockQuantity, String productImagePath, OrderItem orderItem) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStockQuantity = productStockQuantity;
		this.productImagePath = productImagePath;
		this.orderItem = orderItem;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getProductStockQuantity() {
		return productStockQuantity;
	}

	public void setProductStockQuantity(BigDecimal productStockQuantity) {
		this.productStockQuantity = productStockQuantity;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}



}