package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author VERGAJO
 *
 */
@SuppressWarnings("serial")
@Entity(name = "OrderItem")
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

	@Id
	@Column(name = "ORDER_ITEM_ID")
	@SequenceGenerator(name = "ORDER_ITEM_ID_SEQ", sequenceName = "ORDER_ITEM_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ORDER_ITEM_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long orderItemId;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "ORDERED_PRICE")
	private Double productPrice;

	@Column(name = "PRODUCT_ID")
	private long productId;

	@JsonIgnore
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Order orderId;

	public OrderItem() {

	}
	
	

	/**
	 * @param orderItemId
	 * @param quantity
	 * @param productPrice
	 * @param productId
	 * @param orderId
	 */
	public OrderItem(long orderItemId, int quantity, Double productPrice, long productId, Order orderId) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productId = productId;
		this.orderId = orderId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}



	/* (non-Javadoc)
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
		OrderItem other = (OrderItem) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}



	/**
	 * @return the orderItemId
	 */
	public long getOrderItemId() {
		return orderItemId;
	}

	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the orderId
	 */
	public Order getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	

}
