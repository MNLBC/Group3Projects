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

	@RequestMapping(value = "/saveCart", method = RequestMethod.POST)
	@ResponseBody
	public String saveCart(@RequestParam(value = "jsonData", required = true) String jsonData) throws IOException {
		logger.info("Saving cart to database");

		Gson gson = new Gson();
		CartItemList cartItemList = gson.fromJson(jsonData, CartItemList.class);

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
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

	@RequestMapping(value = "/loadCart", method = RequestMethod.POST)
	@ResponseBody
	public Response<ModelWrapper<CartItem>> loadCart(@RequestParam(value = "userId", required = true) long userId)
			throws IOException {
		// Response<ModelWrapper<CartItem>>
		
		
		String test = "";
		List<CartItem> result = cartDAO.loadCart(userId);

		ModelWrapper<CartItem> cartItemWrapper = new ModelWrapper<CartItem>();
		cartItemWrapper.setItems(result);

		Response<ModelWrapper<CartItem>> response = new Response<ModelWrapper<CartItem>>();

		if (CollectionUtils.isNotEmptyList(result)) {
			response.setSuccess(true);
			response.setData(cartItemWrapper);
			logger.info("Cart items of user " + userId + "is successfully retrieved.");
		} else {
			response.setSuccess(true);
			response.setData(cartItemWrapper);
			logger.info("No previous cart for user " + userId);
		}

		return response;

	}

	@RequestMapping(value = "/removeUserCart", method = RequestMethod.POST)
	@ResponseBody
	public boolean removeUserCart(@RequestParam(value = "userId", required = true) Long userId) throws IOException {
		// Response<ModelWrapper<CartItem>>
		boolean result = false;
		if(userId != null){
			result = cartDAO.removeUserCart(userId);
		}
		return result;

	}
}
