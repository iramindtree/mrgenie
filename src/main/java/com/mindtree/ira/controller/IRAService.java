/**
 * 
 */
package com.mindtree.ira.controller;

import com.mindtree.ira.dao.CustomerDAO;
import com.mindtree.ira.dao.ReservationDAO;
import com.mindtree.ira.entity.ReservationInfo;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.IRAServiceResponse;

/**
 * @author admin
 *
 */
public class IRAService {

	public IRAServiceResponse processResponse(AgentResponseBean responseBean,String custId) {
		IRAServiceResponse serviceResponse = new IRAServiceResponse();
		CustomerDAO customerDAO=new CustomerDAO();
		ReservationDAO reservationDAO=new ReservationDAO();
		if (responseBean.getResult().getAction()
				.equalsIgnoreCase("input.welcome")) {
			String customerName = customerDAO.getCustomerName(custId);
			if (null == customerName) {
				serviceResponse.setSpeech("Hi");
			} else {
				serviceResponse.setSpeech("Hi " + customerName);
			}
		}
		else if(responseBean.getResult().getAction().equalsIgnoreCase("check_out.info")){
			ReservationInfo reservationInfo = getReservationInfo(custId,
					reservationDAO);
			String checkOutDate= reservationInfo.getCheckoutDatetime().toString();
			serviceResponse.setSpeech("Your check-out is "+checkOutDate);
		}else if(responseBean.getResult().getAction().equalsIgnoreCase("order.coffee")){
			ReservationInfo reservationInfo = getReservationInfo(custId,
					reservationDAO);
			
			
		}
		return serviceResponse;
	}

	private ReservationInfo getReservationInfo(String custId,
			ReservationDAO reservationDAO) {
		ReservationInfo reservationInfo=reservationDAO.getReservtionInfo(custId);
		return reservationInfo;
	}
}
