package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Core.StockManager;
import Core.Realisateur;
import Core.FilmFactory;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import java.util.StringTokenizer;;


public class AjouterFilm extends JPanel {
	private JTextField textField;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JComboBox comboType;
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
		
		JLabel lblRealisateur = new JLabel("Realisateur :");
		lblRealisateur.setBounds(25, 192, 68, 14);
		add(lblRealisateur);
		
		textField = new JTextField();
		textField.setBounds(124, 55, 229, 20);
		add(textField);
		textField.setColumns(10);
		
	    spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 16.0, 1.0));
		spinner.setBounds(124, 122, 229, 20);
		add(spinner);
		
	    comboBox = new JComboBox();
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
		btnAjouterFilm.setBounds(329, 282, 89, 23);
		btnAjouterFilm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
				
			}
		
		});
		add(btnAjouterFilm);
		
	    comboType = new JComboBox();
		comboType.setBounds(124, 246, 229, 20);
		comboType.addItem("Film Romance");
		comboType.addItem("Film Action");
		comboType.addItem("Film Science Fiction");
		add(comboType);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(25, 249, 46, 14);
		add(lblType);

	}
	
	JComboBox getComboBox()
	{
		return comboBox;
	}
	
	private void buttonClicked()
	{
		FilmFactory fact = new FilmFactory();
		
		String str = (String)comboBox.getSelectedItem();
		
		StringTokenizer tk = new StringTokenizer(str, " ",false);
		
		try {
			mng.addFilm(fact.makeFilm(comboType.getSelectedIndex()+1, 
					                  new Realisateur(tk.nextToken(), tk.nextToken()), 
					                  textField.getText(), 
					                  (double)spinner.getValue()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
