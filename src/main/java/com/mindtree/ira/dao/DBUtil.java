/**
 * 
 */
package com.mindtree.ira.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author M1031960
 *
 */
public class DBUtil {
	
	public static Connection getDBConnection(){
		
		Connection conn = null;
		URI dbUri;
		try {
				//dbUri = new URI(System.getenv("JDBC_DATABASE_URL"));
				
			 	/*String username = dbUri.getUserInfo().split(":")[0];
		        String password = dbUri.getUserInfo().split(":")[1];*/
		        String dbUrl = System.getenv("JDBC_DATABASE_URL");
		        System.out.println("dbUrl" + dbUrl);
		        
		        Class.forName("org.postgresql.Driver");
		        
		        conn = DriverManager.getConnection(dbUrl);
		        
		        System.out.println("Connection Established "+ conn.getSchema());
		        
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		return conn;
	}

}
