package entity;

public class Xecon extends Vehicle 
{
	@Override
	public double tinhTongTienGui(int thoiGianGui) 
	{
		if (thoiGianGui >= 24 && thoiGianGui <= 60) return thoiGianGui * 1000000 * 0.9;
		else if (thoiGianGui > 60 ) return thoiGianGui * 1000000 * 0.8;
		else return thoiGianGui * 1000000;
	}
}