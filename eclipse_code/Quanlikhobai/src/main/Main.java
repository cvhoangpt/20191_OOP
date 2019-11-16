package main;

import java.sql.SQLException;

import database.Connector;
import gui.*;

/**
 * Lớp chứa khối điều khiển bắt đầu của chương trình
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