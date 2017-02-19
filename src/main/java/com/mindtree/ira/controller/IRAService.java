/**
 * 
 */
package com.mindtree.ira.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.mindtree.ira.dao.CustomerDAO;
import com.mindtree.ira.dao.CustomerProfileInfoDAO;
import com.mindtree.ira.dao.MasterDateDAO;
import com.mindtree.ira.dao.PropertyDAO;
import com.mindtree.ira.dao.ReservationDAO;
import com.mindtree.ira.entity.CustomerProfileInfo;
import com.mindtree.ira.entity.MasterDate;
import com.mindtree.ira.entity.PmsReservationInfo;
import com.mindtree.ira.entity.PropertyAmenity;
import com.mindtree.ira.entity.PropertyInfo;
import com.mindtree.ira.entity.ReservationInfo;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.Context;
import com.mindtree.ira.response.bean.IRAServiceResponse;

/**
 * @author admin
 *
 */
public class IRAService {

	public IRAServiceResponse processResponse(AgentResponseBean responseBean,int reservationId) {
		IRAServiceResponse serviceResponse = new IRAServiceResponse();
		CustomerDAO customerDAO=new CustomerDAO();
		ReservationDAO reservationDAO=new ReservationDAO();
		PropertyDAO propertyDAO=new PropertyDAO();
		MasterDateDAO masterDateDAO=new MasterDateDAO();
CustomerProfileInfoDAO customerProfileInfoDAO=new CustomerProfileInfoDAO();
		String inputAction = responseBean.getResult().getAction();
		
		if (inputAction.equalsIgnoreCase("input.welcome")) {
			ReservationInfo reservationInfo=getReservationInfoByReservationId(reservationId,reservationDAO);
			String custId=reservationInfo.getCustomerId();
String customerName = customerDAO.getCustomerName(custId);
			if (null == customerName) {
				serviceResponse.setSpeech("Hi");
			} else {
				serviceResponse.setSpeech("Hi " + customerName);
			}
		}
		else if(inputAction.equalsIgnoreCase("check_out.info")){
			ReservationInfo reservationInfo=getReservationInfoByReservationId(reservationId,reservationDAO);
			SimpleDateFormat prounanceDateString = new SimpleDateFormat("dd MMM YYYY");
			SimpleDateFormat prounanceTimeString = new SimpleDateFormat("HH:mm a");
			serviceResponse.setSpeech("Your check-out is "+ prounanceDateString.format(reservationInfo.getCheckoutDatetime()) +" at "+ prounanceTimeString.format(reservationInfo.getCheckoutDatetime()));
		}else if(responseBean.getResult().getAction().equalsIgnoreCase("order.coffee")){
			String delivery="",kindofcoffee="",size="",typeofmilk="";
			ReservationInfo reservationInfo=getReservationInfoByReservationId(reservationId,reservationDAO);
			CustomerProfileInfo customerProfileInfo=customerProfileInfoDAO.getCustomerProfileInfo(reservationInfo.getCustomerId());
			PmsReservationInfo pmsReservationInfo=customerDAO.getReservationFromPMS(reservationId);
			String roomNumber=pmsReservationInfo.getRoomNumber();
			String customerSugarLevelPreference=customerProfileInfo.getCustomerSugarLevelPreference();
			String customerTempraturePreference=customerProfileInfo.getCustomerTemperaturePreference();
			if(!responseBean.getResult().getParameters().isEmpty()){
				Map<String,Object> parameters=responseBean.getResult().getParameters();
				Object deliveryObject=parameters.get("delivery");
				List<String> deliveryList=(ArrayList<String>)deliveryObject;
				if(deliveryList.size() !=0){
					 delivery=deliveryList.get(0);
				}
				Object kindofcoffeeObject=parameters.get("kindofcoffee");
				List<String> kindofcoffeeList=(ArrayList<String>) kindofcoffeeObject;
				if(kindofcoffeeList.size()!=0){
					kindofcoffee=kindofcoffeeList.get(0);
				}else{
					kindofcoffee=customerProfileInfo.getCustomerMilkPreferece();
				}
				Object typeofmilkObject=parameters.get("typeofmilk");
				if(!StringUtils.isEmpty(typeofmilkObject)){
					typeofmilk=typeofmilkObject.toString();
				}else{
					typeofmilk=customerProfileInfo.getCustomerMilkPreferece();
				}
			}
			
			serviceResponse.setSpeech("We got your Order. Your "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to your room number " + roomNumber+" in next 10 mins");
		}
		else if(inputAction.equalsIgnoreCase("pool.info")){
			Context poolCrossSelling = new Context();
			poolCrossSelling.setLifespan(1);
			poolCrossSelling.setName("pool_cross_selling");
			Context[] poolCrossSellingContextArray = {poolCrossSelling};
			//TODO get todays date and get the amenities details and then compare the availability  
			PmsReservationInfo pmsReservationInfo=customerDAO.getReservationFromPMS(reservationId);
			PropertyInfo propertyInfo=propertyDAO.getPropertyInfo(pmsReservationInfo.getPropertyId());
			PropertyAmenity propertyAmenity=propertyDAO.getPropertyAmenity(propertyInfo.getPropertyId(), "POOL");
			MasterDate masterDate=masterDateDAO.getMasterDate();
			String startTime,endTime,speech;
			String operatingDaysStirng =propertyAmenity.getOperatingDays();
			String[] operatingDays=operatingDaysStirng.split(",");
			List<String> operatingDaysList=Arrays.asList(operatingDays);
			if(operatingDaysList.contains(String.valueOf(masterDate.getMasterDate().getDay()+1))){
				startTime=propertyAmenity.getOpenTime().toString();
				endTime=propertyAmenity.getClosingTime().toString();
				 SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
				speech="Our Swimming Pool will be open from "+_12HourSDF.format(propertyAmenity.getOpenTime())+" to "+_12HourSDF.format(propertyAmenity.getClosingTime())+", To use the pool, you need to have swim attrire. If you don't have one, would you like me to get one for you? ";
			}
			else{
				speech="Sorry Swimming Pool will closed Today";
			}
			
			serviceResponse.setContextOut(poolCrossSellingContextArray);
			//serviceResponse.setDisplayText("Our Swimming Pool will be open from 08:00 AM to 06:00 PM on all days. To use the pool, you need to have swim attrire. Id you don't have one, would you like me to get one for you? ");
			serviceResponse.setDisplayText(speech);
			//serviceResponse.setSpeech("Our Swimming Pool will be open from 08:00 AM to 06:00 PM on all days. To use the pool, you need to have swim attrire. Id you don't have one, would you like me to get one for you? ");
			serviceResponse.setSpeech(speech);
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
		else if(inputAction.equalsIgnoreCase("order.pool_attire")){
			
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
	
	private ReservationInfo getReservationInfoByReservationId(int resevationId,
			ReservationDAO reservationDAO) {
		ReservationInfo reservationInfo=reservationDAO.getReservtionInfoByReservationId(resevationId);
		return reservationInfo;
	}
}
