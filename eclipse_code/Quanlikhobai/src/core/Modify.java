package core;

import java.util.Random;

public class Modify 
{
	public int randomMaKH;
	public int randomMaHD;
	public int randomMKH()
	{
		Random rd = new Random();
		randomMaKH = rd.nextInt(10000);
		return randomMaKH;
	}
	
	public int randomMHD()
	{
		Random rd = new Random();
		randomMaHD = rd.nextInt(10000);
		return randomMaHD;
	}
}
