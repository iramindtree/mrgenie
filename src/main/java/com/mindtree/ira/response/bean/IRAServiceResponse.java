package com.mindtree.ira.response.bean;

import java.io.Serializable;

public class IRAServiceResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String speech;
	private String displayText;
	private Object data;
	private AgentContextBean[] contextOut;
	private String source;
	
	
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public AgentContextBean[] getContextOut() {
		return contextOut;
	}
	public void setContextOut(AgentContextBean[] contextOut) {
		this.contextOut = contextOut;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
