package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import gui.Dialog;
import net.proteanit.sql.DbUtils;

public class Query extends Connector 
{
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public void updateTable(JTable table) throws SQLException
	{
		try
		{
			String sqlUpdateTable = 
			"SELECT khach_hang.MaKH, hop_dong.MaHD, khach_hang.TenKH, hop_dong.Thoigiangui FROM khach_hang, hop_dong WHERE khach_hang.MaKH = hop_dong.MaKH";
			
			pst = conn.prepareStatement(sqlUpdateTable);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e)
		{
			Dialog d = new Dialog();
			d.SQLError();
			e.printStackTrace();
		}
	}
}
