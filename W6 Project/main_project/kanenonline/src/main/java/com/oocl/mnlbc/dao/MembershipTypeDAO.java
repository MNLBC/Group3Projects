package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.MembershipType;

public interface MembershipTypeDAO {

	long getIdByTypeName(String typeName);

	String getMembershipTypeNameById(long typeId);
	
	List<MembershipType> getMembershipTypes(); 
}
