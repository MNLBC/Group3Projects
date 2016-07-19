package com.oocl.mnlbc.entity;

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

@Entity(name = "order_item")
@Table(name = "order_items")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "item_id")
    private Integer itemId;
	@Column(name = "item_name")
    private String itemName;
    @Column(name = "item_details")
    private String itemDetails;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    
    private Order orderId;
    
    public OrderItem(Integer itemId, String itemName, String itemDetails, Order orderId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDetails = itemDetails;
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }    
    
    

	@Override
    public String toString() {
        return "Order ID \t Item Name \t Item Details \n"+ orderId + " \t "
        		+ itemName + "\t" + itemDetails;
    }
}
