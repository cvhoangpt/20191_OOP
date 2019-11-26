package entity.user;

/**
 * Lớp khai báo đối tượng khách hàng
 * 
 * @author hoangcv
 *
 */
public class Khachhang extends Human
{
	private String diaChi, thuDienTu;
	private int soDienThoai, soCMND;
	public static int countKH = 0;
	public Khachhang() {}
	public Khachhang(String tenChuXe, String diaChi, int soDienThoai, int soCMND, String thuDienTu)
	{
		super(tenChuXe);
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.soCMND = soCMND;
		this.thuDienTu = thuDienTu;
		countKH++;
	}
	
	public void setDiaChi(String diaChi)
	{
		this.diaChi = diaChi;
	}
	public String getDiaChi()
	{
		return diaChi;
	}
	
	public void setSoDienThoai(int soDienThoai)
	{
		this.soDienThoai = soDienThoai;
	}
	public int getSoDienThoai()
	{
		return soDienThoai;
	}
	
	public void setSoCMND(int soCMND)
	{
		this.soCMND = soCMND;
	}
	public int getSoCMND()
	{
		return soCMND;
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