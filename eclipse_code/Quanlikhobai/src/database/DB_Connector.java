package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connector 
{
	
	public static Connection getConnection(String dbURL, String userName, String passWord)
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, passWord);
			System.out.println("Connection successfully ...");
		} catch (Exception e)
		{
			System.out.println("Connection failure.");
            e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String args[]) 
	{
		
    }
    
}
