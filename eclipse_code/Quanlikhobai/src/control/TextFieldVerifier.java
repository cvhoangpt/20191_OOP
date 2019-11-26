package control;

import javax.swing.JOptionPane;

public class TextFieldVerifier
{
	public static boolean isIntegerNumeric(String strIntNum)
	{
		if (strIntNum == null) return false;
		try
		{
			int i = Integer.parseInt(strIntNum);
		} catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Cần nhập trường này dưới dạng số");
			return false;
		}
		return true;
	}
	
	public static boolean isDoubleNumeric(String strDouNum)
	{
		if (strDouNum == null) return false;
		try
		{
			int i = Integer.parseInt(strDouNum);
		} catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Cần nhập trường này dưới dạng số");
			return false;
		}
		return true;
	}
}
