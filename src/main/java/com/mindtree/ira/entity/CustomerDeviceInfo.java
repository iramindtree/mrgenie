package com.mindtree.ira.entity;

import java.io.Serializable;


/**
 * The persistent class for the customer_device_info database table.
 * 
 */
public class CustomerDeviceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String deviceId;

	private String customerId;

	public CustomerDeviceInfo() {
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}