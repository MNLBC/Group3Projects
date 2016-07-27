/**
 * 
 */
package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author FLOREJE
 *
 */
@Entity(name = "prodComAsn")
@Table(name = "PRODUCT_COMMENT_ASSN")
public class ProductCommentAssn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_COMMENT_ASSN_ID")
	@SequenceGenerator(name = "PRODUCT_COMMENT_ASSN_ID_SEQ", sequenceName = "PRODUCT_COMMENT_ASSN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PRODUCT_COMMENT_ASSN_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long productCommentAssnId;

	@Column(name = "PRODUCT_COMMENT")
	private String productComment;

	@Column(name = "PRODUCT_ID")
	private long productId;

	@JsonIgnore
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User userId;

	public ProductCommentAssn() {

	}

	/**
	 * @param productCommentAssnId
	 * @param productComment
	 * @param productId
	 * @param userId
	 * 
	 */

	public ProductCommentAssn(long productCommentAssnId, String productComment, long productId, User userId) {
		super();
		this.productCommentAssnId = productCommentAssnId;
		this.productComment = productComment;
		this.productId = productId;
		this.userId = userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCommentAssn other = (ProductCommentAssn) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/**
	 * @return the productCommentAssnId
	 */
	public long getproductCommentAssnId() {
		return productCommentAssnId;
	}

	/**
	 * @param productCommentAssnId
	 *            the productCommentAssnId to set
	 */
	public void setproductCommentAssnId(long productCommentAssnId) {
		this.productCommentAssnId = productCommentAssnId;
	}

	/**
	 * @return the productComment
	 */
	public String getProductComment() {
		return productComment;
	}

	/**
	 * @param productComment
	 *            the productComment to set
	 */
	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

}
