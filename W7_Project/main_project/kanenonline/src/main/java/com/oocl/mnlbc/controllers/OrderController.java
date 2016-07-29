package com.oocl.mnlbc.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
