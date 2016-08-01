/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 */
public interface MembershipTypeDAO {
	
	  public long getIdByTypeName(String typeName);

}
