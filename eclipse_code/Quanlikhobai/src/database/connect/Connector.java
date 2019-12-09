package database.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import gui.form.Dialog;

/**
 * Phương thức liên kết cơ sở dữ liệu thông qua Java Database Connectivity API.
 * Sử dụng cách khởi tạo Lazy initialization (đơn luồng) của mẫu thiết kế Singleton pattern.
 * @author hoangcv
 */
public class Connector
{
	/**
	 * Liên kết đến localhost qua JDBC
	 */
	private static String DB_URL = "jdbc:mysql://localhost:3306/oop20191?useLegacyDatetimeCode=false&serverTimezone=UTC";
	/**
	 * Tên người dùng (mặc định là root)
	 */
	private static String USERNAME = "root";
	/**
	 * Mật khẩu (bỏ trống)
	 */
	private static String PASSWORD = "";
	/**
	 * Đối tượng thuộc lớp Connection
	 */
	protected Connection conn;
	/**
	 * Đối tượng thuộc lớp Connector
	 */
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
	        //System.out.println("Connector notice: Connection successfully ...");
	        
        } catch (ClassNotFoundException e)
		{
        	System.out.println(e);
		} catch (SQLException e) 
		{
			System.err.print("Connector notice: Connection failed.");
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