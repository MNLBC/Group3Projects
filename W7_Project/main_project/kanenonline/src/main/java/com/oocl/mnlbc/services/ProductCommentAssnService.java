/**
 * 
 */
package com.oocl.mnlbc.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.controllers.ProductController;
import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;

/**
 * @author FLOREJE This Service accepts the params passed from controller and
 *         and build the responseData
 *
 */
public class ProductCommentAssnService {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private UserDAO userDAO;

	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	public String saveProductComment(long id, long productId, String productComment) {
		logger.info("Saving product comments to database");

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");

		User userId = userDAO.findById(id);

		if (productDAO.saveProductComment(userId, productId, productComment)) {
			logger.info("Product comment successfully saved to the database.");
			errorMsg += "none";
		} else {
			logger.info("Product comment failed to save to database.");
			errorMsg += "failed";
		}

		builder.append(errorMsg);
		builder.append("\"}}");

		return builder.toString();
	}
}
