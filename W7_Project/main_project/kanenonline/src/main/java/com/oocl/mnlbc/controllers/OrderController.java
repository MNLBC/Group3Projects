package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.constants.KanenOnlineConstants;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.model.OrdersAndItems;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.services.OrderService;

/**
 * 
 * @author VERGAJO
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	private static final Logger logger = Logger.getLogger(OrderController.class);

	/**
	 * Getting the List of orders of a certain user.
	 * 
	 * @param userId
	 * @return String
	 * @throws Exception
	 */

	// Retrieves the order of the currently logged in user.
	@RequestMapping(value = "/userOrder", method = { RequestMethod.POST })
	@ResponseBody
	public Response<OrdersAndItems> getOrderList(@RequestParam(value = "userId", required = true) String userId)
			throws Exception {

		Response<OrdersAndItems> response = new Response<OrdersAndItems>();

		response = orderService.getOrderList(userId);

		
		return response;
	}

	/**
	 * Saving the order of a user
	 * 
	 * @param jsonData
	 * @return String
	 * @throws IOException
	 */
	// Save the order of the user to the database.
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	@ResponseBody
	public String saveOrder(@RequestParam(value = "jsonData", required = true) String jsonData) throws IOException {

		String response;
		response = orderService.saveOrder(jsonData);

		return response;
	}

}
