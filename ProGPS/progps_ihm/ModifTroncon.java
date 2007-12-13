package progps_ihm;

import noyau.*;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.util.Vector;


public class ModifTroncon extends JWindow {

	private static final long serialVersionUID = 1L;
	
	private SingletonProgps progps = null;
	
	private FenetrePrincipale ownerFrame = null;
	
	private Troncon leTroncon = null;
	
	private JButton ownerButton = null;

	private JPanel jContentPane = null;

	private JTextField jTextField_north = null;

	private JPanel jPanel_south = null;

	private JButton jButton_cancel = null;

	private JButton jButton_ok = null;

	private JPanel jPanel_center = null;

	private JLabel jLabel_touristique = null;
	
	private ButtonGroup radioGroup1 = new ButtonGroup();  //  @jve:decl-index=0:
	
	private ButtonGroup radioGroup2 = new ButtonGroup();  //  @jve:decl-index=0:
	
	private ButtonGroup radioGroup3 = new ButtonGroup();  //  @jve:decl-index=0:

	private JRadioButton jRadioButton_yesTouristique = null;

	private JRadioButton jRadioButton_noTouristique = null;

	private JLabel jLabel_yes = null;

	private JLabel jLabel_no = null;

	private JLabel jLabel_payant = null;

	private JRadioButton jRadioButton_yesPayant = null;

	private JRadioButton jRadioButton_noPayant = null;

	private JLabel jLabel_yes1 = null;

	private JLabel jLabel_no1 = null;

	private JComboBox jComboBox_route = null;

	private JLabel jLabel_route = null;

	private JLabel jLabel_ville1 = null;

	private JLabel jLabel_ville2 = null;

	private JComboBox jComboBox_ville1 = null;

	private JComboBox jComboBox_ville2 = null;

	private JLabel jLabel_radars = null;

	private JRadioButton jRadioButton_yesRadars = null;

	private JRadioButton jRadioButton_noRadars = null;

	private JLabel jLabel_yes2 = null;

	private JLabel jLabel_no2 = null;

	private JLabel jLabel_vitesse = null;

	private JComboBox jComboBox_limitations = null;

	private Vector limitations = null;

	private JLabel jLabel_longueur = null;

	private JTextField jTextField_longueur = null;

	/**
	 * @param owner
	 */
	public ModifTroncon(Frame owner, JButton but, SingletonProgps sys, String nomRoute, String troncon) {
		super(owner);
		ownerFrame = (FenetrePrincipale)owner;
		progps = sys;
		String[] result = troncon.split(" ");
		try {
			leTroncon = progps.getTroncon(nomRoute, result[0], result[2]);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		ownerButton = but;
		initialize();
	}
	
	public void remplirChamps(Troncon t) {
		//TODO
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(270, 300);
		this.setContentPane(getJContentPane());//getJContentPane());
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
			jContentPane.add(getJTextField_north(), BorderLayout.NORTH);
			jContentPane.add(getJPanel_south(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_center(), BorderLayout.CENTER);
			jContentPane.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField_north	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_north() {
		if (jTextField_north == null) {
			jTextField_north = new JTextField();
			jTextField_north.setText("Modification d'un tronçon dans la base");
			jTextField_north.setFont(new Font("Arial",Font.BOLD,12));
			jTextField_north.setOpaque(false);
			jTextField_north.setHorizontalAlignment(JTextField.CENTER);
			jTextField_north.setPreferredSize(new Dimension (this.getWidth(),30));
			jTextField_north.setEditable(false);
			jTextField_north.setBorder(BorderFactory.createEmptyBorder());
		}
		return jTextField_north;
	}

	/**
	 * This method initializes jPanel_south	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_south() {
		if (jPanel_south == null) {
			jPanel_south = new JPanel();
			jPanel_south.setLayout(new FlowLayout());
			jPanel_south.add(getJButton_cancel(), null);
			jPanel_south.add(getJButton_ok(), null);
		}
		return jPanel_south;
	}

	/**
	 * This method initializes jButton_cancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_cancel() {
		if (jButton_cancel == null) {
			jButton_cancel = new JButton();
			jButton_cancel.setText("Annuler");
			jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ownerButton.setEnabled(true);
					dispose();
				}
			});
			
		}
		return jButton_cancel;
	}

	/**
	 * This method initializes jButton_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// TODO
					if (jComboBox_ville1.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Veuillez sélectionner la première ville du tronçon.", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else if (jComboBox_ville2.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Veuillez sélectionner la deuxième ville du tronçon.", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else if (jTextField_longueur.getText().equals("") || !jTextField_longueur.getText().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "Longueur de tronçon incorrecte (doit etre un nombre).", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else {
						boolean b = false;
						try {
							b = progps.tronconConnu(((String)jComboBox_route.getToolTipText()),(String)jComboBox_ville1.getSelectedItem(),(String)jComboBox_ville2.getSelectedItem());
						}
						catch (Exception exc) {
							exc.printStackTrace();
						}
						if (b && !(leTroncon.getSaRoute().getNomRoute().equals((String)jComboBox_route.getSelectedItem()) && leTroncon.getSesVilles().toArray()[0].equals((String)jComboBox_ville1.getSelectedItem()) && leTroncon.getSesVilles().toArray()[1].equals((String)jComboBox_ville2.getSelectedItem())) && !(leTroncon.getSaRoute().getNomRoute().equals((String)jComboBox_route.getSelectedItem()) && leTroncon.getSesVilles().toArray()[0].equals((String)jComboBox_ville2.getSelectedItem()) && leTroncon.getSesVilles().toArray()[1].equals((String)jComboBox_ville1.getSelectedItem())) ) {
							 JOptionPane.showMessageDialog(null, "Ce troncon existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						else {
							Vector<Etat> lesEtats = new Vector<Etat>();
							if (jRadioButton_yesPayant.isSelected()) {
								lesEtats.add(Etat.Payant);
							}
							if (jRadioButton_yesTouristique.isSelected()) {
								lesEtats.add(Etat.Touristique);
							}
							if (jRadioButton_yesRadars.isSelected()) {
								lesEtats.add(Etat.Radar);
							}
							//progps.ajouterTroncon((String)jComboBox_ville1.getSelectedItem(), (String)jComboBox_ville2.getSelectedItem(), progps.getRoute((String)jComboBox_route.getSelectedItem()), (new Integer((String)jComboBox_limitations.getSelectedItem())).intValue(), (new Integer(jTextField_longueur.getText())).intValue(), lesEtats);
							leTroncon.setSaRoute(progps.getRoute((String)jComboBox_route.getSelectedItem()));
							try {
								leTroncon.setSesVilles(progps.getVille((String)jComboBox_ville1.getSelectedItem()),progps.getVille((String)jComboBox_ville2.getSelectedItem()));
							}
							catch (Exception exc) {
								exc.printStackTrace();
							}
							leTroncon.setLongueur((new Integer(jTextField_longueur.getText())).intValue());
							leTroncon.setVitesse((new Integer((String)jComboBox_limitations.getSelectedItem())).intValue());
							leTroncon.setSesEtats(lesEtats);
						
							ownerFrame.getAdminPanel().refreshListeTroncons();
							ownerButton.setEnabled(true);
							dispose();
						}
					}
				}
			});
			jButton_ok.setText("OK");
		}
		return jButton_ok;
	}

	/**
	 * This method initializes jPanel_center	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_center() {
		if (jPanel_center == null) {
			jLabel_longueur = new JLabel();
			jLabel_longueur.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_longueur.setText("Longueur : ");
			jLabel_vitesse = new JLabel();
			jLabel_vitesse.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_vitesse.setText("Limitation de vitesse : ");
			jLabel_no2 = new JLabel();
			jLabel_no2.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_no2.setText("Non");
			jLabel_yes2 = new JLabel();
			jLabel_yes2.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_yes2.setText("Oui");
			jLabel_radars = new JLabel();
			jLabel_radars.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_radars.setText("Radars : ");
			jLabel_ville2 = new JLabel();
			jLabel_ville2.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_ville2.setText("Ville 2 : ");
			jLabel_ville1 = new JLabel();
			jLabel_ville1.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_ville1.setText("Ville 1 : ");
			jLabel_route = new JLabel();
			jLabel_route.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_route.setText("Route : ");
			jLabel_no1 = new JLabel();
			jLabel_no1.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_no1.setText("Non");
			jLabel_yes1 = new JLabel();
			jLabel_yes1.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_yes1.setText("Oui");
			jLabel_payant = new JLabel();
			jLabel_payant.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_payant.setText("Tronçon payant : ");
			jLabel_no = new JLabel();
			jLabel_no.setText("Non");
			jLabel_no.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_yes = new JLabel();
			jLabel_yes.setText("Oui");
			jLabel_yes.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_touristique = new JLabel();
			jLabel_touristique.setText("Tronçon touristique : ");
			jLabel_touristique.setFont(new Font("Arial",Font.PLAIN,12));
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new FlowLayout());
			jPanel_center.add(jLabel_route, null);
			jPanel_center.add(getJComboBox_route(), null);
			EmptyLabel empty1 = new EmptyLabel(250,2);
			EmptyLabel empty2 = new EmptyLabel(250,2);
			EmptyLabel empty3 = new EmptyLabel(250,2);
			jPanel_center.add(empty1, null);
			jPanel_center.add(jLabel_ville1, null);
			jPanel_center.add(getJComboBox_ville1(), null);
			jPanel_center.add(empty2, null);
			jPanel_center.add(jLabel_ville2, null);
			jPanel_center.add(getJComboBox_ville2(), null);
			jPanel_center.add(jLabel_longueur, null);
			jPanel_center.add(getJTextField_longueur(), null);
			jPanel_center.add(jLabel_touristique, null);
			jPanel_center.add(getJRadioButton_yesTouristique(), null);
			jPanel_center.add(jLabel_yes, null);
			jPanel_center.add(getJRadioButton_noTouristique(), null);
			jPanel_center.add(jLabel_no, null);
			jPanel_center.add(jLabel_payant, null);
			jPanel_center.add(getJRadioButton_yesPayant(), null);
			jPanel_center.add(jLabel_yes1, null);
			jPanel_center.add(getJRadioButton_noPayant(), null);
			jPanel_center.add(jLabel_no1, null);
			jPanel_center.add(empty3, null);
			jPanel_center.add(jLabel_radars, null);
			jPanel_center.add(getJRadioButton_yesRadars(), null);
			jPanel_center.add(jLabel_yes2, null);
			jPanel_center.add(getJRadioButton_noRadars(), null);
			jPanel_center.add(jLabel_no2, null);
			jPanel_center.add(jLabel_vitesse, null);
			jPanel_center.add(getJComboBox_limitations(), null);
			
			radioGroup1.add(jRadioButton_yesTouristique);
			radioGroup1.add(jRadioButton_noTouristique);
			
			radioGroup2.add(jRadioButton_yesPayant);
			radioGroup2.add(jRadioButton_noPayant);
			
			radioGroup3.add(jRadioButton_yesRadars);
			radioGroup3.add(jRadioButton_noRadars);
			
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jRadioButton_yesTouristique	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_yesTouristique() {
		if (jRadioButton_yesTouristique == null) {
			jRadioButton_yesTouristique = new JRadioButton();
			jRadioButton_yesTouristique.setSelected(leTroncon.isTouristique());
		}
		return jRadioButton_yesTouristique;
	}

	/**
	 * This method initializes jRadioButton_noTouristique	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_noTouristique() {
		if (jRadioButton_noTouristique == null) {
			jRadioButton_noTouristique = new JRadioButton();
			jRadioButton_noTouristique.setSelected(!leTroncon.isTouristique());
		}
		return jRadioButton_noTouristique;
	}

	/**
	 * This method initializes jRadioButton_yesPayant	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_yesPayant() {
		if (jRadioButton_yesPayant == null) {
			jRadioButton_yesPayant = new JRadioButton();
			jRadioButton_yesPayant.setSelected(leTroncon.isPayant());
		}
		return jRadioButton_yesPayant;
	}

	/**
	 * This method initializes jRadioButton_noPayant	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_noPayant() {
		if (jRadioButton_noPayant == null) {
			jRadioButton_noPayant = new JRadioButton();
			jRadioButton_noPayant.setSelected(!leTroncon.isPayant());
		}
		return jRadioButton_noPayant;
	}

	/**
	 * This method initializes jComboBox_route	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_route() {
		if (jComboBox_route == null) {
			jComboBox_route = new JComboBox();
			jComboBox_route.setBackground(Color.WHITE);
			jComboBox_route.setForeground(Color.BLUE);
			jComboBox_route.setPreferredSize(new Dimension(100, 20));
			jComboBox_route.setSelectedItem(leTroncon.getSaRoute().getNomRoute());
		}
		return jComboBox_route;
	}

	/**
	 * This method initializes jComboBox_ville1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_ville1() {
		if (jComboBox_ville1 == null) {
			jComboBox_ville1 = new JComboBox();
			jComboBox_ville1.setBackground(Color.WHITE);
			jComboBox_ville1.setForeground(Color.BLUE);
			jComboBox_ville1.setPreferredSize(new Dimension(150, 20));
			jComboBox_ville1.setSelectedItem(leTroncon.getSesVilles().toArray()[0]);
		}
		return jComboBox_ville1;
	}

	/**
	 * This method initializes jComboBox_ville2	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_ville2() {
		if (jComboBox_ville2 == null) {
			jComboBox_ville2 = new JComboBox();
			jComboBox_ville2.setBackground(Color.WHITE);
			jComboBox_ville2.setForeground(Color.BLUE);
			jComboBox_ville2.setPreferredSize(new Dimension(150, 20));
			jComboBox_ville2.setSelectedItem(leTroncon.getSesVilles().toArray()[1]);
		}
		return jComboBox_ville2;
	}

	/**
	 * This method initializes jRadioButton_yesRadars	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_yesRadars() {
		if (jRadioButton_yesRadars == null) {
			jRadioButton_yesRadars = new JRadioButton();
			jRadioButton_yesRadars.setSelected(leTroncon.isRadar());
		}
		return jRadioButton_yesRadars;
	}

	/**
	 * This method initializes jRadioButton_noRadars	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_noRadars() {
		if (jRadioButton_noRadars == null) {
			jRadioButton_noRadars = new JRadioButton();
			jRadioButton_noRadars.setSelected(!leTroncon.isRadar());
		}
		return jRadioButton_noRadars;
	}

	/**
	 * This method initializes jComboBox_limitations	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_limitations() {
		if (jComboBox_limitations == null) {
			Vector<String> limitations = new Vector<String>();
			limitations.add("50 km/h");
			limitations.add("70 km/h");
			limitations.add("90 km/h");
			limitations.add("110 km/h");
			limitations.add("130 km/h");
			jComboBox_limitations = new JComboBox(limitations);
			jComboBox_limitations.setBackground(Color.WHITE);
			jComboBox_limitations.setForeground(Color.RED);
			jComboBox_limitations.setSelectedItem("" + leTroncon.getVitesse());
		}
		return jComboBox_limitations;
	}

	/**
	 * This method initializes jTextField_longueur	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_longueur() {
		if (jTextField_longueur == null) {
			jTextField_longueur = new JTextField();
			jTextField_longueur.setPreferredSize(new Dimension(150, 20));
			jTextField_longueur.setText("" + leTroncon.getLongueur());
		}
		return jTextField_longueur;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
