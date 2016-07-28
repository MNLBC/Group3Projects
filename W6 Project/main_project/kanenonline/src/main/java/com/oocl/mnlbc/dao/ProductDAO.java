package com.oocl.mnlbc.dao;

import java.util.List;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.User;

/**
 * Interface of Products
 * 
 * @author ITAGroup3
 *
 */
public interface ProductDAO extends GenericDAO<Product> {

	public List<Product> getProductList();
	public boolean saveProductComment(User userId, long productId, String productComment);

}