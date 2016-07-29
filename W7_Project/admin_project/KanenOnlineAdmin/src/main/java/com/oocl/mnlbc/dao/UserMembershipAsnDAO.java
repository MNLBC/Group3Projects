/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;

/**
 * @author Melvin Yu
 *
 */
public interface UserMembershipAsnDAO {
	
	  public UserMembershipAsn updateMembership(UserMembershipAsn asn);
	  public UserMembershipAsn findMembership(User userId);
	  public List<UserMembershipAsn> allMembershipRequest();

}
