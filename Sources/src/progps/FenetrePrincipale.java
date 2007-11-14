package progps;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Rectangle;

/**
 * 
 */
public class FenetrePrincipale extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
		
	private javax.swing.JPanel jFrameContentPane = null;

	private javax.swing.JMenuBar jMenuBar_menu = null;

	private javax.swing.JMenu jMenu_fichier = null;

	private javax.swing.JMenu jMenu1_edition = null;

	private javax.swing.JMenuItem jMenuItem_quitter = null;

	private JMenu jMenu_itineraire = null;

	private JMenu jMenu_aide = null;

	private JMenuItem jMenuItem_Aide = null;

	private JMenuItem jMenuItem_apropos = null;

	private JMenuItem jMenuItem_newitineraire = null;

	private JMenuItem jMenuItem_preferences = null;

	private JTabbedPane jTabbedPane_global = null;

	private JPanel jPanel_user = null;

	private JPanel jPanel_admin = null;

	private JToolBar jToolBar_user = null;

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



	private JTextField jTextField_villeCourante = null;



	private JButton jButton_OKlocalisation = null;



	private JScrollPane jScrollPane_etapes = null;



	private JTable jTable_etapes = null;



	private JPasswordField jPasswordField_adminpass = null;



	private JLabel jLabel_adminpass = null;



	private JLabel jLabel_empty = null;

	private JButton jButton_okadmin = null;

	private jPanel_DemandeItineraire jPanel_DemandeItineraire = null;

	private JPanel jPanel_Sud = null;

	private JPanel jPanel_Centre = null;

	private String[] listeDesVilles;

	private JButton jButton_DemandeRechercheItineraire = null;

	private jPanel_AffichageItineraire jPanel_ListeDesItineraires = null;

	public FenetrePrincipale() {
		super();
		String[] listesDesVilles = {"Paris","Orsay","Bures sur Yvette","Gif sur Yvette","Besançon","Belfort","Montbéliard","Sochaux","Pontarlier","Marseille","Aix en Provance","Monaco","Lille","Toulouse","Lyon","Saint Etienne"};
		listeDesVilles = listesDesVilles;
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
			jFrameContentPane.setName("JFrameContentPane");
			jFrameContentPane.add(getJTabbedPane_global(), BorderLayout.NORTH);
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
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(23, 36, 770, 577);
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
			jMenuBar_menu.add(getJMenu1_edition());
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
	 * This method initializes jMenu1_edition
	 * 
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getJMenu1_edition() {
		if (jMenu1_edition == null) {
			jMenu1_edition = new javax.swing.JMenu();
			jMenu1_edition.setText("Edition");
			jMenu1_edition.add(getJMenuItem_preferences());
		}
		return jMenu1_edition;
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
					System.exit(0);
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
					}
				}
			});
		}
		return jMenuItem_newitineraire;
	}

	/**
	 * This method initializes jMenuItem_preferences	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_preferences() {
		if (jMenuItem_preferences == null) {
			jMenuItem_preferences = new JMenuItem();
			jMenuItem_preferences.setText("Préférences");
			jMenuItem_preferences.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					FenetrePreferences fen = new FenetrePreferences();
					fen.setVisible(true);
				}
			
			});
		}
		return jMenuItem_preferences;
	}

	/**
	 * This method initializes jTabbedPane_global	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_global() {
		if (jTabbedPane_global == null) {
			jTabbedPane_global = new JTabbedPane();
			jTabbedPane_global.addTab("Accueil", null, getJPanel_user(), null);
			jTabbedPane_global.addTab("Itinéraire courant", null, getJPanel_itineraire(), null);
			jTabbedPane_global.addTab("Administration", null, getJPanel_admin(), null);
			jTabbedPane_global.addTab("Demande d'itineraire", null, getJPanel_DemandeItineraire(), null);
			jTabbedPane_global.addTab("Liste des itineraire", null, getJPanel_ListeDesItineraires(), null);
		}
		return jTabbedPane_global;
	}

	private Component getJPanel_ListeDesItineraires() {
		if (jPanel_ListeDesItineraires == null) {
			jPanel_ListeDesItineraires = new jPanel_AffichageItineraire();
		}
		return jPanel_ListeDesItineraires;
	}

	/**
	 * This method initializes jPanel_user	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_user() {
		if (jPanel_user == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridx = 0;
			jPanel_user = new JPanel();
			jPanel_user.setLayout(new BorderLayout());
		}
		return jPanel_user;
	}

	/**
	 * This method initializes jPanel_admin	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_admin() {
		if (jPanel_admin == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 5;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 1;
			jLabel_empty = new JLabel();
			jLabel_empty.setText(" ");
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
			jPanel_admin.setLayout(new GridBagLayout());
			jPanel_admin.add(getJPasswordField_adminpass(), gridBagConstraints3);
			jPanel_admin.add(jLabel_adminpass, gridBagConstraints4);
			jPanel_admin.add(jLabel_empty, gridBagConstraints5);
			jPanel_admin.add(getJButton_okadmin(), gridBagConstraints6);
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
			jLabel_itineraireArrivee.setText(" ");
			jLabel_itineraireArrivee.setPreferredSize(new Dimension(150,18));
			jLabel_itineraireTo = new JLabel();
			jLabel_itineraireTo.setText(" à ");
			jLabel_itineraireDepart = new JLabel();
			jLabel_itineraireDepart.setText(" ");
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
			jPanel_localisation.add(getJTextField_villeCourante(), null);
			jPanel_localisation.add(getJButton_OKlocalisation(), null);
		}
		return jPanel_localisation;
	}

	/**
	 * This method initializes jTextField_villeCourante	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_villeCourante() {
		if (jTextField_villeCourante == null) {
			jTextField_villeCourante = new JTextField();
			jTextField_villeCourante.setPreferredSize(new Dimension(150,18));
		}
		return jTextField_villeCourante;
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
			jTable_etapes = new JTable();
			TableColumn numEtape = new TableColumn();
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
			jTable_etapes.addColumn(infos);
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
		jPanel_admin.repaint();
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
			jButton_okadmin.setText("OK");
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
			System.out.println(jPasswordField_adminpass.getPassword());
			setAdminPanel();
		}
	}

	/**
	 * This method initializes jPanel_DemandeItineraire	
	 * @param listeDesVilles 
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_DemandeItineraire() {
		if (jPanel_DemandeItineraire == null) {
			jPanel_DemandeItineraire = new jPanel_DemandeItineraire();
		}
		return jPanel_DemandeItineraire;
	}

	/**
	 * This method initializes jPanel_Sud	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Sud() {
		if (jPanel_Sud == null) {
			jPanel_Sud = new JPanel();
			jPanel_Sud.setLayout(new GridBagLayout());
			jPanel_Sud.add(getJButton_DemandeRechercheItineraire(), new GridBagConstraints());
		}
		return jPanel_Sud;
	}

	/**
	 * This method initializes jPanel_Centre	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Centre() {
		if (jPanel_Centre == null) {
			jPanel_Centre = new JPanel();
			jPanel_Centre.setLayout(new BorderLayout());
		}
		return jPanel_Centre;
	}

	/**
	 * This method initializes jButton_DemandeRechercheItineraire	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_DemandeRechercheItineraire() {
		if (jButton_DemandeRechercheItineraire == null) {
			jButton_DemandeRechercheItineraire = new JButton();
			jButton_DemandeRechercheItineraire.setText("Recherche des itinéraire");
		}
		return jButton_DemandeRechercheItineraire;
	}
	
}  //  @jve:decl-index=0:visual-constraint="-206,-4"
