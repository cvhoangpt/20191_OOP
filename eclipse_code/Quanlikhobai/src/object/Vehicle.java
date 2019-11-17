package object;

public class Vehicle 
{
	protected String bienSo, loaiXe;
	public Vehicle() {}
	public Vehicle(String bienSo, String loaiXe)
	{
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
	}
	
	public String getBienSo() {
		return bienSo;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
}
