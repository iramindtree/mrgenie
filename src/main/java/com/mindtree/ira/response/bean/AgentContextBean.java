/**
 * 
 */
package com.mindtree.ira.response.bean;

import java.util.Map;

/**
 * @author M1031960
 *
 */
public class AgentContextBean {

	private String name;
	Map<String, Object> parameters;
	int lifespan;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parameters
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	/**
	 * @return the lifespan
	 */
	public int getLifespan() {
		return lifespan;
	}
	/**
	 * @param lifespan the lifespan to set
	 */
	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}
	
	
	
}
