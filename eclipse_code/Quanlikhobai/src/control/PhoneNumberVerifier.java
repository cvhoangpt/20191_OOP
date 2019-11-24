package control;

import java.math.BigDecimal;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class PhoneNumberVerifier extends InputVerifier
{
	@Override
	/**
	 * Phương thức kiểm tra xem trường nhập chỉ n số
	 */
	public boolean verify(JComponent input) 
	{
		String text = ((JTextField) input).getText();
		try
		{
			BigDecimal value = new BigDecimal(text);
			return (value.scale()) <= Math.abs(10);
		} catch (NumberFormatException nfe)
		{
			return false;
		}
		
	}
}
