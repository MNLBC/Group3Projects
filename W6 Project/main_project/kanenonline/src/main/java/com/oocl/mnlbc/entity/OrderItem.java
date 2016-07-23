package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author VERGAJO
 *
 */
@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable {

	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID")
	private Integer orderItemId;

	@Column(name = "QUANTITY")
	private Double quantity;
	
	@Column(name = "ORDERED_PRICE")
	private Double orderedPrice;

	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Orders orderId;

	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	private Product product;

	public OrderItem() {
	}

	public OrderItem(Integer orderItemId, Double quantity, Double orderedPrice, Orders orderId, Product product) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.orderedPrice = orderedPrice;
		this.orderId = orderId;
		this.product = product;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getOrderedPrice() {
		return orderedPrice;
	}

	public void setOrderedPrice(Double orderedPrice) {
		this.orderedPrice = orderedPrice;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
