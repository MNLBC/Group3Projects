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

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.model.UserRequest;
import com.oocl.mnlbc.model.UserRequestList;
import com.oocl.mnlbc.services.MembershipTypeService;
import com.oocl.mnlbc.services.UserMembershipAsnService;
import com.oocl.mnlbc.services.UserService;

/**
 * @author Melvin Yu
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/userRequest", method = RequestMethod.POST)
	@ResponseBody
	public UserRequestList getAllUserRequest() {

		UserMembershipAsnService memberService = new UserMembershipAsnService();
		memberService.init();
		MembershipTypeService typeService = new MembershipTypeService();
		typeService.init();
		List<UserMembershipAsn> asnList = memberService.allMembershipRequest();
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
					typeService.getNameById(asn.getMembershipTypeId()),
					typeService.getNameById(asn.getRequestMembershipTypeId()), approval, approved);
			requestList.add(request);
		}
		response.setUserRequest(requestList);

		return response;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public User loginAdmin(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword){
		UserService userService =  new UserService();
		userService.init();
		User user=userService.validateUser(userName, userPassword);
		
		if(user!=null){
			return user;
		}
		return null;
	}

}
