/**
 * 
 */
package com.oocl.mnlbc.services;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.controllers.ProductController;
import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.ProductCommentAssn;

/**
 * @author FLOREJE
 *
 */
public class ProductCommentAssnService {
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	public String saveProductComment(ProductCommentAssn productComment) {
		logger.info("Saving product comments to database");
		
		StringBuilder builder = new StringBuilder();
		String errorMsg = "";
		
		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		
		if(productDAO.saveProductComment(productComment)){
			logger.info("Product comment successfully saved to the database.");
			errorMsg += "none";
		}else{
			logger.info("Product comment failed to save to database.");
			errorMsg += "failed";
		}
		
		builder.append(errorMsg);
		builder.append("\"}}");
		
		return builder.toString();
	}
}
