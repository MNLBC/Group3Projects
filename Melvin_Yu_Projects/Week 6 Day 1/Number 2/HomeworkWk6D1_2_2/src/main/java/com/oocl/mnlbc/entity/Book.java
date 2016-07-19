package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "book")
@Table(name = "books")
public class Book implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "book_id")
    private Integer bookId;
	@Column(name = "book_name")
    private String bookName;
    @Column(name = "book_details")
    private String bookDetails;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "products", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Product> product = new ArrayList<Product>();
    
    public Book() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    public Integer getBookId() {
		return bookId;
	}



	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getBookDetails() {
		return bookDetails;
	}



	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}



	public List<Product> getProduct() {
		return product;
	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }    
    
    

}
