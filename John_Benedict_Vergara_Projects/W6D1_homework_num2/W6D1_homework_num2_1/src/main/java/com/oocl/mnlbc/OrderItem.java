package com.oocl.mnlbc;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable {

    @Id
//            (strategy = GenerationType.AUTO)
    @Column(name = "ORDERITEM_ID")
    private Integer orderItemId;
    @Column(name = "ORDERITEM_NAME")
    private String orderItemName;
    @Column(name = "ORDERITEM_PRICE")
    private String orderItemPrice;
    @Column(name = "ORDERITEM_DESCRIPTION")
    private String orderItemDescription;
    @JoinColumn(name = "ORDERITEM_ORDER", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders orderId;

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

	public String getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(String orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public String getOrderItemDescription() {
		return orderItemDescription;
	}

	public void setOrderItemDescription(String orderItemDescription) {
		this.orderItemDescription = orderItemDescription;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public OrderItem(Integer orderItemId, String orderItemName, String orderItemPrice, String orderItemDescription,
			Orders orderId) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemName = orderItemName;
		this.orderItemPrice = orderItemPrice;
		this.orderItemDescription = orderItemDescription;
		this.orderId = orderId;
	}

}
