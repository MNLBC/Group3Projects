package com.oocl.mnlbc.entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Entity(name = "PRODUCT")
public class Product implements Serializable{
	
	@Id
    @Column(name = "PROD_ID", nullable = false)
    @GeneratedValue(generator="PROD_SEQ")
	@SequenceGenerator(name="PROD_SEQ", sequenceName="PROD_SEQ", allocationSize=10)
    private long prodId;
	
	@Column(name = "PROD_NAME", nullable = false,length = 50)
    private String prodName;
    
    @Column(name = "PROD_DESC", length = 200)
    private String prodDescription;
    
    @Column(name = "REGULAR_PRICE", precision = 2)
    private String price;
    
    @Column(name = "LAST_UPDATED_TIME")
    private Timestamp updatedTime;
    
    @ManyToMany(mappedBy="productList", fetch=FetchType.EAGER)
    private List<Order> orderList;

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
    
}
