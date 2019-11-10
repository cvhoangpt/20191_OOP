package main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import database.DB_Connector;
import gui.Dashboard;

public class Main 
{
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191?useLegacyDatetimeCode=false&serverTimezone=UTC";
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
	        //ResultSet rs = stmt.executeQuery("select * from student");
	        // show data
	        /*
	        while (rs.next()) 
	        {
	            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
	        }
	        // close connection
	        conn.close();
	        */
        } catch (Exception e) 
		{
        	Dashboard window = new Dashboard();
        	JOptionPane.showMessageDialog(window.getFrame(), "Kiểm tra lại kết nối hoặc truy vấn.", 
        			"Lỗi Cơ sở dữ liệu",
        			JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
	    
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Dashboard window = new Dashboard();
					window.getFrame().setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}
}