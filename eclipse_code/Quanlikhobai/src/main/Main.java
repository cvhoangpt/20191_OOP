package main;

import java.sql.SQLException;

import database.Connector;
import gui.*;

/**
 * Lớp chứa khối điều khiển bắt đầu của chương trình
 * Bắt đầu bằng việc gọi phương thức Lazy Initialization
 * @author hoangcv
 *
 */
public class Main 
{
	public static void main(String[] args) throws SQLException
	{
		Connector.getInstance();

		//Modify m = new Modify();
		//System.out.println(m.randomMHD() + " " + m.randomMKH());
		
		Dashboard begin = new Dashboard();
		begin.startDashboard();
	}
}