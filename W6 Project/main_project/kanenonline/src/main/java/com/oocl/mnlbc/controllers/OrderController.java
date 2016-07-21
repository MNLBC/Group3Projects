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
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.service.OrderService;

/**
 * 
 * @author ITAGroup3 This is the Order Controller where the request from the UI
 *         side
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderDAO;
	private static final Logger logger = Logger.getLogger(OrderController.class);

	/**
	 * getting the List of order of a certain user.
	 * 
	 * @param userId
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/userOrder", method = { RequestMethod.POST })
	@ResponseBody
	public String getOrderList(@RequestParam(value = "userId", required = true) String userId) throws Exception {
		String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
		logger.info("Retrieving orders for user " + userId + "..");
		List<OrderBean> order = orderDAO.getTransactions(Long.parseLong(userId));
		System.out.println(order);
		long orderId = 0;

		Gson gson = new Gson();
		for (OrderBean ord : order) {
			returnJson += gson.toJson(ord) + ",";
		}

		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "],";

		returnJson += "\"items\":[";
		for (OrderBean ord : order) {

			orderId = ord.getOrderId();
			List<CartItemBean> itemList = orderDAO.getItems(orderId);
			for (CartItemBean item : itemList) {
				returnJson += gson.toJson(item) + ",";

			}

		}
		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "]}}";
		// StringBuilder builder = new StringBuilder();
		// String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
		// builder.append(returnJson);
		logger.info("Orders of user " + userId + "is successfully retrieved");
		return returnJson;

	}

	/**
	 * Saving the order of a user
	 * 
	 * @param jsonData
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	@ResponseBody
	public String saveOrder(@RequestParam(value = "jsonData", required = true) String jsonData) throws IOException {

		Gson gson = new Gson();
		OrderBean order = gson.fromJson(jsonData, OrderBean.class);
		order.setOrderId(0);

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		if (orderDAO.createOrder(order)) {
			errorMsg += "none";
		} else {
			errorMsg += "failed";
		}

		builder.append(errorMsg);

		builder.append("\"}}");

		return builder.toString();

	}

}
