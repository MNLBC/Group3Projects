/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.oocl.mnlbc.constants.KanenOnlineConstants;
import com.oocl.mnlbc.daoimpl.MembershipTypeDAOImpl;
import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.model.LoggedInUser;

/**
 * @author Melvin Yu
 *
 *         This is the JMS Consumer Listener Class
 */
public class DiscountRequestListener implements MessageListener {
	private static int onlineUserCount;
	private static Map<String, LoggedInUser> onlineUsers = new HashMap<String, LoggedInUser>();
	
	

	/**
	 * @return the onlineUsers
	 */
	public static Map<String, LoggedInUser> getOnlineUsers() {
		return onlineUsers;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	/**
	 * this method listens to to the ActiveMQ for any Pending message for the
	 * queue KanenOSQueue also updates the membership request from the producer
	 * side in the main project
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
				if (request.indexOf(',') > -1) {
					String[] splittedStr = request.split(",");

					User user = userDAO.findById(Long.parseLong(splittedStr[0]));
					System.out.println("Request recieved from queue. User: " + user.getFullName()+" Request is upgrade to: "+splittedStr[1]);

					UserMembershipAsn memAsn = userMemberAsnDAO.findMembership(user);
					memAsn.setForApproval(1);
					memAsn.setRequestApproved(0);
					memAsn.setRequestMembershipTypeId(memberDAO.getIdByTypeName(splittedStr[1]));
					memAsn = userMemberAsnDAO.updateMembership(memAsn);
				} else {
					if (request.contains(KanenOnlineConstants.USER_LOGGED_IN)) {
						System.out.println(request);
						String userId = request.split("-")[1];

						System.out.println(userId);
						String userName = request.split("-")[2];
						System.out.println(userName);

						onlineUsers.put(userId, new LoggedInUser(userId, userName));

						onlineUserCount++;

						for (LoggedInUser user : onlineUsers.values()) {
							System.out.println(user.getUserId() + ":" + user.getUserName());
						}
					}
					if (request.contains(KanenOnlineConstants.USER_LOGGED_OUT)) {
						String userId = request.split("-")[1];
						if (onlineUsers.get(userId) != null) {
							onlineUsers.remove(userId);
						}
						onlineUserCount--;

						for (LoggedInUser user : onlineUsers.values()) {
							System.out.println(user.getUserId() + ":" + user.getUserName());
						}

					}
					System.out.println(onlineUserCount);
				}
			}
		} catch (JMSException e) {
			System.out.println("JMXException: " + e);
			e.printStackTrace();
		}
	}

}
