package com.ifips.walletOptimiser.fenetrePrincipale;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;

public class ParamsVNS extends JFrame {

	private static final long serialVersionUID = 1L;
	private FenetreIHM parent;
	private JPanel jContentPane = null;
	private JPanel jPanel_center = null;
	private JLabel jLabel_center1 = null;
	private JSlider jSlider_opt1 = null;
	private JLabel jLabel_center2 = null;
	private JSlider jSlider_opt2 = null;
	private JPanel jPanel_south = null;
	private JButton jButton_cancel = null;
	private JButton jButton_ok = null;
	private JLabel jLabel_north = null;

	/**
	 * This is the default constructor
	 */
	public ParamsVNS(FenetreIHM p) {
		super();
		parent = p;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 285);
		this.setContentPane(getJContentPane());
		this.setTitle("Paramètres VNS");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_north = new JLabel();
			jLabel_north.setText("Paramètres de la méthode VNS");
			jLabel_north.setHorizontalAlignment(JLabel.CENTER);
			jLabel_north.setPreferredSize(new Dimension(150,30));
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_center(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_south(), BorderLayout.SOUTH);
			jContentPane.add(jLabel_north, BorderLayout.NORTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_center	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_center() {
		if (jPanel_center == null) {
			jLabel_center2 = new JLabel();
			jLabel_center2.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_center2.setText("Proportion maximale de variation (en %) :");
			EmptyLabel empty1 = new EmptyLabel(this.getWidth(),10);
			EmptyLabel empty2 = new EmptyLabel(this.getWidth(),10);
			jLabel_center1 = new JLabel();
			jLabel_center1.setText("Part des titres qui varie (en %) :");
			jLabel_center1.setFont(new Font("Arial",Font.PLAIN,12));
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new FlowLayout());
			
			jPanel_center.add(empty1);
			jPanel_center.add(jLabel_center1, null);
			jPanel_center.add(getJSlider_opt1(), null);
			jPanel_center.add(empty2);
			jPanel_center.add(jLabel_center2, null);
			jPanel_center.add(getJSlider_opt2(), null);
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jSlider_opt1	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt1() {
		if (jSlider_opt1 == null) {
			jSlider_opt1 = new JSlider();
			jSlider_opt1.setPreferredSize(new Dimension(250,50));
			jSlider_opt1.setMajorTickSpacing(10);
			jSlider_opt1.setMinimum(0);
			jSlider_opt1.setPaintLabels(true);
			jSlider_opt1.setPaintTicks(true);
			jSlider_opt1.setPaintTrack(true);
			jSlider_opt1.setSnapToTicks(false);
			jSlider_opt1.setMaximum(100);
			jSlider_opt1.setToolTipText(jSlider_opt1.getValue() + "%");
			jSlider_opt1.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					jSlider_opt1.setToolTipText(jSlider_opt1.getValue() + "%");
				}
			});
		}
		return jSlider_opt1;
	}

	/**
	 * This method initializes jSlider_opt2	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt2() {
		if (jSlider_opt2 == null) {
			jSlider_opt2 = new JSlider();
			jSlider_opt2.setPreferredSize(new Dimension(250, 50));
			jSlider_opt2.setMajorTickSpacing(10);
			jSlider_opt2.setMaximum(100);
			jSlider_opt2.setMinimum(0);
			jSlider_opt2.setPaintLabels(true);
			jSlider_opt2.setPaintTicks(true);
			jSlider_opt2.setPaintTrack(true);
			jSlider_opt2.setSnapToTicks(false);
			jSlider_opt2.setToolTipText(getJSlider_opt2().getValue() + "%");
			jSlider_opt2.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					jSlider_opt2.setToolTipText(jSlider_opt2.getValue() + "%");
				}
			});
		}
		return jSlider_opt2;
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
			jButton_ok.setText("OK");
			jButton_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// TODO setParams
				}
			});
		}
		return jButton_ok;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
