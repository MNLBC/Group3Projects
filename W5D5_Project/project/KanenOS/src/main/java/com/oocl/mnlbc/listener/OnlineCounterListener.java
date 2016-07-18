/**
 * 
 */
package com.oocl.mnlbc.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;

import com.oocl.mnlbc.Controllers.UserController;

/**
 * @author ITAGroup3
 *
 */
//@WebListener
public class OnlineCounterListener implements HttpSessionListener {

	public static List<String> onlineUsers = new ArrayList<String>();
	public static String session_cnt = "session-counter";
	private static final Logger logger = Logger.getLogger(UserController.class);
/**
 * When the user opens the page the session start
 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session Created");
		HttpSession session = event.getSession();
		onlineUsers.add(session.getId());
		session.setAttribute(OnlineCounterListener.session_cnt, this);
	//	logger.info("Session Created for " + event.getSession());
		logger.info("Number of Page Viewers: " + onlineUsers.size());
	}

	/**
	 * when the user session ends
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session Destroyed");
		HttpSession session = event.getSession();
		onlineUsers.remove(session.getId());
		session.setAttribute(OnlineCounterListener.session_cnt, this);
	}

//	public int getOnlineUsers() {
//		return onlineUsers.size();
//	}
}