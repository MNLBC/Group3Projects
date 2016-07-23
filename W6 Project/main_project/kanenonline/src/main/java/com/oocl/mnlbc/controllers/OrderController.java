package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.model.OrdersAndItems;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * 
 * @author ITAGroup3 This is the Order Controller where the request from the UI
 *         side
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderDAO orderDAO;
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
	public Response<OrdersAndItems> getOrderList(@RequestParam(value = "userId", required = true) String userId)
			throws Exception {
		logger.info("Retrieving orders for user " + userId + "..");
		List<Order> orders = orderDAO.getTransactions(Long.parseLong(userId));
		System.out.println("order 1 cost" + orders.get(0).getTotalCost());

		OrdersAndItems ordersAndItems = new OrdersAndItems();
		ordersAndItems.setOrders(orders);
		List<CartItemBean> allOrderItems = new ArrayList<CartItemBean>();

		long orderId = 0;
		for (Order order : orders) {
			orderId = order.getOrderId();
			List<CartItemBean> itemList = orderDAO.getItems(orderId);

			allOrderItems.addAll(orderDAO.getItems(orderId));

		}
		Response<OrdersAndItems> response = new Response<OrdersAndItems>();

		ordersAndItems.setItems(allOrderItems);
		if (CollectionUtils.isNotEmptyList(orders)) {
			response.setSuccess(true);
			response.setData(ordersAndItems);
			logger.info("Orders of user " + userId + "is successfully retrieved.");
		} else {

			logger.info("Retrieval of user " + userId + " orders failed.");
		}

		return response;
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
