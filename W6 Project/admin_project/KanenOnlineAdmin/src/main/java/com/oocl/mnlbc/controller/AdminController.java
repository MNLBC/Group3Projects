/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.daoimpl.MembershipTypeDAOImpl;
import com.oocl.mnlbc.daoimpl.OrderDAOImpl;
import com.oocl.mnlbc.daoimpl.ProductDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.model.ItemOrder;
import com.oocl.mnlbc.model.Login;
import com.oocl.mnlbc.model.OrderAndItemList;
import com.oocl.mnlbc.model.OrderUser;
import com.oocl.mnlbc.model.UserRequest;
import com.oocl.mnlbc.model.UserRequestList;

/**
 * @author Melvin Yu
 *
 *This class holds the admin controller
 *it handles our ajax request for displaying user request, all orders and userlogin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
/**
 * maps the request for retrieving the user request
 * @return UserRequestList
 */
	@RequestMapping(value = "/userRequest", method = RequestMethod.POST)
	@ResponseBody
	public UserRequestList getAllUserRequest() {

		UserMembershipAsnDAOImpl memberDAO = new UserMembershipAsnDAOImpl();
		memberDAO.init();
		MembershipTypeDAOImpl typeDAO = new MembershipTypeDAOImpl();
		typeDAO.init();
		List<UserMembershipAsn> asnList = memberDAO.allMembershipRequest();
		List<UserRequest> requestList = new ArrayList<UserRequest>();

		UserRequestList response = new UserRequestList();
		for (UserMembershipAsn asn : asnList) {
			int approval = 0;
			int approved = 0;
			if (asn.getForApproval() != null) {
				approval = asn.getForApproval();
			}
			if (asn.getRequestApproved() != null) {
				approval = asn.getRequestApproved();
			}

			UserRequest request = new UserRequest(asn.getUserId().getFullName(), asn.getUserId().getUserId(),
					typeDAO.getNameById(asn.getMembershipTypeId()),
					typeDAO.getNameById(asn.getRequestMembershipTypeId()), approval, approved);
			requestList.add(request);
		}
		response.setUserRequest(requestList);

		return response;
	}
	
	/**
	 * This methods handles the ajax of the Admin Login
	 * @param userName
	 * @param userPassword
	 * @return Login
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Login loginAdmin(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword) {
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();
		User user = userDAO.validateUser(userName, userPassword);
		Login response = new Login();

		if (user != null) {
			response.setUser(user);
			response.setSuccess(true);
			return response;
		}
		return response;
	}

	/**
	 * this methods handles the retrieval of all orders to be displayed in the UI
	 * @return OrderAndItemList
	 */
	@RequestMapping(value = "/getOrders", method = RequestMethod.POST)
	@ResponseBody
	public OrderAndItemList getAllOrders() {

		OrderDAOImpl orderImpl = new OrderDAOImpl();
		orderImpl.init();
		ProductDAOImpl prodImpl = new ProductDAOImpl();
		prodImpl.init();

		OrderUser orderUser;
		ItemOrder itemOrder;
		List<OrderUser> ordUserList = new ArrayList<OrderUser>();
		List<ItemOrder> itemOrderList = new ArrayList<ItemOrder>();
		for (Order order : orderImpl.getAllTransactions()) {
			orderUser = new OrderUser();
			orderUser.setOrder(order);
			orderUser.setFullName(order.getUserId().getFullName());
			orderUser.setUserID(order.getUserId().getUserId());
			ordUserList.add(orderUser);
			System.out.println(orderUser);
		}
		for (OrderItem item : orderImpl.getAllItems()) {
			
			itemOrder = new ItemOrder();
			itemOrder.setItem(item);
			itemOrder.setOrderId(item.getOrderId().getOrderId());
			itemOrder.setProductname(prodImpl.getNameById(item.getProductId()));
			itemOrderList.add(itemOrder);
		}

		OrderAndItemList orderList = new OrderAndItemList();
		orderList.setOrderList(ordUserList);
		orderList.setItemList(itemOrderList);
		orderList.setSuccess(true);

		return orderList;

	}

}