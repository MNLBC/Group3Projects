package com.oocl.mnlbc.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderDAO;

	private static final Logger logger = Logger.getLogger(OrderController.class);

	@RequestMapping(value = "/userOrder", method = { RequestMethod.GET })
	@ResponseBody
	public String getOrderList(@RequestParam(value = "userId", required = true) String userId) throws Exception {
		String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
		logger.info("Retrieving orders for user " + userId + "..");
		List<OrderBean> order = orderDAO.getTransactions(Long.parseLong(userId));

		long orderId = 0;

		Gson gson = new Gson();
		for (OrderBean ord : order) {
			returnJson += gson.toJson(ord) + ",";
			orderId = ord.getOrderId();
		}

		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "],";

		List<ItemsBean> itemList = orderDAO.getItems(orderId);
		returnJson += "\"items\":[";
		for (ItemsBean item : itemList) {
			returnJson += gson.toJson(item) + ",";
		}
		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "]}}";
		// StringBuilder builder = new StringBuilder();
		// String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
		// builder.append(returnJson);
		logger.info("Orders of user " + userId + "is successfully retrieved");
		return returnJson;

	}

	/*@RequestMapping(value = "/saveOrder", method = { RequestMethod.GET })

	@ResponseBody
	public String saveOrder2(

			@RequestParam(value = "userId", required = true) String userId,

			@RequestParam(value = "orderDate", required = true) String orderDate,

			@RequestParam(value = "totalCost", required = true) String totalCost,

			@RequestParam(value = "orderStatus", required = true) String orderStatus,

			@RequestParam(value = "productId", required = true) String productId,

			@RequestParam(value = "quantity", required = true) String quantity,

			@RequestParam(value = "productPrice", required = true) String productPrice) throws Exception {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		builder.append(returnJson);

		OrderBean cart = new OrderBean(0, Long.parseLong(userId), orderDate, Double.parseDouble(totalCost), orderStatus,
				null);
		List<CartItemBean> items = new ArrayList<CartItemBean>();
		items.add(new CartItemBean(Integer.parseInt(productId), "", "", Integer.parseInt(quantity),
				Double.parseDouble(productPrice), ""));
		cart.setItems(items);
		if (orderDAO.createOrder(cart)) {
			errorMsg += "none";
		} else {
			errorMsg += "failed";
		}

		builder.append(errorMsg);

		builder.append("\"}}");
		System.out.println(builder.toString());
		return builder.toString();

	}
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
		System.out.println(builder.toString());

		System.out.println(order.getUserId());
		System.out.println(order.getTotalCost());

		System.out.println(order.getItems().get(0).getProductName());

		return builder.toString();

	}

}
