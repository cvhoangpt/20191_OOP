package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

//import java.sql.Statement;

import gui.*;
import net.proteanit.sql.DbUtils;
import util.Modify;

/**
 * Chứa các liên kết thực thể và truy vấn
 * @author hoang
 *
 */
public class EntityModify extends Connector 
{
	//ResultSet rs = null;
	//PreparedStatement pst = null;
	
	
	/**
	 * Phương thức truy vấn trích xuất csdl vào table
	 * @param table
	 * @throws SQLException
	 */
	public void updateTable(JTable table) throws SQLException
	{
		try
		{
			String sqlUpdateTable = 
	"SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe " + 
	"FROM khach_hang, hop_dong, xe " + 
	"WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso)";
			
			PreparedStatement pst = conn.prepareStatement(sqlUpdateTable);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e)
		{
			Dialog d = new Dialog();
			d.dbError();
			e.printStackTrace();
		}
	}
	
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
			e.printStackTrace();
		}
	}
	
	public void test() throws SQLException
	{
		System.out.println(Dashboard.tcx);
	}
	public void insertHD(String tcx, int sdt, int cmt, String dc, String tdt, String bs, String tt, String tgg, String ctt, String lx) throws SQLException
	{
		Dialog d = new Dialog();
		Modify m = new Modify();
		try
		{
			String value1 = "KH" + String.valueOf(m.randomMKH());
			String value2 = "HD" + String.valueOf(m.randomMHD());
			//Khối chèn bảng khach_hang
			String sqlInsertHD1 = 
	"INSERT INTO khach_hang (MaKH, TenKH, DiaChi, SDT, SoCMND, ThuDienTu) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(sqlInsertHD1);
			pst1.setString(1, value1);
			pst1.setString(2, tcx);
			pst1.setString(3, dc);
			pst1.setInt(4, sdt);
			pst1.setInt(5, cmt);
			pst1.setString(6, tdt);
			pst1.executeUpdate();
			//---
			
			//Khối chèn bảng xe
			String sqlInsertHD2 = 
	"INSERT INTO xe (Bienso, Loaixe, Trongtai) VALUES (?,?,?)";
			PreparedStatement pst2 = conn.prepareStatement(sqlInsertHD2);
			pst2.setString(1, bs);
			pst2.setString(2, lx);
			pst2.setString(3, tt);
			pst2.executeUpdate();
			//--
			
			//Khối chèn bảng hop_dong
			String sqlInsertHD3 = 
	"INSERT INTO hop_dong (MaHD, Hinhthucthanhtoan, Thoigiangui, MaKH, Bienso) VALUES (?,?,?,?,?)";
			PreparedStatement pst3 = conn.prepareStatement(sqlInsertHD3);
			pst3.setString(1, value2);
			pst3.setString(2, ctt);
			pst3.setString(3, tgg);
			pst3.setString(4, value1);
			pst3.setString(5, bs);
			pst3.executeUpdate();
			//---
			
			//Khối khác
			
			//---
			d.dataSave();
		} catch(Exception e)
		{
			d.duplicateBS();
			e.printStackTrace();
		}
	}
	
	public void deleteHD()
	{
		
	}
	
	@SuppressWarnings("rawtypes")
	public void selectRow(String rowBienSo, JTextField textFieldTCX, JTextField textFieldSDT, JTextField textFieldDC, JTextField textFieldTDT, JTextField textFieldCMT, JTextField textFieldBS, JTextField textFieldTT, JTextField textFieldTGG, JTextField textFieldCTT, JComboBox comboBoxLX)
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
				textFieldTCX.setText(rs.getString("TenKH"));
				textFieldSDT.setText(rs.getString("SDT"));
				textFieldDC.setText(rs.getString("DiaChi"));
				textFieldTDT.setText(rs.getString("ThuDienTu"));
				textFieldCMT.setText(rs.getString("SoCMND"));
				textFieldBS.setText(rs.getString("Bienso"));
				textFieldTT.setText(rs.getString("Trongtai"));
				textFieldTGG.setText(rs.getString("Thoigiangui"));
				textFieldCTT.setText(rs.getString("Hinhthucthanhtoan"));
				comboBoxLX.setSelectedItem(rs.getString("Loaixe"));
			}
		} catch (Exception e)
		{
			Dialog d = new Dialog();
			d.dbError();
			e.printStackTrace();
		}
		
	}
}