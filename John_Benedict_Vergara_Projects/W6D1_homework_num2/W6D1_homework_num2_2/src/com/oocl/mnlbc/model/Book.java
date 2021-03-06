package com.oocl.mnlbc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Product")
@Table(name = "Product")
public class Book implements java.io.Serializable {

	@Id
	@Column(name = "PROD_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORY_SEQUENCE")
	private long prod_id;
	@Column(name = "PROD_NAME")
	private String prodName;

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getName() {
		return prodName;
	}

	public void setName(String name) {
		this.prodName = prodName;
	}

}
