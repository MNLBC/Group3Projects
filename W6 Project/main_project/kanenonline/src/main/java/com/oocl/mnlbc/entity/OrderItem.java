package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Entity(name = "OrderItem")
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

	@Id
	@GeneratedValue(generator = "ORDER_ITEM_ID_SEQ")
	@SequenceGenerator(name = "ORDER_ITEM_ID_SEQ", sequenceName = "ORDER_ITEM_ID_SEQ", allocationSize = 111)
	@Column(name = "ORDER_ITEM_ID")
	private long orderItemId;

	@Column(name = "QUANTITY")
	private Double quantity;

	@Column(name = "ORDERED_PRICE")
	private Double orderedPrice;
	@JsonIgnore
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Order orderId;

	/*
	 * @JsonIgnore
	 * 
	 * @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
	 * //@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch =
	 * FetchType.LAZY)
	 * 
	 * @ManyToOne(optional = false, fetch = FetchType.LAZY) private Product
	 * productId;
	 */

	public OrderItem() {

	}

	public OrderItem(Integer orderItemId, Double quantity, Double orderedPrice) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.orderedPrice = orderedPrice;

	}

	public long getOrderItemId() {
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

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId2) {
		this.orderId = orderId2;
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
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}
