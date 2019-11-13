package main;

import database.Connector;
import gui.*;

public class Main 
{
	public static void main(String[] args)
	{
		Connector connecting = new Connector();
		connecting.getConnection();
		Dashboard begin = new Dashboard();
		begin.start();
	}
}
