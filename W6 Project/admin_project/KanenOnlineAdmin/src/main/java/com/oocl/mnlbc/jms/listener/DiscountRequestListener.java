/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.services.UserService;

/**
 * @author Melvin Yu
 *
 */
public class DiscountRequestListener implements MessageListener {

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		UserService rs = new UserService();
		rs.init();
		EntityManager em = rs.getEntityManager();
		User userDb = rs.getById(em, 1000000197);
		System.out.println(userDb);
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
