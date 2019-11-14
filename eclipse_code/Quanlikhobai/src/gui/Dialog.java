package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog extends Window
{

	private JFrame frame;

	public Dialog() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
	}
	
	public JFrame getFrame() 
	{
		return frame;
	}

	public void setFrame(JFrame frame) 
	{
		this.frame = frame;
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
	
	public void SQLError()
	{
		JOptionPane.showMessageDialog(getFrame(), "Kiểm tra lại kết nối hoặc truy vấn.", 
    			"Lỗi cơ sở dữ liệu",
    			JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void EmptyBlank()
	{
		JOptionPane.showMessageDialog(getFrame(), "Bạn nhập chưa đủ các trường", 
				"Lỗi nhập dữ liệu",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Crash()
	{
		JOptionPane.showMessageDialog(getFrame(), "Chương trình không hồi đáp", 
				"Lỗi hệ thống",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
