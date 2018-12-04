package com.nc.unnati.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection()
	{
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/unnati"; //MySQL URL followed by the database name
	String username = "root"; //MySQL username
	String password = ""; //MySQL password
	try 
	{
	try 
	{
	Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers 
	} 
	catch (ClassNotFoundException e)
	{
	e.printStackTrace();
	}
	connection = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	System.out.println("Printing connection object "+connection);
	} 
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	return connection; 
	}
}
