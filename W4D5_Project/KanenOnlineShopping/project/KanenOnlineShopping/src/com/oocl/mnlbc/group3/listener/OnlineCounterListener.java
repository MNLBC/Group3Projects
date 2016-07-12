package com.oocl.mnlbc.group3.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author kanench 
 * A listener class that lists the number of active sessions
 */

@WebListener
public class OnlineCounterListener implements HttpSessionListener {

	public static List<String> onlineUsers = new ArrayList<>();
	public static String session_cnt = "session-counter";

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Session Created");
		HttpSession session = event.getSession();
		onlineUsers.add(session.getId());
		session.setAttribute(OnlineCounterListener.session_cnt, this);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Session Destroyed");
		HttpSession session = event.getSession();
		onlineUsers.remove(session.getId());
		session.setAttribute(OnlineCounterListener.session_cnt, this);
	}

	public int getOnlineUsers() {
		return onlineUsers.size();
	}
}