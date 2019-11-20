package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import entity.Hopdong;
import entity.Khachhang;
import entity.*;
import gui.Dialog;
import net.proteanit.sql.DbUtils;

/**
 * Lớp chứa các truy vấn khác
 * @author hoangcv
 *
 */
public class OtherQuery extends Connector
{
	Dialog dialog = new Dialog();
	Khachhang khachHang = null;
	Hopdong hopDong = null;
	Xecon xeCon = null;
	Xetai xeTai = null;
	private static String tenChuXe;
	private static int soDienThoai;
	private static String diaChi;
	private static String thuDienTu;
	private static int soCMND;
	private static String bienSo;
	private static int trongTai;
	private static int thoiGianGui;
	private static String cachThanhToan;
	private static String loaiXe;
	/**
	 * Phương thức truy vấn trích xuất csdl và làm mới table
	 * @param table
	 * @throws SQLException
	 */
	public void refreshTable(JTable table) throws SQLException
	{
		String sqlUpdateTable = 
	"SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe " + 
	"FROM khach_hang, hop_dong, xe " + 
	"WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso)";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlUpdateTable);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e)
		{
			dialog.databaseError();
			e.printStackTrace();
		}
	}
	
	/**
	 * Phương thức lấy dữ liệu theo cú click chuột của hàng bất kì trong bảng
	 * @param rowBienSo
	 * @param textFieldTCX
	 * @param textFieldSDT
	 * @param textFieldDC
	 * @param textFieldTDT
	 * @param textFieldCMT
	 * @param textFieldBS
	 * @param textFieldTT
	 * @param textFieldTGG
	 * @param textFieldCTT
	 * @param comboBoxLX
	 */
	//JTextField textFieldTCX, JTextField textFieldSDT, JTextField textFieldDC, JTextField textFieldTDT, JTextField textFieldCMT, JTextField textFieldBS, JTextField textFieldTT, JTextField textFieldTGG, JTextField textFieldCTT, JComboBox comboBoxLX
	public void selectRow(String rowBienSo)
	{
		String sqlSR = 
	"SELECT kh.TenKH, kh.DiaChi, kh.SDT, kh.SoCMND, kh.ThuDienTu, hd.Hinhthucthanhtoan, hd.Thoigiangui, x.Bienso, x.Loaixe, x.Trongtai\r\n" + 
	"FROM khach_hang kh "+ 
	"JOIN hop_dong hd ON kh.MaKH = hd.MaKH " + 
	"JOIN xe x ON x.Bienso = hd.Bienso " + 
	"WHERE x.Bienso = '"+rowBienSo+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlSR);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				tenChuXe = rs.getString("TenKH");
				soDienThoai = Integer.parseInt(rs.getString("SDT"));
				diaChi = rs.getString("DiaChi");
				thuDienTu = rs.getString("ThuDienTu");
				soCMND = Integer.parseInt(rs.getString("SoCMND"));
				bienSo = rs.getString("Bienso");
				trongTai = Integer.parseInt(rs.getString("Trongtai"));
				thoiGianGui = Integer.parseInt(rs.getString("Thoigiangui"));
				cachThanhToan = rs.getString("Hinhthucthanhtoan");
				loaiXe = rs.getString("Loaixe");
			}
			/*
			System.out.println(tenChuXe);
			System.out.println(soDienThoai);
			System.out.println(diaChi);
			System.out.println(thuDienTu);
			System.out.println(soCMND);
			System.out.println(bienSo);
			System.out.println(trongTai);
			System.out.println(thoiGianGui);
			System.out.println(cachThanhToan);
			System.out.println(loaiXe);
			
			
			
			
			*/
			rs.close();
			pst.close();
		} catch (Exception e)
		{
			dialog.databaseError();
			e.printStackTrace();
		}
	}
	
	public Khachhang getTextFieldKhachHang()
	{
		khachHang = new Khachhang(tenChuXe, diaChi, soDienThoai, soCMND, thuDienTu);
		return khachHang;
	}
	
	public Hopdong getTextFieldHopDong()
	{
		hopDong = new Hopdong(cachThanhToan);
		return hopDong;
	}
	
	public Xecon getTextFieldXeCon()
	{
		if (loaiXe == "Xe con") xeCon = new Xecon(bienSo, loaiXe, trongTai, thoiGianGui);
		else return null;
		//else if (loaiXe == "Xe tải") vehicle = new Xetai(bienSo, loaiXe, trongTai, thoiGianGui);
		return xeCon;
	}
	
	public Xetai getTextFieldXeTai()
	{
		if (loaiXe == "Xe tải") xeTai = new Xetai(bienSo, loaiXe, trongTai, thoiGianGui);
		else return null;
		return xeTai;
	}
	
	/**
	 * Phương thức truy vấn kiểm tra trùng biển số
	 * @param bienSo
	 * @return
	 */
	public boolean duplicateBienSo(String bienSo)
	{
		String dbssql =
	"SELECT * FROM xe WHERE Bienso=?";
		
		try
		{
			PreparedStatement pst = conn.prepareStatement(dbssql);
			pst.setString(1, bienSo);
			ResultSet rs = pst.executeQuery();
			int count = 0;
			while (rs.next()) count++;
			System.out.println("countDup="+count);
			if (count == 1) 
			{
				dialog.duplicateBienSo();
				return true;
			} 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Phương thức tính số xe đang gửi
	 * @return
	 */
	public ResultSet sumVehicle()
	{
		ResultSet rs = null;
		String sqlCV = "SELECT COUNT(Bienso) FROM xe";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlCV);
			rs = pst.executeQuery();
			rs.next();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
}
