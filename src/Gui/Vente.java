package Gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

import Core.SellManager;
import Core.StockManager;
import Core.Chariot;
import Core.Film;

import java.sql.ResultSet;

public class Vente extends JPanel {
	private JTable table;
	private SellManager mng;
	private StockManager stckMng;
	private Chariot chariot;


	/**
	 * Create the panel.
	 */
	public Vente() {
		setLayout(null);
		
		
		
		try {
			mng = new SellManager();
			stckMng = new StockManager();
			chariot = new Chariot((int)Math.random()*100);
			
			table = new JTable(buildTableModel(stckMng.getAllFilms()));
			table.setBounds(20, 22, 405, 201);
			add(table);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnCommander = new JButton("Ajouter au Panier");
		btnCommander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonClicked();
			}
		});
		btnCommander.setBounds(178, 234, 126, 23);
		add(btnCommander);
		
		JButton btnPasserLaCommande = new JButton("passer La commande");
		btnPasserLaCommande.setBounds(307, 266, 133, 23);
		btnPasserLaCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button();
			}
		});
		add(btnPasserLaCommande);

	}
	protected void button() 
	{
		System.out.println("yuuuu");
		try {
			mng.vend(chariot);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 2; column <= columnCount-1; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 2; columnIndex <= columnCount-1; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}

	protected void buttonClicked() 
	{
		int row = table.getSelectedRow();
		if(row == -1)
			return;

			
			Film f = stckMng.toFilm(row);
			if(f != null)
				chariot.addFilm(f);
			else 
				System.out.println("film null");

		
	}
	

}
