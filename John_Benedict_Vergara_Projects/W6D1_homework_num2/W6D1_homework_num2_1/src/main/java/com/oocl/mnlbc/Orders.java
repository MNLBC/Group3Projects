package com.oocl.mnlbc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Integer orderId;
	@Column(name = "ORDERITEM_ID")
	private String orderItemId;
	@Column(name = "ORDER_TOTALPRICE")
	private String orderTotalPrice;
	@JoinColumn(name = "ORDERS_USERS", referencedColumnName = "USERS_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Users usersId;

	public Orders() {
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(String orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Users getUsersId() {
		return usersId;
	}

	public void setUsersId(Users usersId) {
		this.usersId = usersId;
	}

	public Orders(Integer orderId, String orderItemId, String orderTotalPrice, Users usersId) {
		super();
		this.orderId = orderId;
		this.orderItemId = orderItemId;
		this.orderTotalPrice = orderTotalPrice;
		this.usersId = usersId;
	}

	
	
}
