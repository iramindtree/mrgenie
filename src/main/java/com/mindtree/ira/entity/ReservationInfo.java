package com.mindtree.ira.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the reservation_info database table.
 * 
 */
public class ReservationInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int reservationConfNo;

	private Date arrivalDate;

	private Date checkinDatetime;

	private Date checkoutDatetime;

	private String customerId;

	public ReservationInfo() {
	}

	public int getReservationConfNo() {
		return this.reservationConfNo;
	}

	public void setReservationConfNo(int reservationConfNo) {
		this.reservationConfNo = reservationConfNo;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getCheckinDatetime() {
		return this.checkinDatetime;
	}

	public void setCheckinDatetime(Date checkinDatetime) {
		this.checkinDatetime = checkinDatetime;
	}

	public Date getCheckoutDatetime() {
		return this.checkoutDatetime;
	}

	public void setCheckoutDatetime(Date checkoutDatetime) {
		this.checkoutDatetime = checkoutDatetime;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}