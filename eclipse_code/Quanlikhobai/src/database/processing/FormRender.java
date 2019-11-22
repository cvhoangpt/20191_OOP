package database.processing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import database.connect.Connector;
import entity.contract.Hopdong;
import entity.user.*;
import entity.vehicle.Xecon;
import entity.vehicle.Xetai;
import gui.form.Dialog;
import net.proteanit.sql.DbUtils;

/**
 * Lớp chứa các truy vấn kết xuất giao diện
 * @author hoangcv
 *
 */
public class FormRender extends Connector
{
	Dialog dialog = new Dialog();
	Khachhang khachHang;
	Hopdong hopDong;
	Xecon xeCon;
	Xetai xeTai;
	private String tenChuXe;
	private int soDienThoai;
	private String diaChi;
	private String thuDienTu;
	private int soCMND;
	private String bienSo;
	private int trongTai;
	private int thoiGianGui;
	private String cachThanhToan;
	private String loaiXe;

	public static final String SQL_UPDATE_TABLE = 
			"SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe " + 
					"FROM khach_hang, hop_dong, xe " + 
					"WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso)";
	/**
	 * Phương thức truy vấn trích xuất csdl và làm mới table
	 * @param table
	 * @throws SQLException
	 */
	public void refreshTable(JTable table) throws SQLException
	{
		
		try
		{
			PreparedStatement pst = conn.prepareStatement(SQL_UPDATE_TABLE);
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
				System.out.println("bienSo="+bienSo);
				trongTai = Integer.parseInt(rs.getString("Trongtai"));
				thoiGianGui = Integer.parseInt(rs.getString("Thoigiangui"));
				cachThanhToan = rs.getString("Hinhthucthanhtoan");
				loaiXe = rs.getString("Loaixe");
				System.out.println("loaiXe="+loaiXe);
			}
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
		xeCon = new Xecon(bienSo, loaiXe, trongTai, thoiGianGui);
		return xeCon;
	}
	
	public Xetai getTextFieldXeTai()
	{
		xeTai = new Xetai(bienSo, loaiXe, trongTai, thoiGianGui);
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
