package main;

import java.awt.EventQueue;

import database.Connector;
import gui.Dashboard;

public class Main 
{
	public static void main(String[] args)
	{
		Connector c = new Connector();
		c.getConnection();
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
