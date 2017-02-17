/**
 * 
 */
package com.mindtree.ira.response.bean;

import java.util.List;
import java.util.Map;

/**
 * @author M1031960
 *
 */
public class AgentResponseResultBean {
	
	private String source;
	private String resolvedQuery;
	private String action;
	private boolean actionIncomplete;
	private Map<String, Object> parameters;
	private List<AgentContextBean> contexts;
	private AgentFullfillmentBean fulfillment;
	private float score;
	private AgentResponseMetadata metadata;
	private String speech;
	
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the resolvedQuery
	 */
	public String getResolvedQuery() {
		return resolvedQuery;
	}
	/**
	 * @param resolvedQuery the resolvedQuery to set
	 */
	public void setResolvedQuery(String resolvedQuery) {
		this.resolvedQuery = resolvedQuery;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the actionIncomplete
	 */
	public boolean isActionIncomplete() {
		return actionIncomplete;
	}
	/**
	 * @param actionIncomplete the actionIncomplete to set
	 */
	public void setActionIncomplete(boolean actionIncomplete) {
		this.actionIncomplete = actionIncomplete;
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
	 * @return the contexts
	 */
	public List<AgentContextBean> getContexts() {
		return contexts;
	}
	/**
	 * @param contexts the contexts to set
	 */
	public void setContexts(List<AgentContextBean> contexts) {
		this.contexts = contexts;
	}
	/**
	 * @return the fulfillment
	 */
	public AgentFullfillmentBean getFulfillment() {
		return fulfillment;
	}
	/**
	 * @param fulfillment the fulfillment to set
	 */
	public void setFulfillment(AgentFullfillmentBean fulfillment) {
		this.fulfillment = fulfillment;
	}
	/**
	 * @return the score
	 */
	public float getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(float score) {
		this.score = score;
	}
	/**
	 * @return the metadata
	 */
	public AgentResponseMetadata getMetadata() {
		return metadata;
	}
	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(AgentResponseMetadata metadata) {
		this.metadata = metadata;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	
	

}
