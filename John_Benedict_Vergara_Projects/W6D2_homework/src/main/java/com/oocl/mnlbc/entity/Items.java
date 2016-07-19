/**
 * 
 */
package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author VERGAJO
 *
 */

@Entity(name = "ITEM")
@Table(name = "ITEMS")
public class Items {

	@Id
	@Column(name = "ITEM_ID")
	private String itemId;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "ITEM_CATEGORY")
	private String itemCategory;
	@Column(name = "ITEM_STOCK")
	private int itemStock;
	@Column(name = "ITEM_PRICE")
	private int itemPrice;

	public Items(String itemId, String itemName, String itemCategory, int itemStock, int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemStock = itemStock;
		this.itemPrice = itemPrice;
	}

	public Items() {
		// TODO Auto-generated constructor stub
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
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

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
