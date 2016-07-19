/**
 * 
 */
package com.oocl.mnlbc.hw1no2.order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author KANENCH
 *
 */

@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {
	
	@Column(name = "ITEM_ID")
	private Integer itemId;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "ITEM_DETAILS")
	private String itemDesc;
	@Column(name = "ITEM_PRICE")
	private Integer itemPrice;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId", fetch = FetchType.LAZY)
	private Order order;
	
	public OrderItem() {
	
	}
	
	public OrderItem(Integer itemId) {
		this.itemId = itemId;
	}
	
	public OrderItem(Integer itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}
	
	public OrderItem(Integer itemId, String itemName, String itemDesc) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}
	
	public OrderItem(Integer itemId, String itemName, String itemDesc, Integer itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (itemDesc == null) {
			if (other.itemDesc != null)
				return false;
		} else if (!itemDesc.equals(other.itemDesc))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice == null) {
			if (other.itemPrice != null)
				return false;
		} else if (!itemPrice.equals(other.itemPrice))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	@Override
	public String toString(){
		return "ORDER_ITEM {" + "ITEM_ID=" + itemId + ",  ITEM_NAME='" + itemName +
				"ITEM_DETAILS=" + itemDesc + ",  ITEM_PRICE='" + itemPrice
				+ '\'' + '}';
	}
}
