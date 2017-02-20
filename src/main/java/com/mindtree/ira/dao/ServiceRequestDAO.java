/**
 * 
 */
package com.mindtree.ira.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.mindtree.ira.entity.ServiceRequest;

/**
 * @author M1031960
 *
 */
public class ServiceRequestDAO {
	
	public void insertServiceRequest(ServiceRequest serviceRequest) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateCurrent=simpleDateFormat.format(serviceRequest.getExecutionTime());
		String query = "INSERT INTO service_request(SERVICE_REQUEST_ID,CUSTOMER_ID,PROPERTY_ID,ROOM_NO,DEPARTMENT_ID,REQUEST_DESC,REQUEST_STATUS,EXECUTION_TIME) VALUES ('"+serviceRequest.getServiceRequestId()+"','"+serviceRequest.getCustomerId()+"',"+serviceRequest.getPropertyId()+",'"+serviceRequest.getRoomNo()+"','"+serviceRequest.getDepartmentId()+"','"+serviceRequest.getRequestDesc()+"','"+serviceRequest.getRequestStatus()+"','"+dateCurrent+"')";
		System.out.println(query);
		Statement stmt = null;
		try {
			stmt = getConnection();
			stmt.executeUpdate(query);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Statement getConnection() throws SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement stmt = conn.createStatement();
		return stmt;
	}
}
