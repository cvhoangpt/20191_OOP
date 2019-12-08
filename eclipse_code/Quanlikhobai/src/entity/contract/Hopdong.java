package entity.contract;

import entity.user.Khachhang;
import entity.vehicle.*;

/**
 * Lớp khai báo đối tượng Hợp đồng
 * @author hoangcv
 *
 */
public class Hopdong 
{
	private String cachThanhToan;
	private Khachhang kh;
	private Xecon xeCon;
	private Xetai xeTai;

	public Hopdong() {}
	public Hopdong(Khachhang kh, Xecon xeCon, Xetai xeTai) 
	{
		this.kh = kh;
		this.xeCon = xeCon;
		this.xeTai = xeTai;
	}
	public Hopdong(String cachThanhToan)
	{
		kh = new Khachhang();
		xeCon = new Xecon();
		xeTai = new Xetai();
		this.cachThanhToan = cachThanhToan;
	}
	
	public String getHinhThucThanhToan() {
		return cachThanhToan;
	}
	public void setHinhThucThanhToan(String cachThanhToan) {
		this.cachThanhToan = cachThanhToan;
	}
	
}
