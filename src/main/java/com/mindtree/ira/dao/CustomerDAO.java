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
import com.mindtree.ira.entity.PmsReservationInfo;

/**
 * @author M1031960
 *
 */
public class CustomerDAO {
	
	
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
				stmt.close();
				stmt.getConnection().close();
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
		String query = "SELECT CUST_FNAME FROM CUSTOMER_INFO where CUST_ID= '"+custId+"'";
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
				stmt.close();
				stmt.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerName;
	}

	public PmsReservationInfo getReservationFromPMS(int reservationConformationNumber){
        PmsReservationInfo pmsReservationInfo = new PmsReservationInfo();
        String query = "SELECT RESERVATION_CONF_NO, ROOM_NUMBER, PROPERTY_ID from pms_reservation_info WHERE RESERVATION_CONF_NO = " + reservationConformationNumber + "";
        Statement stmt = null;
        try {
              stmt = getConnection();
              ResultSet rs = stmt.executeQuery(query);
              while (rs.next()) {
                    int reservationConfNumber = rs.getInt("RESERVATION_CONF_NO");
                    String roomNumber = rs.getString("ROOM_NUMBER");
                    String propertyId = rs.getString("PROPERTY_ID");
                    pmsReservationInfo.setPropertyId(propertyId);
                    pmsReservationInfo.setReservationConfNo(reservationConfNumber);
                    pmsReservationInfo.setRoomNumber(roomNumber);
              }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        } finally {
              try {
                    stmt.close();
                    stmt.getConnection().close();
              } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
              }
        }
        return pmsReservationInfo;
  }
	
	public int getCustomerReservationByDeviceId(String deviceId){
		PmsReservationInfo pmsReservationInfo = new PmsReservationInfo();
        String query = "SELECT DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO FROM CUSTOMER_DEVICE_INFO WHERE DEVICE_ID='"+deviceId+"'";
        Statement stmt = null;
        try {
              stmt = getConnection();
              ResultSet rs = stmt.executeQuery(query);
              if(rs.next())
            	  return rs.getInt("RESERVATION_CONF_NO");
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        } finally {
              try {
                    stmt.close();
                    stmt.getConnection().close();
              } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
              }
        }
		return 86904389;
	}

}
