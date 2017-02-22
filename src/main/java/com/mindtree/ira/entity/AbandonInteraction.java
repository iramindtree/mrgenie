/**
 * 
 */
package com.mindtree.ira.entity;

import java.util.Date;

/**
 * @author M1020374
 *
 */
public class AbandonInteraction {
	String CustomerId;
	int interactionId;
	String iteractionType;
	String InteractionSource;
	Date InteractionDateTimestamp;
	String destinationCity;
	Date checkInDate;
	Date checkOutDate;

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public int getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(int interactionId) {
		this.interactionId = interactionId;
	}

	public String getIteractionType() {
		return iteractionType;
	}

	public void setIteractionType(String iteractionType) {
		this.iteractionType = iteractionType;
	}

	public String getInteractionSource() {
		return InteractionSource;
	}

	public void setInteractionSource(String interactionSource) {
		InteractionSource = interactionSource;
	}

	public Date getInteractionDateTimestamp() {
		return InteractionDateTimestamp;
	}

	public void setInteractionDateTimestamp(Date interactionDateTimestamp) {
		InteractionDateTimestamp = interactionDateTimestamp;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
