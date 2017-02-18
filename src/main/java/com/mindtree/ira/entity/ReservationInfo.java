package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation_info database table.
 * 
 */
@Entity
@Table(name="reservation_info")
@NamedQuery(name="ReservationInfo.findAll", query="SELECT r FROM ReservationInfo r")
public class ReservationInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reservation_conf_no")
	private int reservationConfNo;

	@Temporal(TemporalType.DATE)
	@Column(name="arrival_date")
	private Date arrivalDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="checkin_datetime")
	private Date checkinDatetime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="checkout_datetime")
	private Date checkoutDatetime;

	@Column(name="customer_id")
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