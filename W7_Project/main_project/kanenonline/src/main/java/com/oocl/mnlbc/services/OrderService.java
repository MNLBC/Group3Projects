/**
 * 
 */
package com.oocl.mnlbc.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.oocl.mnlbc.constants.KanenOnlineConstants;
import com.oocl.mnlbc.controllers.OrderController;
import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.OrdersAndItems;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author VERGAJO
 *
 */
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private CartDAO cartDAO;

	private static final Logger logger = Logger.getLogger(OrderController.class);

	public Response<OrdersAndItems> getOrderList(String userId) {

		logger.info("Retrieving orders for user " + userId + "..");
		List<Order> orders = orderDAO.getTransactions(Long.parseLong(userId));
		// uses Response model so that the jsondata will have the "success" and
		// "data" value set
		Response<OrdersAndItems> response = new Response<OrdersAndItems>();

		if (orders != null) {

			OrdersAndItems ordersAndItems = new OrdersAndItems();
			ordersAndItems.setOrders(orders);
			List<CartItemBean> allOrderItems = new ArrayList<CartItemBean>();

			long orderId = 0;
			for (Order order : orders) {
				orderId = order.getOrderId();

				allOrderItems.addAll(orderDAO.getItems(orderId));

			}

			ordersAndItems.setItems(allOrderItems);
			if (CollectionUtils.isNotEmptyList(orders)) {
				response.setSuccess(true);
				response.setData(ordersAndItems);
				logger.info("Orders of user " + userId + "is successfully retrieved.");
			} else {
				response.setSuccess(false);
				response.setData(null);
				logger.info("Retrieval of user " + userId + " orders failed.");
			}
		}
		return response;

	}

	public String saveOrder(String jsonData) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		Date date = new Date();
		Gson gson = new Gson();
		Order order = gson.fromJson(jsonData, Order.class);
		order.setOrderDate(dateFormat.format(date));
		order.setOrderStatus(KanenOnlineConstants.DEFAULT_DELIVERY_STATUS);
		order.setOrderId(0);

		List<OrderItem> orderItems = order.getItems();

		order.setItems(null);

		long userId = order.getUserId();

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		if (orderDAO.createOrder(order, orderItems)) {
			cartDAO.removeUserCart(userId);
			errorMsg += "none";
		} else {

			errorMsg += "failed";
		}

		builder.append(errorMsg);

		builder.append("\"}}");

		return builder.toString();

	}

}
