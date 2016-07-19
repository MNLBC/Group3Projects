package com.oocl.mnlbc.item2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author CUNTAAL
 *
 */

@Entity

@Table(name = "Order")

public class Order implements Serializable {

	@Id

	// @GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "order_item_id")

	private Integer orderItemId;

	@Column(name = "order_item_name")

	private String orderItemName;

	@JoinColumn(name = "order_users", referencedColumnName = "user_id")

	@ManyToOne(optional = false, fetch = FetchType.LAZY)

	private Users usersId;

	public Order() {
		super();
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderItemName() {
		return orderItemName;
	}

	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}

	public Users getUsersId() {
		return usersId;
	}

	public void setUsersId(Users usersId) {
		this.usersId = usersId;
	}

}