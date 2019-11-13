package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard 
{

	private JFrame frame;
	private JTextField txtTimKiem;
	private JTable table;
	private JTextField textFieldTCX;
	private JTextField textFieldSDT;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textFieldBS;
	private JTextField textField_1;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setTitle("Chương trình quản lí bãi gửi xe");
		getFrame().setBounds(20, 20, 1366, 768);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblCTQuanLi = new JLabel("BẢNG ĐIỀU KHIỂN TRUNG TÂM");
		lblCTQuanLi.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCTQuanLi.setBounds(12, 13, 360, 35);
		getFrame().getContentPane().add(lblCTQuanLi);
		
		JButton btnThemHD = new JButton("Thêm HD");
		btnThemHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemHD.setBounds(171, 510, 143, 46);
		getFrame().getContentPane().add(btnThemHD);
		
		JButton btnXoaHD = new JButton("Xoá HD");
		btnXoaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaHD.setBounds(171, 569, 143, 46);
		getFrame().getContentPane().add(btnXoaHD);
		
		JLabel lblBGX = new JLabel("Bãi gửi xe 692538");
		lblBGX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBGX.setBounds(12, 46, 360, 25);
		getFrame().getContentPane().add(lblBGX);
		
		JButton btnCpNhtHd = new JButton("Cập nhật HD");
		btnCpNhtHd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCpNhtHd.setBounds(326, 510, 143, 46);
		getFrame().getContentPane().add(btnCpNhtHd);
		
		JButton btnXoaTruong = new JButton("Xoá các trường");
		btnXoaTruong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaTruong.setBounds(326, 569, 143, 46);
		getFrame().getContentPane().add(btnXoaTruong);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setBounds(1079, 13, 259, 35);
		getFrame().getContentPane().add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(1193, 61, 143, 46);
		getFrame().getContentPane().add(btnTimKiem);
		
		String elementCBB[] = {"Chủ xe", "Biển số xe", "Xe con", "Xe tải"};
		JComboBox comboBox = new JComboBox(elementCBB);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(956, 15, 111, 37);
		getFrame().getContentPane().add(comboBox);
		
		JCheckBox chckbxPhiGui = new JCheckBox("Xe có phí gửi > 2.000.000đ");
		chckbxPhiGui.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxPhiGui.setBounds(949, 72, 236, 25);
		getFrame().getContentPane().add(chckbxPhiGui);
		
		table = new JTable();
		table.setBounds(497, 120, 839, 554);
		getFrame().getContentPane().add(table);
		
		JButton btnThngKChi = new JButton("TK doanh thu");
		btnThngKChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThngKChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThngKChi.setBounds(171, 628, 143, 46);
		getFrame().getContentPane().add(btnThngKChi);
		
		JLabel lblTenCX = new JLabel("Tên chủ xe");
		lblTenCX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenCX.setBounds(79, 127, 78, 20);
		frame.getContentPane().add(lblTenCX);
		
		textFieldTCX = new JTextField();
		textFieldTCX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTCX.setBounds(169, 120, 300, 35);
		frame.getContentPane().add(textFieldTCX);
		textFieldTCX.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SĐT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(127, 273, 30, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(169, 264, 300, 35);
		frame.getContentPane().add(textFieldSDT);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(169, 312, 300, 35);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(169, 360, 300, 35);
		frame.getContentPane().add(textField_3);
		
		JLabel lblDC = new JLabel("Địa chỉ");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDC.setBounds(111, 321, 56, 16);
		frame.getContentPane().add(lblDC);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(169, 408, 300, 35);
		frame.getContentPane().add(textField);
		
		JLabel lblTDT = new JLabel("Thư điện tử");
		lblTDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTDT.setBounds(73, 370, 84, 16);
		frame.getContentPane().add(lblTDT);
		
		JLabel lblCMT = new JLabel("CMND/CCCD");
		lblCMT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCMT.setBounds(66, 418, 91, 16);
		frame.getContentPane().add(lblCMT);
		
		JLabel lblLX = new JLabel("Loại xe");
		lblLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLX.setBounds(101, 177, 56, 16);
		frame.getContentPane().add(lblLX);
		
		String loaiXe[] = {"Xe con", "Xe tải"};
		JComboBox comboBoxLX = new JComboBox(loaiXe);
		comboBoxLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxLX.setBounds(169, 170, 84, 33);
		frame.getContentPane().add(comboBoxLX);
		
		JLabel lblTrngTitn = new JLabel("Trọng tải (tấn)");
		lblTrngTitn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrngTitn.setBounds(274, 173, 111, 25);
		frame.getContentPane().add(lblTrngTitn);
		
		JLabel lblBS = new JLabel("Biển số");
		lblBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBS.setBounds(277, 226, 56, 16);
		frame.getContentPane().add(lblBS);
		
		textFieldBS = new JTextField();
		textFieldBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBS.setBounds(347, 218, 122, 33);
		frame.getContentPane().add(textFieldBS);
		textFieldBS.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(385, 168, 84, 35);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTGG = new JLabel("Thời gian gửi (tháng)");
		lblTGG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTGG.setBounds(12, 224, 160, 20);
		frame.getContentPane().add(lblTGG);
		
		textField_4 = new JTextField();
		textField_4.setBounds(171, 216, 82, 35);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
}
