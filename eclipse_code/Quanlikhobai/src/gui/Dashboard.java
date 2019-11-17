package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.awt.Font;

//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;

import database.EntityModify;
import object.*;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import net.proteanit.sql.DbUtils;
/**
 * Phương thức Dashboard: Giao diện điều khiển chính của chương trình
 * @version 1.0
 * @author Hoàng
 * @since 10/2019
 */
@SuppressWarnings("rawtypes")
public class Dashboard extends Window
{
	//private JFrame frame;
	
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
	private JTextField textFieldTGG;
	private JComboBox comboBoxLX;
	private JComboBox comboBoxLS;
	private JTextField textFieldCTT;
	public static String tcx;
	public static int sdt;
	public static String dc;
	public static String tdt;
	public static int cmt; 
	public static String bs;
	public static String tt;
	public static String tgg;
	public static String ctt;
	public static String lx;
	public static String ls;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Dashboard() throws SQLException 
	{
		initialize();
	}

	/**
	 * Khởi tạo nội dung các Frame
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws SQLException 
	{
		EntityModify em = new EntityModify();
		Dialog d = new Dialog();
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
		lblBGX.setBounds(12, 46, 184, 25);
		getFrame().getContentPane().add(lblBGX);
		
		JLabel lblTenCX = new JLabel("Tên chủ xe*");
		lblTenCX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenCX.setBounds(60, 127, 97, 20);
		frame.getContentPane().add(lblTenCX);
		
		textFieldTCX = new JTextField();
		textFieldTCX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTCX.setBounds(169, 120, 300, 35);
		frame.getContentPane().add(textFieldTCX);
		textFieldTCX.setColumns(10);
		
		JLabel lblLX = new JLabel("Loại xe*");
		lblLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLX.setBounds(82, 177, 75, 16);
		frame.getContentPane().add(lblLX);
		String loaiXe[] = {"Xe con", "Xe tải"};
		comboBoxLX = new JComboBox (loaiXe);
		comboBoxLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxLX.setBounds(169, 170, 84, 33);
		comboBoxLX.setVisible(true);
		frame.getContentPane().add(comboBoxLX);
		
		JLabel lblTT = new JLabel("Trọng tải (tấn)");
		lblTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTT.setBounds(274, 173, 111, 25);
		textFieldTT = new JTextField();
		textFieldTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTT.setBounds(385, 168, 84, 35);
		frame.getContentPane().add(lblTT);
		//textFieldTT.setVisible(true);
		frame.getContentPane().add(textFieldTT);
		
		JLabel lblTGG = new JLabel("TG Gửi (tháng)*");
		lblTGG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTGG.setBounds(50, 224, 122, 20);
		frame.getContentPane().add(lblTGG);
		
		textFieldTGG = new JTextField();
		textFieldTGG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTGG.setBounds(171, 216, 82, 35);
		frame.getContentPane().add(textFieldTGG);
		
		JLabel lblBS = new JLabel("Biển số*");
		lblBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBS.setBounds(277, 226, 68, 16);
		frame.getContentPane().add(lblBS);
		
		textFieldBS = new JTextField();
		textFieldBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBS.setBounds(347, 218, 122, 33);
		frame.getContentPane().add(textFieldBS);
		textFieldBS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SĐT*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(107, 317, 50, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(169, 308, 300, 35);
		frame.getContentPane().add(textFieldSDT);
		
		textFieldDC = new JTextField();
		textFieldDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDC.setColumns(10);
		textFieldDC.setBounds(169, 356, 300, 35);
		frame.getContentPane().add(textFieldDC);
		
		JLabel lblDC = new JLabel("Địa chỉ*");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDC.setBounds(92, 365, 75, 16);
		frame.getContentPane().add(lblDC);
		
		JLabel lblTDT = new JLabel("Thư điện tử");
		lblTDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTDT.setBounds(73, 414, 84, 20);
		frame.getContentPane().add(lblTDT);
		
		JLabel lblCMT = new JLabel("CMND/CCCD*");
		lblCMT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCMT.setBounds(50, 462, 107, 16);
		frame.getContentPane().add(lblCMT);
		
		textFieldCMT = new JTextField();
		textFieldCMT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCMT.setColumns(10);
		textFieldCMT.setBounds(169, 452, 300, 35);
		frame.getContentPane().add(textFieldCMT);
		
		textFieldTDT = new JTextField();
		textFieldTDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTDT.setColumns(10);
		textFieldTDT.setBounds(169, 404, 300, 35);
		frame.getContentPane().add(textFieldTDT);
		
		JButton btnThemHD = new JButton("Thêm HD");
		btnThemHD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				tcx = textFieldTCX.getText();
				if (textFieldSDT.getText().toString().isEmpty()) 
				{
					d.emptyBlank();
					return;
				}
				else sdt = Integer.parseInt(textFieldSDT.getText());
				
				if (textFieldCMT.getText().toString().isEmpty())
				{
					d.emptyBlank();
					return;
				} else cmt = Integer.parseInt(textFieldCMT.getText());
				
				dc = textFieldDC.getText();
				tdt = textFieldTDT.getText();
				bs = textFieldBS.getText();
				//kiểm tra trùng biển số xe
				if (em.duplicateBSSQL(bs) == false) return;
				tt = textFieldTT.getText();
				tgg = textFieldTGG.getText();
				ctt = textFieldCTT.getText();
				lx = comboBoxLX.getSelectedItem().toString();
				new Khachhang(tcx, dc, sdt, cmt, tdt);
				new Vehicle(bs, lx, tt);
				
				if (tcx.isEmpty())
				{
					d.emptyBlank();
					return;
				}
				if (sdt == 0)
				{
					d.emptyBlank();
					return;
				}
				if (dc.isEmpty())
				{
					d.emptyBlank();
					return;
				}
				if (cmt == 0)
				{
					d.emptyBlank();
					return;
				}
				if (bs.isEmpty())
				{
					d.emptyBlank();
					return;
				}
				if (tgg.isEmpty())
				{
					d.emptyBlank();
					return;
				}
				if (ctt.isEmpty())
				{
					d.emptyBlank();
					return;
				}
				if ((lx == "Xe tải") && tt.isEmpty()) 
				{
					d.checkXeTai();
					return;
				}	
				/*
				try
				{
					qr.test();
				} catch (SQLException e2)
				{
					e2.printStackTrace();
				}
				*/
				
				try 
				{
					em.insertHD(tcx, sdt, cmt, dc, tdt, bs, tt, tgg, ctt, lx);
					em.refreshTable(tableBriefs);
				} catch (SQLException e1) 
				{	
					e1.printStackTrace();
				}
				
			}
		});
		btnThemHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemHD.setBounds(171, 510, 143, 46);
		getFrame().getContentPane().add(btnThemHD);
		
		JButton btnXoaHD = new JButton("Xoá HD");
		btnXoaHD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (textFieldTCX.getText().isEmpty())
				{
					d.deleteException();
					return;
				}
				bs = textFieldBS.getText();
				try
				{
					em.deleteHD(bs);
					em.refreshTable(tableBriefs);
					removeField();
				} catch (Exception e4)
				{
					e4.printStackTrace();
				}
				
			}
		});
		btnXoaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaHD.setBounds(171, 569, 143, 46);
		getFrame().getContentPane().add(btnXoaHD);
		
		JButton btnCpNhtHd = new JButton("Cập nhật HD");
		btnCpNhtHd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCpNhtHd.setBounds(326, 510, 143, 46);
		getFrame().getContentPane().add(btnCpNhtHd);
		
		JButton btnXoaTruong = new JButton("Xoá các trường");
		btnXoaTruong.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				removeField();
			}
		});
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
		comboBoxLS = new JComboBox(loaiSearch);
		comboBoxLS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxLS.setBounds(956, 15, 111, 37);
		getFrame().getContentPane().add(comboBoxLS);
		
		JCheckBox chckbxPhi2 = new JCheckBox("Xe có phí gửi > 2.000.000đ");
		chckbxPhi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxPhi2.setBounds(956, 72, 236, 25);
		getFrame().getContentPane().add(chckbxPhi2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(497, 120, 839, 554);
		frame.getContentPane().add(scrollPane);
		
		
		//Khối Table----------------------------------
		tableBriefs = new JTable();
		tableBriefs.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					int row = tableBriefs.getSelectedRow();
					System.out.println(row);
					String rowBienSo = (tableBriefs.getModel().getValueAt(row, 3).toString());
					System.out.println(rowBienSo);
					em.selectRow(rowBienSo, textFieldTCX, textFieldSDT, textFieldDC, textFieldTDT, textFieldCMT, textFieldBS, textFieldTT, textFieldTGG, textFieldCTT, comboBoxLX);
					
				} catch (Exception e3)
				{
					e3.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableBriefs);
		tableBriefs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		em.updateTable(tableBriefs);
		
		JLabel lblCTT = new JLabel("Cách thanh toán");
		lblCTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCTT.setBounds(50, 275, 122, 16);
		frame.getContentPane().add(lblCTT);
		
		textFieldCTT = new JTextField();
		textFieldCTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCTT.setBounds(169, 264, 300, 38);
		frame.getContentPane().add(textFieldCTT);
		textFieldCTT.setColumns(10);
		
		JLabel lblBB = new JLabel("(*) bắt buộc");
		lblBB.setBounds(169, 96, 84, 16);
		frame.getContentPane().add(lblBB);
	}
	
	public void removeField()
	{
		getTextFieldTCX().setText("");
		getTextFieldCMT().setText("");
		getTextFieldCTT().setText("");
		getTextFieldDC().setText("");
		getTextFieldSDT().setText("");
		getTextFieldTDT().setText("");
		getTextFieldTT().setText("");
		getTextFieldTGG().setText("");
		getTextFieldBS().setText("");
	}

	/**
	 * Phương thức khởi động Dashboard
	 */
	public void startDashboard()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					getFrame().setVisible(true);
				} catch (Exception e2) 
				{
					Dialog ed = new Dialog();
					ed.crash();
					e2.printStackTrace();
				}
			}
		});
	}

	public JTextField getTextFieldTCX() {
		return textFieldTCX;
	}

	public void setTextFieldTCX(JTextField textFieldTCX) {
		this.textFieldTCX = textFieldTCX;
	}

	public JTextField getTextFieldSDT() {
		return textFieldSDT;
	}

	public void setTextFieldSDT(JTextField textFieldSDT) {
		this.textFieldSDT = textFieldSDT;
	}

	public JTextField getTextFieldDC() {
		return textFieldDC;
	}

	public void setTextFieldDC(JTextField textFieldDC) {
		this.textFieldDC = textFieldDC;
	}

	public JTextField getTextFieldTDT() {
		return textFieldTDT;
	}

	public void setTextFieldTDT(JTextField textFieldTDT) {
		this.textFieldTDT = textFieldTDT;
	}

	public JTextField getTextFieldCMT() {
		return textFieldCMT;
	}

	public void setTextFieldCMT(JTextField textFieldCMT) {
		this.textFieldCMT = textFieldCMT;
	}

	public JTextField getTextFieldTT() {
		return textFieldTT;
	}

	public void setTextFieldTT(JTextField textFieldTT) {
		this.textFieldTT = textFieldTT;
	}

	public JTextField getTextFieldTGG() {
		return textFieldTGG;
	}

	public void setTextFieldTGG(JTextField textFieldTGG) {
		this.textFieldTGG = textFieldTGG;
	}

	public JTextField getTextFieldCTT() {
		return textFieldCTT;
	}

	public void setTextFieldCTT(JTextField textFieldCTT) {
		this.textFieldCTT = textFieldCTT;
	}

	public JTextField getTextFieldBS() {
		return textFieldBS;
	}

	public void setTextFieldBS(JTextField textFieldBS) {
		this.textFieldBS = textFieldBS;
	}
}
