package main;

import java.sql.SQLException;

import database.connect.Connector;
import gui.form.Dashboard;

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
		Dashboard begin = new Dashboard();
		begin.startDashboard();
	}
}