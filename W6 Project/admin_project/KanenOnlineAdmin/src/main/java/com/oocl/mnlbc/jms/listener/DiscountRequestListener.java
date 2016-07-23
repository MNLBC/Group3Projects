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
		System.out.println("aaaa");

		try {
			if (message != null && message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;

				String request = msg.getText();
				String[] splittedStr = request.split(",");
				System.out.println(request + "    " + splittedStr[0]);

				User user = userService.findById(Long.parseLong(splittedStr[0]));
				System.out.println(user);

				UserMembershipAsn memAsn = userMemberAsnService.findMembership(user);
				memAsn.setForApproval(1);
				memAsn.setRequestMembershipTypeId(memberService.getIdByTypeName(splittedStr[1]));
				memAsn = userMemberAsnService.updateMembership(memAsn);

			}
		} catch (JMSException e) {
			System.out.println("JMXException: " + e);
			e.printStackTrace();
		}
	}

}
