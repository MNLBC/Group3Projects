package com.oocl.mnlbc.group3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "ITEM")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID", nullable = false)
	@GeneratedValue(generator = "ITEM_ID_SEQ")
	@SequenceGenerator(name = "ITEM_ID_SEQ", sequenceName = "ITEM_ID_SEQ", allocationSize = 111)
	private long itemId;

	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;

	@Column(name = "ITEM_CATEGORY", nullable = false)
	private String itemCategory;

	@Column(name = "ITEM_STOCK", nullable = false)
	private int itemStock;

	@Column(name = "ITEM_PRICE", nullable = false)
	private double itemPrice;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
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

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
