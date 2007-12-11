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

	private JLabel jLabel_prix = null;

	private JTextField jTextField_prix = null;

	private JLabel jLabel_radars = null;

	private JRadioButton jRadioButton_yesRadars = null;

	private JRadioButton jRadioButton_noRadars = null;

	private JLabel jLabel_yes2 = null;

	private JLabel jLabel_no2 = null;

	private JLabel jLabel_vitesse = null;

	private JComboBox jComboBox_limitations = null;

	private Vector limitations = null;

	/**
	 * @param owner
	 */
	public ModifTroncon(Frame owner, JButton but) {
		super(owner);
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
		this.setSize(270, 310);
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
					ownerButton.setEnabled(true);
					dispose();
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
			jLabel_prix = new JLabel();
			jLabel_prix.setText("Prix : ");
			jLabel_prix.setFont(new Font("Arial",Font.PLAIN,12));
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
			EmptyLabel empty4 = new EmptyLabel(250,2);
			jPanel_center.add(empty1, null);
			jPanel_center.add(jLabel_ville1, null);
			jPanel_center.add(getJComboBox_ville1(), null);
			jPanel_center.add(empty2, null);
			jPanel_center.add(jLabel_ville2, null);
			jPanel_center.add(getJComboBox_ville2(), null);
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
			jPanel_center.add(jLabel_prix, null);
			jPanel_center.add(getJTextField_prix(), null);
			jPanel_center.add(empty4, null);
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
			jRadioButton_yesPayant.setSelected(true);
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
			jRadioButton_noPayant.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					jLabel_prix.setEnabled(!jLabel_prix.isEnabled());
					jTextField_prix.setEnabled(!jTextField_prix.isEnabled());
				}
			});
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
		}
		return jComboBox_ville2;
	}

	/**
	 * This method initializes jTextField_prix	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_prix() {
		if (jTextField_prix == null) {
			jTextField_prix = new JTextField();
			jTextField_prix.setPreferredSize(new Dimension(100,20));
		}
		return jTextField_prix;
	}

	/**
	 * This method initializes jRadioButton_yesRadars	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_yesRadars() {
		if (jRadioButton_yesRadars == null) {
			jRadioButton_yesRadars = new JRadioButton();
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
		}
		return jComboBox_limitations;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
