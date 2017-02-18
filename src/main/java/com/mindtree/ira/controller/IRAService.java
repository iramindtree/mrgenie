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
		String inputAction = responseBean.getResult().getAction();
		
		if (inputAction.equalsIgnoreCase("input.welcome")) {
			String customerName = customerDAO.getCustomerName(custId);
			if (null == customerName) {
				serviceResponse.setSpeech("Hi");
			} else {
				serviceResponse.setSpeech("Hi " + customerName);
			}
		}
		else if(inputAction.equalsIgnoreCase("check_out.info")){
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
		else if(inputAction.equalsIgnoreCase("pool.info")){
			Context poolCrossSelling = new Context();
			poolCrossSelling.setLifespan(1);
			poolCrossSelling.setName("pool_cross_selling");
			Context[] poolCrossSellingContextArray = {poolCrossSelling};
			
			serviceResponse.setContextOut(poolCrossSellingContextArray);
			serviceResponse.setDisplayText("Our Swimming Pool will be open from 08:00 AM to 06:00 PM on all days. To use the pool, you need to have swim attrire. Id you don't have one, would you like me to get one for you? ");
			serviceResponse.setSpeech("Our Swimming Pool will be open from 08:00 AM to 06:00 PM on all days. To use the pool, you need to have swim attrire. Id you don't have one, would you like me to get one for you? ");
		}
		else if(inputAction.equalsIgnoreCase("pool.crossselling")){
			Context poolCrossSelling = new Context();
			poolCrossSelling.setLifespan(1);
			poolCrossSelling.setName("pool_cross_selling_confirm");
			Context[] poolCrossSellingContextArray = {poolCrossSelling};
			
			serviceResponse.setContextOut(poolCrossSellingContextArray);
			serviceResponse.setDisplayText("What size shorts fit you well? ");
			serviceResponse.setSpeech("What size shorts fit you well? ");
		}
		else if(inputAction.equalsIgnoreCase("order.pool_attrire")){
			
			serviceResponse.setDisplayText("Got it. Your attrire will be delivered to your room.");
			serviceResponse.setSpeech("Got it. Your attrire will be delivered to your room.");
		}
		else{
			Context testContext = new Context();
			testContext.setName("Unknown_Action_Context");
			testContext.setLifespan(1);
			Context[] responseContextArray = new Context[1];
			responseContextArray[0] = testContext;
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
