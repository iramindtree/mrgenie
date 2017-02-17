/**
 * 
 */
package com.mindtree.ira.response.bean;

/**
 * @author M1031960
 *
 */
public class AgentResponseBean {
	
	private String id;
	private String timestamp;
	private String lang;
	AgentResponseResultBean result;
	private AgentResponseStatusBean status;
	private String sessionId;
	private Object originalRequest;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/**
	 * @return the result
	 */
	public AgentResponseResultBean getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(AgentResponseResultBean result) {
		this.result = result;
	}
	/**
	 * @return the status
	 */
	public AgentResponseStatusBean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(AgentResponseStatusBean status) {
		this.status = status;
	}
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Object getOriginalRequest() {
		return originalRequest;
	}
	public void setOriginalRequest(Object originalRequest) {
		this.originalRequest = originalRequest;
	}
	
	
	
}
