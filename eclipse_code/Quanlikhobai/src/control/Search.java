package control;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import database.processing.SearchQuery;
import gui.form.Dialog;

/**
 * Lớp điều khiển việc tìm kiếm, giao diện tìm kiếm
 * @author hoangcv
 *
 */
public class Search 
{
	public void tenChuXeSearchResult(JTable table, JCheckBox checkBox, String tcx)
	{
		new SearchQuery().tenChuXeSearchResult(table, checkBox, tcx);
	}
	
	public void bienSoSearchResult(JTable table, JCheckBox checkBox, String bs)
	{
		new SearchQuery().bienSoSearchResult(table, checkBox, bs);
	}
	
	public void loaiXeSearchResult(JTable table, JCheckBox checkBox, String lx)
	{
		new SearchQuery().loaiXeSearchResult(table, checkBox, lx);
	}
	
	public boolean searchIsEmpty(JTextField txtTimKiem)
	{
		Dialog d = new Dialog();
		if (txtTimKiem.getText().isEmpty())
		{
			d.searchException();
			return true;
		} else return false;
	}
	
	public boolean checkBoxChecked(JCheckBox checkBox)
	{
		if (checkBox.isSelected()) return true;
		else return false;
	}
}
