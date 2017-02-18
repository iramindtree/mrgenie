package com.mindtree.ira.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the customer_info database table.
 * 
 */
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String custId;

	private Timestamp custCreated;

	private String custEmail;

	private String custFname;

	private String custGender;

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