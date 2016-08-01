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

import com.oocl.mnlbc.entity.WishList;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.model.WishListId;
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
	public Response<WishListId> saveWishList(@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "productId", required = true) long productId,
			@RequestParam(value = "productName", required = true) String productName,
			@RequestParam(value = "productDescription", required = true) String productDescription,
			@RequestParam(value = "productPrice", required = true) long productPrice,
			@RequestParam(value = "imagePath", required = true) String imagePath) throws IOException {
		long result;

		result = wishListService.saveWishList(userId, productId, productName, productDescription, productPrice,
				imagePath);

		WishListId wishListId = new WishListId();
		wishListId.setId(result);
		
		Response<WishListId> response = new Response<WishListId>();
		
		response.setSuccess(true);
		response.setData(wishListId);
		
		return response;
	}

	@RequestMapping(value = "/clearUserWishList", method = RequestMethod.POST)
	@ResponseBody
	public boolean clearUserWishList(@RequestParam(value = "userId", required = true) long userId) throws IOException {
		boolean result;

		result = wishListService.clearUserWishList(userId);

		return result;
	}

	@RequestMapping(value = "/removeFromWishList", method = RequestMethod.POST)
	@ResponseBody
	public boolean removeFromWishList(@RequestParam(value = "wishListId", required = true) long wishListId)
			throws IOException {

		boolean result;

		result = wishListService.removeFromWishList(wishListId);

		return result;
	}

	@RequestMapping(value = "/loadUserWishList", method = RequestMethod.POST)
	@ResponseBody
	public Response<ModelWrapper<WishList>> loadUserWishList(
			@RequestParam(value = "userId", required = true) long userId) throws IOException {

		Response<ModelWrapper<WishList>> response = new Response<ModelWrapper<WishList>>();

		response = wishListService.loadUserWishList(userId);

		return response;
	}

}
