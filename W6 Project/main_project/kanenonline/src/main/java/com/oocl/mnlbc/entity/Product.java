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
 * @author VERGAJO
 *
 */
@Entity(name="product")
@Table(name="PRODUCT")
//@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
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
	private BigDecimal productPrice;	

	@Column(name = "PRODUCT_STOCK_QUANTITY")
	private BigDecimal productStockQuantity;

	@Column(name = "PRODUCT_IMAGE_PATH")
	private String imagePath;

	/*@OneToMany(mappedBy = "productId")
	private OrderItem orderItem;*/

	public Product() {
	}

	public Product(long productId, String productName, String productDescription, BigDecimal productPrice,
			BigDecimal productStockQuantity, String imagePath, OrderItem orderItem) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStockQuantity = productStockQuantity;
		this.imagePath = imagePath;
		//this.orderItem = orderItem;
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
		return imagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.imagePath = productImagePath;
	}

	/*public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
*/


}