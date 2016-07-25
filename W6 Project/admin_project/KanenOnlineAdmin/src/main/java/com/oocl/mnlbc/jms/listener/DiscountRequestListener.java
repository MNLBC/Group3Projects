/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.oocl.mnlbc.daoimpl.MembershipTypeDAOImpl;
import com.oocl.mnlbc.daoimpl.OrderDAOImpl;
import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;

/**
 * @author Melvin Yu
 *
 * This is the JMS Consumer Listener Class 
 */
public class DiscountRequestListener implements MessageListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	/**
	 * this method listens to to the ActiveMQ for any Pending message for the queue KanenOSQueue
	 * also updates the membership request from the producer side in the main project
	 */
	public void onMessage(Message message) {
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();
		MembershipTypeDAOImpl memberDAO = new MembershipTypeDAOImpl();
		memberDAO.init();
		UserMembershipAsnDAOImpl userMemberAsnDAO = new UserMembershipAsnDAOImpl();
		userMemberAsnDAO.init();
		try {
			if (message != null && message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;

				String request = msg.getText();
				String[] splittedStr = request.split(",");
				System.out.println(request + "    " + splittedStr[0]);

				User user = userDAO.findById(Long.parseLong(splittedStr[0]));
				System.out.println(user);

				UserMembershipAsn memAsn = userMemberAsnDAO.findMembership(user);
				memAsn.setForApproval(1);
				memAsn.setRequestApproved(0);
				memAsn.setRequestMembershipTypeId(memberDAO.getIdByTypeName(splittedStr[1]));
				memAsn = userMemberAsnDAO.updateMembership(memAsn);
				System.out.println(memAsn);

			}
		} catch (JMSException e) {
			System.out.println("JMXException: " + e);
			e.printStackTrace();
		}
	}

}
