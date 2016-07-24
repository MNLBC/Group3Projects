/**
 * 
 */
package com.oocl.mnlb.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.jms.MembershipRequestJMSProducer;

/**
 * @author BRIONSE
 *
 */
public class MembershipRequestJMSTest {

	private ApplicationContext applicationContext = null;

	@Before
	public void setup() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("WebContent/WEB-INF/jms-context.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSendMessage() {
		MembershipRequestJMSProducer jmsProducer = (MembershipRequestJMSProducer) applicationContext
				.getBean("membershipRequestJMSProducer");
		jmsProducer.sendMessage("1000000187,STUDENT");

	}
}
