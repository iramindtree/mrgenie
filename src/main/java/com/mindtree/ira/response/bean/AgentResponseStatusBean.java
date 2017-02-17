/**
 * 
 */
package com.mindtree.ira.response.bean;

/**
 * @author M1031960
 *
 */
public class AgentResponseStatusBean {
	
	private int code;
	private String errorType;
	private String errorId;
	private String errorDetails;
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}
	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	/**
	 * @return the errorId
	 */
	public String getErrorId() {
		return errorId;
	}
	/**
	 * @param errorId the errorId to set
	 */
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}
	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
