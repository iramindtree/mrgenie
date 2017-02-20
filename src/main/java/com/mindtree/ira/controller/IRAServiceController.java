package com.mindtree.ira.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.ira.response.bean.AgentContextBean;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.IRAServiceResponse;

@RestController
public class IRAServiceController {
	
	private static final String ERROR_DATA = "Sorry unable to serve you at the present moment.";
	private static final String SUCCESS_DATA = "Your request has been processed successfully.";
	
	private enum ResponseObjectType{ERROR_DATA,SUCCESS_DATA};
    
  //@RequestMapping("/")
    @RequestMapping(method = RequestMethod.POST)
    public String process(@RequestBody String jsonString, @RequestHeader Map<String, String> header) throws IOException {
    	//TODO: In coming JSON and header printing for testing. To be removed.
    	System.out.println("Input jsonString: \n" + jsonString);
    	Set<String> httpHeaderKeySet = header.keySet();
    	for (Iterator iterator = httpHeaderKeySet.iterator(); iterator
				.hasNext();) {
			String headerKey = (String) iterator.next();
			
			System.out.println(headerKey + " = " + header.get(headerKey) );
			
		}
    	
    	AgentResponseBean responseBean = new ObjectMapper().readValue(jsonString, AgentResponseBean.class);
    	
    	AgentContextBean agentContextBean = getAgentContextByName(responseBean.getResult().getContexts(), "user_device_context");
    	String deviceId = "";
    	if(agentContextBean != null){
    		deviceId = (String)agentContextBean.getParameters().get("deviceId");
    	}
    	else{
    		deviceId = "869100020602312";
    	}
    	IRAService service=new IRAService();
    	//service.processResponse(responseBean);
    	int reservationId= service.getReservationConformationNumberForDeviceId(deviceId);
    	IRAServiceResponse successResponse = service.processResponse(responseBean,reservationId);//buildResponseObject(ResponseObjectType.SUCCESS_DATA);
    	
    	//TODO: Testing DB conncetion.
    	
    	return parseJsonToString(successResponse);
        //return jsonString;
    }
    
    public static IRAServiceResponse buildResponseObject(ResponseObjectType responseObjectType){
    	IRAServiceResponse iraServiceResponse = new IRAServiceResponse();
    	
    	if(responseObjectType.equals(ResponseObjectType.SUCCESS_DATA)) {
    		iraServiceResponse.setSpeech(SUCCESS_DATA);
    		iraServiceResponse.setDisplayText(SUCCESS_DATA);
    	}
    	else {
    		iraServiceResponse.setSpeech(ERROR_DATA);
    		iraServiceResponse.setDisplayText(ERROR_DATA);
    	}
    	
    	return iraServiceResponse;
    }
    
    public static String parseJsonToString(IRAServiceResponse serviceResponse) throws JsonProcessingException {
		String jsonString = null;
		if(serviceResponse != null) {
			ObjectMapper mapper = new ObjectMapper();
			jsonString = mapper.writeValueAsString(serviceResponse);	
		}
		System.out.println("Output jsonString: \n" + jsonString);
		return jsonString;
	}
    
    public AgentContextBean getAgentContextByName(List<AgentContextBean> agentContexts, String agentContextName){
    	for (Iterator iterator = agentContexts.iterator(); iterator.hasNext();) {
			AgentContextBean agentContextBean = (AgentContextBean) iterator
					.next();
			if(agentContextBean.getName().equals(agentContextName))
				return agentContextBean;
			
		}
    	return null;
    }
       
}
