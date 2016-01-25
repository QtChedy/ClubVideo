package Gui;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;

import Core.Realisateur;
import Core.StockManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class RechercherFilm extends JPanel {
	private JTextField textField;
	private JTable table;
	private JComboBox comboBox;
	private StockManager mng;

	/**
	 * Create the panel.
	 */
	public RechercherFilm() {
		setLayout(null);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(227, 26, 114, 20);
		comboBox.addItem("Realisateur");
		comboBox.addItem("Type");
		comboBox.addItem("Titre");
		add(comboBox);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(351, 25, 89, 23);
		btnRechercher.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { 
		    buttonPressed();
		  } 
		} );
		add(btnRechercher);
		
		textField = new JTextField();
		textField.setBounds(20, 26, 185, 20);
		add(textField);
		textField.setColumns(10);
		

		try
		{
			mng = new StockManager();
			table = new JTable(buildTableModel(mng.getAllFilms("titre,prix,type")));
			table.setBounds(10, 75, 430, 214);
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
	public void buttonPressed()
	{
		try
		{
			System.out.println((String)comboBox.getSelectedItem() + textField.getText());
			String tmp = (String)comboBox.getSelectedItem();
			String col;
			String val = "'"+textField.getText()+"'";
			if(tmp.equals("Realisateur"))
			{
				col = "id_realisateur";
				StringTokenizer tk = new StringTokenizer(val, " ", false);
				String value = (new Integer(((new Realisateur(tk.nextToken(), tk.nextToken())).hashCode()))).toString();
				System.out.println(value);
				val = value;
				System.out.println(val);
				
			}
			else if(tmp.equals("Type"))
				col = "type";
		    else 
				col = "titre";
			table.setModel(buildTableModel(mng.filterFilm(col, val)));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
