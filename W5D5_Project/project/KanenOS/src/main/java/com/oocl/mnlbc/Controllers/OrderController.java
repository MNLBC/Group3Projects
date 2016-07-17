package com.oocl.mnlbc.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderDAO;

	@RequestMapping(value = "/userOrder", method = { RequestMethod.POST })
	@ResponseBody
	public String getOrderList(@RequestParam(value = "userId", required = true) String userId) throws Exception {
		String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
		
		
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
//		StringBuilder builder = new StringBuilder();
//		String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
//		builder.append(returnJson);
		return returnJson;
		
	}
	
	

	/*@RequestMapping(value = "/saveOrder", method = { RequestMethod.GET })
	@ResponseBody
	public String saveOrder(
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
		
		OrderBean cart = new OrderBean(0, Long.parseLong(userId), orderDate, Double.parseDouble(totalCost), orderStatus, null);
		List<CartItemBean> items = new ArrayList<CartItemBean>();
		items.add(new CartItemBean(Integer.parseInt(productId), "", "", Integer.parseInt(quantity), Double.parseDouble(productPrice), ""));
		cart.setItems(items);
		orderDAO.createOrder(cart);
		
		errorMsg += "none";
		builder.append(errorMsg);
		
		builder.append("\"}}");
		System.out.println(builder.toString());
		return builder.toString();
		
	}*/
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    public OrderBean saveOrder(@RequestBody OrderBean order) throws IOException
    {
        System.out.println("User id : "+ order.getUserId());
        System.out.println("Total Cost: "+ order.getTotalCost());
        
        
        return order;
    }
	
}
