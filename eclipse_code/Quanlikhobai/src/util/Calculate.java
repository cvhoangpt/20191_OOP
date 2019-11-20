package util;

import java.sql.SQLException;

import database.OtherQuery;

/**
 * Lớp chứa các phương thức tính toán
 * @author hoang
 *
 */
public class Calculate 
{
	/**
	 * Phương thức đếm số xe đang gửi trong bãi
	 * @return
	 * @throws SQLException
	 */
	public int calVehicle() throws SQLException
	{
		int countXe;
		OtherQuery oe = new OtherQuery();
		
		countXe = oe.sumVehicle().getInt("COUNT(Bienso)");
		return countXe;
	}
}
