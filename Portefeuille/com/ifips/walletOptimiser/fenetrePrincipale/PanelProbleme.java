package com.ifips.walletOptimiser.fenetrePrincipale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class PanelProbleme extends JPanel {

	private Vector<String> contraintes = new Vector<String>();  //  @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private FenetreIHM parent = null;
	private JPanel jPanel_north = null;
	private JLabel jLabel_north1 = null;
	private JPanel jPanel_center = null;
	private JLabel jLabel_fcObj = null;
	private JScrollPane jScrollPane_contraintes = null;
	private JTextField jTextField_fcObj = null;
	private JTextArea jTextArea_contraintes = null;
	private JLabel jLabel_contraintes = null;
	private JButton jButton_modifFcObj = null;
	private JPanel jPanel_southcenter = null;
	private JButton jButton_addContrainte = null;
	private JComboBox jComboBox_contraintes = null;
	private JButton jButton_modifContrainte = null;
	private JButton jButton_delContrainte = null;
	private JPanel jPanel_south0 = null;
	private JLabel jLabel_south0 = null;
	private JRadioButton jRadioButton_opt1 = null;
	private JLabel jLabel_opt1 = null;
	private JRadioButton jRadioButton_opt2 = null;
	private JLabel jLabel_opt2 = null;
	private JRadioButton jRadioButton_opt3 = null;
	private JLabel jLabel_opt3 = null;
	private JRadioButton jRadioButton_opt4 = null;
	private JLabel jLabel_opt4 = null;
	private JRadioButton jRadioButton_opt5 = null;
	private JLabel jLabel_opt5 = null;
	private JButton jButton_modifParamsAlgo = null;
	private EmptyLabel empty2 = null;
	private JButton jButton_OKresolution = null;
	private ButtonGroup radioGroup = new ButtonGroup();  //  @jve:decl-index=0:
	private JLabel jLabel_min = null;

	/**
	 * This is the default constructor
	 */
	public PanelProbleme() {
		super();
		initialize();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		initContraintes();
		this.setSize(700, 555);
		this.setLayout(new BorderLayout());
		this.add(getJPanel_north(), BorderLayout.NORTH);
		this.add(getJPanel_center(), BorderLayout.CENTER);
		this.add(getJPanel_south0(), BorderLayout.SOUTH);
		refreshComboContraintes();
		refreshDisplayContraintes();
	}

	private void initContraintes() {
		contraintes.add("[X1] + [X2] + [X3] = 1");
		contraintes.add("3*[X1] + 6*[X2] + 12*[X3] >= 20");
		contraintes.add("[Y1] + [Y2] + [Y3] = 2");
		contraintes.add("0.2*[Y1] <= [X1] <= 0.5*[Y1]");
		contraintes.add("0.15*[Y2] <= [X2] <= 0.75*[Y2]");
		contraintes.add("0.3*[Y3] <= [X3] <= 0.95*[Y3]");
		contraintes.add("[Y1] = 0 || [Y1] = 1");
		contraintes.add("[Y2] = 0 || [Y2] = 1");
		contraintes.add("[Y3] = 0 || [Y3] = 1");
	}
	
	private void refreshComboContraintes() {
		jComboBox_contraintes.removeAllItems();
		for (int i=0; i<contraintes.size(); i++) {
			jComboBox_contraintes.addItem("Contrainte ( " + (i+1) + " )");
		}
	}
	
	private void refreshDisplayContraintes() {
		jTextArea_contraintes.setText("");
		for (int i=0; i<contraintes.size(); i++) {
			jTextArea_contraintes.setText(jTextArea_contraintes.getText() + " ( " + (i+1) + " )\t" + contraintes.get(i) + "\n\n");
		}
	}
	
	private void launchResolution() {
		parent = ((FenetreIHM)getTopLevelAncestor());
		if (radioGroup.getSelection() == null) {
			JOptionPane.showMessageDialog(this, "Erreur : aucune méthode n'a été sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
			return;
		}		
		else {
			((FenetreIHM)getTopLevelAncestor()).launchResolution();
			
			if (jRadioButton_opt1.isSelected()) {
				// Descente
				
			}
			else if (jRadioButton_opt2.isSelected()) {
				// Recuit
				if (parent.getRecuit() != null)
					parent.getRecuit().resoudre();
				else System.out.println("null !");
			}
			else if (jRadioButton_opt3.isSelected()) {
				// VNS
				if (parent.getVNS() != null)
					parent.getVNS().resoudre();
				else System.out.println("null !");
			}
			else if (jRadioButton_opt4.isSelected()) {
				// CPLEX
				parent.getVNS().resoudre();
			}
			else if (jRadioButton_opt5.isSelected()) {
				// Relaxation Lagrangienne
				parent.getLagrange().resoudre();
			}
				
		}
	}
	
	private void launchParams() {
		if (jRadioButton_opt2.isSelected()) {
			// Recuit
			ParamsRecuit recuit = new ParamsRecuit((FenetreIHM)getTopLevelAncestor());
			recuit.setLocation(((FenetreIHM)getTopLevelAncestor()).getLocation());
			recuit.setVisible(true);
		}
		else if (jRadioButton_opt3.isSelected()) {
			// VNS
			ParamsVNS vns = new ParamsVNS((FenetreIHM)getTopLevelAncestor());
			vns.setLocation(((FenetreIHM)getTopLevelAncestor()).getLocation());
			vns.setVisible(true);
		}
		else if (jRadioButton_opt5.isSelected()) {
			// Relaxation Lagrangienne
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Erreur : aucune méthode n'a été sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * This method initializes jPanel_north	
	 * 	
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_north() {
		if (jPanel_north == null) {
			jLabel_north1 = new JLabel();
			jLabel_north1.setText("Formulation du problème :");
			jPanel_north = new JPanel();
			jPanel_north.setLayout(new FlowLayout());
			jPanel_north.add(jLabel_north1, null);
		}
		return jPanel_north;
	}

	/**
	 * This method initializes jPanel_center	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_center() {
		if (jPanel_center == null) {
			jLabel_min = new JLabel();
			jLabel_min.setText("MIN");
			jLabel_min.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_min.setFont(new Font("Arial",Font.PLAIN,13));
			jLabel_min.setForeground(Color.BLUE);
			jLabel_min.setPreferredSize(new Dimension(30,25));
			jLabel_min.setBackground(new Color(240,240,240));
			jLabel_contraintes = new JLabel();
			jLabel_contraintes.setText("Sous-contraintes : ");
			jLabel_fcObj = new JLabel();
			jLabel_fcObj.setText("Fonction objectif : ");
			jLabel_fcObj.setHorizontalAlignment(JLabel.RIGHT);
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new FlowLayout());
			jPanel_center.add(jLabel_fcObj, null);
			jPanel_center.add(jLabel_min, null);
			jPanel_center.add(getJTextField_fcObj(), null);
			jPanel_center.add(getJButton_modifFcObj(), null);
			jPanel_center.add(jLabel_contraintes, null);
			jPanel_center.add(getJScrollPane_contraintes(), null);
			jPanel_center.add(getJPanel_southcenter(), null);
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jScrollPane_contraintes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_contraintes() {
		if (jScrollPane_contraintes == null) {
			jScrollPane_contraintes = new JScrollPane();
			jScrollPane_contraintes.setPreferredSize(new Dimension(540,250));
			jScrollPane_contraintes.setViewportView(getJTextArea_contraintes());
		}
		return jScrollPane_contraintes;
	}

	/**
	 * This method initializes jTextField_fcObj	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_fcObj() {
		if (jTextField_fcObj == null) {
			jTextField_fcObj = new JTextField();
			jTextField_fcObj.setText("10*[X1] + 3*[X2] + 5*[X3]");
			jTextField_fcObj.setFont(new Font("Arial",Font.PLAIN,13));
			jTextField_fcObj.setForeground(Color.BLUE);
			jTextField_fcObj.setPreferredSize(new Dimension(415,25));
			jTextField_fcObj.setEditable(false);
			jTextField_fcObj.setBackground(new Color(240,240,240));
			jTextField_fcObj.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
		}
		return jTextField_fcObj;
	}

	/**
	 * This method initializes jTextArea_contraintes	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_contraintes() {
		if (jTextArea_contraintes == null) {
			jTextArea_contraintes = new JTextArea();
			jTextArea_contraintes.setEditable(false);
			jTextArea_contraintes.setFont(new Font("Arial",Font.PLAIN,13));
			jTextArea_contraintes.setBackground(new Color(240,240,240));
			jTextArea_contraintes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		return jTextArea_contraintes;
	}

	/**
	 * This method initializes jButton_modifFcObj	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_modifFcObj() {
		if (jButton_modifFcObj == null) {
			jButton_modifFcObj = new JButton();
			jButton_modifFcObj.setText("Modifier");
			jButton_modifFcObj.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String newFcObj = JOptionPane.showInputDialog("Entrez la nouvelle fonction objectif :",jTextField_fcObj.getText());
					if (newFcObj != null && !newFcObj.equals("")) {
						jTextField_fcObj.setText(newFcObj);
					}
				}
			});
		}
		return jButton_modifFcObj;
	}

	/**
	 * This method initializes jPanel_southcenter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_southcenter() {
		if (jPanel_southcenter == null) {
			jPanel_southcenter = new JPanel();
			jPanel_southcenter.setPreferredSize(new Dimension(700,95));
			jPanel_southcenter.setLayout(new FlowLayout());
			jPanel_southcenter.add(getJButton_addContrainte(), null);
			EmptyLabel empty1 = new EmptyLabel(700,2);
			jPanel_southcenter.add(empty1, null);
			jPanel_southcenter.add(getJComboBox_contraintes(), null);
			jPanel_southcenter.add(getJButton_modifContrainte(), null);
			jPanel_southcenter.add(getJButton_delContrainte(), null);
		}
		return jPanel_southcenter;
	}

	/**
	 * This method initializes jButton_addContrainte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_addContrainte() {
		if (jButton_addContrainte == null) {
			jButton_addContrainte = new JButton();
			jButton_addContrainte.setText("Ajouter une nouvelle contrainte");
			jButton_addContrainte.setIcon(new ImageIcon("images//bulbicon.png"));
			jButton_addContrainte.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String cont = JOptionPane.showInputDialog("Entrez la nouvelle contrainte :","");
					if (cont != null && !cont.equals("")) {
						contraintes.add(cont);
						refreshComboContraintes();
						refreshDisplayContraintes();
					}
				}
			});
		}
		return jButton_addContrainte;
	}

	/**
	 * This method initializes jComboBox_contraintes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_contraintes() {
		if (jComboBox_contraintes == null) {
			jComboBox_contraintes = new JComboBox();
		}
		return jComboBox_contraintes;
	}

	/**
	 * This method initializes jButton_modifContrainte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_modifContrainte() {
		if (jButton_modifContrainte == null) {
			jButton_modifContrainte = new JButton();
			jButton_modifContrainte.setText("Modifier la contrainte");
			jButton_modifContrainte.setIcon(new ImageIcon("images//editicon.png"));
			jButton_modifContrainte.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					String cont = JOptionPane.showInputDialog("Entrez la contrainte modifiée :",contraintes.get(jComboBox_contraintes.getSelectedIndex()));
					if (cont != null && !cont.equals("")) {
						contraintes.setElementAt(cont, jComboBox_contraintes.getSelectedIndex());
						refreshDisplayContraintes();
					}
				}
			
			});
		}
		return jButton_modifContrainte;
	}

	/**
	 * This method initializes jButton_delContrainte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_delContrainte() {
		if (jButton_delContrainte == null) {
			jButton_delContrainte = new JButton();
			jButton_delContrainte.setText("Supprimer la contrainte");
			jButton_delContrainte.setIcon(new ImageIcon("images//deleteicon.png"));
			jButton_delContrainte.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment effacer la contrainte :\n\" " + contraintes.get(jComboBox_contraintes.getSelectedIndex()) + " \" ?", "Effacer la contrainte ?", JOptionPane.YES_NO_OPTION);
					if (rep == JOptionPane.YES_OPTION) {
						contraintes.removeElementAt(jComboBox_contraintes.getSelectedIndex());
						refreshComboContraintes();
						refreshDisplayContraintes();
					}
				}
			});
		}
		return jButton_delContrainte;
	}

	/**
	 * This method initializes jPanel_south0	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_south0() {
		if (jPanel_south0 == null) {
			empty2 = new EmptyLabel(700, 5);
			jLabel_opt5 = new JLabel();
			jLabel_opt5.setText("Relaxation Lagrangienne");
			jLabel_opt4 = new JLabel();
			jLabel_opt4.setText("CPLEX");
			jLabel_opt3 = new JLabel();
			jLabel_opt3.setText("VNS");
			jLabel_opt2 = new JLabel();
			jLabel_opt2.setText("Recuit simulé");
			jLabel_opt1 = new JLabel();
			jLabel_opt1.setText("Descente");
			jLabel_south0 = new JLabel();
			jLabel_south0.setText("Choisir la méthode de résolution : ");
			jPanel_south0 = new JPanel();
			jPanel_south0.setLayout(new FlowLayout());
			jPanel_south0.setPreferredSize(new Dimension(700, 125));
			jPanel_south0.add(jLabel_south0, null);
			jPanel_south0.add(getJRadioButton_opt1(), null);
			jPanel_south0.add(jLabel_opt1, null);
			jPanel_south0.add(getJRadioButton_opt2(), null);
			jPanel_south0.add(jLabel_opt2, null);
			jPanel_south0.add(getJRadioButton_opt3(), null);
			jPanel_south0.add(jLabel_opt3, null);
			jPanel_south0.add(getJRadioButton_opt4(), null);
			jPanel_south0.add(jLabel_opt4, null);
			jPanel_south0.add(getJRadioButton_opt5(), null);
			jPanel_south0.add(jLabel_opt5, null);
			jPanel_south0.add(getJButton_modifParamsAlgo(), null);
			jPanel_south0.add(empty2, empty2.getName());
			jPanel_south0.add(getJButton_OKresolution(), null);
			
			
			radioGroup.add(jRadioButton_opt1);
			radioGroup.add(jRadioButton_opt2);
			radioGroup.add(jRadioButton_opt3);
			radioGroup.add(jRadioButton_opt4);
			radioGroup.add(jRadioButton_opt5);
		}
		return jPanel_south0;
	}

	/**
	 * This method initializes jRadioButton_opt1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_opt1() {
		if (jRadioButton_opt1 == null) {
			jRadioButton_opt1 = new JRadioButton();
			//jRadioButton_opt1.setSelected(true);
			jRadioButton_opt1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					jButton_modifParamsAlgo.setEnabled(!jButton_modifParamsAlgo.isEnabled());
				}
			});
		}
		return jRadioButton_opt1;
	}

	/**
	 * This method initializes jRadioButton_opt2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_opt2() {
		if (jRadioButton_opt2 == null) {
			jRadioButton_opt2 = new JRadioButton();
		}
		return jRadioButton_opt2;
	}

	/**
	 * This method initializes jRadioButton_opt3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_opt3() {
		if (jRadioButton_opt3 == null) {
			jRadioButton_opt3 = new JRadioButton();
		}
		return jRadioButton_opt3;
	}

	/**
	 * This method initializes jRadioButton_opt4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_opt4() {
		if (jRadioButton_opt4 == null) {
			jRadioButton_opt4 = new JRadioButton();
			jRadioButton_opt4.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					jButton_modifParamsAlgo.setEnabled(!jButton_modifParamsAlgo.isEnabled());
				}
			});
		}
		return jRadioButton_opt4;
	}

	/**
	 * This method initializes jRadioButton_opt5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_opt5() {
		if (jRadioButton_opt5 == null) {
			jRadioButton_opt5 = new JRadioButton();
		}
		return jRadioButton_opt5;
	}
	
	public void setContraintes(Vector<String> cont) {
		contraintes = new Vector<String>(cont);
		refreshDisplayContraintes();
		refreshComboContraintes();
	}
	
	public void setFonctionObjectif(String fonc) {
		jTextField_fcObj.setText(fonc);
	}

	/**
	 * This method initializes jButton_modifParamsAlgo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_modifParamsAlgo() {
		if (jButton_modifParamsAlgo == null) {
			jButton_modifParamsAlgo = new JButton();
			jButton_modifParamsAlgo.setIcon(new ImageIcon("images//toolicon.png"));
			jButton_modifParamsAlgo.setText("Modifier les paramètres de la méthode");
			jButton_modifParamsAlgo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					launchParams();
				}
			});
		}
		return jButton_modifParamsAlgo;
	}

	/**
	 * This method initializes jButton_OKresolution	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_OKresolution() {
		if (jButton_OKresolution == null) {
			jButton_OKresolution = new JButton();
			jButton_OKresolution.setIcon(new ImageIcon("images//gearsicon.png"));
			jButton_OKresolution.setText("Résoudre le problème");
			jButton_OKresolution.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					launchResolution();
				}
			});
		}
		return jButton_OKresolution;
	}

}
