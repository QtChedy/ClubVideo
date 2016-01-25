package Gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.Realisateur;
import Core.StockManager;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class SupprimerRealisateur extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboHolder;
	private JComboBox cmbHold;
	private StockManager mng;

	/**
	 * Create the panel.
	  
	 */
	public SupprimerRealisateur()   {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 155, 182, 20);
		add(textField);
		
		try {
			mng = new StockManager();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel label = new JLabel("Prenom :");
		label.setBounds(54, 158, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Nom :");
		label_1.setBounds(54, 52, 46, 14);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 49, 182, 20);
		add(textField_1);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(174, 243, 89, 23);
		btnSupprimer.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { 
		    buttonPressed();
		  }});
		add(btnSupprimer);

	}

	protected void buttonPressed() {
		try {
			Realisateur r = new Realisateur(textField_1.getText(), textField.getText());
			mng.removeRealisateur(r.hashCode());
			String s = r.getNom() + " "+ r.getPrenom();
			comboHolder.removeItem(s);
			cmbHold.removeItem(s);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void setComboBox(JComboBox combo)
	{
		comboHolder = combo;
	}
	public void setComboSupp(JComboBox combo)
	{
		cmbHold = combo;
	}
}
