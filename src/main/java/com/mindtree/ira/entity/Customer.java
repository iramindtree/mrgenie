/**
 * 
 */
package com.mindtree.ira.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author M1031960
 *
 */
public class Customer {
	
	private String customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	private String customerGender;
	
	
	
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	/**
	 * @param customerId
	 * @param customerFirstName
	 * @param customerLastName
	 * @param customerEmail
	 * @param customerGender
	 */
	public Customer(String customerId, String customerFirstName,
			String customerLastName, String customerEmail, String customerGender) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerGender = customerGender;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}
	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the customerGender
	 */
	public String getCustomerGender() {
		return customerGender;
	}
	/**
	 * @param customerGender the customerGender to set
	 */
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	public String toString(){
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
