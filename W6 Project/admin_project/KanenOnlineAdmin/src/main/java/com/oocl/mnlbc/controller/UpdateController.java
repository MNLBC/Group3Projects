/**
 * 
 */
package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.daoimpl.MembershipTypeDAOImpl;
import com.oocl.mnlbc.daoimpl.OrderDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;

/**
 * @author Melvin Yu
 *
 */
@Controller
@RequestMapping("/update")
public class UpdateController {

	@RequestMapping(value = "/membershipApproval", method = RequestMethod.POST)
	@ResponseBody
	public UserMembershipAsn setApproval(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "approvedType", required = true) String approvedType,
			@RequestParam(value = "isApproved", required = true) String isApproved) {

		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();
		MembershipTypeDAOImpl memberService = new MembershipTypeDAOImpl();
		memberService.init();
		UserMembershipAsnDAOImpl userMemberAsnService = new UserMembershipAsnDAOImpl();
		userMemberAsnService.init();

		User user = userDAO.findById(Long.parseLong(userId));
		System.out.println(user);
		UserMembershipAsn memAsn = userMemberAsnService.findMembership(user);

		if (user != null) {
			if (isApproved.equals("1")) {
				memAsn.setForApproval(0);
				memAsn.setRequestMembershipTypeId(0);
				memAsn.setMembershipTypeId(memberService.getIdByTypeName(approvedType));
				memAsn.setRequestApproved(1);
			} else {
				memAsn.setForApproval(0);
				memAsn.setRequestApproved(2);
			}
			return memAsn = userMemberAsnService.updateMembership(memAsn);
		}
		return null;

	}

	@RequestMapping(value = "/updateOrderStatus", method = RequestMethod.GET)
	@ResponseBody
	public String updateOrderStatus(@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "status", required = true) String status) {
		OrderDAOImpl orderDAO = new OrderDAOImpl();
		orderDAO.init();

		Order order= orderDAO.getOrderById(Long.parseLong(orderId));
		

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		if (order != null) {
			order.setOrderStatus(status);
			order = orderDAO.updateOrderStatus(order);
				errorMsg += "none";
			
		} else {
			errorMsg += "failed";
		}

		builder.append(errorMsg);

		builder.append("\"}}");

		return builder.toString();
	}

}
