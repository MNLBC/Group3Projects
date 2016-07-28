/**
 * 
 */
package com.oocl.mnlbc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.services.UserService;

/**
 * @author CUNTAAL
 *
 */
public class BannedUsersInterceptors implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(BannedUsersInterceptors.class);
	@Autowired
	private UserService userService;

	/**
	 * @param args
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		List<User> bannedUserList = userService.getBannedUsers();
		bannedUserList.addAll(bannedUserList);

		String returnJson = "";
		StringBuilder builder = new StringBuilder();
		String username = request.getParameter("userName");
		boolean isUserBanned = false;

		for (User user : bannedUserList) {
			if (user.getUsername().equals(username)) {
				isUserBanned = true;
			}
		}

		if (isUserBanned) {
			returnJson = "{\"success\":true,\"data\":{\"banned\":true}}";
			builder.append(returnJson);
			logger.info(username + " is banned.");
			response.getWriter().write(builder.toString());
			return false;

		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}