package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "order_item")
@Table(name = "order_items")
public class OrderItem implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Integer itemId;
	@Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "ITEM_DETAILS")
    private String itemDetails;
    @Column(name = "ITEM_CATEGORY")
    private String itemCategory;
    @Column(name = "ITEM_STOCK")
    private Integer itemStock;
    @Column(name = "ITEM_PRICE")
    private Integer itemPrice;
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order orderId;
    
    public OrderItem() {
		// TODO Auto-generated constructor stub
	}
    
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
	
	

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Integer getItemStock() {
		return itemStock;
	}

	public void setItemStock(Integer itemStock) {
		this.itemStock = itemStock;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
		return "OrderItem [itemId=" + itemId + ", itemName=" + itemName + ", itemDetails=" + itemDetails
				+ ", itemCategory=" + itemCategory + ", itemStock=" + itemStock + ", itemPrice=" + itemPrice
				+ ", orderId=" + orderId + "]";
	}    
    
    
    
}
