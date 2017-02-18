package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consumption_info database table.
 * 
 */

public class ConsumptionInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int consumptionId;

	@Column(name="consumption_amount")
	private double consumptionAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="consumption_date")
	private Date consumptionDate;

	@Column(name="reservation_conf_no")
	private String reservationConfNo;

	public ConsumptionInfo() {
	}

	public int getConsumptionId() {
		return this.consumptionId;
	}

	public void setConsumptionId(int consumptionId) {
		this.consumptionId = consumptionId;
	}

	public double getConsumptionAmount() {
		return this.consumptionAmount;
	}

	public void setConsumptionAmount(double consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	public Date getConsumptionDate() {
		return this.consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public String getReservationConfNo() {
		return this.reservationConfNo;
	}

	public void setReservationConfNo(String reservationConfNo) {
		this.reservationConfNo = reservationConfNo;
	}

}