/**
 * 
 */
package com.oocl.mnlbc.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.controllers.ProductController;
import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.model.ProductList;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author VERGAJO
 *
 */
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = Logger.getLogger(ProductController.class);

	public Response<ProductList> getProductList() {
		logger.info("Retrieving products from the database..");
		Response<ProductList> response = new Response<ProductList>();

		ProductList products = new ProductList();

		List<Product> productsList = productDAO.findAll();
		products.setProducts(productsList);
		response.setData(products);
		
		if (CollectionUtils.isNotEmptyList(productsList)) {
			response.setSuccess(true);
			logger.info("Products successfully retrieved.");
		} else {

			logger.info("Retrieval of products failed.");
		}

		return response;

	}
}
