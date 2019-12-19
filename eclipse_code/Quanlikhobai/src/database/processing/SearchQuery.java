package database.processing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JCheckBox;
import javax.swing.JTable;

import control.Search;
import database.connect.Connector;
import gui.form.Dialog;
import net.proteanit.sql.DbUtils;

/**
 * Lớp chứa các câu truy vấn liên quan đến việc tìm kiếm
 * @author hoang
 *
 */
public class SearchQuery extends Connector
{
	Search search = new Search();
	/**
	 * Phương thức truy vấn tìm kiếm theo tên chủ xe
	 * @param table
	 * @param tcx
	 */
	public void tenChuXeSearchResult(JTable table, JCheckBox checkBox, String tcx)
	{
		if (search.checkBoxChecked(checkBox))
		{
			String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe, hop_dong.Dongia, hop_dong.Sotien FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND khach_hang.TenKH = '"+tcx+"' AND hop_dong.Dongia > 2000000)";
			try
			{
				PreparedStatement pst = conn.prepareStatement(sqlSR);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e)
			{
				Dialog d = new Dialog();
				d.databaseError();
				e.printStackTrace();
			}
		} else
		{
			String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe, hop_dong.Dongia, hop_dong.Sotien FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND khach_hang.TenKH = '"+tcx+"')";
			try
			{
				PreparedStatement pst = conn.prepareStatement(sqlSR);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e)
			{
				Dialog d = new Dialog();
				d.databaseError();
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Phương thức truy vấn tìm kiếm theo biển số xe
	 * @param table
	 * @param bs
	 */
	public void bienSoSearchResult(JTable table, JCheckBox checkBox, String bs)
	{
		if (search.checkBoxChecked(checkBox))
		{
			String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe, hop_dong.Dongia, hop_dong.Sotien FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND xe.Bienso = '"+bs+"' AND hop_dong.Dongia > 2000000)";
			try
			{
				PreparedStatement pst = conn.prepareStatement(sqlSR);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e)
			{
				Dialog d = new Dialog();
				d.databaseError();
				e.printStackTrace();
			}
		} else
		{
			String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe, hop_dong.Dongia, hop_dong.Sotien FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND xe.Bienso = '"+bs+"')";
			try
			{
				PreparedStatement pst = conn.prepareStatement(sqlSR);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e)
			{
				Dialog d = new Dialog();
				d.databaseError();
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Phương thức truy vấn tìm kiếm theo loại xe
	 * @param table
	 * @param lx
	 */
	public void loaiXeSearchResult(JTable table, JCheckBox checkBox, String lx)
	{
		if (search.checkBoxChecked(checkBox)) 
		{
			String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe, hop_dong.Dongia, hop_dong.Sotien FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND xe.Loaixe = '"+lx+"' AND hop_dong.Dongia > 2000000)";
			try
			{
				PreparedStatement pst = conn.prepareStatement(sqlSR);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e)
			{
				Dialog d = new Dialog();
				d.databaseError();
				e.printStackTrace();
			}	
		} else 
		{
			String sqlSR = "SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, xe.Bienso, xe.Loaixe, hop_dong.Dongia, hop_dong.Sotien FROM khach_hang, hop_dong, xe WHERE (khach_hang.MaKH = hop_dong.MaKH AND hop_dong.Bienso = xe.Bienso AND xe.Loaixe = '"+lx+"')";
			try
			{
				PreparedStatement pst = conn.prepareStatement(sqlSR);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e)
			{
				Dialog d = new Dialog();
				d.databaseError();
				e.printStackTrace();
			}
		}
			
		
	}
}
