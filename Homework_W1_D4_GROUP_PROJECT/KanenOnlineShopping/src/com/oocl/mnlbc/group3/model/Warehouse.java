package com.oocl.mnlbc.group3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KANENCH
 *
 */
public class Warehouse {

	private List<Product> productSelection;
/**
 * this is the constructor of the Warehouse.
 * intiatiate value of the hardcoded list of products
 */
	public Warehouse() {
		productSelection = new ArrayList<Product>();
		this.initProducts();
	}
/**
 * product initialization
 */
	public void initProducts() {
		this.productSelection.add(new Product(1, "Bag", 10, 50.00, "Big Blue Bag"));
		this.productSelection.add(new Product(2, "Shoes", 7, 40.00, "Silver Small Shoes"));
		this.productSelection.add(new Product(3, "Shirt", 20, 10.50, "Silky Smooth Shirt"));
		this.productSelection.add(new Product(4, "Phone", 5, 320.00, "Fancy Fone"));
	}

	/**
	 * A list instance of Product. so products can be put in the warehouse.
	 * @return productSelection
	 */
	public List<Product> getProductSelection() {
		return productSelection;
	}
	
	/**
	 * this gets the product by product id in the warehouse.
	 * and returns either null or the product
	 * @param prodId
	 * @return Product
	 */

	public Product getWarehousProduct(int prodId) {
		for (int i = 0; i < productSelection.size(); i++) {
			if (this.productSelection.get(i).getProductId() == prodId) {
				return this.productSelection.get(i);
			}
		}
		return null;
	}
	
	/**
	 * setting up the products.
	 * was not used due to no admin usage was not part of the project
	 * @param productSelection
	 */

	public void setProductSelection(List<Product> productSelection) {
		this.productSelection = productSelection;
	}

	/**
	 * this is just to get & display all the Products inside the Warehouse
	 */
	public void listProducts() {
		System.out.println("Available products: ");
		int productCtr = 1;
		for (Product product : this.productSelection) {
			System.out.println(productCtr + ".) "+ product.toString());
			productCtr++;
		}
	}
	
	/**
	 * this is getting the Product inside the list to be put on the cart
	 * returns the product
	 * @param prodId
	 * @return Product
	 */

	public Product getProduct(int prodId) {
		Product prod1 = null;
		for (Product product : productSelection) {
			if (product.getProductId() == prodId) {
				prod1 = deepCopy(product);
			}
		}
		return prod1;
	}
	
	/**
	 * this is to create an independent copy
	 * @param prod
	 * @return
	 */
	public Product deepCopy(Product prod){
		
		Product newProd = new Product();
		newProd.setProductName(prod.getProductName());
		newProd.setInStock(prod.getInStock());
		newProd.setPrice(prod.getPrice());
		newProd.setProductDesc(prod.getProductDesc());
		newProd.setProductId(prod.getProductId());
		
		return newProd;
	}

}
