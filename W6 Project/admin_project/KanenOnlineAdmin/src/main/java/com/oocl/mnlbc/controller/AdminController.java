/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.model.UserRequest;
import com.oocl.mnlbc.model.UserRequestList;
import com.oocl.mnlbc.services.MembershipTypeService;
import com.oocl.mnlbc.services.UserMembershipAsnService;

/**
 * @author Melvin Yu
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/userRequest")
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

}
