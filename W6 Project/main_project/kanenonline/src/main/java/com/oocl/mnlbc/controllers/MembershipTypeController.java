package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.MembershipTypeDAO;
import com.oocl.mnlbc.entity.MembershipType;
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

	@RequestMapping(value = "/getMembershipTypes", method = { RequestMethod.GET })
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
}
