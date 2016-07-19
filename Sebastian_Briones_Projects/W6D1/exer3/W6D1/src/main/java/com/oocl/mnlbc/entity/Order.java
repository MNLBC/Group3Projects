package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Entity(name = "ORDERS")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORDER_ID", nullable = false)
	@GeneratedValue(generator = "ORDER_SEQ")
	@SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize = 111)
	private long orderId;

	@Column(name = "CUST_ID")
	private long custId;

	@Column(name = "TOTAL_PRICE", precision = 2)
	private double totPrice;

	@Column(name = "OREDER_DESC")
	private String orderDesc;

	@Column(name = "ORDER_DATE")
	private Timestamp orderDt;

	@OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "order", targetEntity = Invoice.class)
	private Invoice invoice;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID", insertable = false, updatable = false)
	private User customer;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ORDER_DETAIL", joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID"))
	private List<Product> productList;

	@Version
	@Column(name = "LAST_UPDATED_TIME")
	private Timestamp updatedTime;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Timestamp getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Timestamp orderDt) {
		this.orderDt = orderDt;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
