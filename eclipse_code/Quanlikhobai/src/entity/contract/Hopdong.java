package entity.contract;

/**
 * Lớp khai báo đối tượng Hợp đồng
 * @author hoangcv
 *
 */
public class Hopdong 
{
	private String cachThanhToan;

	public Hopdong() {}
	public Hopdong(String cachThanhToan)
	{
		this.cachThanhToan = cachThanhToan;
	}
	
	public String getHinhThucThanhToan() {
		return cachThanhToan;
	}
	public void setHinhThucThanhToan(String cachThanhToan) {
		this.cachThanhToan = cachThanhToan;
	}
	
}
