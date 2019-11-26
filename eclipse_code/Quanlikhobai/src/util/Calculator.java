package util;

import java.sql.SQLException;

import database.processing.FormRender;

/**
 * Lớp chứa các phương thức tính toán
 * @author hoang
 *
 */
public class Calculator 
{
	/**
	 * Phương thức đếm số xe đang gửi trong bãi
	 * @return
	 * @throws SQLException
	 */
	public int calVehicle() throws SQLException
	{
		int countXe;
		FormRender oe = new FormRender();
		
		countXe = oe.sumVehicle().getInt("COUNT(Bienso)");
		return countXe;
	}
}
