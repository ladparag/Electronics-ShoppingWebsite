package com.electronicshop.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DbConnection {
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			
		Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","");
		return con;
		}
		catch(ClassNotFoundException e)
		{
		e.printStackTrace();
		return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		
		Connection con=getConnection();
		if(con!=null)
		{
			System.out.println("connection established");
		}
		else
		{
			System.out.println("connection fail");
		}
		
		// TODO Auto-generated method stub

	}

}
