package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import gui.Dialog;

public class Connector 
{
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private Connection conn;
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
        	JOptionPane.showMessageDialog(window.getFrame(), "Kiểm tra lại kết nối hoặc truy vấn.", 
        			"Lỗi Cơ sở dữ liệu",
        			JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            System.exit(0);
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
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
