package core;

abstract class Nguoi
{
	protected String ten;
	protected int SDT;
	public Nguoi() {}
	public Nguoi(String ten, int SDT)
	{
		this.ten = ten;
		this.SDT = SDT;
	}
}

abstract class Phuongtien
{
	protected String bienSo, hangXe, mauSac;
	public Phuongtien() {}
	public Phuongtien(String bienSo, String hangXe, String mauSac)
	{
		this.bienSo = bienSo;
		this.hangXe = hangXe;
		this.mauSac = mauSac;
	}
}


public class Brief 
{
	
}
