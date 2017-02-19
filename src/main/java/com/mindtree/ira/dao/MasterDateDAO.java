/**
 * 
 */
package com.mindtree.ira.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.ira.entity.MasterDate;
import com.mindtree.ira.entity.PropertyAmenity;
import com.mindtree.ira.entity.PropertyInfo;

/**
 * @author M1031960
 *
 */
public class MasterDateDAO {
	
	public MasterDate getMasterDate(){
		
		MasterDate masterDate=new MasterDate();
		String query = "SELECT master_date FROM master_date";
		
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				masterDate.setMasterDate(rs.getDate("master_date"));
			}
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
		return masterDate;
	}
	
	public PropertyInfo getPropertyInfo(String propertyCode) {
		PropertyInfo propertyInfo = new PropertyInfo();
		String query = "SELECT PROPERTY_ID, PROPERTY_CODE,PROPERTY_NAME,PROPERTY_GEO_COORDINATES FROM property_info where PROPERTY_CODE= '"
				+ propertyCode + "'";

		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				propertyInfo.setPropertyCode(rs.getString("PROPERTY_CODE"));
				propertyInfo.setPropertyGeoCoordinates(rs
						.getString("PROPERTY_GEO_COORDINATES"));
				propertyInfo.setPropertyId(rs.getInt("PROPERTY_ID"));
				propertyInfo.setPropertyName(rs.getString("PROPERTY_CODE"));
			}
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
		return propertyInfo;
	}
	
	public PropertyAmenity getPropertyAmenity(int propertyId,String amenity){
		PropertyAmenity propertyAmenity=new PropertyAmenity();
		String query = "SELECT AMENITY_ID,PROPERTY_ID,AMENITY_NAME,OPERATING_DAYS,OPEN_TIME,CLOSING_TIME FROM property_amenities where PROPERTY_ID= "
				+ propertyId + "and AMENITY_NAM E='"+amenity+"'";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				propertyAmenity.setAmenityId(rs.getInt("AMENITY_ID"));
				propertyAmenity.setAmenityName(rs.getString("AMENITY_NAME"));
				propertyAmenity.setClosingTime(rs.getTime("CLOSING_TIME"));
				propertyAmenity.setOpenTime(rs.getTime("OPEN_TIME"));
				propertyAmenity.setOperatingDays(rs.getString("OPERATING_DAYS"));
				propertyAmenity.setPropertyId(rs.getInt("PROPERTY_ID"));
			}
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

		return propertyAmenity;
	}
	
	private Statement getConnection() throws SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement stmt = conn.createStatement();
		return stmt;
	}
}
