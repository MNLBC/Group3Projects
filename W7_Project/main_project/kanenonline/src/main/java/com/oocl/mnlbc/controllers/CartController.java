package com.oocl.mnlbc.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.entity.CartItem;
import com.oocl.mnlbc.model.CartItemList;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.services.CartService;

/**
 * @author VERGAJO
 * 
 */

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

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

		Gson gson = new Gson();
		// accepts the jsonData from the request and uses GSON to convert JSON
		// to Object
		// uses CartItemList to map the jsonData to java object
		CartItemList cartItemList = gson.fromJson(jsonData, CartItemList.class);

		String response = "";

		response = cartService.saveCart(cartItemList);

		return response;
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

		Response<ModelWrapper<CartItem>> response = new Response<ModelWrapper<CartItem>>();

		response = cartService.loadCart(userId);

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
	public boolean removeUserCart(@RequestParam(value = "userId", required = true) long userId) throws IOException {
		boolean result;

		result = cartService.removeUserCart(userId);

		return result;
	}
}
