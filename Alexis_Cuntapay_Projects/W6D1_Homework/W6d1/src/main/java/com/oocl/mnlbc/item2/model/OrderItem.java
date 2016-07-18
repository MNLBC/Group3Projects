package com.oocl.mnlbc.item2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItem implements Serializable {

    @Id
//            (strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Integer orderItemId;
    @Column(name = "order_itemname")
    private String orderItemName;
    @JoinColumn(name = "order_item_order", referencedColumnName = "ORDERS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order ordersId;
    
	public OrderItem() {
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
	public Order getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Order ordersId) {
		this.ordersId = ordersId;
	}
    
}
