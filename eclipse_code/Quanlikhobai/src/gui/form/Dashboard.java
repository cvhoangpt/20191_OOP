package gui.form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JScrollPane;

import java.awt.Font;

//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;

import control.Modify;
import database.export.FrameRender;
import database.export.ModifiedQuery;
import database.export.SearchQuery;
import entity.contract.Hopdong;
import entity.user.*;
import entity.vehicle.Xecon;
import entity.vehicle.Xetai;
import gui.can.StartFrame;
import gui.can.Erasable;
import util.Calculate;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Phương thức Dashboard: Giao diện điều khiển chính của chương trình
 * @version 1.0
 * @author Hoangcv
 * @since 10/2019
 */
@SuppressWarnings("rawtypes")
public class Dashboard extends Window implements StartFrame, Erasable
{
	private JFrame frame;
	
	public JFrame getFrame() 
	{
		return frame;
	}

	public void setFrame(JFrame frame) 
	{
		this.frame = frame;
		frame.getContentPane().addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tableBriefs.getSelectionModel().clearSelection();
			}
		});
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
	private JTextField textTimKiem;
	private JTable tableBriefs;
	private JTextField textTenChuXe;
	private JTextField textSoDienThoai;
	private JTextField textDiaChi;
	private JTextField textThuDienTu;
	private JTextField textSoCMND;
	private JTextField textBienSo;
	private JTextField textTrongTai;
	private JTextField textThoiGianGui;
	private JComboBox boxLoaiXe;
	private JComboBox boxLoaiSearch;
	private JTextField textCachThanhToan;
	private JLabel lblcalVehicle;
	public static String tenChuXe;
	public static int soDienThoai;
	public static String diaChi;
	public static String thuDienTu;
	public static int soCMND; 
	public static String bienSo;
	public static String trongTai;
	public static String thoiGianGui;
	public static String cachThanhToan;
	public static String loaiXe;
	public static String loaiSearch;
	Khachhang khachHang = new Khachhang();
	Xecon xeCon = new Xecon();
	Xetai xeTai = new Xetai();
	Hopdong hopDong = new Hopdong();

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
		ModifiedQuery modifiedQuery = new ModifiedQuery();
		FrameRender frameRender = new FrameRender();
		SearchQuery searchQuery = new SearchQuery();
		Dialog dialog = new Dialog();
		Modify modify = new Modify();
		
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
		
		textTenChuXe = new JTextField();
		textTenChuXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTenChuXe.setBounds(169, 120, 300, 35);
		frame.getContentPane().add(textTenChuXe);
		textTenChuXe.setColumns(10);
		
		JLabel lblLX = new JLabel("Loại xe*");
		lblLX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLX.setBounds(82, 177, 75, 16);
		frame.getContentPane().add(lblLX);
		String cbloaiXe[] = {"Xe con", "Xe tải"};
		boxLoaiXe = new JComboBox (cbloaiXe);
		boxLoaiXe.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (boxLoaiXe.getSelectedItem().toString() == "Xe con") textTrongTai.setText("");
			}
		});
		
		boxLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boxLoaiXe.setBounds(169, 170, 84, 33);
		boxLoaiXe.setVisible(true);
		frame.getContentPane().add(boxLoaiXe);
		
		JLabel lblTT = new JLabel("Trọng tải (tấn)");
		lblTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTT.setBounds(274, 173, 111, 25);
		textTrongTai = new JTextField();
		textTrongTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTrongTai.setBounds(385, 168, 84, 35);
		frame.getContentPane().add(lblTT);
		//textFieldTT.setVisible(true);
		frame.getContentPane().add(textTrongTai);
		
		JLabel lblTGG = new JLabel("TG Gửi (tháng)*");
		lblTGG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTGG.setBounds(50, 224, 122, 20);
		frame.getContentPane().add(lblTGG);
		
		textThoiGianGui = new JTextField();
		textThoiGianGui.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textThoiGianGui.setBounds(171, 216, 82, 35);
		frame.getContentPane().add(textThoiGianGui);
		
		JLabel lblBS = new JLabel("Biển số*");
		lblBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBS.setBounds(277, 226, 68, 16);
		frame.getContentPane().add(lblBS);
		
		textBienSo = new JTextField();
		textBienSo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textBienSo.setBounds(347, 218, 122, 33);
		frame.getContentPane().add(textBienSo);
		textBienSo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SĐT*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(107, 317, 50, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textSoDienThoai = new JTextField();
		textSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textSoDienThoai.setColumns(10);
		textSoDienThoai.setBounds(169, 308, 300, 35);
		frame.getContentPane().add(textSoDienThoai);
		
		textDiaChi = new JTextField();
		textDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(169, 356, 300, 35);
		frame.getContentPane().add(textDiaChi);
		
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
		
		textSoCMND = new JTextField();
		textSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textSoCMND.setColumns(10);
		textSoCMND.setBounds(169, 452, 300, 35);
		frame.getContentPane().add(textSoCMND);
		
		textThuDienTu = new JTextField();
		textThuDienTu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textThuDienTu.setColumns(10);
		textThuDienTu.setBounds(169, 404, 300, 35);
		frame.getContentPane().add(textThuDienTu);
		
		JButton btnThemHD = new JButton("Thêm HD");
		btnThemHD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//kiểm tra các trường bị thiếu
				if (modify.nineElementIsEmpty(textTenChuXe, textSoDienThoai, textDiaChi, textSoCMND, textBienSo, textThoiGianGui, textCachThanhToan, boxLoaiXe, textTrongTai) == true) return;	
				tenChuXe = textTenChuXe.getText();
				soDienThoai = Integer.parseInt(textSoDienThoai.getText());
				soCMND = Integer.parseInt(textSoCMND.getText());
				diaChi = textDiaChi.getText();
				thuDienTu = textThuDienTu.getText();
				bienSo = textBienSo.getText();
				//kiểm tra trùng biển số xe
				if (frameRender.duplicateBienSo(bienSo) == true) return;
				trongTai = textTrongTai.getText();
				thoiGianGui = textThoiGianGui.getText();
				cachThanhToan = textCachThanhToan.getText();
				loaiXe = boxLoaiXe.getSelectedItem().toString();
				
				try 
				{
					modifiedQuery.insertHopDong(tenChuXe, soDienThoai, soCMND, diaChi, thuDienTu, bienSo, trongTai, thoiGianGui, cachThanhToan, loaiXe);
					frameRender.refreshTable(tableBriefs);
					visibleCalVehicle();
				} catch (SQLException e1) 
				{	
					e1.printStackTrace();
				}
				
			}
		});
		btnThemHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemHD.setBounds(171, 510, 135, 46);
		getFrame().getContentPane().add(btnThemHD);
		
		JButton btnXoaHD = new JButton("Xoá HD");
		btnXoaHD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (modify.tcx_bsDeleteIsEmpty(textTenChuXe, textBienSo) == true) return;
				
				bienSo = textBienSo.getText();
				//System.out.println(bs);
				try
				{
					modifiedQuery.deleteHopDong(bienSo);
					frameRender.refreshTable(tableBriefs);
					removeField();
					visibleCalVehicle();
				} catch (Exception e4)
				{
					e4.printStackTrace();
				}
				
			}
		});
		btnXoaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaHD.setBounds(171, 569, 135, 46);
		getFrame().getContentPane().add(btnXoaHD);
		
		JButton btnCapNhatHD = new JButton("Cập nhật HD");
		btnCapNhatHD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (modify.tcx_bsUpdateIsEmpty(textTenChuXe, textBienSo) == true) return;
				
				bienSo = textBienSo.getText();
				//System.out.println("update:" + bs);
				tenChuXe = textTenChuXe.getText();
				soDienThoai = Integer.parseInt(textSoDienThoai.getText());
				soCMND = Integer.parseInt(textSoCMND.getText());
				diaChi = textDiaChi.getText();
				thuDienTu = textThuDienTu.getText();
				trongTai = textTrongTai.getText();
				thoiGianGui = textThoiGianGui.getText();
				cachThanhToan = textCachThanhToan.getText();
				loaiXe = boxLoaiXe.getSelectedItem().toString();
				bienSo = textBienSo.getText();
				
				try
				{
					modifiedQuery.updateHopDong(tenChuXe, soDienThoai, soCMND, diaChi, thuDienTu, bienSo, trongTai, thoiGianGui, cachThanhToan, loaiXe);
					frameRender.refreshTable(tableBriefs);
					//visibleCalVehicle();
				} catch (SQLException se)
				{
					dialog.duplicateBienSo();
					se.printStackTrace();
				}					
			}
		});
		btnCapNhatHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhatHD.setBounds(334, 510, 135, 46);
		getFrame().getContentPane().add(btnCapNhatHD);
		
		JButton btnXoaTruong = new JButton("CF");
		btnXoaTruong.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				removeField();
			}
		});
		btnXoaTruong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaTruong.setBounds(334, 569, 59, 46);
		getFrame().getContentPane().add(btnXoaTruong);
		
		JButton btnThongKe = new JButton("TK doanh thu");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setBounds(171, 628, 135, 46);
		getFrame().getContentPane().add(btnThongKe);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (textTimKiem.getText().isEmpty())
				{
					dialog.searchException();
					return;
				}
				String value = textTimKiem.getText();
				loaiSearch = boxLoaiSearch.getSelectedItem().toString();
				if (loaiSearch == "Chủ xe") searchQuery.tenChuXeSearchResult(tableBriefs, value);
				else if (loaiSearch == "Biển số xe") searchQuery.bienSoSearchResult(tableBriefs, value);
				else if (loaiSearch == "Loại xe") searchQuery.loaiXeSearchResult(tableBriefs, value);
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(1193, 61, 143, 46);
		getFrame().getContentPane().add(btnTimKiem);
		
		textTimKiem = new JTextField();
		textTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTimKiem.setBounds(1077, 16, 259, 35);
		getFrame().getContentPane().add(textTimKiem);
		textTimKiem.setColumns(10);
		
		String loaiSearch[] = {"Chủ xe", "Biển số xe", "Loại xe"};
		//DefaultComboBoxModel<String> loaiSearchModel = new DefaultComboBoxModel<String>(loaiSearch);
		boxLoaiSearch = new JComboBox(loaiSearch);
		boxLoaiSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textTimKiem.setText("");
			}
		});
		boxLoaiSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boxLoaiSearch.setBounds(956, 15, 111, 37);
		getFrame().getContentPane().add(boxLoaiSearch);
		
		JCheckBox chckbxPhi2 = new JCheckBox("Xe có phí gửi >2 tr/tháng");
		chckbxPhi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (chckbxPhi2.isSelected()) System.out.println("Đã được check");
				else System.out.println("Chưa được check");
			}
		});
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
					frameRender.selectRow(rowBienSo);
					khachHang = frameRender.getTextFieldKhachHang();
					hopDong = frameRender.getTextFieldHopDong();
					xeCon = frameRender.getTextFieldXeCon();
					xeTai = frameRender.getTextFieldXeTai();
					
					//System.out.println("hung" + khachHang.getTenChuXe());
					
					textTenChuXe.setText(khachHang.getTenChuXe());
					textSoDienThoai.setText(String.valueOf(khachHang.getSoDienThoai()));
					textDiaChi.setText(khachHang.getDiaChi());
					textThuDienTu.setText(khachHang.getThuDienTu());
					textSoCMND.setText(String.valueOf(khachHang.getSoCMND()));
					textCachThanhToan.setText(hopDong.getHinhThucThanhToan());
					System.out.println("otherQuery.getLoaiXe()=" + frameRender.getLoaiXe());
					System.out.println("xeCon.getBienSo()"+xeCon.getBienSo());
					
					if (frameRender.getLoaiXe() == "Xe con") 
					{
//						xeCon = frameRender.getTextFieldXeCon();
						//System.out.println("xeCon="+xeCon);
						textBienSo.setText(xeCon.getBienSo());
						System.out.println("xeCon.getBienSo()"+xeCon.getBienSo());
						textTrongTai.setText(String.valueOf(xeCon.getTrongTai()));
						textThoiGianGui.setText(String.valueOf(xeCon.getThoiGianGui()));
						boxLoaiXe.setSelectedItem(xeCon.getLoaiXe());
					} else 
					{
//						xeTai = frameRender.getTextFieldXeTai();
						textBienSo.setText(xeTai.getBienSo());
						System.out.println("xeCon.getBienSo()"+xeTai.getBienSo());
						textTrongTai.setText(String.valueOf(xeTai.getTrongTai()));
						textThoiGianGui.setText(String.valueOf(xeTai.getThoiGianGui()));
						boxLoaiXe.setSelectedItem(xeTai.getLoaiXe());
					}
					
					
				} catch (Exception e3)
				{
					e3.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableBriefs);
		tableBriefs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		frameRender.refreshTable(tableBriefs);
		
		JLabel lblCTT = new JLabel("Cách thanh toán");
		lblCTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCTT.setBounds(50, 275, 122, 16);
		frame.getContentPane().add(lblCTT);
		
		textCachThanhToan = new JTextField();
		textCachThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCachThanhToan.setBounds(169, 264, 300, 38);
		frame.getContentPane().add(textCachThanhToan);
		textCachThanhToan.setColumns(10);
		
		JLabel lblNote1 = new JLabel("(*) bắt buộc");
		lblNote1.setBounds(169, 96, 97, 16);
		frame.getContentPane().add(lblNote1);
		
		JLabel lblNote2 = new JLabel("CF: Xoá các trường");
		lblNote2.setBounds(334, 628, 135, 16);
		frame.getContentPane().add(lblNote2);
		
		JLabel lblNote3 = new JLabel("RT: Làm mới bảng");
		lblNote3.setBounds(334, 644, 135, 16);
		frame.getContentPane().add(lblNote3);
		
		JButton btnRt = new JButton("RT");
		btnRt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frameRender.refreshTable(tableBriefs);
				} catch (SQLException se)
				{
					se.printStackTrace();
				}
			}
		});
		btnRt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRt.setBounds(410, 569, 59, 46);
		frame.getContentPane().add(btnRt);
		
		Calculate c = new Calculate();
		lblcalVehicle = new JLabel("Bãi gửi xe đang có "+c.calVehicle()+" xe.");
		lblcalVehicle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcalVehicle.setBounds(497, 88, 200, 30);
		frame.getContentPane().add(lblcalVehicle);
		
	}
	/**
	 * Phương thức xoá trường. Ghi đè phương thức của Interface Ability
	 */
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
	 * Phương thức làm mới JLabel
	 * Chưa hoàn thiện
	 */
	public void visibleCalVehicle()
	{
		getLblcalVehicle().setVisible(false);
		getLblcalVehicle().setVisible(true);
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
					Dialog d = new Dialog();
					d.crash();
					e2.printStackTrace();
				}
			}
		});
	}

	public JTextField getTextFieldTCX() {
		return textTenChuXe;
	}

	public void setTextFieldTCX(JTextField textFieldTCX) {
		this.textTenChuXe = textFieldTCX;
	}

	public JTextField getTextFieldSDT() {
		return textSoDienThoai;
	}

	public void setTextFieldSDT(JTextField textFieldSDT) {
		this.textSoDienThoai = textFieldSDT;
	}

	public JTextField getTextFieldDC() {
		return textDiaChi;
	}

	public void setTextFieldDC(JTextField textFieldDC) {
		this.textDiaChi = textFieldDC;
	}

	public JTextField getTextFieldTDT() {
		return textThuDienTu;
	}

	public void setTextFieldTDT(JTextField textFieldTDT) {
		this.textThuDienTu = textFieldTDT;
	}

	public JTextField getTextFieldCMT() {
		return textSoCMND;
	}

	public void setTextFieldCMT(JTextField textFieldCMT) {
		this.textSoCMND = textFieldCMT;
	}

	public JTextField getTextFieldTT() {
		return textTrongTai;
	}

	public void setTextFieldTT(JTextField textFieldTT) {
		this.textTrongTai = textFieldTT;
	}

	public JTextField getTextFieldTGG() {
		return textThoiGianGui;
	}

	public void setTextFieldTGG(JTextField textFieldTGG) {
		this.textThoiGianGui = textFieldTGG;
	}

	public JTextField getTextFieldCTT() {
		return textCachThanhToan;
	}

	public void setTextFieldCTT(JTextField textFieldCTT) {
		this.textCachThanhToan = textFieldCTT;
	}

	public JTextField getTextFieldBS() {
		return textBienSo;
	}

	public void setTextFieldBS(JTextField textFieldBS) {
		this.textBienSo = textFieldBS;
	}

	public JLabel getLblcalVehicle() {
		return lblcalVehicle;
	}

	public void setLblcalVehicle(JLabel lblcalVehicle) {
		this.lblcalVehicle = lblcalVehicle;
	}
}
