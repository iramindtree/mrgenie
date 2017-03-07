/**
 * 
 */
package com.mindtree.ira.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.StringUtils;

import com.mindtree.ira.dao.ConsumptionDAO;
import com.mindtree.ira.dao.CustomerDAO;
import com.mindtree.ira.dao.CustomerProfileInfoDAO;
import com.mindtree.ira.dao.MasterDateDAO;
import com.mindtree.ira.dao.PropertyDAO;
import com.mindtree.ira.dao.ReservationDAO;
import com.mindtree.ira.dao.ServiceRequestDAO;
import com.mindtree.ira.entity.AbandonInteraction;
import com.mindtree.ira.entity.CustomerProfileInfo;
import com.mindtree.ira.entity.MasterDate;
import com.mindtree.ira.entity.PmsReservationInfo;
import com.mindtree.ira.entity.PropertyAmenity;
import com.mindtree.ira.entity.PropertyInfo;
import com.mindtree.ira.entity.ReservationInfo;
import com.mindtree.ira.entity.ServiceRequest;
import com.mindtree.ira.response.bean.AgentContextBean;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.IRAServiceResponse;

/**
 * @author admin
 *
 */
public class IRAService {

	/**
	 * @param responseBean
	 * @param reservationId
	 * @return
	 */
	public IRAServiceResponse processResponse(AgentResponseBean responseBean,int reservationId) {
		IRAServiceResponse serviceResponse = new IRAServiceResponse();
		CustomerDAO customerDAO=new CustomerDAO();
		ReservationDAO reservationDAO=new ReservationDAO();
		PropertyDAO propertyDAO=new PropertyDAO();
		MasterDateDAO masterDateDAO=new MasterDateDAO();
		CustomerProfileInfoDAO customerProfileInfoDAO=new CustomerProfileInfoDAO();
		ServiceRequestDAO serviceRequestDAO=new ServiceRequestDAO();
		ConsumptionDAO consumptionDAO=new ConsumptionDAO();
		
		ReservationInfo reservationInfo=getReservationInfoByReservationId(reservationId,reservationDAO);
		CustomerProfileInfo customerProfileInfo=customerProfileInfoDAO.getCustomerProfileInfo(reservationInfo.getCustomerId());
		PmsReservationInfo pmsReservationInfo=customerDAO.getReservationFromPMS(reservationId);
		PropertyInfo propertyInfo=propertyDAO.getPropertyInfo(pmsReservationInfo.getPropertyId());
		String roomNumber=pmsReservationInfo.getRoomNumber();
		String customerName = customerDAO.getCustomerName(reservationInfo.getCustomerId());
		String inputAction = responseBean.getResult().getAction();
		
		if (inputAction.equalsIgnoreCase("input.welcome")) {
			String custId=reservationInfo.getCustomerId();
			if (null == customerName) {
				serviceResponse.setSpeech("Hi");
			} else {
				serviceResponse.setSpeech("Hi " + customerName);
			}
		}
		else if(inputAction.equalsIgnoreCase("check_out.info")){
			SimpleDateFormat prounanceDateString = new SimpleDateFormat("dd MMM YYYY");
			SimpleDateFormat prounanceTimeString = new SimpleDateFormat("HH:mm a");
			if(DateUtils.isSameDay(masterDateDAO.getMasterDate().getMasterDate(), reservationInfo.getCheckoutDatetime())){
                serviceResponse.setSpeech("Your check-out is today at "+ prounanceTimeString.format(reservationInfo.getCheckoutDatetime()) +". Would you like me to book a cab to the airport?");
                AgentContextBean conciergeServices = new AgentContextBean();
                conciergeServices.setLifespan(1);
                conciergeServices.setName("book_cab_airport");
                AgentContextBean[] conciergeServiceContextArray = {conciergeServices};
                serviceResponse.setContextOut(conciergeServiceContextArray);
          }
          else
                serviceResponse.setSpeech("Your check-out is "+ prounanceDateString.format(reservationInfo.getCheckoutDatetime()) +" at "+ prounanceTimeString.format(reservationInfo.getCheckoutDatetime()));

		}
		else if(responseBean.getResult().getAction().equalsIgnoreCase("order.coffee")){
			String delivery="",kindofcoffee="",size="",typeofmilk="",amount="",unit ="";
			
			String customerSugarLevelPreference=customerProfileInfo.getCustomerSugarLevelPreference();
			String customerTempraturePreference=customerProfileInfo.getCustomerTemperaturePreference();
			if(!responseBean.getResult().getParameters().isEmpty()){
				Map<String,Object> parameters=responseBean.getResult().getParameters();
				Object deliveryObject=parameters.get("delivery");
				List<String> deliveryList=(ArrayList<String>)deliveryObject;
				if(deliveryList.size() !=0){
					 delivery=deliveryList.get(0);
				}
				Object kindofcoffeeObject=parameters.get("Coffee_type");
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
				List<Object> unitVolume=(ArrayList<Object>) parameters.get("unit-volume");
				if(null!=unitVolume && unitVolume.size()>0){
				
				Object unitVolumeFirstObject=unitVolume.get(0);
				Map<String,Object> unitVolumeFirstObjectMap=(Map<String,Object>) unitVolumeFirstObject;
				int amountInt=(int)unitVolumeFirstObjectMap.get("amount");
				amount=String.valueOf(amountInt);
				unit=(String)unitVolumeFirstObjectMap.get("unit");
		
				}
				//String[] unitVolumeFirstArray=(String[])unitVolumeFirstObject;
				//String unitVolumeString=unitVolumeFirstObject.
				//System.out.println("unit print "+unitVolumeFirstArray);
			/*	String unitVolumeFirst=unitVolumeFirstObject.
				if(null!=unitVolume){
					
				}*/
			}
			if(reservationInfo.getReservationConfNo()==19736383){
				if(amount.equalsIgnoreCase("")||unit.equalsIgnoreCase("")){
					serviceResponse.setSpeech("I got your Order. Your "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to you in the lobby by next 10 min");
					serviceResponse.setDisplayText("I got your Order. Your "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to you in the lobby by next 10 min");
				}else{
					serviceResponse.setSpeech("I got your Order. Your "+amount+" "+unit+" "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to you in the lobby by next 10 min");
					serviceResponse.setDisplayText("I got your Order. Your "+amount+" "+unit+" "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to you in the lobby by next 10 min");
				}
			}else{
				if(amount.equalsIgnoreCase("")||unit.equalsIgnoreCase("")){
				serviceResponse.setSpeech("I got your Order. Your "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to your room number " + roomNumber+" in next 10 mins");
				serviceResponse.setDisplayText("I got your Order. Your "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to your room number " + roomNumber+" in next 10 mins");
				}else{
					serviceResponse.setSpeech("I got your Order. Your "+amount+" "+unit+" "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to your room number " + roomNumber+" in next 10 mins");
					serviceResponse.setDisplayText("I got your Order. Your "+amount+" "+unit+" "+kindofcoffee+" with "+typeofmilk+" milk and "+customerSugarLevelPreference+" of sugar at "+customerTempraturePreference+" Temprature will be served to your room number " + roomNumber+" in next 10 mins");
				}
			}
			//adding the service request to service request table
			ServiceRequest serviceRequest=new ServiceRequest();
			serviceRequest.setCustomerId(reservationInfo.getCustomerId());
			serviceRequest.setDepartmentId("KOT");
			serviceRequest.setExecutionTime(new Date());
			serviceRequest.setPropertyId(propertyInfo.getPropertyId());
			serviceRequest.setRequestDesc("Coffee Request -> kind: "+ kindofcoffee +", size: "+ size +", delivery: "+ delivery +", milk: "+ typeofmilk +", sugar: "+ customerSugarLevelPreference +", temp: "+ customerTempraturePreference);
			serviceRequest.setRequestStatus("Requested");
			if(reservationInfo.getReservationConfNo()==19736383){
				serviceRequest.setRoomNo(roomNumber);
			}else{
				serviceRequest.setRoomNo("pool area");
			}
			
			Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
	        String datetime = ft.format(dNow);
			serviceRequest.setServiceRequestId(datetime);
			serviceRequestDAO.insertServiceRequest(serviceRequest);
		}
		//order.beer_budweiser
		else if(responseBean.getResult().getAction().equalsIgnoreCase("order.beer")){
			String brand="", size="", speach;
			
			if(!responseBean.getResult().getParameters().isEmpty()){
				Map<String,Object> parameters=responseBean.getResult().getParameters();
				Object brandObject=parameters.get("beer_brand");
				List<String> brandList=(ArrayList<String>)brandObject;
				if(brandList.size() !=0){
					 brand=brandList.get(0);
				}
				
				Object sizeObject=parameters.get("beer_size");
				List<String> sizeList=(ArrayList<String>)sizeObject;
				if(sizeList.size() !=0){
					 size=sizeList.get(0);
				}
				
			}
			if(brand.equalsIgnoreCase("Heineken")){
				speach = "Sorry "+ customerName +", looks like "+ brand +" beer is out of stock at the moment. Instead would you like to have Budwiser beer?";
				List<AgentContextBean> existingContext = responseBean.getResult().getContexts();
				AgentContextBean[] existingContextArray = new AgentContextBean[20];
				for (int i=0; i <existingContext.size(); i++) {
					AgentContextBean agentContextBean = existingContext.get(i);
					existingContextArray[i] = agentContextBean;
					
				}
				
				serviceResponse.setContextOut(existingContextArray);
			}
			else{
				speach = "Great! Your order of "+ brand +" beer will be served to your room " + roomNumber + " in next 10mins";
				//adding the service request to service request table
				ServiceRequest serviceRequest=new ServiceRequest();
				serviceRequest.setCustomerId(reservationInfo.getCustomerId());
				serviceRequest.setDepartmentId("KOT");
				serviceRequest.setExecutionTime(new Date());
				serviceRequest.setPropertyId(propertyInfo.getPropertyId());
				serviceRequest.setRequestDesc("Beer Request -> Brand: "+ brand +", Size: "+ size);
				serviceRequest.setRequestStatus("Requested");
				serviceRequest.setRoomNo(roomNumber);
				
				Date dNow = new Date();
		        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		        String datetime = ft.format(dNow);
				serviceRequest.setServiceRequestId(datetime);
				serviceRequestDAO.insertServiceRequest(serviceRequest);
			}
						
			serviceResponse.setSpeech(speach);
			
		}
		
		else if(responseBean.getResult().getAction().equalsIgnoreCase("order.pizza")){
			String type="", toppings="", crust="", size="";
			
			if(!responseBean.getResult().getParameters().isEmpty()){
				Map<String,Object> parameters=responseBean.getResult().getParameters();
				Object typeObject=parameters.get("type");
				List<String> typeList=(ArrayList<String>)typeObject;
				if(typeList.size() !=0){
					 type=typeList.get(0);
				}
				Object toppingsObject=parameters.get("topping");
				List<String> toppingsList=(ArrayList<String>)toppingsObject;
				if(toppingsList.size() !=0){
					 toppings=toppingsList.get(0);
				}
				Object crustObject=parameters.get("crust");
				List<String> crustList=(ArrayList<String>)crustObject;
				if(crustList.size() !=0){
					 crust=crustList.get(0);
				}
				Object sizeObject=parameters.get("size");
				List<String> sizeList=(ArrayList<String>)sizeObject;
				if(sizeList.size() !=0){
					 size=sizeList.get(0);
				}
				
			}
			String speach = "A delicious "+ size +" size "+ type +" pizza with  " + toppings + " toppings will be delivered to your "+roomNumber+" as soon as you reach hotel!";			
			serviceResponse.setSpeech(speach);
			//adding the service request to service request table
			ServiceRequest serviceRequest=new ServiceRequest();
			serviceRequest.setCustomerId(reservationInfo.getCustomerId());
			serviceRequest.setDepartmentId("KOT");
			serviceRequest.setExecutionTime(new Date());
			serviceRequest.setPropertyId(propertyInfo.getPropertyId());
			serviceRequest.setRequestDesc("Pizza Request -> Size: "+ size +", Toppings: "+ toppings +", Crust: " + toppings);
			serviceRequest.setRequestStatus("Requested");
			serviceRequest.setRoomNo(roomNumber);
			
			Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
	        String datetime = ft.format(dNow);
			serviceRequest.setServiceRequestId(datetime);
			serviceRequestDAO.insertServiceRequest(serviceRequest);
		}
				
		else if(inputAction.equalsIgnoreCase("pool.info")){
			AgentContextBean poolCrossSelling = new AgentContextBean();
			poolCrossSelling.setLifespan(1);
			poolCrossSelling.setName("pool_cross_selling");
			AgentContextBean[] poolCrossSellingContextArray = {poolCrossSelling};
			//TODO get todays date and get the amenities details and then compare the availability  
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
				speech="Our Swimming Pool will be open from "+_12HourSDF.format(propertyAmenity.getOpenTime())+" to "+_12HourSDF.format(propertyAmenity.getClosingTime())+". To use the pool, you need to have swim attire. If you don't have one, would you like me to get one for you? ";
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
			AgentContextBean poolCrossSelling = new AgentContextBean();
			poolCrossSelling.setLifespan(1);
			poolCrossSelling.setName("pool_cross_selling_confirm");
			AgentContextBean[] poolCrossSellingContextArray = {poolCrossSelling};
			
			serviceResponse.setContextOut(poolCrossSellingContextArray);
			serviceResponse.setDisplayText("What size shorts fit you well? ");
			serviceResponse.setSpeech("What size shorts fit you well? ");
		}
		else if(inputAction.equalsIgnoreCase("order.pool_attire")){
			
			serviceResponse.setDisplayText("Got it. Your attire will be delivered to your room number "+pmsReservationInfo.getRoomNumber() +". You can find the pool right next to the bar near lobby.");
			serviceResponse.setSpeech("Got it. Your attire will be delivered to your room number"+pmsReservationInfo.getRoomNumber()+". You can find the pool right next to the bar near lobby.");
			
			
			ServiceRequest serviceRequest=new ServiceRequest();
			serviceRequest.setCustomerId(reservationInfo.getCustomerId());
			serviceRequest.setDepartmentId("POS");
			serviceRequest.setExecutionTime(new Date());
			serviceRequest.setPropertyId(propertyInfo.getPropertyId());
			serviceRequest.setRequestDesc("pool attire request");
			serviceRequest.setRequestStatus("Requested");
			serviceRequest.setRoomNo(pmsReservationInfo.getRoomNumber());
			
			Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
	        String datetime = ft.format(dNow);
			serviceRequest.setServiceRequestId(datetime);
			serviceRequestDAO.insertServiceRequest(serviceRequest);
		}else if(inputAction.equalsIgnoreCase("consumption.info")){
			long consumptionAmount=consumptionDAO.getConsumptionAmount(reservationInfo.getReservationConfNo());
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			if(simpleDateFormat.format(reservationInfo.getCheckoutDatetime()).equals(simpleDateFormat.format(masterDateDAO.getMasterDate().getMasterDate()))){
				serviceResponse.setSpeech("Your Final Consumption Amount is $"+consumptionAmount);
				serviceResponse.setDisplayText("Your Final Consumption Amount is $"+consumptionAmount);
				AgentContextBean creditCardBilling = new AgentContextBean();
				creditCardBilling.setLifespan(1);
				creditCardBilling.setName("billing_credit_card_confirm");
				AgentContextBean[] creditCardBillingContextArray = {creditCardBilling};
				serviceResponse.setContextOut(creditCardBillingContextArray);
			}else{
				serviceResponse.setSpeech("Your Consumption as of now is $"+consumptionAmount+ " however your check-out date is "+new SimpleDateFormat("yyyy-MM-dd").format(reservationInfo.getCheckoutDatetime()));
				serviceResponse.setDisplayText("Your Consumption as of now is $"+consumptionAmount+ " however your check-out date is "+new SimpleDateFormat("yyyy-MM-dd").format(reservationInfo.getCheckoutDatetime()));
			}
		}else if(inputAction.equalsIgnoreCase("do-not_book.hotel")){
			Date checkInDate=null;
			Date checkOutDate=null;
			String geoCity = null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			if(!responseBean.getResult().getParameters().isEmpty()){
				Map<String,Object> parameters=responseBean.getResult().getParameters();
				Object checkInDateObj=parameters.get("check-in-date");
				if(!StringUtils.isEmpty(checkInDateObj)){
					try {
						checkInDate=sdf.parse(checkInDateObj.toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				Object checkOutDateObj=parameters.get("check-out-date");
				if(!StringUtils.isEmpty(checkOutDateObj)){
					try {
						checkOutDate=sdf.parse(checkOutDateObj.toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
				Object geoCityObj=parameters.get("geo-city");
				if(!StringUtils.isEmpty(geoCityObj)){
					geoCity=geoCityObj.toString();	
				}
				
			}
			serviceResponse.setSpeech("No problem, you may always come back to me on this");
			serviceResponse.setDisplayText("No problem, you may always come back to me on this");
			//customerProfileInfo
			AbandonInteraction abandonInteraction=new AbandonInteraction();
			abandonInteraction.setCheckInDate(checkInDate);
			abandonInteraction.setCheckOutDate(checkOutDate);
			abandonInteraction.setCustomerId(customerProfileInfo.getCustomerId());
			abandonInteraction.setDestinationCity(geoCity);
			abandonInteraction.setInteractionDateTimestamp(new Date());
			abandonInteraction.setInteractionSource("ai");
			abandonInteraction.setIteractionType("Abandon Search");
			
			ServiceRequestDAO seDao=new ServiceRequestDAO();
			seDao.insertIntoAbandonSearch(abandonInteraction);
			
		}
		else{
			AgentContextBean testContext = new AgentContextBean();
			testContext.setName("Unknown_Action_Context");
			testContext.setLifespan(1);
			AgentContextBean[] responseContextArray = new AgentContextBean[1];
			responseContextArray[0] = testContext;
			serviceResponse.setContextOut(responseContextArray);
			serviceResponse.setSpeech("I am not sure how to serve that. Let me see if i can find someone to help you with this request.");
			serviceResponse.setDisplayText("I am not sure how to serve that. Let me see if i can find someone to help you with this request.");
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
	
	public int getReservationConformationNumberForDeviceId(String deviceId){
    	return new CustomerDAO().getCustomerReservationByDeviceId(deviceId);
    }
}
