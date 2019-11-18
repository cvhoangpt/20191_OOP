package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.Statement;

import gui.*;
import util.Modify;

/**
 * Chứa các liên kết thực thể và truy vấn
 * @author hoang
 *
 */
public class ModifiedEntity extends Connector 
{
	//ResultSet rs = null;
	//PreparedStatement pst = null;
	
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
			//d.dataSave();
		} catch(Exception e)
		{
			d.dbError();
			e.printStackTrace();
		}
	}
	
	public void deleteHD(String rowBienSo)
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
	
	public void updateHD(String tcx, int sdt, int cmt, String dc, String tdt, String bs, String tt, String tgg, String ctt, String lx)
	{
		String getMaKH = null;
		Dialog d = new Dialog();
		String sqlGetMaKH =
	"SELECT kh.MaKH FROM khach_hang kh " +
	"JOIN hop_dong hd ON kh.MaKH = hd.MaKH " +
	"JOIN xe x ON x.Bienso = hd.Bienso " +
	"WHERE x.Bienso = '"+bs+"'";
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
			d.updateBSError();
			return;
		}
		String sqlUpdateHD1 =
	"UPDATE khach_hang " +
	"SET TenKH='"+tcx+"', DiaChi='"+dc+"', SDT='"+sdt+"', SoCMND='"+cmt+"', ThuDienTu='"+tdt+"'" +
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
	"SET Bienso='"+bs+"', Loaixe='"+lx+"' "+
	"WHERE Bienso='"+bs+"'";
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
	"SET Hinhthucthanhtoan='"+ctt+"', Thoigiangui='"+tgg+"'" +
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
		d.updateSave();
	}
}