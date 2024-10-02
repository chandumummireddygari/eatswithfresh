package com.foodapp.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactory {

	private static Connection con=null;

	public static Connection  requestConnection() throws SQLException, ClassNotFoundException 
	
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp","root","chandu@16");
		System.out.println("yes");
		return con;
	}
}
