package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionPostgres
{
	static String driverClassName="org.postgresql.Driver";
	static String username="vtlwxxntbwzycr";
	static String password="73a797736de23d9a731b68cc87b9095058357fab971998e60e460ec96bea1357";
	static String connectionUrl="jdbc:postgresql://ec2-52-44-166-58.compute-1.amazonaws.com:5432/d2f7efbh3nu7pv?sslmode=require";	

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
	public static void main(String[] args) {
		DBConnectionPostgres.getDBConnection();
	}
}
