/**
 * 
 */
package com.oocl.mnlbc.model;

import java.util.List;

import com.oocl.mnlbc.entity.Product;

/**
 * @author Christian Kanen
 *
 */
public class ProductList {

	private List<Product> productList;

	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductList [productList=" + productList + "]";
	}
	
	
	
}
