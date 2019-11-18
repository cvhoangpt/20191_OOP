package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.Dialog;
import net.proteanit.sql.DbUtils;

/**
 * Lớp chứa các truy vấn khác
 * @author hoangcv
 *
 */
public class OtherEntity extends Connector
{
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
			Dialog d = new Dialog();
			d.dbError();
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
			rs.close();
			pst.close();
		} catch (Exception e)
		{
			Dialog d = new Dialog();
			d.dbError();
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Phương thức truy vấn kiểm tra trùng biển số
	 * @param bs
	 * @return
	 */
	public boolean duplicateBSSQL(String bs)
	{
		String dbssql =
	"SELECT * FROM xe WHERE Bienso=?";
		try
		{
			PreparedStatement pst = conn.prepareStatement(dbssql);
			pst.setString(1, bs);
			ResultSet rs = pst.executeQuery();
			int count = 0;
			while (rs.next()) count++;
			System.out.println("countDup="+count);
			if (count == 1) 
			{
				Dialog d = new Dialog();
				d.duplicateBS();
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
	public ResultSet sqlCalVehicle()
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
}
