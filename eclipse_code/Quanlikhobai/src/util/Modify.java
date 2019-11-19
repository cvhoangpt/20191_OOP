package util;

import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.Dialog;

/**
 * Lớp chứa các phương thức trong việc thay đổi dữ liệu csdl
 * @author hoang
 *
 */
public class Modify 
{
	private int randomMaKH;
	private int randomMaHD;
	Random rd = new Random();
	Dialog d = new Dialog();
	/**
	 * Phương thức lấy ngẫu nhiên giá trị số nguyên trong khoảng 100000
	 * @param randomMaKH
	 * @return
	 */
	public int randomMKH()
	{
		randomMaKH = rd.nextInt(100000);
		return randomMaKH;
	}
	
	/**
	 * Phương thức lấy ngẫu nhiên giá trị số nguyên trong khoản 100000
	 * @param randomMaHD
	 * @param value2
	 * @return
	 */
	public int randomMHD()
	{
		randomMaHD = rd.nextInt(100000);
		return randomMaHD;
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
			d.checkXeTai();
			return true;
		}
		return false;
	}
}
