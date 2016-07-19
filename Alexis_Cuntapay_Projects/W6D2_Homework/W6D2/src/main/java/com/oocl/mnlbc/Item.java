package com.oocl.mnlbc;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author CUNTAAL
 *
 */
@Entity
@Table(name = "items")
public class Item implements Serializable {

	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Integer itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "Item_category")
	private String itemCategory;
	@Column(name = "item_stock")
	private Integer itemStock;
	@Column(name = "item_price")
	private Integer itemPrice;

	public Item() {

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
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", itemStock="
				+ itemStock + ", itemPrice=" + itemPrice + "]";
	}
	
	

}