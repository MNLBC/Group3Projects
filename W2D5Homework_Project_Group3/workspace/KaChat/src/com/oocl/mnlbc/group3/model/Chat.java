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

	public Chat(String username, String chat, String date) {
		super();
		this.username = username;
		this.chat = chat;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
