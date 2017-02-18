package com.mindtree.ira.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the service_request database table.
 * 
 */
public class ServiceRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serviceRequestId;

	private String customerId;

	private String departmentId;

	private Date executionTime;

	private int propertyId;

	private String requestDesc;

	private String requestStatus;

	private String roomNo;

	public ServiceRequest() {
	}

	public String getServiceRequestId() {
		return this.serviceRequestId;
	}

	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Date getExecutionTime() {
		return this.executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public int getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getRequestDesc() {
		return this.requestDesc;
	}

	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}

	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

}