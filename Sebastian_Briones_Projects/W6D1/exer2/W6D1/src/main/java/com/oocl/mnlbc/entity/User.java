package com.oocl.mnlbc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 * 
 * @author BRIONSE
 *
 */
@Entity(name = "User") 
@Table(name = "CUSTOMER") 
public class User implements Serializable{
		@Id //signifies the primary key
		@Column(name = "CUST_ID", nullable = false)
		@GeneratedValue(generator="CUSTOMER_SEQ")
		@SequenceGenerator(name="CUSTOMER_SEQ", sequenceName="CUSTOMER_SEQ", allocationSize=1)
		private long custId;
		
		@Column(name = "FIRST_NAME", length = 50)
		private String firstName;
		
		@Column(name = "LAST_NAME", nullable = false,length = 50)
		private String lastName;
		
		@Column(name = "STREET")
		private String street;
		
		@Column(name = "APPT")  
		private String appt;
		
		@Column(name = "CITY")  
		private String city;
		
		@Column(name = "ZIP_CODE",nullable = false)  
		private String zipCode;
		
		@Column(name = "EMAIL",nullable = false)  
		private String email;
		
		@Version
		@Column(name = "LAST_UPDATED_TIME")
		//@Temporal(TemporalType.TIMESTAMP)
		private Timestamp updatedTime;

		@OneToMany(mappedBy="customer" , targetEntity=Order.class)
		private Collection orders;
		
		public String toString() {
	       StringBuffer sb = new StringBuffer();
	       sb.append("custId : " + custId);
	       sb.append("firstName : " + firstName);
	       sb.append("lastName : " + lastName);
	       sb.append("street : " + street);
	       sb.append("city : " + city);
	       sb.append("appt : " + appt);
	       sb.append("zipCode : " + zipCode);
	       sb.append("email : " + email);
	       return sb.toString();
	    }

		public String getAppt() {
			return appt;
		}

		public void setAppt(String appt) {
			this.appt = appt;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public long getCustId() {
			return custId;
		}

		public void setCustId(long custId) {
			this.custId = custId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public Date getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(Timestamp updatedTime) {
			this.updatedTime = updatedTime;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public Collection<Order> getOrders(){
			return orders;
		}
		
		public void setOrders(Collection<Order> orders){
			this.orders = orders;
		}

}
