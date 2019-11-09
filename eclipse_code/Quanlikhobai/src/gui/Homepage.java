package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Homepage 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCTQuanLi = new JLabel("Chương trình Quản lí bãi gửi xe");
		lblCTQuanLi.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCTQuanLi.setBounds(24, 13, 342, 35);
		frame.getContentPane().add(lblCTQuanLi);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(50, 126, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
