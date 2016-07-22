package com.oocl.mnlbc.model;
/**
 * 
 * @author Alexis Cuntapay
 *
 * @param <T>
 */
public class Response<T> {
	
	private boolean success;    
	private T data;
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	

}
