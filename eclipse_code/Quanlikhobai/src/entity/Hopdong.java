package entity;

/**
 * Lớp khai báo đối tượng Hợp đồng
 * @author hoangcv
 *
 */
public class Hopdong 
{
	private String hinhThucThanhToan;
	
	
	public Hopdong() {}
	public Hopdong(String hinhThucThanhToan, String thoiGianGui)
	{
		this.hinhThucThanhToan = hinhThucThanhToan;
	
	}
	
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	
}
