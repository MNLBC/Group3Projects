/**
 * 
 */
package com.oocl.mnlbc.hw1no2.ManytoMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author KANENCH
 *
 */
@Entity
@Table(name = "BOOK")
public class BookModel {

	@Column(name = "BOOK_ID")
	private Integer bookId;
	@Column(name = "BOOK_TITLE")
	private String bookTitle;
	@Column(name = "BOOK_AUTHOR")
	private String bookAuthor;
	@Column(name = "BOOK_CATEGORY")
	private String bookCategory;
	
	@ManyToMany(mappedBy="bookCategory")	
	private List<ProductModel> productCat;
	/**
	 * @param bookId
	 * @param bookTitle
	 * @param bookAuthor
	 * @param bookCategory
	 */
	public BookModel(Integer bookId, String bookTitle, String bookAuthor, String bookCategory) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
	}

	public BookModel() {

	}

	public BookModel(Integer bookId) {
		this.bookId=bookId;
	}

	/**
	 * @return the productCat
	 */
	public List<ProductModel> getProductCat() {
		return productCat;
	}

	/**
	 * @param productCat the productCat to set
	 */
	public void setProductCat(List<ProductModel> productCat) {
		this.productCat = productCat;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}

	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	/**
	 * @return the bookCategory
	 */
	public String getBookCategory() {
		return bookCategory;
	}

	/**
	 * @param bookCategory the bookCategory to set
	 */
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookCategory == null) ? 0 : bookCategory.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
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
		BookModel other = (BookModel) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookCategory == null) {
			if (other.bookCategory != null)
				return false;
		} else if (!bookCategory.equals(other.bookCategory))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		return true;
	}
	
	

}
