package main;

import java.sql.SQLException;

import database.Connector;
import gui.*;

public class Main 
{
	public static void main(String[] args) throws SQLException
	{
		Connector connecting = new Connector();
		connecting.getConnection();
		Dashboard begin = new Dashboard();
		begin.start();
	}
}
