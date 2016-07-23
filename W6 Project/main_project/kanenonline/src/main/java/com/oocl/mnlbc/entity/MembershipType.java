package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * MembershipType Model Class
 * @author BRIONSE
 *
 */
@Entity(name = "MembershipType")
@Table(name = "MEMBERSHIP_TYPE")
public class MembershipType {

	@Id
	@Column(name = "MEMBERSHIP_TYPE_ID")
	@GeneratedValue(generator = "MEMBERSHIP_TYPE_ID_SEQ")
	@SequenceGenerator(name = "MEMBERSHIP_TYPE_ID_SEQ", sequenceName = "MEMBERSHIP_TYPE_ID_SEQ", allocationSize = 111)
	private long membershipTypeId;

	@Column(name = "MEMBERSHIP_TYPE_NAME")
	private String membershipTypeName;

	@Column(name = "DISCOUNT_RATE")
	private int discountRate;

	/**
	 * @return the membershipTypeId
	 */
	public long getMembershipTypeId() {
		return membershipTypeId;
	}

	/**
	 * @param membershipTypeId
	 *            the membershipTypeId to set
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
	 * @param membershipTypeName
	 *            the membershipTypeName to set
	 */
	public void setMembershipTypeName(String membershipTypeName) {
		this.membershipTypeName = membershipTypeName;
	}

	/**
	 * @return the discountRate
	 */
	public int getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate
	 *            the discountRate to set
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

}
