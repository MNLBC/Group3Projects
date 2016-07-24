package com.oocl.mnlbc.model;

import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.entity.Product;
/**
 * Wrapper class for products
 * @author BRIONSE
 *
 */
public class ProductList {

	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductList() {
		super();
		this.products = new ArrayList<Product>();
	}

}
