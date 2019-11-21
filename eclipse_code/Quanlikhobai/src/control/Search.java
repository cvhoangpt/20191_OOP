package control;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import gui.form.Dialog;

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
	
	public boolean checkBoxChecked(JCheckBox fff)
	{
		if (fff.isSelected()) return true;
		else return false;
	}
}
