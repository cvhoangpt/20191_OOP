package entity.vehicle;

public class Xecon extends Vehicle 
{
	public Xecon() {}
	public Xecon(String bienSo, String loaiXe, int trongTai, int thoiGianGui)
	{
		super(bienSo, loaiXe, trongTai, thoiGianGui);
	}
	@Override
	public double tinhTongTienGui(int thoiGianGui) 
	{
		if (thoiGianGui >= 24 && thoiGianGui <= 60) return thoiGianGui * 1000000 * 0.9;
		else if (thoiGianGui > 60 ) return thoiGianGui * 1000000 * 0.8;
		else return thoiGianGui * 1000000;
	}
}