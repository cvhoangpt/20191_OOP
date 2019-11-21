package entity.vehicle;

/**
 * Lớp khai báo đối tượng Vehicle
 * @author hoang
 *
 */
public abstract class Vehicle 
{
	protected String bienSo, loaiXe; 
	protected int trongTai, thoiGianGui;
	public static int countXe = 0;
	public Vehicle() {}
	public Vehicle(String bienSo, String loaiXe, int trongTai, int thoiGianGui)
	{
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
		this.trongTai = trongTai;
		this.thoiGianGui = thoiGianGui;
		countXe++;
	}
	
	public abstract double tinhTongTienGui(int thoiGianGui);
	
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
	public int getTrongTai() {
		return trongTai;
	}
	public void setTrongTai(int trongTai) {
		this.trongTai = trongTai;
	}
	public int getThoiGianGui() {
		return thoiGianGui;
	}
	public void setThoiGianGui(int thoiGianGui) {
		this.thoiGianGui = thoiGianGui;
	}
}
