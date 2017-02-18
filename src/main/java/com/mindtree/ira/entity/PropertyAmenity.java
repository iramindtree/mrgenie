package com.mindtree.ira.entity;

import java.io.Serializable;
import java.sql.Time;


/**
 * The persistent class for the property_amenities database table.
 * 
 */
public class PropertyAmenity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int amenityId;

	private String amenityName;

	private Time closingTime;

	private Time openTime;

	private String operatingDays;

	private int propertyId;

	public PropertyAmenity() {
	}

	public int getAmenityId() {
		return this.amenityId;
	}

	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}

	public String getAmenityName() {
		return this.amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public Time getClosingTime() {
		return this.closingTime;
	}

	public void setClosingTime(Time closingTime) {
		this.closingTime = closingTime;
	}

	public Time getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

	public String getOperatingDays() {
		return this.operatingDays;
	}

	public void setOperatingDays(String operatingDays) {
		this.operatingDays = operatingDays;
	}

	public int getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

}