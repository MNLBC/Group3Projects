package com.oocl.mnlbc.group3.model;

/**
 * Product Model Class
 * 
 * @author YUME
 * @author2 Group3
 * @version 1
 */
public class Product {

	private String productName;
	private int inStock;
	private double price;
	private String productDesc;
	private int productId;

	/**
	 * 
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * setting the productId
	 * 
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product() {

	}

	/**
	 * Product model Constructor
	 * 
	 * @param productId
	 * @param productName
	 * @param inStock
	 * @param price
	 * @param productDesc
	 */

	public Product(int productId, String productName, int inStock, double price, String productDesc) {
		this.productId = productId;
		this.productName = productName;
		this.inStock = inStock;
		this.price = price;
		this.productDesc = productDesc;
	}

	/**
	 * getting
	 * 
	 * @return productName
	 */

	public String getProductName() {
		return productName;
	}

	/**
	 * setting the productName
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * getting the inStock
	 * 
	 * @return
	 */

	public int getInStock() {
		return inStock;
	}

	/**
	 * setting the inStocks
	 * 
	 * @param inStocks
	 */

	public void setInStock(int inStocks) {
		this.inStock = inStocks;
	}

	/**
	 * getting the Price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * setting the price
	 * 
	 * @param price
	 */

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * getting the productDesc
	 * 
	 * @return productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * setting the productDesc
	 * 
	 * @param productDesc
	 */

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * this is just to return a simple string value of the product
	 */

	public String toString() {
		return "Product ID:[" + this.productId + "]" + " Product name: " + this.productName + " " + this.productDesc
				+ " Price: $" + this.price + " Currently in stock: " + this.inStock;
	}

}
