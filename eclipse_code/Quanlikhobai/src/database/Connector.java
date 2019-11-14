package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import gui.Dialog;

public class Connector
{
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	protected Connection conn;
	private static Connector instance;
	
	public Connector()
	{
		try 
		{   
			Class.forName("com.mysql.cj.jdbc.Driver");
	        this.conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	        System.out.println("Connection successfully ...");
	        
        } catch (ClassNotFoundException e)
		{
        	System.out.println(e);
		} catch (SQLException e) 
		{
        	Dialog window = new Dialog();
        	window.SQLError();
            e.printStackTrace();
            System.exit(0);
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	@SuppressWarnings("unused")
	private static Connector getInstance() throws SQLException
	{
		if (instance == null)
		{
			instance = new Connector();
		}
		else if (instance.getConnection().isClosed())
		{
			instance = new Connector();
		}
		return instance;
	}
}
