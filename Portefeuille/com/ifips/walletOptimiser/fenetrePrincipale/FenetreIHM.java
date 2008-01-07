package com.ifips.walletOptimiser.fenetrePrincipale;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import com.ifips.walletOptimiser.algo.Lagrange;
import com.ifips.walletOptimiser.algo.MonCPLEX;
import com.ifips.walletOptimiser.algo.RecuitSimule;
import com.ifips.walletOptimiser.algo.VNS;

import java.io.File;
import java.io.InputStream;
import java.util.Vector;

public class FenetreIHM extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanelProbleme panProb = new PanelProbleme();
	
	private PanelResolution panReso = new PanelResolution();
	
	private VNS leVNS = null;  //  @jve:decl-index=0:
	
	private RecuitSimule leRecuit = null;
	
	private MonCPLEX leCPLEX = null;
	
	private Lagrange leLagrange = null;
	
	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu jMenu_file = null;

	private JMenu jMenu_help = null;

	private JMenuItem jMenuItem_file = null;

	private JMenuItem jMenuItem_quit = null;

	private JTabbedPane jTabbedPane_general = null;

	private JMenuItem jMenuItem_help = null;

	private JMenuItem jMenuItem_about = null;

	private JMenuItem jMenuItem_save = null;

	/**
	 * This is the default constructor
	 */
	public FenetreIHM() {
		super();
		initialize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//this.setSize(750, 630);
		this.setSize(new Dimension(710, 650));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Gestion de problèmes d'optimisation");
		this.setIconImage(this.getToolkit().getImage("walleticon.png"));
	}

	public void launchResolution() {
		jTabbedPane_general.setEnabledAt(1, true);
		jTabbedPane_general.setSelectedIndex(1);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane_general(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu_file());
			jJMenuBar.add(getJMenu_help());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu_file	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_file() {
		if (jMenu_file == null) {
			jMenu_file = new JMenu();
			jMenu_file.setText("Fichier");
			jMenu_file.add(getJMenuItem_file());
			jMenu_file.add(getJMenuItem_save());
			jMenu_file.add(getJMenuItem_quit());
		}
		return jMenu_file;
	}

	/**
	 * This method initializes jMenu_help	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_help() {
		if (jMenu_help == null) {
			jMenu_help = new JMenu();
			jMenu_help.setText("Aide");
			jMenu_help.add(getJMenuItem_help());
			jMenu_help.add(getJMenuItem_about());
		}
		return jMenu_help;
	}

	/**
	 * This method initializes jMenuItem_file	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_file() {
		if (jMenuItem_file == null) {
			jMenuItem_file = new JMenuItem();
			jMenuItem_file.setText("Charger problème...");
			jMenuItem_file.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FiltreFichiers filtre = new FiltreFichiers("Fichiers XML (*.xml)",".xml");
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("/"));
					chooser.changeToParentDirectory();
					chooser.removeChoosableFileFilter(chooser.getFileFilter());
					chooser.addChoosableFileFilter(filtre);
					int retour = chooser.showOpenDialog(null);
					if (retour == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile() != null && !chooser.getSelectedFile().getName().equals("")) {
						System.out.println("Charger : " + chooser.getSelectedFile().getName());
					}
				}
			});
		}
		return jMenuItem_file;
	}

	/**
	 * This method initializes jMenuItem_quit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_quit() {
		if (jMenuItem_quit == null) {
			jMenuItem_quit = new JMenuItem();
			jMenuItem_quit.setText("Quitter");
			jMenuItem_quit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int reponse = JOptionPane.showConfirmDialog(new Frame(),
							"Voulez-vous vraiment quitter ?",
							"Quitter ?", 
							JOptionPane.YES_NO_OPTION);
					if (reponse == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
		}
		return jMenuItem_quit;
	}

	/**
	 * This method initializes jTabbedPane_general	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_general() {
		if (jTabbedPane_general == null) {
			jTabbedPane_general = new JTabbedPane();
			jTabbedPane_general.add("Problème", panProb);
			jTabbedPane_general.add("Résolution", panReso);
			jTabbedPane_general.setEnabledAt(1, false);
		}
		return jTabbedPane_general;
	}

	/**
	 * This method initializes jMenuItem_help	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_help() {
		if (jMenuItem_help == null) {
			jMenuItem_help = new JMenuItem();
			jMenuItem_help.setText("Aide");
			jMenuItem_help.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						Process p = Runtime.getRuntime().exec("cmd /C start manuel.pdf");
						InputStream stdOut = p.getInputStream();
						if(stdOut.read() != -1){
							System.err.println("Erreur ! Acrobat Reader est-il installé ?");
						}
					}catch(Exception exception){
						System.err.println("Exception occured: " + e);
					} 
				}
			});
		}
		return jMenuItem_help;
	}

	/**
	 * This method initializes jMenuItem_about	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_about() {
		if (jMenuItem_about == null) {
			jMenuItem_about = new JMenuItem();
			jMenuItem_about.setText("A propos...");
			jMenuItem_about.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Gestion de problèmes d'optimisation v1.0\n\n" +
							"IFIPS CI-3 Informatique - Groupe BERTHOMME\n\n" +
							"Année 2007-2008",
							"A propos...",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return jMenuItem_about;
	}

	/**
	 * This method initializes jMenuItem_save	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_save() {
		if (jMenuItem_save == null) {
			jMenuItem_save = new JMenuItem();
			jMenuItem_save.setText("Sauvegarder problème...");
			jMenuItem_save.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FiltreFichiers filtre = new FiltreFichiers("Fichiers XML (*.xml)",".xml");
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("/"));
					chooser.changeToParentDirectory();
					chooser.removeChoosableFileFilter(chooser.getFileFilter());
					chooser.addChoosableFileFilter(filtre);
					int retour = chooser.showSaveDialog(null);
					if (retour == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile() != null && !chooser.getSelectedFile().getName().equals("")) {
						if (chooser.getSelectedFile().exists()) {
							int reponse = JOptionPane.showConfirmDialog(new Frame(),
								       "Voulez-vous écraser le fichier existant \"" + chooser.getSelectedFile().getName() + "\" ?",
								       "Ecraser le fichier ?", 
								        JOptionPane.YES_NO_OPTION);
						  	if (reponse == JOptionPane.YES_OPTION) {
								System.out.println("Enregistrer : " + chooser.getSelectedFile().getName());
							}
						}
						else {
							System.out.println("Enregistrer : " + chooser.getSelectedFile().getName());
						}
					}
				}
			});
		}
		return jMenuItem_save;
	}
	
	public void ajouterTexteJournal(String texte) {
		panReso.appendTextJournal(texte);
	}
	
	public void ajouterTexteSolution(String texte) {
		panReso.appendTextSolution(texte);
	}
	
	public void viderTexteJournal() {
		panReso.clearTextJournal();
	}
	
	public void viderTexteSolution() {
		panReso.clearTextSolution();
	}
	
	public void setVNS(VNS v) {
		leVNS = v;
	}
	
	public void setRecuit(RecuitSimule r) {
		leRecuit = r;
	}
	
	public void setCPLEX(MonCPLEX c) {
		leCPLEX = c;
	}
	
	public void setLagrange(Lagrange l) {
		leLagrange = l;
	}
	
	public void setContraintes(Vector<String> cont) {
		panProb.setContraintes(cont);
	}
	
	public void setFonctionObjectif(String fct) {
		panProb.setFonctionObjectif(fct);
	}
	
	public VNS getVNS() {
		return leVNS;
	}
	
	public RecuitSimule getRecuit() {
		return leRecuit;
	}
	
	public Lagrange getLagrange() {
		return leLagrange;
	}
	
	public MonCPLEX getCPLEX() {
		return leCPLEX;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
