/**
 * 
 */
package com.mindtree.ira.controller;

import java.text.SimpleDateFormat;

import com.mindtree.ira.dao.CustomerDAO;
import com.mindtree.ira.dao.ReservationDAO;
import com.mindtree.ira.entity.ReservationInfo;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.Context;
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
			SimpleDateFormat prounanceDateString = new SimpleDateFormat("dd MMM YYYY");
			SimpleDateFormat prounanceTimeString = new SimpleDateFormat("HH:mm a");
			String checkOutDate= reservationInfo.getCheckoutDatetime().toString();
			serviceResponse.setSpeech("Your check-out is "+ prounanceDateString.format(reservationInfo.getCheckoutDatetime()) +" at "+ prounanceTimeString.format(reservationInfo.getCheckoutDatetime()));
		}else if(responseBean.getResult().getAction().equalsIgnoreCase("order.coffee")){
			ReservationInfo reservationInfo = getReservationInfo(custId,
					reservationDAO);
			
			
		}
		else{
			Context testContext = new Context();
			testContext.setName("Unknown_Action_Context");
			Context[] responseContextArray = new Context[1];
			serviceResponse.setContextOut(responseContextArray);
			serviceResponse.setSpeech("I am not sure how to serve that. Let me see if u can find someone to help you with this request.");
			serviceResponse.setDisplayText("I am not sure how to serve that. Let me see if u can find someone to help you with this request.");
		}
		return serviceResponse;
	}

	private ReservationInfo getReservationInfo(String custId,
			ReservationDAO reservationDAO) {
		ReservationInfo reservationInfo=reservationDAO.getReservtionInfo(custId);
		return reservationInfo;
	}
}
