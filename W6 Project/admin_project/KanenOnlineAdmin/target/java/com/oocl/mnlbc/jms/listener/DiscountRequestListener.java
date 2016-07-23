/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author MNLTT02
 *
 */
public class DiscountRequestListener implements MessageListener {

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
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
