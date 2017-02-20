/**
 * 
 */
package com.mindtree.ira.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.ira.entity.CustomerProfileInfo;

/**
 * @author M1031960
 *
 */
public class CustomerProfileInfoDAO {
	
	
	public CustomerProfileInfo getCustomerProfileInfo(String customerId) {
		CustomerProfileInfo customerProfileInfo = new CustomerProfileInfo();
		String query = "SELECT CUSTOMER_ID, CUSTOMER_PREFERECE_TYPE, CUSTOMER_PREFERENCE_SUBTYPE, CUSTOMER_MILK_REFERENCE, CUSTOMER_SUGER_LEVEL_PREFERENCE, CUSTOMER_TEMPERATURE_PREFERENCE FROM CUSTOMER_PROFILE_INFO where CUSTOMER_ID= '"
				+ customerId + "'";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				customerProfileInfo.setCustomerId(rs.getString("CUSTOMER_ID"));
				customerProfileInfo.setCustomerMilkPreferece(rs
						.getString("CUSTOMER_MILK_REFERENCE"));
				customerProfileInfo.setCustomerPrefSubType(rs
						.getString("CUSTOMER_PREFERECE_TYPE"));
				customerProfileInfo.setCustomerPrefType(rs
						.getString("CUSTOMER_PREFERECE_TYPE"));
				customerProfileInfo.setCustomerSugarLevelPreference(rs
						.getString("CUSTOMER_SUGER_LEVEL_PREFERENCE"));
				customerProfileInfo.setCustomerTemperaturePreference(rs
						.getString("CUSTOMER_TEMPERATURE_PREFERENCE"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
				stmt.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerProfileInfo;
	}

	private Statement getConnection() throws SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement stmt = conn.createStatement();
		return stmt;
	}

	
	
	

}
