/**
 * 
 */
package com.mindtree.ira.controller;

import com.mindtree.ira.dao.CustomerDAO;
import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.IRAServiceResponse;

/**
 * @author admin
 *
 */
public class IRAService {

	public IRAServiceResponse processResponse(AgentResponseBean responseBean,String CustId) {
		IRAServiceResponse serviceResponse = new IRAServiceResponse();
		CustomerDAO customerDAO=new CustomerDAO();
		if (responseBean.getResult().getAction()
				.equalsIgnoreCase("input.welcome")) {
			String customerName = customerDAO.getCustomerName(CustId);
			if (null == customerName) {
				serviceResponse.setSpeech("Hi");
			} else {
				serviceResponse.setSpeech("Hi " + customerName);
			}
		}
		if(responseBean.getResult().getAction().equalsIgnoreCase("check_out.info")){
			serviceResponse.setSpeech("Your check-out is on 18th of Feburary at 12 pm");
		}
		return serviceResponse;
	}
}
