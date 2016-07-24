package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.MembershipTypeDAO;
import com.oocl.mnlbc.entity.MembershipType;
import com.oocl.mnlbc.jms.MembershipRequestJMSProducer;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * MembershipType Controller
 * 
 * @author Sebastian Briones
 *
 */
@Controller
@RequestMapping("/membership")
public class MembershipTypeController {

	@Autowired
	private MembershipTypeDAO membershipTypeDAO;

	@Autowired
	private MembershipRequestJMSProducer membershipRequestProducer;

	@RequestMapping(value = "/getMembershipTypes", method = { RequestMethod.POST })
	@ResponseBody
	public Response<ModelWrapper<MembershipType>> getMembershipTypes() throws IOException {
		Response<ModelWrapper<MembershipType>> response = new Response<ModelWrapper<MembershipType>>();
		List<MembershipType> membershipTypes = membershipTypeDAO.getMembershipTypes();

		ModelWrapper<MembershipType> wrapper = new ModelWrapper<MembershipType>();
		wrapper.setItems(membershipTypes);
		response.setData(wrapper);

		if (CollectionUtils.isNotEmptyList(membershipTypes)) {
			response.setSuccess(true);
		}
		return response;

	};

	@RequestMapping(value = "/newMembershipTypeRequest", method = { RequestMethod.POST })
	@ResponseBody
	public Response<String> newMembershipTypRequest(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "requestedMembershipTypeName", required = true) String requestedMembershipTypeName)
			throws IOException {

		Response<String> response = new Response<String>();

		if (userId != null && requestedMembershipTypeName != null) {
			membershipRequestProducer.sendMessage(userId + "," + requestedMembershipTypeName);
			response.setSuccess(true);
		}
		
		response.setData("Request sent!");

		return response;

	};

}
