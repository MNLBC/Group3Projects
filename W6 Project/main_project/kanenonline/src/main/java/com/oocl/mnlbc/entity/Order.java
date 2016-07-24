/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VERGAJO
 *
 */
@Entity(name = "Order")
@Table(name = "ORDERS")
public class Order implements Serializable {

//	@Id
//	@GeneratedValue(generator = "ORDER_ID_SEQ")
//	@SequenceGenerator(name = "ORDER_ID_SEQ", sequenceName = "ORDER_ID_SEQ", allocationSize = 111)
//	@Column(name = "ORDER_ID")
//	private long orderId;
//	
	@Id
	@Column(name = "ORDER_ID")
	@SequenceGenerator(name = "ORDER_ID_SEQ", sequenceName = "ORDER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ORDER_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long orderId;

	@Column(name = "ORDER_DATE")
	private String orderDate;

	@Column(name = "TOTAL_COST")
	private double totalCost;

	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	@Column(name = "USER_ID")
	private long userId;

	// @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	// @ManyToOne(optional = false, fetch = FetchType.LAZY)
	// private long userId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
	private List<OrderItem> items;

	public Order() {
	}

	public Order(long orderId, String orderDate, double totalCost, String orderStatus, long userId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}