package progps_ihm;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.util.Vector;

public class AdminPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane_adminTabs = null;
	private JPanel jPanel_adminInfos = null;
	private JPanel jPanel_adminVilles = null;
	private JLabel jLabel_adminInfos1 = null;
	private JLabel jLabel_adminNbVilles = null;
	private JLabel jLabel_adminInfos2 = null;
	private JLabel jLabel_adminNbRoutes = null;
	private JLabel jLabel_adminInfos3 = null;
	private JLabel jLabel_adminNbTroncons = null;
	private JLabel jLabel_adminInfos4 = null;
	private JLabel jLabel_adminVillesIndispo = null;
	private JLabel jLabel_empty2 = null;
	private JLabel jLabel_adminRoutesIndispo = null;
	private JLabel jLabel_adminTronconsIndispo = null;
	private JPanel jPanel_adminTabInfosIndispo = null;
	private JLabel jLabel_empty3 = null;
	private JLabel jLabel_empty5 = null;
	
	private String[] listNone = {"Aucun(e)"};
	private JButton jButton_adminAddVille = null;
	private JComboBox jComboBox_adminVilles = null;
	private JButton jButton_adminModifVille = null;
	private JButton jButton_adminIndispoVille = null;
	private JLabel jLabel_empty6 = null;
	private JLabel jLabel_empty7 = null;
	private JPanel jPanel_adminRoutes = null;
	private JButton jButton_adminAddRoute = null;
	private JComboBox jComboBox_adminRoutes = null;
	private JButton jButton_adminModifRoute = null;
	private JButton jButton_adminIndispoRoute = null;
	private JLabel jLabel_empty8 = null;
	private JLabel jLabel_empty9 = null;
	private JPanel jPanel_adminTroncons = null;
	private JButton jButton_adminAddTroncon = null;
	private JComboBox jComboBox_adminTroncons = null;
	private JButton jButton_adminModifTroncon = null;
	private JButton jButton_adminIndispoTroncon = null;
	private JLabel jLabel_empty10 = null;
	private JLabel jLabel_empty11 = null;
	private JComboBox jComboBox_adminRoutesTroncons = null;
	private JScrollPane jScrollPane_adminVillesIndispo = null;
	private JList jList_adminVillesIndispo = null;
	private JLabel jLabel_adminTronconsRoutes = null;
	private JLabel jLabel_empty12 = null;
	private JScrollPane jScrollPane_adminRoutesIndispo = null;
	private JList jList_adminRoutesIndispo = null;
	private Vector routesIndispo = null;
	private JScrollPane jScrollPane_adminTronconsIndispo = null;
	private JList jList_adminTronconsIndispo = null;
	private Vector tronconsIndispo = null;
	/**
	 * This is the default constructor
	 */
	public AdminPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridx = 0;
		this.setSize(770, 480);
		this.setLayout(new GridBagLayout());
		this.add(getJTabbedPane_adminTabs(), gridBagConstraints);
	}
	
	private void nouvelleVille() {
		AjoutVille ajV = new AjoutVille((Frame)(this.getTopLevelAncestor()),jButton_adminAddVille);
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		ajV.setLocation(location);
		ajV.setVisible(true);
		jButton_adminAddVille.setEnabled(false);
	}
	
	private void modificationVille() {
		ModifVille modV = new ModifVille((Frame)(this.getTopLevelAncestor()), jButton_adminModifVille);
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		//System.out.println((location.getX()+modV.getWidth()) + "     " + (this.getLocation().getX()+this.getWidth()));
		//if ((location.getX()+modV.getWidth()) > (this.getLocation().getX()+this.getWidth()))
			//location.setLocation((location.getX()-modV.getWidth()), location.getY());
		modV.setLocation(location);
		modV.setVisible(true);
		jButton_adminModifVille.setEnabled(false);
	}

	/**
	 * This method initializes jTabbedPane_adminTabs	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_adminTabs() {
		if (jTabbedPane_adminTabs == null) {
			jTabbedPane_adminTabs = new JTabbedPane();
			jTabbedPane_adminTabs.addTab("Informations", null, getJPanel_adminInfos(), null);
			jTabbedPane_adminTabs.addTab("Villes", null, getJPanel_adminVilles(), null);
			jTabbedPane_adminTabs.addTab("Routes", null, getJPanel_adminRoutes(), null);
			jTabbedPane_adminTabs.addTab("Tronçons", null, getJPanel_adminTroncons(), null);
		}
		return jTabbedPane_adminTabs;
	}

	/**
	 * This method initializes jPanel_adminInfos	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminInfos() {
		if (jPanel_adminInfos == null) {
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 10;
			gridBagConstraints22.gridy = 0;
			jLabel_empty5 = new JLabel();
			jLabel_empty5.setText("                             ");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 0;
			jLabel_empty3 = new JLabel();
			jLabel_empty3.setText("                             ");
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 3;
			gridBagConstraints20.gridy = 0;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 4;
			gridBagConstraints19.gridy = 0;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 8;
			gridBagConstraints17.gridy = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 1;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 9;
			gridBagConstraints7.gridy = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 5;
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 7;
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridwidth = 9;
			gridBagConstraints18.gridheight = 1;
			gridBagConstraints18.gridy = 2;
			jLabel_adminTronconsIndispo = new JLabel();
			jLabel_adminTronconsIndispo.setText("Tronçons indisponibles : ");
			jLabel_adminRoutesIndispo = new JLabel();
			jLabel_adminRoutesIndispo.setText("Routes indisponibles : ");
			jLabel_empty2 = new JLabel();
			jLabel_empty2.setText(" ");
			jLabel_adminVillesIndispo = new JLabel();
			jLabel_adminVillesIndispo.setText("Villes indisponibles : ");
			jLabel_adminInfos4 = new JLabel();
			jLabel_adminInfos4.setText(" tronçons dans la base.");
			jLabel_adminNbTroncons = new JLabel();
			jLabel_adminNbTroncons.setForeground(new Color(0,176,52));
			jLabel_adminNbTroncons.setText("43599");
			jLabel_adminNbTroncons.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_adminNbTroncons.setPreferredSize(new Dimension(60,16));
			jLabel_adminInfos3 = new JLabel();
			jLabel_adminInfos3.setText(" routes, et ");
			jLabel_adminNbRoutes = new JLabel();
			jLabel_adminNbRoutes.setForeground(new Color(0,176,52));
			jLabel_adminNbRoutes.setText("564");
			jLabel_adminNbRoutes.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_adminNbRoutes.setPreferredSize(new Dimension(60,16));
			jLabel_adminInfos2 = new JLabel();
			jLabel_adminInfos2.setText(" villes, ");
			jLabel_adminNbVilles = new JLabel();
			jLabel_adminNbVilles.setText("3456");
			jLabel_adminNbVilles.setForeground(new Color(0,176,52));
			jLabel_adminNbVilles.setPreferredSize(new Dimension(60,16));
			jLabel_adminNbVilles.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_adminInfos1 = new JLabel();
			jLabel_adminInfos1.setText("Il y a actuellement ");
			jPanel_adminInfos = new JPanel();
			jPanel_adminInfos.setLayout(new GridBagLayout());
			jPanel_adminInfos.add(getJPanel_adminTabInfosIndispo(), gridBagConstraints18);
			jPanel_adminInfos.add(jLabel_adminNbTroncons, gridBagConstraints17);
			jPanel_adminInfos.add(jLabel_adminInfos1, gridBagConstraints11);
			jPanel_adminInfos.add(jLabel_adminNbVilles, gridBagConstraints20);
			jPanel_adminInfos.add(jLabel_adminInfos2, gridBagConstraints19);
			jPanel_adminInfos.add(jLabel_adminInfos3, gridBagConstraints5);
			jPanel_adminInfos.add(jLabel_adminNbRoutes, gridBagConstraints4);
			jPanel_adminInfos.add(jLabel_adminInfos4, gridBagConstraints7);
			jPanel_adminInfos.add(jLabel_empty2, gridBagConstraints8);
			jPanel_adminInfos.add(jLabel_empty3, gridBagConstraints21);
			jPanel_adminInfos.add(jLabel_empty5, gridBagConstraints22);
		}
		return jPanel_adminInfos;
	}

	/**
	 * This method initializes jPanel_adminVilles	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminVilles() {
		if (jPanel_adminVilles == null) {
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 0;
			gridBagConstraints28.gridy = 1;
			jLabel_empty7 = new JLabel();
			jLabel_empty7.setText("                                  ");
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 3;
			gridBagConstraints27.gridy = 1;
			jLabel_empty6 = new JLabel();
			jLabel_empty6.setText("                                  ");
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 2;
			gridBagConstraints26.gridy = 2;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 2;
			gridBagConstraints25.gridy = 1;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints24.gridy = 2;
			gridBagConstraints24.weightx = 1.0;
			gridBagConstraints24.gridheight = 2;
			gridBagConstraints24.gridx = 1;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 1;
			gridBagConstraints23.gridy = 0;
			jPanel_adminVilles = new JPanel();
			jPanel_adminVilles.setLayout(new GridBagLayout());
			jPanel_adminVilles.add(getJButton_adminAddVille(), gridBagConstraints23);
			jPanel_adminVilles.add(getJComboBox_adminVilles(), gridBagConstraints24);
			jPanel_adminVilles.add(getJButton_adminModifVille(), gridBagConstraints25);
			jPanel_adminVilles.add(getJButton_adminIndispoVille(), gridBagConstraints26);
			jPanel_adminVilles.add(jLabel_empty6, gridBagConstraints27);
			jPanel_adminVilles.add(jLabel_empty7, gridBagConstraints28);
		}
		return jPanel_adminVilles;
	}

	/**
	 * This method initializes jPanel_adminTabInfosIndispo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminTabInfosIndispo() {
		if (jPanel_adminTabInfosIndispo == null) {
			GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
			gridBagConstraints42.fill = GridBagConstraints.BOTH;
			gridBagConstraints42.gridy = 2;
			gridBagConstraints42.weightx = 1.0;
			gridBagConstraints42.weighty = 1.0;
			gridBagConstraints42.gridx = 2;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 1;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.weighty = 1.0;
			gridBagConstraints16.gridx = 2;
			GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
			gridBagConstraints43.fill = GridBagConstraints.BOTH;
			gridBagConstraints43.gridy = 0;
			gridBagConstraints43.weightx = 1.0;
			gridBagConstraints43.weighty = 1.0;
			gridBagConstraints43.gridx = 2;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 0;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.weighty = 1.0;
			gridBagConstraints14.gridx = 2;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.weighty = 1.0;
			gridBagConstraints10.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = -1;
			gridBagConstraints1.gridy = -1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = -1;
			gridBagConstraints2.gridy = -1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = -1;
			gridBagConstraints3.gridy = -1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = -1;
			gridBagConstraints6.gridy = -1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridwidth = 1;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridwidth = 1;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridwidth = 1;
			gridBagConstraints15.gridy = 2;
			gridBagConstraints15.gridx = 1;
			jPanel_adminTabInfosIndispo = new JPanel();
			jPanel_adminTabInfosIndispo.setLayout(new GridBagLayout());
			jPanel_adminTabInfosIndispo.add(jLabel_adminTronconsIndispo, gridBagConstraints15);
			jPanel_adminTabInfosIndispo.add(jLabel_adminRoutesIndispo, gridBagConstraints12);
			jPanel_adminTabInfosIndispo.add(jLabel_adminVillesIndispo, gridBagConstraints9);
			jPanel_adminTabInfosIndispo.add(getJScrollPane_adminVillesIndispo(), gridBagConstraints43);
			jPanel_adminTabInfosIndispo.add(getJScrollPane_adminRoutesIndispo(), gridBagConstraints16);
			jPanel_adminTabInfosIndispo.add(getJScrollPane_adminTronconsIndispo(), gridBagConstraints42);
		}
		return jPanel_adminTabInfosIndispo;
	}

	/**
	 * This method initializes jButton_adminAddVille	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminAddVille() {
		if (jButton_adminAddVille == null) {
			jButton_adminAddVille = new JButton();
			jButton_adminAddVille.setText("Ajouter une ville");
			jButton_adminAddVille.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nouvelleVille();
				}
			});
			
		}
		return jButton_adminAddVille;
	}
	
	public JButton getAddVille() {
		return jButton_adminAddVille;
	}

	/**
	 * This method initializes jComboBox_adminVilles	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminVilles() {
		if (jComboBox_adminVilles == null) {
			Vector<String> villes = new Vector<String>();
			villes.add("Orsay");
			jComboBox_adminVilles = new JComboBox(villes);
			jComboBox_adminVilles.setPreferredSize(new Dimension(200,10));
		}
		return jComboBox_adminVilles;
	}

	/**
	 * This method initializes jButton_adminModifVille	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminModifVille() {
		if (jButton_adminModifVille == null) {
			jButton_adminModifVille = new JButton();
			jButton_adminModifVille.setText("Modifier cette ville");
			jButton_adminModifVille.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificationVille();
				}
			});
		}
		return jButton_adminModifVille;
	}

	/**
	 * This method initializes jButton_adminIndispoVille	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminIndispoVille() {
		if (jButton_adminIndispoVille == null) {
			jButton_adminIndispoVille = new JButton();
			jButton_adminIndispoVille.setText("Rendre cette ville indisponible");
			jButton_adminIndispoVille
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre la ville " + jComboBox_adminVilles.getSelectedItem() + " indisponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
							if (rep == JOptionPane.YES_OPTION) {
								
							}
						}
					});
		}
		return jButton_adminIndispoVille;
	}

	/**
	 * This method initializes jPanel_adminRoutes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminRoutes() {
		if (jPanel_adminRoutes == null) {
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.gridx = 0;
			gridBagConstraints34.gridy = 1;
			jLabel_empty9 = new JLabel();
			jLabel_empty9.setText("                                  ");
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.gridx = 3;
			gridBagConstraints33.gridy = 1;
			jLabel_empty8 = new JLabel();
			jLabel_empty8.setText("                                  ");
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 2;
			gridBagConstraints32.gridy = 2;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 2;
			gridBagConstraints31.gridy = 1;
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints30.gridx = 1;
			gridBagConstraints30.gridy = 2;
			gridBagConstraints30.weightx = 1.0;
			gridBagConstraints30.gridheight = 2;
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 1;
			gridBagConstraints29.gridy = 0;
			jPanel_adminRoutes = new JPanel();
			jPanel_adminRoutes.setLayout(new GridBagLayout());
			jPanel_adminRoutes.add(getJButton_adminAddRoute(), gridBagConstraints29);
			jPanel_adminRoutes.add(getJComboBox_adminRoutes(), gridBagConstraints30);
			jPanel_adminRoutes.add(getJButton_adminModifRoute(), gridBagConstraints31);
			jPanel_adminRoutes.add(getJButton_adminIndispoRoute(), gridBagConstraints32);
			jPanel_adminRoutes.add(jLabel_empty8, gridBagConstraints33);
			jPanel_adminRoutes.add(jLabel_empty9, gridBagConstraints34);
		}
		return jPanel_adminRoutes;
	}

	/**
	 * This method initializes jButton_adminAddRoute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminAddRoute() {
		if (jButton_adminAddRoute == null) {
			jButton_adminAddRoute = new JButton();
			jButton_adminAddRoute.setText("Ajouter une route");
		}
		return jButton_adminAddRoute;
	}

	/**
	 * This method initializes jComboBox_adminRoutes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminRoutes() {
		if (jComboBox_adminRoutes == null) {
			Vector<String> routes = new Vector<String>();
			routes.add("A6");
			routes.add("N118");
			jComboBox_adminRoutes = new JComboBox(routes);
			jComboBox_adminRoutes.setPreferredSize(new Dimension(200, 10));
		}
		return jComboBox_adminRoutes;
	}

	/**
	 * This method initializes jButton_adminModifRoute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminModifRoute() {
		if (jButton_adminModifRoute == null) {
			jButton_adminModifRoute = new JButton();
			jButton_adminModifRoute.setText("Modifier cette route");
		}
		return jButton_adminModifRoute;
	}

	/**
	 * This method initializes jButton_adminIndispoRoute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminIndispoRoute() {
		if (jButton_adminIndispoRoute == null) {
			jButton_adminIndispoRoute = new JButton();
			jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
		}
		return jButton_adminIndispoRoute;
	}

	/**
	 * This method initializes jPanel_adminTroncons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminTroncons() {
		if (jPanel_adminTroncons == null) {
			GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
			gridBagConstraints45.gridx = 1;
			gridBagConstraints45.gridy = 2;
			jLabel_empty12 = new JLabel();
			jLabel_empty12.setText("                  ");
			jLabel_empty12.setPreferredSize(new Dimension(100,30));
			GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
			gridBagConstraints44.gridx = 1;
			gridBagConstraints44.gridy = 0;
			jLabel_adminTronconsRoutes = new JLabel();
			jLabel_adminTronconsRoutes.setText("Choisir une route :");
			GridBagConstraints gridBagConstraints39 = new GridBagConstraints();
			gridBagConstraints39.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints39.gridy = 1;
			gridBagConstraints39.weightx = 1.0;
			gridBagConstraints39.gridx = 1;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.gridy = 4;
			jLabel_empty11 = new JLabel();
			jLabel_empty11.setText("                                  ");
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.gridx = 3;
			gridBagConstraints40.gridy = 4;
			jLabel_empty10 = new JLabel();
			jLabel_empty10.setText("                                  ");
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 2;
			gridBagConstraints38.gridy = 5;
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 2;
			gridBagConstraints37.gridy = 4;
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints36.gridx = 1;
			gridBagConstraints36.gridy = 5;
			gridBagConstraints36.weightx = 1.0;
			gridBagConstraints36.gridheight = 2;
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.gridx = 2;
			gridBagConstraints35.gridy = 1;
			jPanel_adminTroncons = new JPanel();
			jPanel_adminTroncons.setLayout(new GridBagLayout());
			jPanel_adminTroncons.add(getJButton_adminAddTroncon(), gridBagConstraints35);
			jPanel_adminTroncons.add(getJComboBox_adminTroncons(), gridBagConstraints36);
			jPanel_adminTroncons.add(getJButton_adminModifTroncon(), gridBagConstraints37);
			jPanel_adminTroncons.add(getJButton_adminIndispoTroncon(), gridBagConstraints38);
			jPanel_adminTroncons.add(jLabel_empty10, gridBagConstraints40);
			jPanel_adminTroncons.add(jLabel_empty11, gridBagConstraints41);
			jPanel_adminTroncons.add(getJComboBox_adminRoutesTroncons(), gridBagConstraints39);
			jPanel_adminTroncons.add(jLabel_adminTronconsRoutes, gridBagConstraints44);
			jPanel_adminTroncons.add(jLabel_empty12, gridBagConstraints45);
		}
		return jPanel_adminTroncons;
	}

	/**
	 * This method initializes jButton_adminAddTroncon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminAddTroncon() {
		if (jButton_adminAddTroncon == null) {
			jButton_adminAddTroncon = new JButton();
			jButton_adminAddTroncon.setText("Ajouter un troncon");
		}
		return jButton_adminAddTroncon;
	}

	/**
	 * This method initializes jComboBox_adminTroncons	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminTroncons() {
		if (jComboBox_adminTroncons == null) {
			Vector<String> troncons = new Vector<String>();
			troncons.add("N118 - Orsay <-> Les Ulis");
			jComboBox_adminTroncons = new JComboBox(troncons);
			jComboBox_adminTroncons.setPreferredSize(new Dimension(200, 18));
		}
		return jComboBox_adminTroncons;
	}

	/**
	 * This method initializes jButton_adminModifTroncon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminModifTroncon() {
		if (jButton_adminModifTroncon == null) {
			jButton_adminModifTroncon = new JButton();
			jButton_adminModifTroncon.setText("Modifier ce tronçon");
		}
		return jButton_adminModifTroncon;
	}

	/**
	 * This method initializes jButton_adminIndispoTroncon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminIndispoTroncon() {
		if (jButton_adminIndispoTroncon == null) {
			jButton_adminIndispoTroncon = new JButton();
			jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
		}
		return jButton_adminIndispoTroncon;
	}

	/**
	 * This method initializes jComboBox_adminRoutesTroncons	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminRoutesTroncons() {
		if (jComboBox_adminRoutesTroncons == null) {
			Vector<String> routes = new Vector<String>();
			routes.add("N118");
			routes.add("A6");
			jComboBox_adminRoutesTroncons = new JComboBox(routes);
			jComboBox_adminRoutesTroncons.setPreferredSize(new Dimension(200, 20));
		}
		return jComboBox_adminRoutesTroncons;
	}

	/**
	 * This method initializes jScrollPane_adminVillesIndispo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_adminVillesIndispo() {
		if (jScrollPane_adminVillesIndispo == null) {
			jScrollPane_adminVillesIndispo = new JScrollPane();
			jScrollPane_adminVillesIndispo.setPreferredSize(new Dimension(200, 120));
			jScrollPane_adminVillesIndispo.setViewportView(getJList_adminVillesIndispo());
		}
		return jScrollPane_adminVillesIndispo;
	}

	/**
	 * This method initializes jList_adminVillesIndispo	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_adminVillesIndispo() {
		if (jList_adminVillesIndispo == null) {
			Vector<String> villesIndispo = new Vector<String>();
			villesIndispo.add("Antony");
			villesIndispo.add("Metz");
			villesIndispo.add("Palaiseau");
			villesIndispo.add("Valence");
			jList_adminVillesIndispo = new JList(villesIndispo);
			jList_adminVillesIndispo.setForeground(Color.RED);
		}
		return jList_adminVillesIndispo;
	}

	/**
	 * This method initializes jScrollPane_adminRoutesIndispo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_adminRoutesIndispo() {
		if (jScrollPane_adminRoutesIndispo == null) {
			jScrollPane_adminRoutesIndispo = new JScrollPane();
			jScrollPane_adminRoutesIndispo.setPreferredSize(new Dimension(200, 120));
			jScrollPane_adminRoutesIndispo.setViewportView(getJList_adminRoutesIndispo());
		}
		return jScrollPane_adminRoutesIndispo;
	}

	/**
	 * This method initializes routesIndispo	
	 * 	
	 * @return java.util.Vector	
	 */
	private Vector getRoutesIndispo() {
		if (routesIndispo == null) {
			routesIndispo = new Vector();
			routesIndispo.add("Aucune");
		}
		return routesIndispo;
	}

	/**
	 * This method initializes jList_adminRoutesIndispo	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_adminRoutesIndispo() {
		if (jList_adminRoutesIndispo == null) {
			jList_adminRoutesIndispo = new JList(getRoutesIndispo());
			jList_adminRoutesIndispo.setForeground(Color.RED);
		}
		return jList_adminRoutesIndispo;
	}

	/**
	 * This method initializes jScrollPane_adminTronconsIndispo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_adminTronconsIndispo() {
		if (jScrollPane_adminTronconsIndispo == null) {
			jScrollPane_adminTronconsIndispo = new JScrollPane();
			jScrollPane_adminTronconsIndispo.setPreferredSize(new Dimension(200, 120));
			jScrollPane_adminTronconsIndispo.setViewportView(getJList_adminTronconsIndispo());
		}
		return jScrollPane_adminTronconsIndispo;
	}

	/**
	 * This method initializes tronconsIndispo	
	 * 	
	 * @return java.util.Vector	
	 */
	private Vector getTronconsIndispo() {
		if (tronconsIndispo == null) {
			tronconsIndispo = new Vector();
			tronconsIndispo.add("Aucun");
		}
		return tronconsIndispo;
	}

	/**
	 * This method initializes jList_adminTronconsIndispo	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_adminTronconsIndispo() {
		if (jList_adminTronconsIndispo == null) {
			jList_adminTronconsIndispo = new JList(getTronconsIndispo());
			jList_adminTronconsIndispo.setForeground(Color.RED);
		}
		return jList_adminTronconsIndispo;
	}


}
