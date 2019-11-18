package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Lớp chứa các hộp thoại thông báo
 * @author hoangcv
 *
 */
public class Dialog extends Window
{
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
	
	/**
	 * Phương thức in ra màn hình hộp thoại thông báo lỗi cơ sở dữ liệu
	 */
	public void dbError()
	{
		JOptionPane.showMessageDialog(getFrame(), "Kiểm tra lại kết nối hoặc truy vấn.", 
    			"Lỗi cơ sở dữ liệu",
    			JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void checkXeTai()
	{
		JOptionPane.showMessageDialog(getFrame(), "Bạn cần nhập trọng tải đối với xe tải",
				"Lỗi nhập dữ liệu",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void duplicateBS()
	{
		JOptionPane.showMessageDialog(getFrame(), "Có vẻ đã trùng biển số xe",
				"Lỗi trùng lặp dữ liệu",
				JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Phương thức in ra màn hình hộp thoại thông báo lỗi không nhập đủ các trường
	 */
	public void emptyBlank()
	{
		JOptionPane.showMessageDialog(getFrame(), "Bạn nhập chưa đủ các trường (*)", 
				"Lỗi nhập dữ liệu",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void deleteException()
	{
		JOptionPane.showMessageDialog(getFrame(), "Không có gì để xoá", 
				"Lỗi ngoại lệ",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void updateException()
	{
		JOptionPane.showMessageDialog(getFrame(), "Không có gì để cập nhật", 
				"Lỗi ngoại lệ",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void dataSave()
	{
		JOptionPane.showMessageDialog(getFrame(), "Thêm hợp đồng thành công",
				"Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void updateSave()
	{
		JOptionPane.showMessageDialog(getFrame(), "Cập nhật hợp đồng thành công",
				"Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Phương thức in ra màn hình hộp thoại thông báo lỗi chương trình bị treo
	 */
	public void crash()
	{
		JOptionPane.showMessageDialog(getFrame(), "Chương trình không hồi đáp", 
				"Lỗi hệ thống",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void removeField() {}
}
