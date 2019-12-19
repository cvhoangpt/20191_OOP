package entity.vehicle;

public class Xetai extends Vehicle
{
	public Xetai() {}
	public Xetai(String bienSo, String loaiXe, int trongTai, int thoiGianGui)
	{
		super(bienSo, loaiXe, trongTai, thoiGianGui);
	}
	//overloading
	public double donGia(int trongTai)
	{
		return 700000;
	}
	//overloading
	public double tinhTongTienGui(int trongTai) 
	{
		return trongTai * 700000;
	}
}
