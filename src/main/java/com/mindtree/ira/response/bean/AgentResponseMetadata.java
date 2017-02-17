/**
 * 
 */
package com.mindtree.ira.response.bean;

/**
 * @author M1031960
 *
 */
public class AgentResponseMetadata {

	private String intentId;
	private String webhookUsed;
	private String webhookForSlotFillingUsed;
	private String intentName;
	/**
	 * @return the intentId
	 */
	public String getIntentId() {
		return intentId;
	}
	/**
	 * @param intentId the intentId to set
	 */
	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}
	/**
	 * @return the webhookUsed
	 */
	public String getWebhookUsed() {
		return webhookUsed;
	}
	/**
	 * @param webhookUsed the webhookUsed to set
	 */
	public void setWebhookUsed(String webhookUsed) {
		this.webhookUsed = webhookUsed;
	}
	/**
	 * @return the webhookForSlotFillingUsed
	 */
	public String getWebhookForSlotFillingUsed() {
		return webhookForSlotFillingUsed;
	}
	/**
	 * @param webhookForSlotFillingUsed the webhookForSlotFillingUsed to set
	 */
	public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
		this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
	}
	/**
	 * @return the intentName
	 */
	public String getIntentName() {
		return intentName;
	}
	/**
	 * @param intentName the intentName to set
	 */
	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}
	
	
}
