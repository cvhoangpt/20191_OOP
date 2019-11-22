package control;

import java.sql.SQLException;

import javax.swing.JTable;

import database.processing.FormRender;

/**
 * Lớp điều khiển việc thao tác giao diện
 * @author hoangcv
 *
 */
public class FormControl 
{
	public void refreshTable(JTable table) throws SQLException
	{
		new FormRender().refreshTable(table);
	}
}
