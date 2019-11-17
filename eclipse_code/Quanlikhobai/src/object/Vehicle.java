package object;

public class Vehicle 
{
	private String bienSo, loaiXe, trongTai; 
	
	public Vehicle() {}
	public Vehicle(String bienSo, String loaiXe, String trongTai)
	{
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
		this.trongTai = trongTai;
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
	public String getTrongTai() {
		return trongTai;
	}
	public void setTrongTai(String trongTai) {
		this.trongTai = trongTai;
	}
}
