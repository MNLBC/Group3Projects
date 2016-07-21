package com.oocl.mnlbc.dao;

import java.util.List;
import javax.sql.DataSource;
import com.oocl.mnlbc.model.ProductBean;
/**
 * 
 * @author ITAGroup3
 *
 */
public interface ProductDAO {
	/**
	 * Interface of Products
	 */
	
	public void setDataSource(DataSource ds);
	
	public List<ProductBean> getProductList();

	public boolean updateProductList(ProductBean prod);

}