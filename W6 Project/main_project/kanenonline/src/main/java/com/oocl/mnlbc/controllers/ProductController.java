package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.model.ProductList;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * 
 * @author BRIONSE
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAO productService;

	private static final Logger logger = Logger.getLogger(ProductController.class);

	/**
	 * getting all the products
	 * 
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/productList", method = { RequestMethod.POST })
	@ResponseBody
	public Response<ProductList> getProductList() throws IOException {
		logger.info("Retrieving products from the database..");

		ProductList products = new ProductList();
		List<Product> productsList = productService.getProductList();

		products.setProducts(productsList);
         Response<ProductList> response= new Response<ProductList>();
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
