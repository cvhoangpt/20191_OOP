package util;

import javax.swing.JTextField;

import gui.Dialog;

public class Search 
{
	public boolean searchIsEmpty(JTextField txtTimKiem)
	{
		Dialog d = new Dialog();
		if (txtTimKiem.getText().isEmpty())
		{
			d.searchException();
			return true;
		} else return false;
	}
}
