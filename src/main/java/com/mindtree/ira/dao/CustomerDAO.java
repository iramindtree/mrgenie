/**
 * 
 */
package com.mindtree.ira.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.ira.entity.Customer;

/**
 * @author M1031960
 *
 */
public class CustomerDAO {
	
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		String query = "SELECT CUST_ID, CUST_FNAME, CUST_LNAME, CUST_EMAIL, CUST_GENDER FROM CUSTOMER_INFO LIMIT 25";
		try{
			Connection conn = DBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String customerId = rs.getString("CUST_ID");
				String customerFirstName = rs.getString("CUST_FNAME");
				String customerLastName = rs.getString("CUST_LNAME");
				String customerEmail = rs.getString("CUST_EMAIL");
				String customerGender = rs.getString("CUST_GENDER");
				
				customers.add(new Customer(customerId, customerFirstName, customerLastName, customerEmail, customerGender));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return customers;
	}

}
