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

	public long getProductCommentAssnId() {
		return productCommentAssnId;
	}

	public void setProductCommentAssnId(long productCommentAssnId) {
		this.productCommentAssnId = productCommentAssnId;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (productCommentAssnId ^ (productCommentAssnId >>> 32));
		return result;
	}

	/* (non-Javadoc)
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
		if (productCommentAssnId != other.productCommentAssnId)
			return false;
		return true;
	}

	

}
