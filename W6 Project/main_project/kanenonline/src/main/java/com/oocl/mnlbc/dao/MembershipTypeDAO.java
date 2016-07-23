package com.oocl.mnlbc.dao;

public interface MembershipTypeDAO {

	long getIdByTypeName(String typeName);

	String getMembershipTypeNameById(long typeId);
}
