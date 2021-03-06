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
import com.mindtree.ira.entity.ReservationInfo;

/**
 * @author M1031960
 *
 */
public class ReservationDAO {
	
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		String query = "SELECT CUST_ID, CUST_FNAME, CUST_LNAME, CUST_EMAIL, CUST_GENDER FROM CUSTOMER_INFO LIMIT 25";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String customerId = rs.getString("CUST_ID");
				String customerFirstName = rs.getString("CUST_FNAME");
				String customerLastName = rs.getString("CUST_LNAME");
				String customerEmail = rs.getString("CUST_EMAIL");
				String customerGender = rs.getString("CUST_GENDER");

				customers.add(new Customer(customerId, customerFirstName,
						customerLastName, customerEmail, customerGender));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.getConnection().close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customers;
	}

	private Statement getConnection() throws SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement stmt = conn.createStatement();
		return stmt;
	}

	public String getCustomerName(String custId) {
		String customerName = null;
		String query = "SELECT CUST_FNAME FROM CUSTOMER_INFO LIMIT 25";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				customerName = rs.getString("CUST_FNAME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.getConnection().close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerName;
	}
	
	public ReservationInfo getReservtionInfo(String custId) {
		ReservationInfo reservationInfo = new ReservationInfo();
		String query = "SELECT RESERVATION_CONF_NO, ARRIVAL_DATE, CHECKIN_DATETIME, CHECKOUT_DATETIME, CUSTOMER_ID  from RESERVATION_INFO WHERE CUSTOMER_ID = '"
				+ custId + "' LIMIT 25";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				reservationInfo.setCheckoutDatetime(rs.getTimestamp("CHECKOUT_DATETIME"));
				reservationInfo.setArrivalDate(rs.getDate("ARRIVAL_DATE"));
				reservationInfo.setCheckinDatetime(rs.getDate("CHECKIN_DATETIME"));
				reservationInfo.setCustomerId(rs.getString("CUSTOMER_ID"));
				reservationInfo.setReservationConfNo(rs.getInt("RESERVATION_CONF_NO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.getConnection().close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reservationInfo;
	}
	
	public ReservationInfo getReservtionInfoByReservationId(int reservationId) {
		ReservationInfo reservationInfo = new ReservationInfo();
		String query = "SELECT RESERVATION_CONF_NO, ARRIVAL_DATE, CHECKIN_DATETIME, CHECKOUT_DATETIME, CUSTOMER_ID  from RESERVATION_INFO WHERE RESERVATION_CONF_NO = " + reservationId + "";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				reservationInfo.setCheckoutDatetime(rs.getTimestamp("CHECKOUT_DATETIME"));
				reservationInfo.setArrivalDate(rs.getDate("ARRIVAL_DATE"));
				reservationInfo.setCheckinDatetime(rs.getDate("CHECKIN_DATETIME"));
				reservationInfo.setCustomerId(rs.getString("CUSTOMER_ID"));
				reservationInfo.setReservationConfNo(rs.getInt("RESERVATION_CONF_NO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.getConnection().close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reservationInfo;
	}
	
	

}
