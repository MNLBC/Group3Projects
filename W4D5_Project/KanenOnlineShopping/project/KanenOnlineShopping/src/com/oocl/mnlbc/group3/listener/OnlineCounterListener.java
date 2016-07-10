package com.oocl.mnlbc.group3.listener;


import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineCounterListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		Integer counter = (Integer) context.getAttribute("counter");
		if (counter == null)
			counter = new Integer(1);
		else
			counter = new Integer(counter + 1);

		context.setAttribute("counter", counter);

		session.setMaxInactiveInterval(60);

		System.out.println("A new session is created.");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		Integer counter = (Integer) context.getAttribute("counter");
		if (counter == null)
			counter = new Integer(1);
		else
			counter = new Integer(counter + 1);

		context.setAttribute("counter", counter);

		session.setMaxInactiveInterval(1000);

		System.out.println("A new session is created.");
	}

}