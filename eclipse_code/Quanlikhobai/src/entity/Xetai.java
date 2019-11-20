package entity;

public class Xetai extends Vehicle
{
	public Xetai() {}
	public Xetai(String bienSo, String loaiXe, int trongTai, int thoiGianGui)
	{
		super(bienSo, loaiXe, trongTai, thoiGianGui);
	}
	@Override
	public double tinhTongTienGui(int thoiGianGui) 
	{
		return thoiGianGui * 700000;
	}
}
