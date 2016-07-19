package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity(name="ORDER_INVOICE")
public class Invoice implements Serializable{

	@Id
	@Column(name="INVOICE_ID",nullable=false)
	@GeneratedValue(generator="ORDER_INVOICE_SEQ")
	@SequenceGenerator(name="ORDER_INVOICE_SEQ", sequenceName="ORDER_INVOICE_SEQ", allocationSize=1)
	private long invoiceId;
	
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name = "AMOUNT_DUE", precision = 2)
    private double amountDue;
    
    @Column(name = "DATE_RAISED")  
    private Timestamp orderRaisedDt;

    @Column(name = "DATE_SETTLED")  
    private Timestamp orderSettledDt;
    
    @Column(name = "DATE_CANCELLED")  
    private Timestamp orderCancelledDt;
    
    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Timestamp updatedTime;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "ORDER_ID", insertable=false, updatable=false) 
    private Order order;

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public Timestamp getOrderRaisedDt() {
		return orderRaisedDt;
	}

	public void setOrderRaisedDt(Timestamp orderRaisedDt) {
		this.orderRaisedDt = orderRaisedDt;
	}

	public Timestamp getOrderSettledDt() {
		return orderSettledDt;
	}

	public void setOrderSettledDt(Timestamp orderSettledDt) {
		this.orderSettledDt = orderSettledDt;
	}

	public Timestamp getOrderCancelledDt() {
		return orderCancelledDt;
	}

	public void setOrderCancelledDt(Timestamp orderCancelledDt) {
		this.orderCancelledDt = orderCancelledDt;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}       
    
    
}
