package control;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import database.processing.ModifiedQuery;
import gui.form.Dialog;

/**
 * Lớp chứa các phương thức trong việc thay đổi dữ liệu csdl
 * @author hoangcv
 *
 */
public class Modify 
{
	Dialog d = new Dialog();
	
	public void insertHopDong(String tcx, int sdt, int cmt, String dc, String tdt, String bs, String tt, String tgg, String ctt, String lx) throws SQLException
	{
		new ModifiedQuery().insertHopDong(tcx, sdt, cmt, dc, tdt, bs, tt, tgg, ctt, lx);
	}
	
	public void deleteHopDong(String rowBienSo)
	{
		new ModifiedQuery().deleteHopDong(rowBienSo);
	}
	
	public void updateHopDong(String tenChuXe, int sdt, int soCMND, String diaChi, String thuDienTu, String bienSo, String trongTai, String thoiGianGui, String cachThanhToan, String loaiXe)
	{
		new ModifiedQuery().updateHopDong(tenChuXe, sdt, soCMND, diaChi, thuDienTu, bienSo, trongTai, thoiGianGui, cachThanhToan, loaiXe);
	}
	
	public boolean tcx_bsDeleteIsEmpty(JTextField textFieldTCX, JTextField textFieldBS)
	{
		
		if (textFieldTCX.getText().isEmpty())
		{
			d.deleteException();
			return true;
		}
		if (textFieldBS.getText().isEmpty())
		{
			d.deleteException();
			return true;
		}
		return false;
	}
	
	public boolean tcx_bsUpdateIsEmpty(JTextField textFieldTCX, JTextField textFieldBS)
	{
		
		if (textFieldTCX.getText().isEmpty())
		{
			d.updateException();
			return true;
		}
		if (textFieldBS.getText().isEmpty())
		{
			d.updateException();
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean nineElementIsEmpty(JTextField textFieldTCX, JTextField textFieldSDT, JTextField textFieldDC, JTextField textFieldCMT, JTextField textFieldBS, JTextField textFieldTGG, JTextField textFieldCTT, JComboBox comboBoxLX, JTextField textFieldTT)
	{
		
		if (textFieldTCX.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if (textFieldSDT.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if (textFieldDC.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if (textFieldCMT.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if (textFieldBS.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if (textFieldTGG.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if (textFieldCTT.getText().isEmpty())
		{
			d.emptyBlank();
			return true;
		}
		if ((comboBoxLX.getSelectedItem().toString() == "Xe tải") && textFieldTT.getText().isEmpty()) 
		{
			d.checkTrongTai();
			return true;
		}
		return false;
	}
}
