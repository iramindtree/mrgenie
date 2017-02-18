package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the property_amenities database table.
 * 
 */
@Entity
@Table(name="property_amenities")
@NamedQuery(name="PropertyAmenity.findAll", query="SELECT p FROM PropertyAmenity p")
public class PropertyAmenity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="amenity_id")
	private int amenityId;

	@Column(name="amenity_name")
	private String amenityName;

	@Column(name="closing_time")
	private Time closingTime;

	@Column(name="open_time")
	private Time openTime;

	@Column(name="operating_days")
	private String operatingDays;

	@Column(name="property_id")
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