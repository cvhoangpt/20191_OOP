package control;

import java.sql.SQLException;

import javax.swing.JTable;

import database.export.FrameRender;

/**
 * Lớp điều khiển việc thao tác giao diện
 * @author hoangcv
 *
 */
public class FrameControl 
{
	public void refreshTable(JTable table) throws SQLException
	{
		new FrameRender().refreshTable(table);
	}
	
	public void selectRow(String rowBienSo)
	{
		new FrameRender().selectRow(rowBienSo);
	}
}
