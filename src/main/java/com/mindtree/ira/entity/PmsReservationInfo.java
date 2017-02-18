package com.mindtree.ira.entity;

import java.io.Serializable;


/**
 * The persistent class for the pms_reservation_info database table.
 * 
 */
public class PmsReservationInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int reservationConfNo;

	private String propertyId;

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