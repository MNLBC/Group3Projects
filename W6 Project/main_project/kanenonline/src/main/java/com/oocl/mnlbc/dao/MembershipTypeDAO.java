package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.MembershipType;
/**
 * 
 * @author BRIONSE
 *
 */
public interface MembershipTypeDAO {

	long getIdByTypeName(String typeName);

	String getMembershipTypeNameById(long typeId);
	
	List<MembershipType> getMembershipTypes(); 
}
