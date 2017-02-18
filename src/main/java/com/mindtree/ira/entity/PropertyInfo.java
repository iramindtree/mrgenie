package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the property_info database table.
 * 
 */
@Entity
@Table(name="property_info")
@NamedQuery(name="PropertyInfo.findAll", query="SELECT p FROM PropertyInfo p")
public class PropertyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="property_id")
	private int propertyId;

	@Column(name="property_code")
	private String propertyCode;

	@Column(name="property_geo_coordinates")
	private String propertyGeoCoordinates;

	@Column(name="property_name")
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