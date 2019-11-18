package util;

import java.sql.SQLException;

import database.OtherEntity;

public class Calculate 
{
	public int calVehicle() throws SQLException
	{
		int countXe;
		OtherEntity oe = new OtherEntity();
		
		countXe = oe.sqlCalVehicle().getInt("COUNT(Bienso)");
		return countXe;
	}
}
