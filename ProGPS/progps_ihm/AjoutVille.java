package progps_ihm;

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

import noyau.Route;
import noyau.SingletonProgps;
import noyau.Ville;


public class AjoutVille extends JWindow {

	private static final long serialVersionUID = 1L;
	
	private SingletonProgps progps = null;
	
	private FenetrePrincipale ownerFrame = null;
	
	private JButton ownerButton = null;
	
	private JPanel jContentPane = null;

	private JTextField jTextField_north = null;

	private JPanel jPanel_south = null;

	private JButton jButton_cancel = null;

	private JButton jButton_ok = null;

	private JPanel jPanel_center = null;

	private JLabel jLabel_nomVille = null;

	private JTextField jTextField_nomVille = null;

	private JLabel jLabel_touristique = null;
	
	private ButtonGroup radioGroup1 = new ButtonGroup();

	private JRadioButton jRadioButton_yes = null;

	private JRadioButton jRadioButton_no = null;

	private JLabel jLabel_yes = null;

	private JLabel jLabel_no = null;

	private JLabel jLabel_typeVille = null;

	private JComboBox jComboBox_typeVille = null;

	/**
	 * @param owner
	 */
	public AjoutVille(Frame owner, JButton but, SingletonProgps sys) {
		super(owner);
		ownerFrame = (FenetrePrincipale)owner;
		ownerButton = but;
		progps = sys;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(270, 148);
		this.setContentPane(getJContentPane());
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
			jTextField_north.setText("Ajout d'une ville dans la base");
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
					// action modif ville
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
					if (jTextField_nomVille.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer un nom pour la ville !", "Erreur", JOptionPane.ERROR_MESSAGE);
						jTextField_nomVille.requestFocus();
					}
					else if (progps.villeConnue(jTextField_nomVille.getText())) {
						JOptionPane.showMessageDialog(null, "Cette ville existe d�j� !", "Erreur", JOptionPane.ERROR_MESSAGE);
						jTextField_nomVille.requestFocus();
					}
					else if (!jRadioButton_no.isSelected() && !jRadioButton_yes.isSelected()) {
						JOptionPane.showMessageDialog(null, "Veuillez selectionner si la ville est touristique.", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else {
						progps.ajouterVille(jTextField_nomVille.getText(),true,jComboBox_typeVille.getSelectedIndex(),jRadioButton_yes.isSelected());
						ownerButton.setEnabled(true);
						ownerFrame.getAdminPanel().refreshListeVilles();
						dispose();
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
			jLabel_typeVille = new JLabel();
			jLabel_typeVille.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_typeVille.setText("Type de la ville : ");
			jLabel_no = new JLabel();
			jLabel_no.setText("Non");
			jLabel_no.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_yes = new JLabel();
			jLabel_yes.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_yes.setText("Oui");
			jLabel_touristique = new JLabel();
			jLabel_touristique.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_touristique.setText("Ville touristique : ");
			jLabel_nomVille = new JLabel();
			jLabel_nomVille.setText("Nom de la ville : ");
			jLabel_nomVille.setFont(new Font("Arial",Font.PLAIN,12));
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new FlowLayout());
			jPanel_center.add(jLabel_nomVille, null);
			jPanel_center.add(getJTextField_nomVille(), null);
			jPanel_center.add(jLabel_typeVille, null);
			jPanel_center.add(getJComboBox_typeVille(), null);
			jPanel_center.add(jLabel_touristique, null);
			jPanel_center.add(getJRadioButton_yes(), null);
			jPanel_center.add(jLabel_yes, null);
			jPanel_center.add(getJRadioButton_no(), null);
			jPanel_center.add(jLabel_no, null);
			
			radioGroup1.add(jRadioButton_yes);
			radioGroup1.add(jRadioButton_no);
			
			
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jTextField_nomVille	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_nomVille() {
		if (jTextField_nomVille == null) {
			jTextField_nomVille = new JTextField();
			jTextField_nomVille.setPreferredSize(new Dimension(150,18));
		}
		return jTextField_nomVille;
	}

	/**
	 * This method initializes jRadioButton_yes	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_yes() {
		if (jRadioButton_yes == null) {
			jRadioButton_yes = new JRadioButton();
		}
		return jRadioButton_yes;
	}

	/**
	 * This method initializes jRadioButton_no	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_no() {
		if (jRadioButton_no == null) {
			jRadioButton_no = new JRadioButton();
		}
		return jRadioButton_no;
	}

	/**
	 * This method initializes jComboBox_typeVille	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_typeVille() {
		if (jComboBox_typeVille == null) {
			jComboBox_typeVille = new JComboBox();
			jComboBox_typeVille.setBackground(Color.WHITE);
			jComboBox_typeVille.setPreferredSize(new Dimension(150,20));
			jComboBox_typeVille.addItem("Petite");
			jComboBox_typeVille.addItem("Moyenne");
			jComboBox_typeVille.addItem("Grande");
		}
		return jComboBox_typeVille;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
