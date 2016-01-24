package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AjouterRealisateur extends JPanel {
	private JTextField lnNom;
	private JTextField lnPrenom;
	private JButton btnAjouter;

	/**
	 * Create the panel.
	 */
	public AjouterRealisateur() {
		setLayout(null);
		
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
		add(btnAjouter);

	}

}
