/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.ProductCommentAssn;

/**
 * @author Melvin Yu
 *
 */
public interface ProductDAO {
	public String getNameById(long typeId);
	public Product updateProduct(Product product);
	boolean createProduct(Product product);
	public List<ProductCommentAssn> getProductComments();
	public List<Product> getProductList();
}
