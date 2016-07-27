/**
 * 
 */
package com.oocl.mnlbc.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.entity.WishList;
import com.oocl.mnlbc.model.CartItemList;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.services.WishListService;

/**
 * @author VERGAJO
 *
 */
@Controller
@RequestMapping("/wishList")
public class WishListController {

	@Autowired
	WishListService wishListService;

	@RequestMapping(value = "/saveWishList", method = RequestMethod.POST)
	@ResponseBody()
	public String saveWishList(@RequestParam(value = "jsonData", required = true) String jsonData) throws IOException {

		Gson gson = new Gson();
		// accepts the jsonData from the request and uses GSON to convert JSON
		// to Object
		// uses CartItemList to map the jsonData to java object

		WishList wishList = gson.fromJson(jsonData, CartItemList.class);

		String response = "";

		response = wishListService.saveCart(wishList);

		return response;
	}

	@RequestMapping(value = "/clearUserWishList", method = RequestMethod.GET)
	@ResponseBody
	public boolean clearUserWishList(@RequestParam(value = "userId", required = true) long userId) throws IOException {
		boolean result;

		result = wishListService.clearUserWishList(userId);

		return result;
	}

	@RequestMapping(value = "/removeFromWishList", method = RequestMethod.GET)
	@ResponseBody
	public boolean removeFromWishList(@RequestParam(value = "wishListId", required = true) long wishListId)
			throws IOException {
		
		boolean result;

		result = wishListService.removeFromWishList(wishListId);

		return result;
	}
	
	@RequestMapping(value = "/loadUserWishList", method = RequestMethod.GET)
	@ResponseBody
	public Response<ModelWrapper<WishList>> loadUserWishList(@RequestParam(value = "userId", required = true) long userId)
			throws IOException {

		Response<ModelWrapper<WishList>> response = new Response<ModelWrapper<WishList>>();

		response = wishListService.loadUserWishList(userId);

		return response;
	}

}
