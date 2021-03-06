package com.oocl.mnlbc.group3.model;

import java.util.List;

/**
 * 
 * Chat Model class
 * 
 * @author kanench
 * @version 1.0
 */
public class Chat {
	private String username;
	private String chat;
	private String date;
/**
 * 
 * @param username
 * @param chat
 * @param date
 */
	public Chat(String username, String chat, String date) {
		super();
		this.username = username;
		this.chat = chat;
		this.date = date;
	}
/**
 * 
 * @return username
 */
	public String getUsername() {
		return username;
	}
/**
 * 
 * @param username
 */
	public void setUsername(String username) {
		this.username = username;
	}
/**
 * 
 * @return chat
 */
	public String getChat() {
		return chat;
	}
/**
 * 
 * @param chat
 */
	public void setChat(String chat) {
		this.chat = chat;
	}
/**
 * 
 * @return date
 */
	public String getDate() {
		return date;
	}
/**
 * 
 * @param date
 */
	public void setDate(String date) {
		this.date = date;
	}

}
