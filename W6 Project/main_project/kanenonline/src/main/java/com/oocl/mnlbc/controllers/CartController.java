/**
 * 
 */
package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.entity.CartItem;
import com.oocl.mnlbc.model.CartItemList;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author VERGAJO
 * @author FLOREJE
 *
 */

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartDAO cartDAO;
	private static final Logger logger = Logger.getLogger(OrderController.class);

	/**
	 * Saves the cart of the user to the database
	 * 
	 * @param jsonData
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveCart", method = RequestMethod.POST)
	@ResponseBody
	public String saveCart(@RequestParam(value = "jsonData", required = true) String jsonData) throws IOException {
		logger.info("Saving cart to database");

		Gson gson = new Gson();
		//accepts the jsonData from the request and uses GSON to convert JSON to Object
		//uses CartItemList to map the jsonData to java object
		CartItemList cartItemList = gson.fromJson(jsonData, CartItemList.class);

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		//cartDAO.savecart accepts the parameter cartItemList to save to the Database
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

	/**
	 * Loads the saved cart of the user
	 * 
	 * @param userId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/loadCart", method = RequestMethod.POST)
	@ResponseBody
	public Response<ModelWrapper<CartItem>> loadCart(@RequestParam(value = "userId", required = true) long userId)
			throws IOException {
		//Accepts the userId from the ajax request and use it to load the cart of the user
		List<CartItem> result = cartDAO.loadCart(userId);

		
		ModelWrapper<CartItem> cartItemWrapper = new ModelWrapper<CartItem>();
		//uses the "items" of ModelWrapper to containt the List of CartItems
		cartItemWrapper.setItems(result);

		//uses response wrapper so that the response json would contain "success" and "data"
		Response<ModelWrapper<CartItem>> response = new Response<ModelWrapper<CartItem>>();

		if (CollectionUtils.isNotEmptyList(result)) {
			//set the success value of the response Jsondata to true
			response.setSuccess(true);
			//set the data value of the response jsondata to the cartItemWrapper which containes the list of CartItems
			response.setData(cartItemWrapper);
			logger.info("Cart items of user " + userId + "is successfully retrieved.");
		} else {
			response.setSuccess(true);
			response.setData(cartItemWrapper);
			logger.info("No previous cart for user " + userId);
		}

		return response;

	}

	/**
	 * Deletes the existing cart of the user from the database
	 * 
	 * @param userId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/removeUserCart", method = RequestMethod.POST)
	@ResponseBody
	public boolean removeUserCart(@RequestParam(value = "userId", required = true) Long userId) throws IOException {
		boolean result = false;
		if (userId != null) {
			//removeUserCart accepts the parameter userId from the request to remove the cart
			result = cartDAO.removeUserCart(userId);
		}
		return result;

	}
}