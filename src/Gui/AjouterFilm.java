package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Core.StockManager;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.sql.*;;


public class AjouterFilm extends JPanel {
	private JTextField textField;
	private StockManager mng;

	/**
	 * Create the panel.
	 */
	public AjouterFilm() {
		setLayout(null);
		
		JLabel lblTitreFilm = new JLabel("Titre Film :");
		lblTitreFilm.setBounds(25, 58, 56, 14);
		add(lblTitreFilm);
		
		JLabel lblPrix = new JLabel("prix :");
		lblPrix.setBounds(25, 125, 46, 14);
		add(lblPrix);
		
		JLabel lblRealisateur = new JLabel("Realisateur");
		lblRealisateur.setBounds(25, 192, 68, 14);
		add(lblRealisateur);
		
		textField = new JTextField();
		textField.setBounds(124, 55, 229, 20);
		add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 16.0, 1.0));
		spinner.setBounds(124, 122, 229, 20);
		add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 189, 229, 20);
		add(comboBox);
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
			System.out.println("hello");
		}
		
		JButton btnAjouterFilm = new JButton("Ajouter Film");
		btnAjouterFilm.setBounds(329, 231, 89, 23);
		add(btnAjouterFilm);

	}
}
