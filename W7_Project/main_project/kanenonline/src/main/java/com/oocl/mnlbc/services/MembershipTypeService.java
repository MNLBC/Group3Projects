/**
 * 
 */
package com.oocl.mnlbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.dao.MembershipTypeDAO;
import com.oocl.mnlbc.entity.MembershipType;
import com.oocl.mnlbc.jms.MembershipRequestJMSProducer;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author FLOREJE
 *
 */
public class MembershipTypeService {

	@Autowired
	private MembershipTypeDAO membershipTypeDAO;

	@Autowired
	private MembershipRequestJMSProducer membershipRequestProducer;
	
	public Response<ModelWrapper<MembershipType>> getMembershipTypes(){
		
		Response<ModelWrapper<MembershipType>> response = new Response<ModelWrapper<MembershipType>>();
		List<MembershipType> membershipTypes = membershipTypeDAO.getMembershipTypes();

		ModelWrapper<MembershipType> wrapper = new ModelWrapper<MembershipType>();
		wrapper.setItems(membershipTypes);
		response.setData(wrapper);

		if (CollectionUtils.isNotEmptyList(membershipTypes)) {
			response.setSuccess(true);
		}
		return response;

	}
	
	public  Response<String> newMembershipTypRequest( String userId, String requestedMembershipTypeName){
		
		Response<String> response = new Response<String>();

		if (userId != null && requestedMembershipTypeName != null) {
			membershipRequestProducer.sendMessage(userId + "," + requestedMembershipTypeName);
			response.setSuccess(true);
		}

		response.setData("Request sent!");

		return response;

	}
}
