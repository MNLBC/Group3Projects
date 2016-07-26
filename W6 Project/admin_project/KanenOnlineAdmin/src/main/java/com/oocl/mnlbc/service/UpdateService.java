/**
 * 
 */
package com.oocl.mnlbc.service;

import com.oocl.mnlbc.daoimpl.MembershipTypeDAOImpl;
import com.oocl.mnlbc.daoimpl.OrderDAOImpl;
import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;

/**
 * @author Melvin Yu
 * @author VERGAJO
 */
public class UpdateService {

	
	public UserMembershipAsn setApproval(String userId, String approvedType, String isApproved){

		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();
		MembershipTypeDAOImpl memberService = new MembershipTypeDAOImpl();
		memberService.init();
		UserMembershipAsnDAOImpl userMemberAsnService = new UserMembershipAsnDAOImpl();
		userMemberAsnService.init();

		User user = userDAO.findById(Long.parseLong(userId));
		System.out.println(user);
		UserMembershipAsn memAsn = userMemberAsnService.findMembership(user);
		/*
		 * Default of isApproved is 0 -> 1 is Approved -> 2 is Disapproved
		 * Default of forApproval is 0 not to be displayed in Admin Ui -> 1 is a pending request to be displayed in the UI
		 * 
		 */
		if (user != null) {
			if (isApproved.equals("1")) {// if the value from the request param isApprove is 1 it will approve the user request.
				memAsn.setForApproval(0);
				memAsn.setRequestMembershipTypeId(0);//once approved the requested type will be back to 0 
				memAsn.setMembershipTypeId(memberService.getIdByTypeName(approvedType));//and the current will be the requested type.
				memAsn.setRequestApproved(1);
			} else {
				memAsn.setForApproval(0);
				memAsn.setRequestApproved(2);
			}
			return memAsn = userMemberAsnService.updateMembership(memAsn);
		}
		return null;


		
	}
	
	public StringBuilder updateOrderStatus(String orderId, String status){
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

		return builder;

		
	}
}
