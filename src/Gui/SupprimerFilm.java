package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import Core.StockManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.sql.*;

public class SupprimerFilm extends JPanel {
	private StockManager mng;
	private JTable table;
	
	

	/**
	 * Create the panel.
	 */
	public SupprimerFilm() {
		setLayout(null);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(178, 266, 89, 23);
		add(btnSupprimer);
		try
		{
		
			mng = new StockManager();
			table = new JTable(buildTableModel(mng.getAllFilms()));
			table.setBounds(28, 32, 384, 210);
			add(table);
			
		}
		catch(SQLException e)
		{
			
		}
		
		

	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
}
