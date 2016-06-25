/**
 * 
 */
package com.oocl.mnlbc.group3.model;

/**
 * @author YUME
 *
 */
public class Conversation {
	
	private int convId;
	private String chat;
	private String date;
	/**
	 * @param convId
	 * @param chat
	 * @param date
	 */
	public Conversation(int convId, String chat, String date) {
		super();
		this.convId = convId;
		this.chat = chat;
		this.date = date;
	}
	/**
	 * @return the convId
	 */
	public int getConvId() {
		return convId;
	}
	/**
	 * @param convId the convId to set
	 */
	public void setConvId(int convId) {
		this.convId = convId;
	}
	/**
	 * @return the chat
	 */
	public String getChat() {
		return chat;
	}
	/**
	 * @param chat the chat to set
	 */
	public void setChat(String chat) {
		this.chat = chat;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
