/**
 * 
 */
package com.mindtree.ira.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author M1031960
 *
 */
public class ConsumptionDAO {
	
	
	public long getConsumptionAmount(int reservationConfoNumber) {
		long consumptionAmount=0;
		String query = "SELECT SUM(consumption_amount) as consumption FROM consumption_info WHERE RESERVATION_CONF_NO= "+reservationConfoNumber+"";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				consumptionAmount = rs.getInt("consumption");
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
		return consumptionAmount;
	}

	private Statement getConnection() throws SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement stmt = conn.createStatement();
		return stmt;
	}

	
}
