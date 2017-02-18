package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the customer_info database table.
 * 
 */
@Entity
@Table(name="customer_info")
@NamedQuery(name="CustomerInfo.findAll", query="SELECT c FROM CustomerInfo c")
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUST_ID")
	private String custId;

	@Column(name="CUST_CREATED")
	private Timestamp custCreated;

	@Column(name="CUST_EMAIL")
	private String custEmail;

	@Column(name="CUST_FNAME")
	private String custFname;

	@Column(name="CUST_GENDER")
	private String custGender;

	@Column(name="CUST_LNAME")
	private String custLname;

	public CustomerInfo() {
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Timestamp getCustCreated() {
		return this.custCreated;
	}

	public void setCustCreated(Timestamp custCreated) {
		this.custCreated = custCreated;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustFname() {
		return this.custFname;
	}

	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}

	public String getCustGender() {
		return this.custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public String getCustLname() {
		return this.custLname;
	}

	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}

}