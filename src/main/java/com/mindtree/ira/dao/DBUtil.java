/**
 * 
 */
package com.mindtree.ira.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;

/**
 * @author M1031960
 *
 */
public class DBUtil {
	
	public static Connection getDBConnection(){
		
		URI dbUri;
		try {
			dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
			
			 String username = dbUri.getUserInfo().split(":")[0];
		        String password = dbUri.getUserInfo().split(":")[1];
		        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

		        System.out.println("Username:"+ username);
		        System.out.println("password:"+ password);
		        System.out.println("dbUrl:"+ dbUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
		
		return null;
	}

}
