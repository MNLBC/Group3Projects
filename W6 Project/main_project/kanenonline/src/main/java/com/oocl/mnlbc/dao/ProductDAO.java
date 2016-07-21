package com.oocl.mnlbc.dao;

import java.util.List;
import com.oocl.mnlbc.entity.Product;

/**
 * Interface of Products
 * 
 * @author ITAGroup3
 *
 */
public interface ProductDAO {

	public List<Product> getProductList();

}