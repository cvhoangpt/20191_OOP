package main;

import java.sql.SQLException;

import database.Connector;
import gui.*;

public class Main 
{
	public static void main(String[] args) throws SQLException
	{
		Connector.getInstance();

		Dashboard begin = new Dashboard();
		begin.start();
	}
}