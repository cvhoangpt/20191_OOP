package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DB_Connector;
public class Main 
{
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	public static void main(String[] args)
	{
		//DB_Connector dbc = new DB_Connector();
		try 
		{   
	        Connection conn = DB_Connector.getConnection(DB_URL, USERNAME, PASSWORD);
	        // crate statement
	        Statement stmt = conn.createStatement();
	        // get data from table 'student'
	        ResultSet rs = stmt.executeQuery("select * from student");
	        // show data
	        while (rs.next()) 
	        {
	            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
	        }
	        // close connection
	        conn.close();
        } catch (Exception e) 
		{
            e.printStackTrace();
        }
	    
	}
}