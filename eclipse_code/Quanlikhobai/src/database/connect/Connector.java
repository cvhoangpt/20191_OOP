package database.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import gui.form.Dialog;

/**
 * Phương thức liên kết cơ sở dữ liệu thông qua Java Database Connectivity API.
 * Sử dụng cách khởi tạo Lazy initialization (đơn luồng) của mẫu thiết kế Singleton pattern.
 * @author hoangcv
 * @param DB_URL liên kết đến localhost qua JDBC
 * @param USERNAME tên người dùng (mặc định là root)
 * @param PASSWORD mật khẩu (bỏ trống)
 * @param conn đối tượng thuộc lớp Connection
 * @param instance đối tượng thuộc lớp Connector
 */
public class Connector
{
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	protected Connection conn;
	private static Connector instance;
	
	/**
	 * Hàm khởi tạo
	 */
	protected Connector()
	{
		try 
		{   
			Class.forName("com.mysql.cj.jdbc.Driver");
	        this.conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	        System.out.println("Connector notice: Connection successfully ...");
	        
        } catch (ClassNotFoundException e)
		{
        	System.out.println(e);
		} catch (SQLException e) 
		{
        	Dialog d = new Dialog();
        	d.databaseError();
            e.printStackTrace();
            System.exit(0);
		}
	}
	
	private Connection getConnection()
	{
		return conn;
	}
	
	/**
	 * Phương thức "khởi tạo lười biếng"
	 * @return instance
	 * @throws SQLException
	 */
	public static Connector getInstance() throws SQLException
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