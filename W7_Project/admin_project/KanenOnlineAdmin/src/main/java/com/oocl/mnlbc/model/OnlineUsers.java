/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;
import java.util.Map;

/**
 * @author Melvin Yu
 *
 */
public class OnlineUsers {
	private  List<LoggedInUser> onlineList;

	/**
	 * @return the onlineList
	 */
	public  List<LoggedInUser> getOnlineList() {
		return onlineList;
	}

	/**
	 * @param onlineList the onlineList to set
	 */
	public  void setOnlineList(List<LoggedInUser> onlineList) {
		this.onlineList = onlineList;
	}

	
	
}
