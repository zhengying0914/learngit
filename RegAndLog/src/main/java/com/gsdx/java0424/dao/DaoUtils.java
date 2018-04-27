package com.gsdx.java0424.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DaoUtils {
	private static Connection connect;

	public static Connection getConn() {
		try {  
		      Class.forName("com.mysql.jdbc.Driver");     //¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò     
		    }  
		    catch (Exception e) {  
		      e.printStackTrace();  
		    }  
		    try {  
		    		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb","root","123456");   
		    }  
		    catch (Exception e) {  
		      e.printStackTrace();  
		    }
			return connect;  
		  }  
}
