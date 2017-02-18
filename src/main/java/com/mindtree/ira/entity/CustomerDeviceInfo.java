package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_device_info database table.
 * 
 */
@Entity
@Table(name="customer_device_info")
@NamedQuery(name="CustomerDeviceInfo.findAll", query="SELECT c FROM CustomerDeviceInfo c")
public class CustomerDeviceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="device_id")
	private String deviceId;

	@Column(name="customer_id")
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