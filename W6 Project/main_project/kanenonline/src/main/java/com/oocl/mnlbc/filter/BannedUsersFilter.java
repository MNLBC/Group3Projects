/**
 * 
 */
package com.oocl.mnlbc.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * @author ITAGroup3
 *
 */

public class BannedUsersFilter implements Filter {

	List<String> bannedUserList;
	private static final Logger logger = Logger.getLogger(BannedUsersFilter.class);

	public BannedUsersFilter() {
		// TODO Auto-generated constructor stub

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Filters all banned user
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		bannedUserList = new ArrayList<String>();
		bannedUserList.add("jscott");
		bannedUserList.add("randy");
		bannedUserList.add("yume");

		String returnJson = "";
		StringBuilder builder = new StringBuilder();
		String username = request.getParameter("userName");
		boolean isUserBanned = false;

		for (String user : bannedUserList) {
			if (user.equals(username)) {
				isUserBanned = true;
			}
		}

		if (isUserBanned) {
			returnJson = "{\"success\":true,\"data\":{\"banned\":true}}";
			builder.append(returnJson);
			logger.info(username + " is banned.");
			response.getWriter().write(builder.toString());

		} else {

			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// bannedUserList = userDAO.getBannedUsers();
	}
}
