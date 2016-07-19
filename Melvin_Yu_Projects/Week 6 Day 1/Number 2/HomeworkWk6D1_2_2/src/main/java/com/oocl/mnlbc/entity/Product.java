package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "product")
@Table(name = "products")
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;
	@Column(name = "product_name")
    private String productName;
    @Column(name = "product_details")
    private String productDetails;

    
    public Product() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public Integer getProductId() {
		return productId;
	}



	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductDetails() {
		return productDetails;
	}



	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}





	@Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }
    
    
}
