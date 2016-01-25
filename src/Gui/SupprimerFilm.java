package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import Core.FilmFactory;
import Core.Realisateur;
import Core.StockManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class SupprimerFilm extends JPanel {
	private StockManager mng;
	private JTextField textField;
	private JComboBox comboType;
	private JComboBox comboBox;
	private JSpinner spinner;
	
	

	/**
	 * Create the panel.
	 */
	public SupprimerFilm() {
		setLayout(null);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(319, 287, 89, 23);
		btnSupprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
				
			}
		
		});
		add(btnSupprimer);
		
		comboBox = new JComboBox();
		comboBox.setBounds(148, 187, 229, 20);
		add(comboBox);
		
		JLabel label = new JLabel("Realisateur");
		label.setBounds(49, 190, 68, 14);
		add(label);
		
		JLabel label_1 = new JLabel("prix :");
		label_1.setBounds(49, 123, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Titre Film :");
		label_2.setBounds(49, 56, 56, 14);
		add(label_2);
		
		spinner = new JSpinner();
		spinner.setBounds(148, 120, 229, 20);
		add(spinner);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 53, 229, 20);
		add(textField);
		
		comboType = new JComboBox();
		comboType.setBounds(148, 244, 229, 20);
		comboType.addItem("Film Romance");
		comboType.addItem("Film Action");
		comboType.addItem("Film Science Fiction");
		add(comboType);
		
		JLabel label_3 = new JLabel("Type :");
		label_3.setBounds(49, 247, 46, 14);
		add(label_3);
		try
		{
			mng = new StockManager();
			ResultSet s = mng.getAllRealisateur();
			while(s.next())
			{
				comboBox.addItem(s.getString("nom")+ " "+s.getString("prenom"));
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("error");
		}
		
		

	}
	
	private void buttonClicked()
	{
		FilmFactory fact = new FilmFactory();
		
		String str = (String)comboBox.getSelectedItem();
		StringTokenizer tk = new StringTokenizer(str, " ",false);
		
		try {
			mng.removeFilm((   fact.makeFilm(comboType.getSelectedIndex()+1, 
					                  new Realisateur(tk.nextToken(), tk.nextToken()), 
					                  textField.getText(), 
					                  Double.parseDouble(spinner.getValue().toString()))).hashCode()
					   );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	JComboBox getComboBox()
	{
		return comboBox;
	}
}
