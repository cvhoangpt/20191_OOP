package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connector 
{
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	
	public static Connection getConnection(String dbURL, String userName, String passWord)
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, passWord);
			System.out.println("Connection successfully ...");
		} catch (Exception e)
		{
			System.out.println("Connection failure.");
            e.printStackTrace();
		}
		return conn;
	}
	/*
	public static void main(String args[]) 
	{
		try 
		{   
	        Connection conn = getConnection(DB_URL, USERNAME, PASSWORD);
	        // crate statement
	        Statement stmt = conn.createStatement();
	        // get data from table 'student'
	        ResultSet rs = stmt.executeQuery("select * from student");
	        // show data
	        while (rs.next()) {
	            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        }
	        // close connection
	        conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
