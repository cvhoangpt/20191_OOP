package core;

import java.util.Random;

public class Modify 
{
	public int randomMaKH;
	public int randomMaHD;
	public int randomMKH()
	{
		Random rdMaKH = new Random();
		randomMaKH = rdMaKH.nextInt(10000);
		return randomMaKH;
	}
	
	public int randomMHD()
	{
		Random rdMaHD = new Random();
		randomMaHD = rdMaHD.nextInt(10000);
		return randomMaHD;
	}
}
