/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.services.MembershipTypeService;
import com.oocl.mnlbc.services.UserMembershipAsnService;
import com.oocl.mnlbc.services.UserService;

/**
 * @author Melvin Yu
 *
 */
public class DiscountRequestListener implements MessageListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		UserService userService = new UserService();
		userService.init();
		MembershipTypeService memberService = new MembershipTypeService();
		memberService.init();
		UserMembershipAsnService userMemberAsnService = new UserMembershipAsnService();
		userMemberAsnService.init();
		
		System.out.println("MEMBER ID: "+memberService.getIdByTypeName("STUDENT"));
		
//		User user = userService.validateUser("brionse", "redhat");
		User user = userService.findById(1000000128);
		System.out.println(user);
		
		UserMembershipAsn memAsn = userMemberAsnService.findMembership(user);
		memAsn.setForApproval(1);
		memAsn.setRequestMembershipTypeId(memberService.getIdByTypeName("STUDENT"));
		memAsn = userMemberAsnService.updateMembership(memAsn);
		
		
//		for(User user : rs.getList()){
//			System.out.println(user);
//		}
//		
		List<UserMembershipAsn> listMembership = userMemberAsnService.allMembershipRequest();
		
		for(UserMembershipAsn mem: listMembership){
			System.out.println(mem);
		}
		
		try {
			if (message != null 
					&& message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
				System.out.println("Test");
				System.out.println(msg.getText());
			}
		} catch (JMSException e) {
			System.out.println("JMXException: " + e);
			e.printStackTrace();
		}
	}

}
