package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Core.StockManager;
import Core.Realisateur;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class AjouterRealisateur extends JPanel {
	private JTextField lnNom;
	private JTextField lnPrenom;
	private JButton btnAjouter;
	private JComboBox comboHolder;
	private JComboBox cmbHold;
	private StockManager mng;

	/**
	 * Create the panel.
	 */
	public AjouterRealisateur() {
		setLayout(null);
		
		try
		{
			mng = new StockManager();
		}
		catch(SQLException e)
		{
			
		}
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(76, 58, 46, 14);
		add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(76, 164, 46, 14);
		add(lblPrenom);
		
		lnNom = new JTextField();
		lnNom.setBounds(201, 55, 182, 20);
		add(lnNom);
		lnNom.setColumns(10);
		
		lnPrenom = new JTextField();
		lnPrenom.setBounds(201, 161, 182, 20);
		add(lnPrenom);
		lnPrenom.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(181, 243, 89, 23);
		btnAjouter.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { 
		    buttonPressed();
		  }

		private void buttonPressed() {
			
			try {
				Realisateur r = new Realisateur(lnNom.getText(), lnPrenom.getText());
				mng.addRealisateur(r);
				String s = r.getNom() + " "+ r.getPrenom();
				comboHolder.addItem(s);
				cmbHold.addItem(s);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		} } );
		add(btnAjouter);

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
