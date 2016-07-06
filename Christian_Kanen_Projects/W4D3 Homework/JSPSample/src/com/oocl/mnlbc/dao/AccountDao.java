/**
 * 
 */
package com.oocl.mnlbc.dao;

/**
 * @author kanench
 *
 */
public interface AccountDao {

	
	public boolean userExists(String uname);
	
	public boolean userRegister(String uname, String pword, String fname, String add, String cnt, String email);
}
