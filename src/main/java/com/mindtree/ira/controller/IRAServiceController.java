package com.mindtree.ira.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.ira.dao.CustomerDAO;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.IRAServiceResponse;

@RestController
public class IRAServiceController {
	
	private static final String ERROR_DATA = "Sorry unable to serve you at the present moment.";
	private static final String SUCCESS_DATA = "Your request has been processed successfully.";
	
	private enum ResponseObjectType{ERROR_DATA,SUCCESS_DATA};
    
  //@RequestMapping("/")
    @RequestMapping(method = RequestMethod.POST)
    public String process(@RequestBody String jsonString) throws IOException {
    	System.out.println("Input jsonString: \n" + jsonString);
    	
    	
    	AgentResponseBean responseBean = new ObjectMapper().readValue(jsonString, AgentResponseBean.class);
    	String customerId="9741657696";
    	IRAService service=new IRAService();
    	//service.processResponse(responseBean);
    	
    	IRAServiceResponse successResponse = service.processResponse(responseBean,customerId);//buildResponseObject(ResponseObjectType.SUCCESS_DATA);
    	
    	//TODO: Testing DB conncetion.
    	
    	System.out.println(new CustomerDAO().getAllCustomers());
    	
    	
    	
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
    
}
