package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import core.Modify;

//import java.sql.Statement;

import gui.*;
import net.proteanit.sql.DbUtils;

/**
 * Chứa các liên kết thực thể và truy vấn
 * @author hoang
 *
 */
public class Query extends Connector 
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
		try
		{
			String sqlUpdateTable = 
	"SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, hop_dong.Thoigiangui, xe.Trongtai FROM khach_hang, hop_dong, xe, bang_gia WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso)";
			
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
	public void insertHD() throws SQLException
	{
		Dialog d = new Dialog();
		Modify m = new Modify();
		try
		{
			//Khối chèn bảng khach_hang
			String sqlInsertHD1 = 
	"INSERT INTO khach_hang (TenKH, DiaChi, SDT, SoCMND, ThuDienTu) VALUES (?,?,?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(sqlInsertHD1);
			pst1.setString(1, Dashboard.tcx);
			pst1.setString(2, Dashboard.dc);
			pst1.setInt(3, Dashboard.sdt);
			pst1.setInt(4, Dashboard.cmt);
			pst1.setString(5, Dashboard.tdt);
			pst1.executeUpdate();
			//---
			
			//Khối chèn bảng xe
			String sqlInsertHD2 = 
	"INSERT INTO xe (Bienso, Loaixe, Trongtai) VALUES (?,?,?)";
			PreparedStatement pst2 = conn.prepareStatement(sqlInsertHD2);
			pst2.setString(1, Dashboard.bs);
			pst2.setString(2, Dashboard.lx);
			pst2.setString(3, Dashboard.tt);
			pst2.executeUpdate();
			//--
			
			//Khối chèn bảng hop_dong
			String sqlInsertHD3 = 
	"INSERT INTO hop_dong (Hinhthucthanhtoan, Thoigiangui, Bienso) VALUES (?,?,?)";
			PreparedStatement pst3 = conn.prepareStatement(sqlInsertHD3);
			pst3.setString(1, Dashboard.ctt);
			pst3.setString(2, Dashboard.tgg);
			pst3.setString(3, Dashboard.bs);
			pst3.executeUpdate();
			//---
			
			//Khối khác
			String value1 = String.valueOf(m.randomMKH());
			String sqlInsertOther1 =
	"INSERT INTO khach_hang MaKH VALUES ?";
			PreparedStatement pst4 = conn.prepareStatement(sqlInsertOther1);
			pst4.setString(1, value1);
			pst4.executeUpdate();
			
			String sqlInsertOther2 =
	"INSERT INTO hop_dong MaKH VALUES ?";
			PreparedStatement pst5 = conn.prepareStatement(sqlInsertOther2);
			pst5.setString(1, value1);
			pst5.executeUpdate();
			
			String value2 = String.valueOf(m.randomMaHD);
			String sqlInsertOther3 =
	"INSERT INTO hop_dong MaHD VALUES ?";
			PreparedStatement pst6 = conn.prepareStatement(sqlInsertOther3);
			pst6.setString(1, value2);
			
			
			//---
			d.dataSave();
		} catch(Exception e)
		{
			d.dbError();
			e.printStackTrace();
		}
	}
}