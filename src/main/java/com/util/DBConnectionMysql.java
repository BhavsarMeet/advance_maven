package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionMysql 
{	
	static String driverClassName="com.mysql.cj.jdbc.Driver";
	static String username="root";
	static String password="root";
	static String connectionUrl="jdbc:mysql://localhost:3306/advance_java";	

	public static Connection getDBConnection()
	{
		Connection conn=null;
		
		try {
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(connectionUrl, username, password);
			
			if(conn!=null)
			{
				System.out.println("connected...");	
			}
			else
			{
				System.out.println("Connection Incomplete...");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	
	}

}	
