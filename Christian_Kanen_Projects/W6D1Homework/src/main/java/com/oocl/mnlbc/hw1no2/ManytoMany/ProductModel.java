/**
 * 
 */
package com.oocl.mnlbc.hw1no2.ManytoMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 * @author KANENCH
 *
 */
@Entity
@Table(name = "PRODUCT")
public class ProductModel {

	@Column(name = "PRODUCT_ID")
	private Integer productId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_CATEGORY")
	private String productCategory;

	@JoinTable(name = "BOOK", joinColumns = @JoinColumn(name = "PRODUC_CATEGORY", referencedColumnName = "BOOK_CATEGORY"), inverseJoinColumns = @JoinColumn(name = "BOOK_CATEGORY", referencedColumnName = "PRODUCT_CATEGORY"))
	private List<BookModel> bookList;

	/**
	 * @param productId
	 * @param productName
	 * @param productCategory
	 */
	public ProductModel(Integer productId, String productName, String productCategory) {
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
	}

	/**
	 * @param productId
	 */
	public ProductModel(Integer productId) {
		super();
		this.productId = productId;
	}

	/**
	 * 
	 */
	public ProductModel() {

	}

	/**
	 * @return the productId
	 */

	public Integer getProductId() {
		return productId;
	}

	/**
	 * @return the bookList
	 */
	public List<BookModel> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList
	 *            the bookList to set
	 */
	public void setBookList(List<BookModel> bookList) {
		this.bookList = bookList;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory
	 *            the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
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
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		ProductModel other = (ProductModel) obj;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

}
