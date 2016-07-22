package com.oocl.mnlbc.model;

import java.util.ArrayList;
import java.util.List;

public class ModelWrapper<T> {

	List<T> items;

	/**
	 * @return the items
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<T> items) {
		this.items = items;
	}

	public ModelWrapper() {
		this.items = new ArrayList<T>();
	}

}
