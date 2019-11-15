package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JScrollPane;

import java.awt.Font;

//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;

import database.Query;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

//import net.proteanit.sql.DbUtils;

public class Dashboard extends Window
{
	private JFrame frame;
	public JFrame getFrame() 
	{
		return frame;
	}

	public void setFrame(JFrame frame) 
	{
		this.frame = frame;
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
	private JTextField txtTimKiem;
	private JTable tableBriefs;
	private JTextField textFieldTCX;
	private JTextField textFieldSDT;
	private JTextField textFieldDC;
	private JTextField textFieldTDT;
	private JTextField textFieldCMT;
	private JTextField textFieldBS;
	private JTextField textFieldTT;
	private JTextField textFieldTTG;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Dashboard() throws SQLException 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws SQLException 
	{
		setFrame(new JFrame());
		getFrame().setTitle("Chương trình quản lí bãi gửi xe");
		getFrame().setBounds(20, 20, 1366, 768);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblCTQuanLi = new JLabel("BẢNG ĐIỀU KHIỂN TRUNG TÂM");
		lblCTQuanLi.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCTQuanLi.setBounds(12, 13, 360, 35);
		getFrame().getContentPane().add(lblCTQuanLi);
		
		JLabel lblBGX = new JLabel("Bãi gửi xe 692538");
		lblBGX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBGX.setBounds(12, 46, 360, 25);
		getFrame().getContentPane().add(lblBGX);
		
		JLabel lblTenCX = new JLabel("Tên chủ xe");
		lblTenCX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenCX.setBounds(79, 127, 78, 20);
		frame.getContentPane().add(lblTenCX);
		
		textFieldTCX = new JTextField();
		textFieldTCX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTCX.setBounds(169, 120, 300, 35);
		frame.getContentPane().add(textFieldTCX);
		textFieldTCX.setColumns(10);
		
		JLabel lblLX = new JLabel("Loại xe");
		lblLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLX.setBounds(101, 177, 56, 16);
		frame.getContentPane().add(lblLX);
		String loaiXe[] = {"Xe con", "Xe tải"};
		JComboBox comboBoxLX = new JComboBox (loaiXe);
		comboBoxLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxLX.setBounds(169, 170, 84, 33);
		frame.getContentPane().add(comboBoxLX);
		
		JLabel lblTrngTitn = new JLabel("Trọng tải (tấn)");
		lblTrngTitn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrngTitn.setBounds(274, 173, 111, 25);
		frame.getContentPane().add(lblTrngTitn);
		
		textFieldTT = new JTextField();
		textFieldTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTT.setBounds(385, 168, 84, 35);
		frame.getContentPane().add(textFieldTT);
		textFieldTT.setColumns(10);
		
		JLabel lblTGG = new JLabel("Thời gian gửi (tháng)");
		lblTGG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTGG.setBounds(12, 224, 160, 20);
		frame.getContentPane().add(lblTGG);
		
		textFieldTTG = new JTextField();
		textFieldTTG.setBounds(171, 216, 82, 35);
		frame.getContentPane().add(textFieldTTG);
		textFieldTTG.setColumns(10);
		
		JLabel lblBS = new JLabel("Biển số");
		lblBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBS.setBounds(277, 226, 56, 16);
		frame.getContentPane().add(lblBS);
		
		textFieldBS = new JTextField();
		textFieldBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBS.setBounds(347, 218, 122, 33);
		frame.getContentPane().add(textFieldBS);
		textFieldBS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SĐT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(127, 273, 30, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(169, 264, 300, 35);
		frame.getContentPane().add(textFieldSDT);
		
		textFieldDC = new JTextField();
		textFieldDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDC.setColumns(10);
		textFieldDC.setBounds(169, 312, 300, 35);
		frame.getContentPane().add(textFieldDC);
		
		JLabel lblDC = new JLabel("Địa chỉ");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDC.setBounds(111, 321, 56, 16);
		frame.getContentPane().add(lblDC);
		
		JLabel lblTDT = new JLabel("Thư điện tử");
		lblTDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTDT.setBounds(73, 370, 84, 16);
		frame.getContentPane().add(lblTDT);
		
		JLabel lblCMT = new JLabel("CMND/CCCD");
		lblCMT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCMT.setBounds(66, 418, 91, 16);
		frame.getContentPane().add(lblCMT);
		
		textFieldCMT = new JTextField();
		textFieldCMT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCMT.setColumns(10);
		textFieldCMT.setBounds(169, 408, 300, 35);
		frame.getContentPane().add(textFieldCMT);
		
		textFieldTDT = new JTextField();
		textFieldTDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTDT.setColumns(10);
		textFieldTDT.setBounds(169, 360, 300, 35);
		frame.getContentPane().add(textFieldTDT);
		
		JButton btnThemHD = new JButton("Thêm HD");
		btnThemHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemHD.setBounds(171, 510, 143, 46);
		getFrame().getContentPane().add(btnThemHD);
		
		JButton btnXoaHD = new JButton("Xoá HD");
		btnXoaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaHD.setBounds(171, 569, 143, 46);
		getFrame().getContentPane().add(btnXoaHD);
		
		JButton btnCpNhtHd = new JButton("Cập nhật HD");
		btnCpNhtHd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCpNhtHd.setBounds(326, 510, 143, 46);
		getFrame().getContentPane().add(btnCpNhtHd);
		
		JButton btnXoaTruong = new JButton("Xoá các trường");
		btnXoaTruong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaTruong.setBounds(326, 569, 143, 46);
		getFrame().getContentPane().add(btnXoaTruong);
		
		JButton btnThngKChi = new JButton("TK doanh thu");
		btnThngKChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThngKChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThngKChi.setBounds(171, 628, 143, 46);
		getFrame().getContentPane().add(btnThngKChi);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(1193, 61, 143, 46);
		getFrame().getContentPane().add(btnTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setBounds(1077, 16, 259, 35);
		getFrame().getContentPane().add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		String loaiSearch[] = {"Chủ xe", "Biển số xe", "Xe con", "Xe tải"};
		//DefaultComboBoxModel<String> loaiSearchModel = new DefaultComboBoxModel<String>(loaiSearch);
		JComboBox comboBoxLS = new JComboBox(loaiSearch);
		comboBoxLS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxLS.setBounds(956, 15, 111, 37);
		getFrame().getContentPane().add(comboBoxLS);
		
		JCheckBox chckbxPhi2 = new JCheckBox("Xe có phí gửi > 2.000.000đ");
		chckbxPhi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxPhi2.setBounds(956, 72, 236, 25);
		getFrame().getContentPane().add(chckbxPhi2);
		
		
		//Khối Table----------------------------------
		//String colNames[] = {"Mã KH", "Tên KH", "Địa chỉ", "SĐT", "CMT", "Email"};
		tableBriefs = new JTable(new Object[][] {}, new Object[] {"Mã KH", "Tên KH", "Địa chỉ", "SĐT", "CMT", "Email"});
		tableBriefs.setCellSelectionEnabled(true);
		tableBriefs.setColumnSelectionAllowed(true);
		tableBriefs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableBriefs.setBounds(497, 120, 816, 554);
		getFrame().getContentPane().add(tableBriefs);
		Query qr = new Query();
		qr.updateTable(tableBriefs);

		//table.setModel(new DefaultTableModel(dataTable,vctHeader));
		
		//JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//JScrollPane scrollPane = new JScrollPane(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//scrollPane.setBounds(1315, 120, 21, 554);
		//getFrame().getContentPane().add(scrollPane);
		//scrollPane.setViewportView(table);
		//table.setModel(new DefaultTableModel(qr.updateTable(table),vctHeader));
		
		//---------------------------------------------
	}

	
	
	public void start()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					getFrame().setVisible(true);
				} catch (Exception e) 
				{
					Dialog ed = new Dialog();
					ed.Crash();
					e.printStackTrace();
				}
			}
		});
	}
}
