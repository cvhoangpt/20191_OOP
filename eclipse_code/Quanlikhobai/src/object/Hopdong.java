package object;

public class Hopdong 
{
	private String hinhThucThanhToan;
	private String thoiGianGui;
	
	public Hopdong() {}
	public Hopdong(String hinhThucThanhToan, String thoiGianGui)
	{
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.thoiGianGui = thoiGianGui;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getThoiGianGui() {
		return thoiGianGui;
	}
	public void setThoiGianGui(String thoiGianGui) {
		this.thoiGianGui = thoiGianGui;
	}
}
