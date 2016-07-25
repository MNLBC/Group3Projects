/**
 * 
 */
package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Melvin Yu
 *
 *	This is the Entitiy of the MEMBERSHIP_TYPE Table
 */
@Entity(name="memberType")
@Table(name="MEMBERSHIP_TYPE")
public class MembershipType {
	
	@Id
	@Column(name="MEMBERSHIP_TYPE_ID")
	private long membershipTypeId;
	@Column(name="MEMBERSHIP_TYPE_NAME")
	private String membershipTypeName;

	/**
	 * 
	 */
	public MembershipType() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param membershipTypeId
	 * @param membershipTypeName
	 */
	public MembershipType(long membershipTypeId, String membershipTypeName) {
		super();
		this.membershipTypeId = membershipTypeId;
		this.membershipTypeName = membershipTypeName;
	}
	/**
	 * @return the membershipTypeId
	 */
	public long getMembershipTypeId() {
		return membershipTypeId;
	}
	/**
	 * @param membershipTypeId the membershipTypeId to set
	 */
	public void setMembershipTypeId(long membershipTypeId) {
		this.membershipTypeId = membershipTypeId;
	}
	/**
	 * @return the membershipTypeName
	 */
	public String getMembershipTypeName() {
		return membershipTypeName;
	}
	/**
	 * @param membershipTypeName the membershipTypeName to set
	 */
	public void setMembershipTypeName(String membershipTypeName) {
		this.membershipTypeName = membershipTypeName;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MembershipType [membershipTypeId=" + membershipTypeId + ", membershipTypeName=" + membershipTypeName
				+ "]";
	}
	
	

}
