package com.mindtree.ira.entity;

import java.io.Serializable;


/**
 * The persistent class for the property_info database table.
 * 
 */
public class PropertyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int propertyId;

	private String propertyCode;

	private String propertyGeoCoordinates;

	private String propertyName;

	public PropertyInfo() {
	}

	public int getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyCode() {
		return this.propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPropertyGeoCoordinates() {
		return this.propertyGeoCoordinates;
	}

	public void setPropertyGeoCoordinates(String propertyGeoCoordinates) {
		this.propertyGeoCoordinates = propertyGeoCoordinates;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}