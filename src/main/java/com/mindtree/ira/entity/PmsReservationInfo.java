package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pms_reservation_info database table.
 * 
 */
@Entity
@Table(name="pms_reservation_info")
@NamedQuery(name="PmsReservationInfo.findAll", query="SELECT p FROM PmsReservationInfo p")
public class PmsReservationInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reservation_conf_no")
	private int reservationConfNo;

	@Column(name="property_id")
	private String propertyId;

	@Column(name="room_number")
	private String roomNumber;

	public PmsReservationInfo() {
	}

	public int getReservationConfNo() {
		return this.reservationConfNo;
	}

	public void setReservationConfNo(int reservationConfNo) {
		this.reservationConfNo = reservationConfNo;
	}

	public String getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

}