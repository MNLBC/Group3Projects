/**
 * 
 */
package com.oocl.mnlbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.model.AllUser;
import com.oocl.mnlbc.service.UpdateService;

/**
 * @author Melvin Yu
 * @author VERGAJO This Controller handles all the request for Updates from the
 *         UI
 */
@Controller
@RequestMapping("/update")
public class UpdateController {

	@Autowired
	UpdateService updateService;

	/**
	 * this request approves or disapproves the Membership Request
	 * 
	 * @param userId
	 * @param approvedType
	 * @param isApproved
	 * @return UserMembershipAsn
	 */

	@RequestMapping(value = "/membershipApproval", method = RequestMethod.POST)
	@ResponseBody
	public UserMembershipAsn setApproval(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "approvedType", required = true) String approvedType,
			@RequestParam(value = "isApproved", required = true) String isApproved) {

		UpdateService updateService = new UpdateService();

		UserMembershipAsn memAsn;

		memAsn = updateService.setApproval(userId, approvedType, isApproved);

		return memAsn;

	}

	/**
	 * This request updates the order status of a specific order.
	 * 
	 * @param orderId
	 * @param status
	 * @return String
	 */
	@RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST)
	@ResponseBody
	public String updateOrderStatus(@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "status", required = true) String status) {

		UpdateService updateService = new UpdateService();

		StringBuilder builder = new StringBuilder();
		builder = updateService.updateOrderStatus(orderId, status);

		return builder.toString();
	}

	/**
	 * This request updates the order status of a specific order.
	 * 
	 * @param orderId
	 * @param status
	 * @return String
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public AllUser updateUser(@RequestParam(value = "jsonData", required = true) String jsonData) {

		return updateService.updateUser(jsonData);
	}

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	@ResponseBody
	public String createUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "deliveryAddress", required = true) String deliveryAddress,
			@RequestParam(value = "mobileNumber", required = true) String mobileNumber,
			@RequestParam(value = "userRole", required = true) String userRole) throws Exception {

		String builder = updateService.createUser(userName, userPassword, fullName, email, deliveryAddress,
				mobileNumber, userRole);
		return builder;
	}

}
