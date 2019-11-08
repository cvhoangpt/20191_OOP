package core;

class Nguoi
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
	protected String bienSo, hangXe, mauSac, loaiXe;
	public Phuongtien() {}
	public Phuongtien(String bienSo, String hangXe, String mauSac, String loaiXe)
	{
		this.bienSo = bienSo;
		this.hangXe = hangXe;
		this.mauSac = mauSac;
		this.loaiXe = loaiXe;
	}
	
	public abstract String getLoaiXe();
}


public class Brief 
{
	
}
