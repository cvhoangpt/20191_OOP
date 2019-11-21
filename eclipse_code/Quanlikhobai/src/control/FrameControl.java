package control;

import java.sql.SQLException;

import javax.swing.JTable;

import database.export.FrameRender;

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
