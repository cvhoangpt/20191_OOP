package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import gui.Dialog;
import net.proteanit.sql.DbUtils;

/**
 * Lớp chứa các câu truy vấn liên quan đến việc tìm kiếm
 * @author hoang
 *
 */
public class SearchEntity extends Connector
{
	/**
	 * Phương thức truy vấn tìm kiếm theo tên chủ xe
	 * @param table
	 * @param tcx
	 */
	public void tcxSearchResult(JTable table, String tcx)
	{
		String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND khach_hang.TenKH = '"+tcx+"')";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlSR);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e)
		{
			Dialog d = new Dialog();
			d.dbError();
			e.printStackTrace();
		}
	}
	
	/**
	 * Phương thức truy vấn tìm kiếm theo biển số xe
	 * @param table
	 * @param bs
	 */
	public void bsSearchResult(JTable table, String bs)
	{
		String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND xe.Bienso = '"+bs+"')";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlSR);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e)
		{
			Dialog d = new Dialog();
			d.dbError();
			e.printStackTrace();
		}
	}
	
	/**
	 * Phương thức truy vấn tìm kiếm theo loại xe
	 * @param table
	 * @param lx
	 */
	public void lxSearchResult(JTable table, String lx)
	{
		String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND xe.Loaixe = '"+lx+"')";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlSR);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e)
		{
			Dialog d = new Dialog();
			d.dbError();
			e.printStackTrace();
		}
	}
}
