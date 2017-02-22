/**
 * 
 */
package com.mindtree.ira.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author M1031960
 *
 */
public class DBUtil {

	public static Connection getDBConnection() {

		Connection conn = null;
		try {
			String dbUrl = System.getenv("JDBC_DATABASE_URL");
			System.out.println("dbUrl" + dbUrl);
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrgenei?reconnect=true&user=root&password=Welcome123");
			conn = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
