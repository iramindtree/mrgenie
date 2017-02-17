/**
 * 
 */
package com.mindtree.ira.response.bean;

import java.util.List;

/**
 * @author M1031960
 *
 */
public class AgentFullfillmentBean {

	public String speech;
	private List<FullfillmentMessageBean> messages;
	/**
	 * @return the speech
	 */
	public String getSpeech() {
		return speech;
	}
	/**
	 * @param speech the speech to set
	 */
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	/**
	 * @return the messages
	 */
	public List<FullfillmentMessageBean> getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<FullfillmentMessageBean> messages) {
		this.messages = messages;
	}
	
	
}
