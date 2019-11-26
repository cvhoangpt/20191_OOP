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
	public void tenChuXeSearchResult(JTable table, String tcx)
	{
		new SearchQuery().tenChuXeSearchResult(table, tcx);
	}
	
	public void bienSoSearchResult(JTable table, String bs)
	{
		new SearchQuery().bienSoSearchResult(table, bs);
	}
	
	public void loaiXeSearchResult(JTable table, String lx)
	{
		new SearchQuery().loaiXeSearchResult(table, lx);
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
	
	public boolean checkBoxChecked(JCheckBox fff)
	{
		if (fff.isSelected()) return true;
		else return false;
	}
}
