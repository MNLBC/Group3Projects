package com.oocl.mnlbc.group3.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.oocl.mnlbc.group3.dao.UserDAO;
import com.oocl.mnlbc.group3.dao.UserDAOImpl;
import com.oocl.mnlbc.group3.model.UserBean;

/**
 * Servlet Filter for blacklisting users
 */
@WebFilter("/BannedUsersFilter")
public class BannedUsersFilter implements Filter {

    List<UserBean> bannedUserList;
    private static UserDAO userDAO = UserDAOImpl.getInstance();
    
    public BannedUsersFilter() {
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String username = httpRequest.getParameter("username");
		boolean isUserBanned = false;
		
		for(UserBean user : bannedUserList){
			if(user.getUserName().equals(username)){
				isUserBanned = true;
			}
		}
		
		if(isUserBanned){
			
		}else{
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		bannedUserList = userDAO.getBannedUsers();
	}

}
