package database.export;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.connect.Connector;
import gui.form.*;
import util.NumberProcessing;

/**
 * Chứa các truy vấn việc thay đổi hợp đồng
 * @author hoangcv
 *
 */
public class ModifiedQuery extends Connector 
{
	//ResultSet rs = null;
	//PreparedStatement pst = null;
	Dialog dialog = new Dialog();
	NumberProcessing numProcess = new NumberProcessing();
	public void test() throws SQLException
	{
		System.out.println(Dashboard.tenChuXe);
	}
	
	/**
	 * Phương thức truy vấn thêm hợp đồng
	 * @param tcx
	 * @param sdt
	 * @param cmt
	 * @param dc
	 * @param tdt
	 * @param bs
	 * @param tt
	 * @param tgg
	 * @param ctt
	 * @param lx
	 * @throws SQLException
	 */
	public void insertHopDong(String tcx, int sdt, int cmt, String dc, String tdt, String bs, String tt, String tgg, String ctt, String lx) throws SQLException
	{
		String valueKH = "KH" + String.valueOf(numProcess.randomMKH());
		String valueHD = "HD" + String.valueOf(numProcess.randomMHD());
		try
		{
			//Khối chèn bảng khach_hang
			String sqlInsertHD1 = 
	"INSERT INTO khach_hang (MaKH, TenKH, DiaChi, SDT, SoCMND, ThuDienTu) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(sqlInsertHD1);
			pst1.setString(1, valueKH);
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
			pst3.setString(1, valueHD);
			pst3.setString(2, ctt);
			pst3.setString(3, tgg);
			pst3.setString(4, valueKH);
			pst3.setString(5, bs);
			pst3.executeUpdate();
			//---
			
			//Khối khác
			
			//---
			//d.dataSave();
		} catch(Exception e)
		{
			dialog.databaseError();
			e.printStackTrace();
		}
	}
	
	/**
	 * Phương thức truy vấn xoá hợp đồng
	 * @param rowBienSo
	 */
	public void deleteHopDong(String rowBienSo)
	{
		String getMaKH = null;
		String sqlGetMaKH =
	"SELECT kh.MaKH FROM khach_hang kh " +
	"JOIN hop_dong hd ON kh.MaKH = hd.MaKH " +
	"JOIN xe x ON x.Bienso = hd.Bienso " +
	"WHERE x.Bienso = '"+rowBienSo+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlGetMaKH);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) getMaKH = rs.getString("MaKH");
			System.out.println(getMaKH);
			rs.close();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		String sqlDHD1 = 
	"DELETE FROM xe WHERE Bienso = '"+rowBienSo+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlDHD1);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		String sqlDHD2 =
	"DELETE FROM khach_hang WHERE MaKH = '"+getMaKH+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlDHD2);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Phương thức truy vấn cập nhật (sửa) hợp đồng
	 * @param tenChuXe
	 * @param sdt
	 * @param soCMND
	 * @param diaChi
	 * @param thuDienTu
	 * @param bienSo
	 * @param trongTai
	 * @param thoiGianGui
	 * @param cachThanhToan
	 * @param loaiXe
	 */
	public void updateHopDong(String tenChuXe, int sdt, int soCMND, String diaChi, String thuDienTu, String bienSo, String trongTai, String thoiGianGui, String cachThanhToan, String loaiXe)
	{
		String getMaKH = null;
		
		String sqlGetMaKH =
	"SELECT kh.MaKH FROM khach_hang kh " +
	"JOIN hop_dong hd ON kh.MaKH = hd.MaKH " +
	"JOIN xe x ON x.Bienso = hd.Bienso " +
	"WHERE x.Bienso = '"+bienSo+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlGetMaKH);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) getMaKH = rs.getString("MaKH");
			System.out.println("makh="+getMaKH);
			
			rs.close();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (getMaKH == null) 
		{
			dialog.updateBienSoError();
			return;
		}
		
		String sqlUpdateHD1 =
	"UPDATE khach_hang " +
	"SET TenKH='"+tenChuXe+"', DiaChi='"+diaChi+"', SDT='"+sdt+"', SoCMND='"+soCMND+"', ThuDienTu='"+thuDienTu+"'" +
	"WHERE MaKH='"+getMaKH+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlUpdateHD1);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		String sqlUpdateHD2 =
	"UPDATE xe " +
	"SET Bienso='"+bienSo+"', Loaixe='"+loaiXe+"' "+
	"WHERE Bienso='"+bienSo+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlUpdateHD2);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		String sqlUpdateHD3 =
	"UPDATE hop_dong " +
	"SET Hinhthucthanhtoan='"+cachThanhToan+"', Thoigiangui='"+thoiGianGui+"'" +
	"WHERE MaKH='"+getMaKH+"'";
		try
		{
			PreparedStatement pst = conn.prepareStatement(sqlUpdateHD3);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}	
		dialog.updateSave();
	}
}