package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 628, 473);
		frame.getContentPane().add(tabbedPane);
		
		AjouterFilm tabAjFlm = new AjouterFilm();
		AjouterRealisateur tabAjRea = new AjouterRealisateur();
		SupprimerFilm tabSuppFlm = new SupprimerFilm();
		SupprimerRealisateur tabSuppRea = new SupprimerRealisateur();
		RechercherFilm tabRechFlm = new RechercherFilm();
		Vente tabVente = new Vente();
		
		
		tabbedPane.add("Ajouter Film", tabAjFlm);
		tabbedPane.add("SupprimerFilm", tabSuppFlm);
		tabbedPane.add("Ajouter Realisateur", tabAjRea);
		tabbedPane.add("Supprimer Realisateur", tabSuppRea);
		tabbedPane.add("RecherCher Film", tabRechFlm);
		tabbedPane.add("Vente", tabVente);
		
		tabAjRea.setComboBox(tabAjFlm.getComboBox());
		tabAjRea.setComboSupp(tabSuppFlm.getComboBox());
		tabSuppRea.setComboBox(tabAjFlm.getComboBox());
		tabSuppRea.setComboSupp(tabSuppFlm.getComboBox());
		
		
	}
}
