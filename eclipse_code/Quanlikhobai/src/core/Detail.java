package core;

//import core.Brief;
class KhachHang extends Nguoi
{
	private String diaChi, ngayCapCMND, noiCapCMND, thuDienTu;
	private int soCMND;
	
	public KhachHang() {}
	public KhachHang(String ten, String diaChi, int SDT, int soCMND, String ngayCapCMND, String noiCapCMND, String thuDienTu)
	{
		super(ten, SDT);
		this.diaChi = diaChi;
		this.soCMND = soCMND;
		this.ngayCapCMND = ngayCapCMND;
		this.noiCapCMND = noiCapCMND;
		this.thuDienTu = thuDienTu;
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

class NhanVien extends Nguoi
{
	private String chucVu;
	
	public NhanVien() {}
	public NhanVien(String ten, String chucVu, int SDT)
	{
		super(ten, SDT);
		this.chucVu = chucVu;
	}
	
	public void setTen(String ten)
	{
		this.ten = ten;
	}
	public String getTen()
	{
		return ten;
	}
	
	public String getChucVu() 
	{
		return chucVu;
	}
	public void setChucVu(String chucVu) 
	{
		this.chucVu = chucVu;
	}
	
	public int getSDT()
	{
		return SDT;
	}
	public void setSDT(int SDT)
	{
		this.SDT = SDT;
	}
}

class Xecon extends Phuongtien
{
	
}

class Xetai extends Phuongtien
{
	
}
class Hopdong
{
	
}

class Ve
{
	
}
public class Detail 
{

}
