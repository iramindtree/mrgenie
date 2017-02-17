/**
 * 
 */
package com.mindtree.ira.controller;

import com.mindtree.ira.response.bean.AgentResponseBean;
import com.mindtree.ira.response.bean.IRAServiceResponse;

/**
 * @author admin
 *
 */
public class IRAService {

	public IRAServiceResponse processResponse(AgentResponseBean responseBean) {
		IRAServiceResponse serviceResponse = new IRAServiceResponse();
		if (responseBean.getResult().getAction().equalsIgnoreCase("input.welcome")) {
			serviceResponse.setSpeech("Hi Vijendra");
		}
		return serviceResponse;
	}
}
