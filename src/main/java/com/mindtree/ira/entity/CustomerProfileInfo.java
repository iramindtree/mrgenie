/**
 * 
 */
package com.mindtree.ira.entity;

/**
 * @author M1020374
 *
 */
public class CustomerProfileInfo {
	
	String customerId;
	String customerPrefType;
	String customerPrefSubType;
	String customerMilkPreferece;
	String customerSugarLevelPreference;
	String customerTemperaturePreference;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPrefType() {
		return customerPrefType;
	}
	public void setCustomerPrefType(String customerPrefType) {
		this.customerPrefType = customerPrefType;
	}
	public String getCustomerPrefSubType() {
		return customerPrefSubType;
	}
	public void setCustomerPrefSubType(String customerPrefSubType) {
		this.customerPrefSubType = customerPrefSubType;
	}
	public String getCustomerMilkPreferece() {
		return customerMilkPreferece;
	}
	public void setCustomerMilkPreferece(String customerMilkPreferece) {
		this.customerMilkPreferece = customerMilkPreferece;
	}
	public String getCustomerSugarLevelPreference() {
		return customerSugarLevelPreference;
	}
	public void setCustomerSugarLevelPreference(String customerSugarLevelPreference) {
		this.customerSugarLevelPreference = customerSugarLevelPreference;
	}
	public String getCustomerTemperaturePreference() {
		return customerTemperaturePreference;
	}
	public void setCustomerTemperaturePreference(
			String customerTemperaturePreference) {
		this.customerTemperaturePreference = customerTemperaturePreference;
	}

}
