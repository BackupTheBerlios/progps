package progps_ihm;

import noyau.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JList;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

/**
 * 
 */
public class FenetrePrincipale extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private FenetrePreferences fenPrefs = null;
	
	private SingletonProgps progps = null;
	
	private Admin admin = null;
	
	private User utilisateur = null;
	
	private javax.swing.JPanel jFrameContentPane = null;

	private javax.swing.JMenuBar jMenuBar_menu = null;

	private javax.swing.JMenu jMenu_fichier = null;

	private javax.swing.JMenuItem jMenuItem_quitter = null;

	private JMenu jMenu_itineraire = null;

	private JMenu jMenu_aide = null;

	private JMenuItem jMenuItem_Aide = null;

	private JMenuItem jMenuItem_apropos = null;

	private JMenuItem jMenuItem_newitineraire = null;

	private JTabbedPane jTabbedPane_global = null;

	private JPanel jPanel_accueil = null;

	private JPanel jPanel_admin = null;

	private JPanel jPanel_itineraire = null;

	private JPanel jPanel_itineraireNorth = null;

	private JLabel jLabel_itineraireFrom = null;

	private JLabel jLabel_itineraireDepart = null;

	private JLabel jLabel_itineraireTo = null;
	
	private JLabel jLabel_itineraireArrivee = null;
	
	private JButton jButton_itineraireModifier = null;

	private JPanel jPanel_etapes = null;

	private JPanel jPanel_localisation = null;

	private JLabel jLabel_arrivea = null;

	private JButton jButton_OKlocalisation = null;

	private JScrollPane jScrollPane_etapes = null;

	private JTable jTable_etapes = null;
	
	private TableDataModel tabEtapesModele = new TableDataModel();  //  @jve:decl-index=0:visual-constraint="839,55"

	private JPasswordField jPasswordField_adminpass = null;

	private JLabel jLabel_adminpass = null;

	private JLabel jLabel_empty = null;

	private JButton jButton_okadmin = null;

	private ChoixItineraire jPanel_choixItineraire = null;

	private JLabel jLabel_accueil1 = null;

	private JPanel jPanel_accueilSouth = null;

	private JButton jButton_rechercherIti = null;

	private JPanel jPanel_params = null;

	private JLabel jLabel_villeDepart = null;

	private JPanel jPanel_paramsNorth = null;

	private JLabel jLabel_villeArrivee = null;

	private JLabel jLabel_empty1 = null;

	private JComboBox jComboBox_villeDepart = null;

	private JComboBox jComboBox_villeArrivee = null;

	private JLabel jLabel_empty2 = null;

	private JLabel jLabel_empty3 = null;

	private JLabel jLabel_empty4 = null;

	private JLabel jLabel_empty5 = null;

	private JLabel jLabel_empty8 = null;

	private JPanel jPanel_listVilles = null;

	private JButton jButton_versEtapes = null;

	private JButton jButton_enleverEtape = null;

	private JList jList_villes = null;

	private JButton jButton_versEviter = null;

	private JButton jButton_enleverEviter = null;

	private JLabel jLabel_empty7 = null;

	private JButton jButton_effacerVillesEtapes = null;

	private JButton jButton_effacerVillesEviter = null;

	private JPanel jPanel_globalParams = null;

	private JLabel jLabel_empty11 = null;

	private JLabel jLabel_empty13 = null;

	private JLabel jLabel_villesEtapes = null;

	private JLabel jLabel_villesEviter = null;

	private JLabel jLabel_options1 = null;

	private JCheckBox jCheckBox_options1 = null;

	private JLabel jLabel_options2 = null;

	private JCheckBox jCheckBox_options2 = null;

	private JLabel jLabel_empty15 = null;

	private JLabel jLabel_empty16 = null;

	private JLabel jLabel_options3 = null;

	private JCheckBox jCheckBox_options3 = null;

	private JLabel jLabel_options21 = null;

	private JLabel jLabel_options31 = null;

	private JLabel jLabel_options11 = null;

	private JLabel jLabel_empty17 = null;

	private JLabel jLabel_options4 = null;

	private JLabel jLabel_options41 = null;

	private JCheckBox jCheckBox_options4 = null;

	private JLabel jLabel_options42 = null;

	private JComboBox jComboBox_limitations = null;

	private JLabel jLabel_empty18 = null;

	private JLabel jLabel_options5 = null;

	private JRadioButton jRadioButton1 = null;

	private JRadioButton jRadioButton2 = null;

	private JLabel jLabel_options51 = null;

	private JLabel jLabel_options53 = null;

	private JLabel jLabel_options52 = null;

	private ButtonGroup radioGroup1 = new ButtonGroup();  //  @jve:decl-index=0:

	private JLabel jLabel_empty12 = null;

	private JLabel jLabel_empty19 = null;

	private JScrollPane jScrollPane_villes = null;

	private JScrollPane jScrollPane_villesEtapes = null;

	private JList jList_villesEtapes = null;

	private JScrollPane jScrollPane_villesEviter = null;

	private JList jList_villesEviter = null;

	private JLabel jLabel_deroul1 = null;

	private JLabel jLabel_deroul2 = null;

	private JPanel jPanel_globalVilles = null;

	private JLabel jLabel_fillEmpty1 = null;

	private JPanel jPanel_listParams = null;

	private JLabel jLabel_fillEmpty2 = null;

	private JButton jButton_affinerParams = null;

	private JLabel jLabel_empty9 = null;

	private JMenu jMenu_edition = null;

	private JMenuItem jMenuItem_preferences = null;

	private JMenuItem jMenuItem_adminPass = null;

	private JLabel jLabel_empty20 = null;

	private JLabel jLabel_empty6 = null;

	private JComboBox jComboBox_villeCourante = null;

	private JLabel jLabel_empty43 = null;
	
	
	
	private int numEtape = 0;
	private int nbEtapes = 0;

	public FenetrePrincipale(SingletonProgps leProgps) {
		super();
		progps = leProgps;
		initialize();
	}

	/**
	 * Return the JFrameContentPane property value.
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJFrameContentPane() {
		if (jFrameContentPane == null) {
			jFrameContentPane = new javax.swing.JPanel();
			jFrameContentPane.setLayout(new BorderLayout());
			jFrameContentPane.add(getJTabbedPane_global(), BorderLayout.CENTER);
		}
		return jFrameContentPane;
	}

	/**
	 * Initialize the class.
	 */
	private void initialize() {
		this.setContentPane(getJFrameContentPane());
		this.setJMenuBar(getJMenuBar_menu());
		this.setTitle("ProGPS");
		this.setIconImage(this.getToolkit().getImage("images//gps_small.png"));
		this.setResizable(false);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(23, 36, 803, 740);
		jTabbedPane_global.setSelectedIndex(0);
		jTabbedPane_global.setEnabledAt(1,false);
		//jTabbedPane_global.setEnabledAt(2,false);
		toggleDisplayVilles();
		toggleDisplayParams();
	}
	
	private void toggleDisplayVilles() {
		if (jLabel_deroul1.getText().equals("-")) {
			jLabel_deroul1.setText("+");
			jLabel_fillEmpty1.setText("Afficher les options concernant les villes");
			jPanel_listVilles.setVisible(false);
			this.setSize(this.getWidth(),(this.getHeight()-200));
		}
		else {
			jLabel_deroul1.setText("-");
			jLabel_fillEmpty1.setText("Masquer les options concernant les villes");
			jPanel_listVilles.setVisible(true);
			this.setSize(this.getWidth(),(this.getHeight()+200));
		}
	}
	
	private void toggleDisplayParams() {
		if (jLabel_deroul2.getText().equals("-")) {
			jLabel_deroul2.setText("+");
			jLabel_fillEmpty2.setText("Afficher les paramètres disponibles pour la recherche");
			jPanel_listParams.setVisible(false);
			//jPanel_listParams.setSize(jPanel_listParams.getWidth(),1);
			//jPanel_globalParams.setSize(jPanel_globalParams.getWidth(),(jPanel_globalParams.getHeight()-40));
			//this.setSize(this.getWidth(),(this.getHeight()-5));
		}
		else {
			jLabel_deroul2.setText("-");
			jLabel_fillEmpty2.setText("Masquer les paramètres");
			jPanel_listParams.setVisible(true);
			//jPanel_globalParams.setSize(jPanel_globalParams.getWidth(),(jPanel_globalParams.getHeight()+235));
			//this.setSize(this.getWidth(),(this.getHeight()+235));
		}
	}
	
	private void initTabExemple() {
		
		Vector<String> line1 = new Vector<String>();
		line1.add("1");
		line1.add("Paris");
		line1.add("Dijon");
		line1.add("A6");
		line1.add("300 km");
		line1.add("payant/radar/touristique/130");
		
		Vector<String> line2 = new Vector<String>();
		line2.add("2");
		line2.add("Dijon");
		line2.add("Lyon");
		line2.add("A6");
		line2.add("200 km");
		line2.add("payant/110");
		
		Vector<String> line3 = new Vector<String>();
		line3.add("3");
		line3.add("Lyon");
		line3.add("Avignon");
		line3.add("N91");
		line3.add("100 km");
		line3.add("payant/touristique/90");
		
		Vector<String> line4 = new Vector<String>();
		line4.add("4");
		line4.add("Avignon");
		line4.add("Aix-en-Provence");
		line4.add("A6");
		line4.add("200 km");
		line4.add("radar/110");
		
		tabEtapesModele.addRow(line1);
		tabEtapesModele.addRow(line2);
		tabEtapesModele.addRow(line3);
		tabEtapesModele.addRow(line4);
		
		nbEtapes = 4;
	}
	
	/*public void initItineraire(Itineraire iti) {
		for (int i=0;i<nbEtapes; i++) {
			tabEtapesModele.removeRow(0);
		}
		
		Vector<String> line = new Vector<String>();
		int num = 1;
		
		Ville villeDep = iti.getVilleDepart();
		Ville villeArr = iti.getVilleArrivee();
		Ville derniereVilleTrav = villeDep;
		Ville tmp;
		String infos = "";
		
		for(Iterator iter = iti.getTroncons().iterator(); iter.hasNext();) {
			Troncon tronc = (Troncon)iter.next();
			line.add("" + num);												// Numero de l'etape
			line.add(derniereVilleTrav.getNomVille());						// Ville départ troncon			
			tmp = iti.getVilleSuivante(derniereVilleTrav);
			line.add(tmp.getNomVille());									// Ville arrivée troncon
			line.add(tronc.getSaRoute().getNomRoute());						// Nom de la route
			infos += tronc.getVitesse();
			
			for(Iterator iter2 = iti.getTronconCourant().getSesEtats().iterator(); iter2.hasNext();) {
				Etat e = (Etat)iter2.hasNext()
				infos += "/";
				infos += e.toString();
			}
			line.add(infos);
			
			tabEtapesModele.addRow(line);
			derniereVilleTrav = tmp;
			num++;
		}
		
		nbEtapes = --num;
		//jTable_etapes.repaint();
	}*/
	
	public void setVillesCourantesPoss(Vector<String> villes) {
		jComboBox_villeCourante.removeAllItems();
		Collections.sort(villes);
		DefaultComboBoxModel combo = new DefaultComboBoxModel(villes);
		jComboBox_villeCourante.setModel(combo);
		//for (int i=0;i<)
	}
	
	public void setNumEtapeCourante(int num) {
		if (num <= nbEtapes && num >= 0) {
			numEtape = num;
			jTable_etapes.setDefaultRenderer(Object.class, new CellGrisee(numEtape));
			jTable_etapes.getColumnModel().getColumn(5).setCellRenderer(new TabInfos(numEtape));
			jTable_etapes.repaint();
		}
		else System.out.println("setNumEtapeCourante : Valeur incorrecte");
	}
	
	public void resetAllItineraire() {
		for (int i=0;i<nbEtapes; i++) {
			tabEtapesModele.removeRow(0);
		}
		
		jComboBox_villeCourante.removeAllItems();
		jLabel_itineraireDepart.setText("");
		jLabel_itineraireArrivee.setText("");
	}
	
	public void changerValeur(String valeur, int ligne, int col) {
		tabEtapesModele.setValueAt(valeur, ligne, col);
	}
	
	private void lancerRecherche() {
		jTabbedPane_global.setEnabledAt(1,true);
		//jTabbedPane_global.setEnabledAt(2,true);
		//jTabbedPane_global.setSelectedIndex(1);
		/*WaitPanel wp = new WaitPanel(this);
		wp.setAlwaysOnTop(true);
		jTabbedPane_global.setEnabled(false);
		wp.setSize(new Dimension(50,50));
		wp.setLocation((int)(this.getLocation().getX()+this.getWidth()/2-wp.getWidth()/2),(int)(this.getLocation().getY()+this.getHeight()/2-wp.getHeight()/2));
		wp.setVisible(true);
		this.setEnabled(false);*/
		//TODO
	}
	

	/**
	 * This method initializes jMenuBar_menu
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private javax.swing.JMenuBar getJMenuBar_menu() {
		if (jMenuBar_menu == null) {
			jMenuBar_menu = new javax.swing.JMenuBar();
			jMenuBar_menu.add(getJMenu_fichier());
			jMenuBar_menu.add(getJMenu_edition());
			jMenuBar_menu.add(getJMenu_itineraire());
			jMenuBar_menu.add(getJMenu_aide());
			
		}
		return jMenuBar_menu;
	}

	/**
	 * This method initializes jMenu_fichier
	 * 
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getJMenu_fichier() {
		if (jMenu_fichier == null) {
			jMenu_fichier = new javax.swing.JMenu();
			jMenu_fichier.add(getJMenuItem_quitter());
			jMenu_fichier.setText("Fichier");
		}
		return jMenu_fichier;
	}

	/**
	 * This method initializes jMenuItem_quitter
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getJMenuItem_quitter() {
		if (jMenuItem_quitter == null) {
			jMenuItem_quitter = new javax.swing.JMenuItem();
			jMenuItem_quitter.setText("Quitter");
			jMenuItem_quitter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int i = JOptionPane.showConfirmDialog(null,
				            "Voulez-vous vraiment quitter ProGPS ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
		}
		return jMenuItem_quitter;
	}

	/**
	 * This method initializes jMenu_itineraire	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_itineraire() {
		if (jMenu_itineraire == null) {
			jMenu_itineraire = new JMenu();
			jMenu_itineraire.setText("Itinéraire");
			jMenu_itineraire.add(getJMenuItem_newitineraire());
		}
		return jMenu_itineraire;
	}

	/**
	 * This method initializes jMenu_aide	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_aide() {
		if (jMenu_aide == null) {
			jMenu_aide = new JMenu();
			jMenu_aide.setText("Aide");
			jMenu_aide.add(getJMenuItem_Aide());
			jMenu_aide.add(getJMenuItem_apropos());
		}
		return jMenu_aide;
	}

	/**
	 * This method initializes jMenuItem_Aide	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Aide() {
		if (jMenuItem_Aide == null) {
			jMenuItem_Aide = new JMenuItem();
			jMenuItem_Aide.setText("Aide");
		}
		return jMenuItem_Aide;
	}

	/**
	 * This method initializes jMenuItem_apropos	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_apropos() {
		if (jMenuItem_apropos == null) {
			jMenuItem_apropos = new JMenuItem();
			jMenuItem_apropos.setText("A propos...");
			jMenuItem_apropos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FenetreAPropos about = new FenetreAPropos(null);
				}
			});
		}
		return jMenuItem_apropos;
	}

	/**
	 * This method initializes jMenuItem_newitineraire	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_newitineraire() {
		if (jMenuItem_newitineraire == null) {
			jMenuItem_newitineraire = new JMenuItem();
			jMenuItem_newitineraire.setText("Nouvel itinéraire");
			jMenuItem_newitineraire.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(new Frame(),
				            "Voulez-vous vraiment commencer un nouvel itinéraire ?\n" +
				            "Cette fonction effacera l'itinéraire courant.", "Attention",
				            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(option == JOptionPane.YES_OPTION) {	// réponse : OUI
						jTabbedPane_global.setSelectedIndex(0);
						jTabbedPane_global.setEnabledAt(1,false);
						jTabbedPane_global.setEnabledAt(2,false);
					}
				}
			});
		}
		return jMenuItem_newitineraire;
	}

	/**
	 * This method initializes jTabbedPane_global	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_global() {
		if (jTabbedPane_global == null) {
			jTabbedPane_global = new JTabbedPane();
			jTabbedPane_global.addTab("Etape 1 : Paramètres", null, getJPanel_accueil(), null);
			jTabbedPane_global.addTab("Etape 2 : Choix itinéraire", null, getJPanel_choixItineraire(), null);
			jTabbedPane_global.addTab("Etape 3 : Itinéraire courant", null, getJPanel_itineraire(), null);
			jTabbedPane_global.addTab("Administration", null, getJPanel_admin(), null);
		}
		return jTabbedPane_global;
	}

	/**
	 * This method initializes jPanel_accueil	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_accueil() {
		if (jPanel_accueil == null) {
			jLabel_accueil1 = new JLabel();
			jLabel_accueil1.setText("Choisissez les paramètres de votre itinéraire :");
			jLabel_accueil1.setPreferredSize(new Dimension(200,40));
			jLabel_accueil1.setHorizontalAlignment(JLabel.CENTER);
			jPanel_accueil = new JPanel();
			jPanel_accueil.setLayout(new BorderLayout());
			jPanel_accueil.add(jLabel_accueil1, BorderLayout.NORTH);
			jPanel_accueil.add(getJPanel_accueilSouth(), BorderLayout.SOUTH);
			jPanel_accueil.add(getJPanel_params(), BorderLayout.CENTER);
		}
		return jPanel_accueil;
	}

	/**
	 * This method initializes jPanel_admin	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_admin() {
		if (jPanel_admin == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 5;
			jLabel_empty6 = new EmptyLabel(700,20);
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 7;
			jLabel_empty9 = new EmptyLabel(700,50);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 6;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 1;
			jLabel_empty = new EmptyLabel(700,10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 0;
			jLabel_adminpass = new JLabel();
			jLabel_adminpass.setText("Veuillez entrer le mot de passe administrateur :");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridy = 4;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridx = 0;
			jPanel_admin = new JPanel();
			jPanel_admin.setLayout(new FlowLayout());
			jPanel_admin.add(jLabel_empty9, null);
			jPanel_admin.add(jLabel_adminpass, null);
			jPanel_admin.add(jLabel_empty, null);
			jPanel_admin.add(getJPasswordField_adminpass(), null);
			jPanel_admin.add(jLabel_empty6, null);
			jPanel_admin.add(getJButton_okadmin(), null);
		}
		return jPanel_admin;
	}
	

	/**
	 * This method initializes jPanel_itineraire	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_itineraire() {
		if (jPanel_itineraire == null) {
			jPanel_itineraire = new JPanel();
			jPanel_itineraire.setLayout(new BorderLayout());
			jPanel_itineraire.add(getJPanel_itineraireNorth(), BorderLayout.NORTH);
			jPanel_itineraire.add(getJPanel_etapes(), BorderLayout.CENTER);
			jPanel_itineraire.add(getJPanel_localisation(), BorderLayout.SOUTH);
		}
		return jPanel_itineraire;
	}

	/**
	 * This method initializes jPanel_itineraireNorth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_itineraireNorth() {
		if (jPanel_itineraireNorth == null) {
			jLabel_itineraireArrivee = new JLabel();
			jLabel_itineraireArrivee.setText("Aix-en-Provence");
			jLabel_itineraireArrivee.setForeground(Color.BLUE);
			jLabel_itineraireArrivee.setHorizontalAlignment(JLabel.CENTER);
			jLabel_itineraireArrivee.setPreferredSize(new Dimension(150,18));
			jLabel_itineraireTo = new JLabel();
			jLabel_itineraireTo.setText(" à ");
			jLabel_itineraireDepart = new JLabel();
			jLabel_itineraireDepart.setText("Paris");
			jLabel_itineraireDepart.setForeground(Color.BLUE);
			jLabel_itineraireDepart.setHorizontalAlignment(JLabel.CENTER);
			jLabel_itineraireDepart.setPreferredSize(new Dimension(150,18));
			jLabel_itineraireFrom = new JLabel();
			jLabel_itineraireFrom.setText("Itinéraire de ");
			jPanel_itineraireNorth = new JPanel();
			jPanel_itineraireNorth.setLayout(new FlowLayout());
			//jPanel_itineraireNorth.setAlignmentX(JPanel.LEFT_ALIGNMENT);
			jPanel_itineraireNorth.add(jLabel_itineraireFrom, null);
			jPanel_itineraireNorth.add(jLabel_itineraireDepart, null);
			jPanel_itineraireNorth.add(jLabel_itineraireTo, null);
			jPanel_itineraireNorth.add(jLabel_itineraireArrivee, null);
			jPanel_itineraireNorth.add(getJButton_itineraireModifier(), null);
		}
		return jPanel_itineraireNorth;
	}

	/**
	 * This method initializes jButton_itineraireModifier	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_itineraireModifier() {
		if (jButton_itineraireModifier == null) {
			jButton_itineraireModifier = new JButton();
			jButton_itineraireModifier.setText("Modifier");
			jButton_itineraireModifier
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							jTabbedPane_global.setSelectedIndex(0);
							jTabbedPane_global.setEnabledAt(0, true);
						}
					});
		}
		return jButton_itineraireModifier;
	}

	/**
	 * This method initializes jPanel_etapes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_etapes() {
		if (jPanel_etapes == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridx = 0;
			jPanel_etapes = new JPanel();
			jPanel_etapes.setLayout(new GridBagLayout());
			jPanel_etapes.add(getJScrollPane_etapes(), gridBagConstraints2);
		}
		return jPanel_etapes;
	}

	/**
	 * This method initializes jPanel_localisation	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_localisation() {
		if (jPanel_localisation == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridx = 1;
			jLabel_arrivea = new JLabel();
			jLabel_arrivea.setText("Je suis arrivé à : ");
			
			jPanel_localisation = new JPanel();
			jPanel_localisation.setLayout(new FlowLayout());
			jPanel_localisation.add(jLabel_arrivea,null);
			jPanel_localisation.add(getJComboBox_villeCourante(), null);
			jPanel_localisation.add(getJButton_OKlocalisation(), null);
		}
		return jPanel_localisation;
	}

	/**
	 * This method initializes jButton_OKlocalisation	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_OKlocalisation() {
		if (jButton_OKlocalisation == null) {
			jButton_OKlocalisation = new JButton();
			jButton_OKlocalisation.setText("OK");
			jButton_OKlocalisation.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (((String)tabEtapesModele.getValueAt(numEtape, 2)).equals((String)jComboBox_villeCourante.getSelectedItem())) {
						numEtape++;
						jTable_etapes.setDefaultRenderer(Object.class, new CellGrisee(numEtape));
						jTable_etapes.getColumnModel().getColumn(5).setCellRenderer(new TabInfos(numEtape));
						jTable_etapes.repaint();
						if (numEtape == nbEtapes) {
							jButton_OKlocalisation.setEnabled(false);
							jComboBox_villeCourante.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Vous êtes arrivés à destination !", "Arrivée", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else {
						//TODO
						System.out.println("Recalcul necessaire !");
					}
				}
			});
		}
		return jButton_OKlocalisation;
	}

	/**
	 * This method initializes jScrollPane_etapes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_etapes() {
		if (jScrollPane_etapes == null) {
			jScrollPane_etapes = new JScrollPane();
			jScrollPane_etapes.setViewportView(getJTable_etapes());
		}
		return jScrollPane_etapes;
	}

	/**
	 * This method initializes jTable_etapes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable_etapes() {
		if (jTable_etapes == null) {
			
			/*TableColumn numEtape = new TableColumn();
			numEtape.setHeaderValue("N°");
			numEtape.setPreferredWidth(1);
			numEtape.setResizable(false);
			jTable_etapes.addColumn(numEtape);
			TableColumn villeDepart = new TableColumn();
			villeDepart.setHeaderValue("Ville départ");
			jTable_etapes.addColumn(villeDepart);
			TableColumn villeArrivee = new TableColumn();
			villeArrivee.setHeaderValue("Ville arrivée");
			jTable_etapes.addColumn(villeArrivee);
			TableColumn tronconRoute = new TableColumn();
			tronconRoute.setHeaderValue("Route");
			jTable_etapes.addColumn(tronconRoute);
			TableColumn distance = new TableColumn();
			distance.setHeaderValue("Distance");
			jTable_etapes.addColumn(distance);
			TableColumn infos = new TableColumn();
			infos.setHeaderValue("Informations");
			TabInfos tabInfos = new TabInfos();
			infos.setCellRenderer(tabInfos);
			jTable_etapes.addColumn(infos);*/
			
			tabEtapesModele.addColumn("N°");
			tabEtapesModele.addColumn("Ville de départ");
			tabEtapesModele.addColumn("Ville d'arrivée");
			tabEtapesModele.addColumn("Route");
			tabEtapesModele.addColumn("Distance");
			tabEtapesModele.addColumn("Informations");
			
			jTable_etapes = new JTable(tabEtapesModele);
			jTable_etapes.setAutoCreateColumnsFromModel(false);
			jTable_etapes.setRowHeight(35);
			jTable_etapes.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			
			jTable_etapes.getTableHeader().setReorderingAllowed(false);
			
			jTable_etapes.setDefaultRenderer(Object.class, new CellGrisee(numEtape));
			jTable_etapes.getColumnModel().getColumn(5).setCellRenderer(new TabInfos(numEtape));
			jTable_etapes.getColumnModel().getColumn(0).setMaxWidth(20);
			
			initTabExemple();
			
		}
		return jTable_etapes;	
	}

	/**
	 * This method initializes jPasswordField_adminpass	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField_adminpass() {
		if (jPasswordField_adminpass == null) {
			jPasswordField_adminpass = new JPasswordField();
			jPasswordField_adminpass.setPreferredSize(new Dimension(100,20));
			jPasswordField_adminpass.setText("***********");
			jPasswordField_adminpass.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					jPasswordField_adminpass.setText("");
				}
			});
			jPasswordField_adminpass.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
						verifyAdminPass();
					}
				}
			});
		}
		return jPasswordField_adminpass;
	}

	/**
	 * This method initializes the admin panel after	
	 * the password has been given
	 * 
	 */
	private void setAdminPanel() {
		jPanel_admin.removeAll();
		//jPanel_admin.repaint();
		jPanel_admin.add(new AdminPanel(),null);
		JButton jButton_logout = new JButton();
		jButton_logout.setText("Se déconnecter");
		jButton_logout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//resetAdminPanel();
				jPanel_admin.removeAll();
				jPanel_admin = null;
				jTabbedPane_global.removeTabAt(3);
				jTabbedPane_global.addTab("Administration", null, getJPanel_admin(), null);
				jTabbedPane_global.setSelectedIndex(3);
				//jPanel_admin.repaint();
				jMenuItem_adminPass.setEnabled(true);
				repaint();
			}
		});
		jPanel_admin.add(jButton_logout);
		jPanel_admin.repaint();
	}
	
	/**
	 * This method reinitializes the admin panel after	
	 * the admin has logged out
	 * 
	 */
	private void resetAdminPanel() {
		jPanel_admin.removeAll();
		//jPanel_admin.repaint();
		jPanel_admin.add(new AdminPanel(),null);
		jPanel_admin.repaint();
	}
	
	
	
	/**
	 * This method initializes jButton_okadmin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_okadmin() {
		if (jButton_okadmin == null) {
			jButton_okadmin = new JButton();
			jButton_okadmin.setIcon(new ImageIcon("images//icon_unlock.gif"));
			jButton_okadmin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					verifyAdminPass();
				}
			});
		}
		return jButton_okadmin;
	}
	
	private void verifyAdminPass() {
		if(new String(jPasswordField_adminpass.getPassword()).equals("progps")) {
			setAdminPanel();
			jMenuItem_adminPass.setEnabled(false);
		}
		else {
			JOptionPane.showMessageDialog(this, "Erreur : le mot de passe que vous avez entré est incorrect !",
					"Erreur - ProGPS", JOptionPane.ERROR_MESSAGE);
			jPasswordField_adminpass.setText("");
			jPasswordField_adminpass.requestFocus();
		}
	}

	/**
	 * This method initializes jPanel_choixItineraire	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_choixItineraire() {
		if (jPanel_choixItineraire == null) {
			jPanel_choixItineraire = new ChoixItineraire();
		}
		return jPanel_choixItineraire;
	}

	/**
	 * This method initializes jPanel_accueilSouth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_accueilSouth() {
		if (jPanel_accueilSouth == null) {
			jPanel_accueilSouth = new JPanel();
			jPanel_accueilSouth.setLayout(new FlowLayout());
			jPanel_accueilSouth.add(getJButton_rechercherIti(), null);
		}
		return jPanel_accueilSouth;
	}

	/**
	 * This method initializes jButton_rechercherIti	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_rechercherIti() {
		if (jButton_rechercherIti == null) {
			jButton_rechercherIti = new JButton();
			jButton_rechercherIti.setText("Rechercher les itinéraires possibles");
			jButton_rechercherIti.setIcon(new ImageIcon("images//gps_small.png"));
			jButton_rechercherIti.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					lancerRecherche();
				}
			});
			jButton_rechercherIti.setIconTextGap(10);
		}
		return jButton_rechercherIti;
	}

	/**
	 * This method initializes jPanel_params	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_params() {
		if (jPanel_params == null) {
			jLabel_villeDepart = new JLabel();
			jLabel_villeDepart.setText("Ville de départ :");
			jPanel_params = new JPanel();
			jPanel_params.setLayout(new BorderLayout());
			jPanel_params.add(getJPanel_paramsNorth(), java.awt.BorderLayout.NORTH);
			jPanel_params.add(getJPanel_globalParams(), BorderLayout.SOUTH);
			jPanel_params.add(getJPanel_globalVilles(), BorderLayout.CENTER);
		}
		return jPanel_params;
	}

	/**
	 * This method initializes jPanel_paramsNorth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_paramsNorth() {
		if (jPanel_paramsNorth == null) {
			jLabel_empty8 = new JLabel();
			jLabel_empty8.setPreferredSize(new Dimension(770, 5));
			jLabel_empty8.setText("");
			jLabel_empty5 = new JLabel();
			jLabel_empty5.setPreferredSize(new Dimension(110, 20));
			jLabel_empty5.setText("");
			jLabel_empty4 = new JLabel();
			jLabel_empty4.setPreferredSize(new Dimension(80, 20));
			jLabel_empty4.setText("");
			jLabel_empty3 = new JLabel();
			jLabel_empty3.setPreferredSize(new Dimension(110, 20));
			jLabel_empty3.setText("");
			jLabel_empty2 = new JLabel();
			jLabel_empty2.setText("");
			jLabel_empty2.setPreferredSize(new Dimension(220,20));
			jLabel_empty1 = new JLabel();
			jLabel_empty1.setText("");
			jLabel_empty1.setPreferredSize(new Dimension(80,20));
			jLabel_villeArrivee = new JLabel();
			jLabel_villeArrivee.setText("Ville d'arrivée :");
			jPanel_paramsNorth = new JPanel();
			jPanel_paramsNorth.setLayout(new FlowLayout());
			jPanel_paramsNorth.setPreferredSize(new Dimension(770,60));
			jPanel_paramsNorth.add(jLabel_empty3, null);
			jPanel_paramsNorth.add(jLabel_villeDepart, null);
			jPanel_paramsNorth.add(jLabel_empty5, null);
			jPanel_paramsNorth.add(jLabel_empty1, null);
			jPanel_paramsNorth.add(jLabel_villeArrivee, null);
			jPanel_paramsNorth.add(jLabel_empty2, null);
			jPanel_paramsNorth.add(getJComboBox_villeDepart(), null);
			jPanel_paramsNorth.add(jLabel_empty4, null);
			jPanel_paramsNorth.add(getJComboBox_villeArrivee(), null);
			jPanel_paramsNorth.add(jLabel_empty8, null);
		}
		return jPanel_paramsNorth;
	}

	/**
	 * This method initializes jComboBox_villeDepart	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_villeDepart() {
		if (jComboBox_villeDepart == null) {
			Vector<String> villesDep = new Vector<String>();
			villesDep.add("Paris");
			villesDep.add("Orsay");
			jComboBox_villeDepart = new JComboBox(villesDep);
			jComboBox_villeDepart.setPreferredSize(new Dimension(200,20));
			jComboBox_villeDepart.setBackground(Color.WHITE);
			jComboBox_villeDepart.setForeground(Color.BLUE);
			jComboBox_villeDepart.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return jComboBox_villeDepart;
	}

	/**
	 * This method initializes jComboBox_villeArrivee	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_villeArrivee() {
		if (jComboBox_villeArrivee == null) {
			Vector<String> villesArr = new Vector<String>();
			villesArr.add("Aix-en-Provence");
			jComboBox_villeArrivee = new JComboBox(villesArr);
			jComboBox_villeArrivee.setPreferredSize(new Dimension(200,20));
			jComboBox_villeArrivee.setBackground(Color.WHITE);
			jComboBox_villeArrivee.setForeground(Color.BLUE);
			jComboBox_villeArrivee.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			jComboBox_villeArrivee.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return jComboBox_villeArrivee;
	}

	/**
	 * This method initializes jPanel_listVilles	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_listVilles() {
		if (jPanel_listVilles == null) {
			
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.fill = GridBagConstraints.BOTH;
			gridBagConstraints26.gridy = 1;
			gridBagConstraints26.weightx = 1.0;
			gridBagConstraints26.weighty = 1.0;
			gridBagConstraints26.gridheight = 4;
			gridBagConstraints26.gridx = 5;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.fill = GridBagConstraints.BOTH;
			gridBagConstraints24.gridy = 1;
			gridBagConstraints24.weightx = 1.0;
			gridBagConstraints24.weighty = 1.0;
			gridBagConstraints24.gridheight = 4;
			gridBagConstraints24.gridx = 1;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.BOTH;
			gridBagConstraints20.weighty = 1.0;
			gridBagConstraints20.gridx = 3;
			gridBagConstraints20.gridy = 1;
			gridBagConstraints20.gridheight = 4;
			gridBagConstraints20.weightx = 1.0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 5;
			gridBagConstraints7.gridy = 0;
			jLabel_villesEviter = new JLabel();
			jLabel_villesEviter.setText("Villes à éviter :");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jLabel_villesEtapes = new JLabel();
			jLabel_villesEtapes.setText("Villes étapes :");
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 5;
			gridBagConstraints19.gridy = 6;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 1;
			gridBagConstraints18.gridy = 6;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 4;
			gridBagConstraints16.gridy = 1;
			jLabel_empty7 = new JLabel();
			jLabel_empty7.setPreferredSize(new Dimension(50, 20));
			jLabel_empty7.setText("");
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 4;
			gridBagConstraints13.gridy = 4;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 4;
			gridBagConstraints12.gridy = 3;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 2;
			gridBagConstraints10.gridy = 4;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 2;
			gridBagConstraints9.gridy = 3;
			jPanel_listVilles = new JPanel();
			jPanel_listVilles.setPreferredSize(new Dimension(750,180));
			jPanel_listVilles.setLayout(new GridBagLayout());
			jPanel_listVilles.add(getJButton_versEtapes(), gridBagConstraints9);
			jPanel_listVilles.add(getJButton_enleverEtape(), gridBagConstraints10);
			jPanel_listVilles.add(getJButton_versEviter(), gridBagConstraints12);
			jPanel_listVilles.add(getJButton_enleverEviter(), gridBagConstraints13);
			
			//JScrollPane scrollVilles = new JScrollPane(getJList_villes());
			
			jPanel_listVilles.add(getJButton_effacerVillesEtapes(), gridBagConstraints18);
			jPanel_listVilles.add(jLabel_empty7, gridBagConstraints16);
			jPanel_listVilles.add(getJButton_effacerVillesEviter(), gridBagConstraints19);
			jPanel_listVilles.add(jLabel_villesEtapes, gridBagConstraints);
			jPanel_listVilles.add(jLabel_villesEviter, gridBagConstraints7);
			jPanel_listVilles.add(getJScrollPane_villes(), gridBagConstraints20);
			jPanel_listVilles.add(getJScrollPane_villesEtapes(), gridBagConstraints24);
			jPanel_listVilles.add(getJScrollPane_villesEviter(), gridBagConstraints26);
		}
		return jPanel_listVilles;
	}

	/**
	 * This method initializes jButton_versEtapes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_versEtapes() {
		if (jButton_versEtapes == null) {
			jButton_versEtapes = new JButton();
			jButton_versEtapes.setText("<<");
			jButton_versEtapes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton_versEtapes;
	}

	/**
	 * This method initializes jButton_enleverEtape	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_enleverEtape() {
		if (jButton_enleverEtape == null) {
			jButton_enleverEtape = new JButton();
			jButton_enleverEtape.setText(">>");
			jButton_enleverEtape.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton_enleverEtape;
	}

	/**
	 * This method initializes jList_villes	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_villes() {
		if (jList_villes == null) {
			Vector<String> villes = new Vector<String>();
			villes.add("Besançon");
			villes.add("Dijon");
			villes.add("Evian");
			villes.add("Lyon");
			villes.add("Marseille");
			villes.add("Montpellier");
			villes.add("Nancy");
			villes.add("Nice");
			villes.add("Reims");
			villes.add("Saint-Etienne");
			villes.add("Strasbourg");
			villes.add("Trifouillis-les-Oies");
			
			jList_villes = new JList(villes);
			//jList_villes.setPreferredSize(new Dimension(150,100));
		}
		return jList_villes;
	}

	/**
	 * This method initializes jButton_versEviter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_versEviter() {
		if (jButton_versEviter == null) {
			jButton_versEviter = new JButton();
			jButton_versEviter.setText(">>");
			jButton_versEviter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton_versEviter;
	}

	/**
	 * This method initializes jButton_enleverEviter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_enleverEviter() {
		if (jButton_enleverEviter == null) {
			jButton_enleverEviter = new JButton();
			jButton_enleverEviter.setText("<<");
		}
		return jButton_enleverEviter;
	}

	/**
	 * This method initializes jButton_effacerVillesEtapes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_effacerVillesEtapes() {
		if (jButton_effacerVillesEtapes == null) {
			jButton_effacerVillesEtapes = new JButton();
			jButton_effacerVillesEtapes.setText("Effacer tout");
		}
		return jButton_effacerVillesEtapes;
	}

	/**
	 * This method initializes jButton_effacerVillesEviter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_effacerVillesEviter() {
		if (jButton_effacerVillesEviter == null) {
			jButton_effacerVillesEviter = new JButton();
			jButton_effacerVillesEviter.setText("Effacer tout");
		}
		return jButton_effacerVillesEviter;
	}

	/**
	 * This method initializes jPanel_globalParams	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_globalParams() {
		if (jPanel_globalParams == null) {
			jLabel_fillEmpty2 = new JLabel();
			jLabel_fillEmpty2.setPreferredSize(new Dimension(760, 23));
			jLabel_fillEmpty2.setText("");
			jLabel_fillEmpty2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jLabel_fillEmpty2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					toggleDisplayParams();
				}
			});
			jLabel_deroul2 = new JLabel();
			jLabel_deroul2.setFont(new Font("Verdana", Font.BOLD, 18));
			jLabel_deroul2.setText("-");
			jLabel_deroul2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jLabel_deroul2.setForeground(Color.BLUE);
			jLabel_deroul2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					toggleDisplayParams();
				}
			});
			
			jLabel_empty19 = new JLabel();
			jLabel_empty19.setPreferredSize(new Dimension(113, 20));
			jLabel_empty19.setText("");
			jLabel_empty12 = new JLabel();
			jLabel_empty12.setPreferredSize(new Dimension(47, 20));
			jLabel_empty12.setText("");
			jLabel_options52 = new JLabel();
			jLabel_options52.setIcon(new ImageIcon(""));
			jLabel_options52.setText("le plus rapide");
			jLabel_options53 = new JLabel();
			jLabel_options53.setText("le plus court");
			jLabel_options51 = new JLabel();
			jLabel_options51.setIcon(new ImageIcon("images//reseau_small.jpg"));
			jLabel_options51.setPreferredSize(new Dimension(35,30));
			jLabel_options5 = new JLabel();
			jLabel_options5.setText("Je souhaite que mon chemin soit :");
			jLabel_empty18 = new JLabel();
			jLabel_empty18.setPreferredSize(new Dimension(750, 2));
			jLabel_empty18.setText("");
			jLabel_options42 = new JLabel();
			jLabel_options42.setText("de moins de :");
			jLabel_options42.setEnabled(false);
			jLabel_options41 = new JLabel();
			jLabel_options41.setIcon(new ImageIcon("images//panneau90_small.png"));
			jLabel_options4 = new JLabel();
			jLabel_options4.setText("Je souhaite éviter les limitations");
			jLabel_options4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jCheckBox_options4.setSelected(!jCheckBox_options4.isSelected());
					jLabel_options42.setEnabled(!jLabel_options42.isEnabled());
					jComboBox_limitations.setEnabled(!jComboBox_limitations.isEnabled());
				}
			});
			jLabel_empty17 = new JLabel();
			jLabel_empty17.setPreferredSize(new Dimension(750, 2));
			jLabel_empty17.setText("");
			jLabel_options11 = new JLabel();
			jLabel_options11.setIcon(new ImageIcon("images//eiffel_small.png"));
			jLabel_options31 = new JLabel();
			jLabel_options31.setIcon(new ImageIcon("images//radar.jpg"));
			jLabel_options21 = new JLabel();
			jLabel_options21.setIcon(new ImageIcon("images//euros_small.png"));
			jLabel_options3 = new JLabel();
			jLabel_options3.setText("Je souhaite éviter les radars");
			jLabel_options3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jCheckBox_options3.setSelected(!jCheckBox_options3.isSelected());
				}
			});
			jLabel_empty16 = new JLabel();
			jLabel_empty16.setPreferredSize(new Dimension(750, 2));
			jLabel_empty16.setText("");
			jLabel_empty15 = new JLabel();
			jLabel_empty15.setPreferredSize(new Dimension(750, 2));
			jLabel_empty15.setText("");
			jLabel_options2 = new JLabel();
			jLabel_options2.setIcon(new ImageIcon(""));
			jLabel_options2.setText("Je souhaite éviter les parcours payants");
			jLabel_options2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jCheckBox_options2.setSelected(!jCheckBox_options2.isSelected());
				}
			});
			jLabel_options1 = new JLabel();
			jLabel_options1.setText("Je souhaite privilégier les itinéraires touristiques");
			jLabel_options1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jCheckBox_options1.setSelected(!jCheckBox_options1.isSelected());
				}
			});
			jLabel_empty13 = new JLabel();
			jLabel_empty13.setPreferredSize(new Dimension(235, 20));
			jLabel_empty13.setText("");
			jLabel_empty11 = new JLabel();
			jLabel_empty11.setPreferredSize(new Dimension(190, 20));
			jLabel_empty11.setText("");
			jPanel_globalParams = new JPanel();
			jPanel_globalParams.setLayout(new FlowLayout());
			jPanel_globalParams.setPreferredSize(new Dimension(770, 285));
			jPanel_globalParams.add(jLabel_deroul2, null);
			jPanel_globalParams.add(jLabel_fillEmpty2, null);
			jPanel_globalParams.add(getJPanel_listParams(), null);
			
			radioGroup1.add(jRadioButton1);
			radioGroup1.add(jRadioButton2);
		}
		return jPanel_globalParams;
	}

	/**
	 * This method initializes jCheckBox_options1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_options1() {
		if (jCheckBox_options1 == null) {
			jCheckBox_options1 = new JCheckBox();
		}
		return jCheckBox_options1;
	}

	/**
	 * This method initializes jCheckBox_options2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_options2() {
		if (jCheckBox_options2 == null) {
			jCheckBox_options2 = new JCheckBox();
		}
		return jCheckBox_options2;
	}

	/**
	 * This method initializes jCheckBox_options3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_options3() {
		if (jCheckBox_options3 == null) {
			jCheckBox_options3 = new JCheckBox();
		}
		return jCheckBox_options3;
	}

	/**
	 * This method initializes jCheckBox_options4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_options4() {
		if (jCheckBox_options4 == null) {
			jCheckBox_options4 = new JCheckBox();
			jCheckBox_options4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jComboBox_limitations.isEnabled()) {
						jLabel_options42.setEnabled(false);
						jComboBox_limitations.setEnabled(false);
					}
					else {
						jLabel_options42.setEnabled(true);
						jComboBox_limitations.setEnabled(true);
					}
				}
			});
		}
		return jCheckBox_options4;
	}

	/**
	 * This method initializes jComboBox_limitations	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_limitations() {
		if (jComboBox_limitations == null) {
			java.util.Vector<String> limitations = new Vector<String>();
			limitations.add("50 km/h");
			limitations.add("70 km/h");
			limitations.add("90 km/h");
			limitations.add("110 km/h");
			limitations.add("130 km/h");
			jComboBox_limitations = new JComboBox(limitations);
			jComboBox_limitations.setBackground(Color.WHITE);
			jComboBox_limitations.setForeground(Color.RED);
			jComboBox_limitations.setEnabled(false);
		}
		return jComboBox_limitations;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setActionCommand("plusrapide");
		    jRadioButton1.setSelected(true);
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setActionCommand("pluscourt");
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jScrollPane_villes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_villes() {
		if (jScrollPane_villes == null) {
			jScrollPane_villes = new JScrollPane();
			jScrollPane_villes.setViewportView(getJList_villes());
			jScrollPane_villes.setPreferredSize(new Dimension(100,100));
		}
		return jScrollPane_villes;
	}

	/**
	 * This method initializes jScrollPane_villesEtapes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_villesEtapes() {
		if (jScrollPane_villesEtapes == null) {
			jScrollPane_villesEtapes = new JScrollPane();
			jScrollPane_villesEtapes.setViewportView(getJList_villesEtapes());
			jScrollPane_villesEtapes.setPreferredSize(new Dimension(100,100));
		}
		return jScrollPane_villesEtapes;
	}

	/**
	 * This method initializes jList_villesEtapes	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_villesEtapes() {
		if (jList_villesEtapes == null) {
			Vector<String> villesEtapes = new Vector<String>();
			villesEtapes.add("Dijon");
			villesEtapes.add("Lyon");
			jList_villesEtapes = new JList(villesEtapes);
			jList_villesEtapes.setForeground(new Color(0,176,52));
		}
		return jList_villesEtapes;
	}

	/**
	 * This method initializes jScrollPane_villesEviter	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_villesEviter() {
		if (jScrollPane_villesEviter == null) {
			jScrollPane_villesEviter = new JScrollPane();
			jScrollPane_villesEviter.setViewportView(getJList_villesEviter());
			jScrollPane_villesEviter.setPreferredSize(new Dimension(100,100));
		}
		return jScrollPane_villesEviter;
	}

	/**
	 * This method initializes jList_villesEviter	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_villesEviter() {
		if (jList_villesEviter == null) {
			Vector<String> villesEviter = new Vector<String>();
			villesEviter.add("Strasbourg");
			villesEviter.add("Nice");
			villesEviter.add("Evian");
			jList_villesEviter = new JList(villesEviter);
			jList_villesEviter.setForeground(Color.RED);
		}
		return jList_villesEviter;
	}

	/**
	 * This method initializes jPanel_globalVilles	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_globalVilles() {
		if (jPanel_globalVilles == null) {
			jLabel_fillEmpty1 = new JLabel();
			jLabel_fillEmpty1.setPreferredSize(new Dimension(760, 23));
			jLabel_fillEmpty1.setText("");
			jLabel_fillEmpty1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jLabel_fillEmpty1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					toggleDisplayVilles();
				}
			});
			jLabel_deroul1 = new JLabel();
			jLabel_deroul1.setText("-");
			jLabel_deroul1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jLabel_deroul1.setForeground(Color.BLUE);
			jLabel_deroul1.setFont(new java.awt.Font("Verdana",java.awt.Font.BOLD,18));
			jLabel_deroul1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					toggleDisplayVilles();
				}
			});
			
			jPanel_globalVilles = new JPanel();
			jPanel_globalVilles.setLayout(new FlowLayout());
			jPanel_globalVilles.setAlignmentY(JPanel.TOP_ALIGNMENT);
			//jPanel_globalVilles.setPreferredSize(new Dimension(750,100));
			jPanel_globalVilles.add(jLabel_deroul1, null);
			jPanel_globalVilles.add(jLabel_fillEmpty1, null);
			jPanel_globalVilles.add(getJPanel_listVilles(), null);
		}
		return jPanel_globalVilles;
	}

	/**
	 * This method initializes jPanel_listParams
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_listParams() {
		if (jPanel_listParams == null) {
			jLabel_empty43 = new JLabel();
			jLabel_empty43.setPreferredSize(new Dimension(12, 20));
			jLabel_empty43.setText("");
			jLabel_empty20 = new JLabel();
			jLabel_empty20.setPreferredSize(new Dimension(750, 2));
			jLabel_empty20.setText("");
			jPanel_listParams = new JPanel();
			jPanel_listParams.setPreferredSize(new Dimension(760, 245));
			jPanel_listParams.setLayout(new FlowLayout());
			jPanel_listParams.add(jLabel_options11, null);
			jPanel_listParams.add(getJCheckBox_options1(), null);
			jPanel_listParams.add(jLabel_options1, null);
			jPanel_listParams.add(jLabel_empty19, null);
			jPanel_listParams.add(jLabel_empty15, null);
			jPanel_listParams.add(jLabel_options21, null);
			jPanel_listParams.add(getJCheckBox_options2(), null);
			jPanel_listParams.add(jLabel_options2, null);
			jPanel_listParams.add(jLabel_empty11, null);
			jPanel_listParams.add(jLabel_empty16, null);
			jPanel_listParams.add(jLabel_options31, null);
			jPanel_listParams.add(getJCheckBox_options3(), null);
			jPanel_listParams.add(jLabel_options3, null);
			jPanel_listParams.add(jLabel_empty13, null);
			jPanel_listParams.add(jLabel_empty17, null);
			jPanel_listParams.add(jLabel_options41, null);
			jPanel_listParams.add(getJCheckBox_options4(), null);
			jPanel_listParams.add(jLabel_options4, null);
			jPanel_listParams.add(jLabel_options42, null);
			jPanel_listParams.add(getJComboBox_limitations(), null);
			jPanel_listParams.add(jLabel_empty12, null);
			jPanel_listParams.add(jLabel_empty18, null);
			jPanel_listParams.add(jLabel_options51, null);
			jPanel_listParams.add(jLabel_options5, null);
			jPanel_listParams.add(getJRadioButton1(), null);
			jPanel_listParams.add(jLabel_options52, null);
			jPanel_listParams.add(getJRadioButton2(), null);
			jPanel_listParams.add(jLabel_options53, null);
			jPanel_listParams.add(jLabel_empty43, null);
			jPanel_listParams.add(jLabel_empty20, null);
			jPanel_listParams.add(getJButton_affinerParams(), null);
		}
		return jPanel_listParams;
	}

	/**
	 * This method initializes jButton_affinerParams	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_affinerParams() {
		if (jButton_affinerParams == null) {
			jButton_affinerParams = new JButton();
			jButton_affinerParams.setText("Affiner les paramètres");
			jButton_affinerParams.setIcon(new ImageIcon("images//slider_small.png"));
			jButton_affinerParams.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (fenPrefs != null) {
						fenPrefs.setVisible(true);
					}
					else {
						fenPrefs = new FenetrePreferences();
						fenPrefs.setVisible(true);
					}
				}
			});
		}
		return jButton_affinerParams;
	}

	/**
	 * This method initializes jMenu_edition	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_edition() {
		if (jMenu_edition == null) {
			jMenu_edition = new JMenu();
			jMenu_edition.setText("Edition");
			jMenu_edition.add(getJMenuItem_preferences());
			jMenu_edition.add(getJMenuItem_adminPass());
		}
		return jMenu_edition;
	}

	/**
	 * This method initializes jMenuItem_preferences	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_preferences() {
		if (jMenuItem_preferences == null) {
			jMenuItem_preferences = new JMenuItem();
			jMenuItem_preferences.setText("Préférences...");
			jMenuItem_preferences.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (fenPrefs != null) {
						fenPrefs.setVisible(true);
					}
					else {
						fenPrefs = new FenetrePreferences();
						fenPrefs.setVisible(true);
					}
				}
			});
		}
		return jMenuItem_preferences;
	}

	/**
	 * This method initializes jMenuItem_adminPass	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_adminPass() {
		if (jMenuItem_adminPass == null) {
			jMenuItem_adminPass = new JMenuItem();
			jMenuItem_adminPass.setText("Mot de passe administration...");
			jMenuItem_adminPass.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FenetreAdminPass fenAdmin = new FenetreAdminPass();
					fenAdmin.setVisible(true);
				}
			});
		}
		return jMenuItem_adminPass;
	}

	/**
	 * This method initializes jComboBox_villeCourante	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_villeCourante() {
		if (jComboBox_villeCourante == null) {
			String[] villesCourPoss = {"Lyon","Nancy","Besançon","Dijon","Aix-en-Provence","Avignon"};
			jComboBox_villeCourante = new JComboBox(villesCourPoss);
			jComboBox_villeCourante.setPreferredSize(new Dimension(200,22));
			jComboBox_villeCourante.setBackground(Color.WHITE);
		}
		return jComboBox_villeCourante;
	}
	
}  //  @jve:decl-index=0:visual-constraint="24,14"
