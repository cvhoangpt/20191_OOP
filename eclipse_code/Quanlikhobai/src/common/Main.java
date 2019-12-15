package common;

import java.sql.SQLException;

//import database.connect.Connector;
import gui.form.Dashboard;

/**
 * Lớp chứa khối điều khiển bắt đầu của chương trình
 * Bắt đầu bằng việc gọi phương thức Lazy Initialization
 * @author hoangcv
 *
 */
public class Main 
{
	public static void main(String[] args)
	{
		//Connector.getInstance();
		try
		{
			Dashboard begin = new Dashboard();
			begin.startFrame();
		} catch (SQLException se)
		{
			se.printStackTrace();
		}
		
	}
}