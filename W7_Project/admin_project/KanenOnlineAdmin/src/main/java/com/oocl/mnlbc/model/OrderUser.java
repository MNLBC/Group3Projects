/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;

import com.oocl.mnlbc.entity.Order;

/**
 * @author Melvin Yu
 *
 * This model handles the order and the userId with its fullname
 */
public class OrderUser {
	private String fullName;
	private long userID;
	private Order order;

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderUser [fullName=" + fullName + ", userID=" + userID + ", order=" + order + "]";
	}
	
	

}
