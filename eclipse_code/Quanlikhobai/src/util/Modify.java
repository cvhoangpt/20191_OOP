package util;

import java.util.Random;

public class Modify 
{
	private int randomMaKH;
	private int randomMaHD;
	Random rd = new Random();
	
	public int randomMKH()
	{
		randomMaKH = rd.nextInt(100000);
		return randomMaKH;
	}
	
	public int randomMHD()
	{
		randomMaHD = rd.nextInt(100000);
		return randomMaHD;
	}
}
