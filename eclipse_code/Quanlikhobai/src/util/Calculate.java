package util;

import java.sql.SQLException;

import database.OtherEntity;

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
		OtherEntity oe = new OtherEntity();
		
		countXe = oe.sqlCalVehicle().getInt("COUNT(Bienso)");
		return countXe;
	}
}
