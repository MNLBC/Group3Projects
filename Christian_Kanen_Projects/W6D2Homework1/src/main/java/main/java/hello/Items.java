package main.java.hello;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author KANENCH
 *
 */
@Entity
@Table(name="ITEMS")
public class Items implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ITEM_ID")
	private String itemId;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "ITEM_CATEGORY")
	private String itemCategory;	
	@Column(name = "ITEM_STOCK")
	private Integer itemStock;
	@Column(name = "ITEM_PRICE")
	private Integer itemPrice;

	/**
	 * 
	 */
	public Items() {

	}

	/**
	 * @param itemId
	 */
	public Items(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}

	/**
	 * @param itemCategory
	 *            the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	/**
	 * @return the itemStock
	 */
	public Integer getItemStock() {
		return itemStock;
	}

	/**
	 * @param itemStock
	 *            the itemStock to set
	 */
	public void setItemStock(Integer itemStock) {
		this.itemStock = itemStock;
	}

	/**
	 * @return the itemPrice
	 */
	public Integer getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Items))
			return false;
		Items other = (Items) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}
	
	public String toString(){
		return  "ITEMS {" + "ITEM_ID=" + itemId + ",  ITEM_NAME='" + itemName +
				", ITEM_CATEGORY=" + itemCategory + ",  ITEM_STOCK='" + itemStock  +
				", ITEM_PRICE =" + itemPrice+ '\'' + '}';
	}
}
