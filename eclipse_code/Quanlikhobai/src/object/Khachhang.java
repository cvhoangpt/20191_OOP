package object;

/**
 * Lớp khai báo đối tượng khách hàng
 * 
 * @author hoangcv
 *
 */
public class Khachhang extends Human
{
	private String diaChi, ngayCapCMND, noiCapCMND, thuDienTu;
	private int SDT, soCMND;
	public static int countKH = 0;
	public Khachhang() {}
	public Khachhang(String ten, String diaChi, int SDT, int soCMND, String thuDienTu)
	{
		super(ten);
		this.SDT = SDT;
		this.diaChi = diaChi;
		this.soCMND = soCMND;
		this.thuDienTu = thuDienTu;
		countKH++;
	}
	
	public void setTen(String ten)
	{
		this.ten = ten;
	}
	public String getTen()
	{
		return ten;
	}
	
	public void setDiaChi(String diaChi)
	{
		this.diaChi = diaChi;
	}
	public String getDiaChi()
	{
		return diaChi;
	}
	
	public void setSDT(int SDT)
	{
		this.SDT = SDT;
	}
	public int getSDT()
	{
		return SDT;
	}
	
	public void setSoCMND(int soCMND)
	{
		this.soCMND = soCMND;
	}
	public int getSoCMND()
	{
		return soCMND;
	}
	
	public void setNgayCapCMND(String ngayCapCMND)
	{
		this.ngayCapCMND = ngayCapCMND;
	}
	public String getNgayCapCMND()
	{
		return ngayCapCMND;
	}
	
	public void setNoiCapCMND(String noiCapCMND)
	{
		this.noiCapCMND = noiCapCMND;
	}
	public String getNoiCapCMND()
	{
		return noiCapCMND;
	}
	
	public void setThuDienTu(String thuDienTu)
	{
		this.thuDienTu = thuDienTu;
	}
	public String getThuDienTu()
	{
		return thuDienTu;
	}
}