package util;

import java.util.Random;

/**
 * Lớp chứa các phương thức trong việc thay đổi dữ liệu csdl
 * @author hoang
 *
 */
public class Modify 
{
	private int randomMaKH;
	private int randomMaHD;
	Random rd = new Random();
	
	/**
	 * Phương thức lấy ngẫu nhiên giá trị số nguyên trong khoảng 100000
	 * @param randomMaKH
	 * @return
	 */
	public int randomMKH()
	{
		randomMaKH = rd.nextInt(100000);
		return randomMaKH;
	}
	
	/**
	 * Phương thức lấy ngẫu nhiên giá trị số nguyên trong khoản 100000
	 * @param randomMaHD
	 * @param value2
	 * @return
	 */
	public int randomMHD()
	{
		randomMaHD = rd.nextInt(100000);
		return randomMaHD;
	}
}
