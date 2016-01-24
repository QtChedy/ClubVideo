package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class SupprimerFilm extends JPanel {

	/**
	 * Create the panel.
	 */
	public SupprimerFilm() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(32, 27, 389, 209);
		add(list);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(178, 266, 89, 23);
		add(btnSupprimer);

	}
}
