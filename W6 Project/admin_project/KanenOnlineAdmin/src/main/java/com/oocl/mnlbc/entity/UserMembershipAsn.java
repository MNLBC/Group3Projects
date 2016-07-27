/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Melvin Yu
 *
 * This is the Entitiy of the User_MEMBERSHIP_ASSN table
 */
@Entity(name = "userMemAssn")
@Table(name = "USER_MEMBERSHIP_ASSN")
public class UserMembershipAsn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_MEMBERSHIP_ID")
	@SequenceGenerator(name = "USER_MEMBERSHIP_ASSN_ID_SEQ", sequenceName = "USER_MEMBERSHIP_ASSN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "USER_MEMBERSHIP_ASSN_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long userMembershipId;
	@Column(name="MEMBERSHIP_TYPE_ID")
	private long membershipTypeId;
	@Column(name="REQUESTED_MEMBERSHIP_TYPE_ID")
	private long requestMembershipTypeId;
	@Column(name="IS_FOR_APPROVAL")
	private Integer forApproval;
	@Column(name="IS_REQUEST_APPROVED")
	private Integer requestApproved;
	@JsonIgnore
	@OneToOne(optional=false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User userId;
	
	
	
	/**
	 * 
	 */
	public UserMembershipAsn() {
		// TODO Auto-generated constructor stub
	}

	


	/**
	 * @param userMembershipId
	 * @param membershipTypeId
	 * @param requestMembershipTypeId
	 * @param forApproval
	 * @param requestApproved
	 * @param userId
	 */
	public UserMembershipAsn(long userMembershipId, long membershipTypeId, long requestMembershipTypeId,
			Integer forApproval, Integer requestApproved) {
		super();
		this.userMembershipId = userMembershipId;
		this.membershipTypeId = membershipTypeId;
		this.requestMembershipTypeId = requestMembershipTypeId;
		this.forApproval = forApproval;
		this.requestApproved = requestApproved;
	}




	/**
	 * @return the userMembershipId
	 */
	public long getUserMembershipId() {
		return userMembershipId;
	}




	/**
	 * @param userMembershipId the userMembershipId to set
	 */
	public void setUserMembershipId(long userMembershipId) {
		this.userMembershipId = userMembershipId;
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
	 * @return the requestMembershipTypeId
	 */
	public long getRequestMembershipTypeId() {
		return requestMembershipTypeId;
	}




	/**
	 * @param requestMembershipTypeId the requestMembershipTypeId to set
	 */
	public void setRequestMembershipTypeId(long requestMembershipTypeId) {
		this.requestMembershipTypeId = requestMembershipTypeId;
	}




	/**
	 * @return the forApproval
	 */
	public Integer getForApproval() {
		return forApproval;
	}




	/**
	 * @param forApproval the forApproval to set
	 */
	public void setForApproval(Integer forApproval) {
		this.forApproval = forApproval;
	}




	/**
	 * @return the requestApproved
	 */
	public Integer getRequestApproved() {
		return requestApproved;
	}




	/**
	 * @param requestApproved the requestApproved to set
	 */
	public void setRequestApproved(Integer requestApproved) {
		this.requestApproved = requestApproved;
	}




	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserMembershipAsn [userMembershipId=" + userMembershipId + ", membershipTypeId=" + membershipTypeId
				+ ", requestMembershipTypeId=" + requestMembershipTypeId + ", forApproval=" + forApproval
				+ ", requestApproved=" + requestApproved + "]";
	}
	
	
	
	

}
