/**
 * 
 */
package com.oocl.mnlbc.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.controllers.OrderController;
import com.oocl.mnlbc.dao.WishListDAO;
import com.oocl.mnlbc.entity.WishList;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author VERGAJO
 *
 */
public class WishListService {

	@Autowired
	WishListDAO wishListDAO;

	private static final Logger logger = Logger.getLogger(OrderController.class);

	public String saveCart(WishList wishList) {
		logger.info("Saving cart to database");
		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		// cartDAO.savecart accepts the parameter cartItemList to save to the
		// Database
		if (wishListDAO.saveUserWishList(wishList)) {
			logger.info("WishList successfully saved to the database.");
			errorMsg += "none";
		} else {
			logger.info("WishList failed to save to database.");
			errorMsg += "failed";
		}

		builder.append(errorMsg);
		builder.append("\"}}");

		return builder.toString();

	}

	public boolean removeFromWishList(long wishListId) {

		boolean result = false;
		if (wishListId > 0) {
			// removeUserCart accepts the parameter userId from the request to
			result = wishListDAO.removeFromWishList(wishListId);
		}
		return result;
	}

	public boolean clearUserWishList(long wishListId) {

		boolean result = false;
		if (wishListId > 0) {
			// removeUserCart accepts the parameter userId from the request to
			result = wishListDAO.clearUserWishList(wishListId);
		}
		return result;
	}

	public Response<ModelWrapper<WishList>> loadUserWishList(long userId) {

		Response<ModelWrapper<WishList>> response = new Response<ModelWrapper<WishList>>();

		List<WishList> result = wishListDAO.loadUserWishList(userId);

		ModelWrapper<WishList> wishListWrapper = new ModelWrapper<WishList>();

		wishListWrapper.setItems(result);

		if (CollectionUtils.isNotEmptyList(result)) {

			response.setSuccess(true);
			response.setData(wishListWrapper);

			logger.info("Cart items of user " + userId + "is successfully retrieved.");
		} else {

			response.setSuccess(true);
			response.setData(wishListWrapper);

			logger.info("No previous cart for user " + userId);
		}

		return response;

	}

}
