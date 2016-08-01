/**
 * 
 */
package com.oocl.mnlbc.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.controllers.OrderController;
import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.entity.CartItem;
import com.oocl.mnlbc.model.CartItemList;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author VERGAJO
 *
 */
public class CartService {

	@Autowired
	private CartDAO cartDAO;

	private static final Logger logger = Logger.getLogger(OrderController.class);

	public String saveCart(CartItemList cartItemList) {
		logger.info("Saving cart to database");
		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		// cartDAO.savecart accepts the parameter cartItemList to save to the
		// Database
		if (cartDAO.saveCart(cartItemList)) {
			logger.info("Cart successfully saved to the database.");
			errorMsg += "none";
		} else {
			logger.info("Cart failed to save to database.");
			errorMsg += "failed";
		}

		builder.append(errorMsg);
		builder.append("\"}}");

		return builder.toString();

	}

	public Response<ModelWrapper<CartItem>> loadCart(long userId) {

		// Accepts the userId from the ajax request and use it to load the cart
		// of the user
		List<CartItem> result = cartDAO.loadCart(userId);

		ModelWrapper<CartItem> cartItemWrapper = new ModelWrapper<CartItem>();
		// uses the "items" of ModelWrapper to containt the List of CartItems
		cartItemWrapper.setItems(result);

		// uses response wrapper so that the response json would contain
		// "success" and "data"
		Response<ModelWrapper<CartItem>> response = new Response<ModelWrapper<CartItem>>();

		if (CollectionUtils.isNotEmptyList(result)) {
			// set the success value of the response Jsondata to true
			response.setSuccess(true);
			// set the data value of the response jsondata to the
			// cartItemWrapper which containes the list of CartItems
			response.setData(cartItemWrapper);
			logger.info("Cart items of user " + userId + "is successfully retrieved.");
		} else {
			response.setSuccess(true);
			response.setData(cartItemWrapper);
			logger.info("No previous cart for user " + userId);
		}

		return response;

	}

	public boolean removeUserCart(long userId) {

		boolean result = false;
		if (userId > 0) {
			// removeUserCart accepts the parameter userId from the request to
			result = cartDAO.removeUserCart(userId);
		}
		return result;
	}

}
