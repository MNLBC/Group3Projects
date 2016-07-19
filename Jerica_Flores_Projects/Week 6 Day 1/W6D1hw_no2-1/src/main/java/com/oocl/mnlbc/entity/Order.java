package com.oocl.mnlbc.entity;

import java.io.Serializable;
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

@Entity(name = "order")
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User userId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.EAGER)
	
	private List<OrderItem> itemList;

	public Order(Integer orderId, User userId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (orderId != null ? orderId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Order)) {
			return false;
		}
		Order other = (Order) object;
		if ((this.orderId == null && other.orderId != null)
				|| (this.orderId != null && !this.orderId.equals(other.orderId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Order ID \t User Id \n" + orderId + "\t" + userId;
	}
}
