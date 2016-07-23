/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author VERGAJO
 *
 */
@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

	@Id
	@Column(name = "ORDER_ID")
	private long orderId;

	@Column(name = "ORDER_DATE")
	private String orderDate;

	@Column(name = "TOTAL_COST")
	private BigDecimal totalCost;
	
	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	@JoinColumn(name = "USERS_ID", referencedColumnName = "USERS_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User usersId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
	private List<OrderItem> orderItemsList;

	public Orders() {
	}

	public Orders(long orderId, String orderDate, BigDecimal totalCost, String orderStatus, User usersId,
			List<OrderItem> orderItemsList) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		this.usersId = usersId;
		this.orderItemsList = orderItemsList;
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

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUsersId() {
		return usersId;
	}

	public void setUsersId(User usersId) {
		this.usersId = usersId;
	}

	public List<OrderItem> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItem> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

	


}