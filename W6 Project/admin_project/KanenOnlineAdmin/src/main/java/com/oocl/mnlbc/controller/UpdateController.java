/**
 * 
 */
package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.services.MembershipTypeService;
import com.oocl.mnlbc.services.UserMembershipAsnService;
import com.oocl.mnlbc.services.UserService;

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

		UserService userService = new UserService();
		userService.init();
		MembershipTypeService memberService = new MembershipTypeService();
		memberService.init();
		UserMembershipAsnService userMemberAsnService = new UserMembershipAsnService();
		userMemberAsnService.init();

		User user = userService.findById(Long.parseLong(userId));
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

}
