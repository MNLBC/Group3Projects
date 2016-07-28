/**
 * 
 */
package com.oocl.mnlbc.dao;

import javax.persistence.Query;

import com.oocl.mnlbc.entity.Product;

/**
 * @author Melvin Yu
 *
 */
public interface ProductDAO {
	public String getNameById(long typeId);
	public Product updateProduct(Product product);
	boolean createProduct(Product product);
	
}
