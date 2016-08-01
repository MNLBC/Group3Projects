package com.oocl.mnlbc.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.MembershipType;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.services.MembershipTypeService;

/**
 * MembershipType Controller
 * 
 * @author FLOREJE
 *
 */
@Controller
@RequestMapping("/membership")
public class MembershipTypeController {

	@Autowired
	MembershipTypeService membershipTypeService;

	/**
	 * Retrieves the user membership types
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getMembershipTypes", method = { RequestMethod.POST })
	@ResponseBody
	public Response<ModelWrapper<MembershipType>> getMembershipTypes() throws IOException {
		
		Response<ModelWrapper<MembershipType>> response = new Response<ModelWrapper<MembershipType>>();
		
		response = membershipTypeService.getMembershipTypes();
		
			return response;
	};

	/**
	 * Receives a new membership type request and sends a message of the request
	 * to the admin server for approval.
	 * 
	 * @param userId
	 * @param requestedMembershipTypeName
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/newMembershipTypeRequest", method = { RequestMethod.POST })
	@ResponseBody
	public Response<String> newMembershipTypRequest(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "requestedMembershipTypeName", required = true) String requestedMembershipTypeName)
			throws IOException {
		
		Response<String> response = new Response<String>();
		
		response = membershipTypeService.newMembershipTypRequest(userId, requestedMembershipTypeName);

		return response;
	};

}
