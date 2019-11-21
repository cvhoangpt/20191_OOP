package util;

import java.sql.SQLException;

import database.processing.FrameRender;

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
		FrameRender oe = new FrameRender();
		
		countXe = oe.sumVehicle().getInt("COUNT(Bienso)");
		return countXe;
	}
}
