/**
 * 
 */
package com.oocl.mnlbc.hw1no2.order;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.oocl.mnlbc.hw1no1.entity.Students;

/**
 * @author KANENCH
 *
 */
@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//	 (strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "ITEM_ID")
	private Integer itemId;
	
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrderItem orderItem;
	

	public Order(){
		
	}
	
	public Order(Integer userId) {
		super();
		this.userId = userId;
	}

	public Order(Integer userId, Integer itemId) {
		super();
		this.userId = userId;
		this.itemId = itemId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Order other = (Order) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString(){
		return "ORDERS {" + "USER_ID=" + userId + ",  ITEM_ID='" + itemId 
				+ '\'' + '}';
	}
	
}
