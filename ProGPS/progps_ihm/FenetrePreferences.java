package progps_ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.plaf.SliderUI;

import noyau.Preference;
import noyau.SingletonProgps;

public class FenetrePreferences extends JFrame {

	private static final long serialVersionUID = 1L;

	private SingletonProgps progps = null;
	
	private static final int VILLES_EVITER = 0;
	private static final int VILLES_ETAPES = 1;
	private static final int RADARS = 2;
	private static final int PAYANT = 3;
	private static final int VITESSE = 4;
	private static final int TOURISTIQUE = 5;
	
	private Vector<Integer> valuesInit = new Vector<Integer>();  //  @jve:decl-index=0:
	
	private JPanel jContentPane = null;

	private JPanel jPanel_preferences = null;

	private JLabel jLabel_opt1 = null;

	private JSlider jSlider_opt1 = null;

	private JPanel jPanel_south = null;

	private JButton jButton_ok = null;

	private JButton jButton_cancel = null;

	private JTextPane jTextPane_opt0 = null;

	private JLabel jLabel_opt2 = null;

	private JSlider jSlider_opt2 = null;

	private JLabel jLabel_opt3 = null;

	private JSlider jSlider_opt3 = null;

	private JLabel jLabel_opt4 = null;

	private JSlider jSlider_opt4 = null;

	private JLabel jLabel_opt5 = null;

	private JSlider jSlider_opt5 = null;

	private JLabel jLabel_opt6 = null;

	private JSlider jSlider_opt6 = null;

	private JCheckBox jCheckBox_opt1 = null;

	private JCheckBox jCheckBox_opt2 = null;

	private JCheckBox jCheckBox_opt3 = null;

	private JCheckBox jCheckBox_opt4 = null;

	private JCheckBox jCheckBox_opt5 = null;

	private JCheckBox jCheckBox_opt6 = null;
	
	private Vector<JSlider> lesSliders = new Vector<JSlider>();  //  @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public FenetrePreferences(SingletonProgps sys) {
		super();
		progps = sys;
		initialize();
		refreshInitValues();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 410);
		this.setContentPane(getJContentPane());
		this.setTitle("Préférences");
		this.setIconImage(this.getToolkit().getImage("C://progps_images//gps_small.png"));
		this.setResizable(false);
	}
	
	public void refreshInitValues() {
		valuesInit.removeAllElements();
		for (int i=0; i < lesSliders.size(); i++) {
			if (!lesSliders.get(i).isEnabled()) {
				valuesInit.add(0);
			}
			else valuesInit.add(new Integer(lesSliders.get(i).getValue()));
		}
	}
	
	public void setInitValues() {
		for (int i=0; i < valuesInit.size(); i++) {
			if (valuesInit.get(i).intValue() == 0) {
				lesSliders.get(i).setEnabled(false);
				lesSliders.get(i).setValue(0);
			}
			else {
				lesSliders.get(i).setEnabled(true);
				lesSliders.get(i).setValue(valuesInit.get(i).intValue());
			}
		}
	}
	
	private void commitSliderValue(JSlider slider) {
		for (int i=0; i<lesSliders.size(); i++) {
			if (slider != lesSliders.get(i)) {
				if (lesSliders.get(i).isEnabled()) {
					if (slider.getValue() == lesSliders.get(i).getValue()) {
						lesSliders.get(i).setValue(0);
					}
				}
			}
		}
	}
	
	private boolean checkSliderValues() {
		for (int i=0; i<lesSliders.size(); i++) {
			if (lesSliders.get(i).getValue() == 0) {
				if (lesSliders.get(i).isEnabled()) {
					JOptionPane.showMessageDialog(null, "Une priorité ne peut pas être égale à 0 !", "Erreur", JOptionPane.ERROR_MESSAGE);
					lesSliders.get(i).requestFocus();
					return false;
				}
			}
		}
		return true;
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
			jContentPane.add(getJPanel_preferences(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_south(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_preferences	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_preferences() {
		if (jPanel_preferences == null) {
			/*GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;*/
			jLabel_opt6 = new JLabel();
			jLabel_opt6.setPreferredSize(new Dimension(150, 30));
			jLabel_opt6.setText("Itinéraire touristique : ");
			jLabel_opt6.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_opt5 = new JLabel();
			jLabel_opt5.setPreferredSize(new Dimension(150, 30));
			jLabel_opt5.setText("Limites de vitesses : ");
			jLabel_opt5.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_opt4 = new JLabel();
			jLabel_opt4.setPreferredSize(new Dimension(150, 30));
			jLabel_opt4.setText("Routes payantes : ");
			jLabel_opt4.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_opt3 = new JLabel();
			jLabel_opt3.setPreferredSize(new Dimension(150, 30));
			jLabel_opt3.setText("Radars : ");
			jLabel_opt3.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_opt2 = new JLabel();
			jLabel_opt2.setPreferredSize(new Dimension(150, 30));
			jLabel_opt2.setText("Villes étapes : ");
			jLabel_opt2.setHorizontalAlignment(JLabel.RIGHT);
			jTextPane_opt0 = new JTextPane();
			jTextPane_opt0.setEditable(false);
			jTextPane_opt0.setPreferredSize(new Dimension(350,40));
			jTextPane_opt0.setText("Vous pouvez choisir pour chaque préférence le taux de priorité que vous lui accordez (chaque priorité doit être unique):");
			jLabel_opt1 = new JLabel();
			jLabel_opt1.setText("Villes à éviter : ");
			jLabel_opt1.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_opt1.setPreferredSize(new Dimension(150,30));
			jPanel_preferences = new JPanel();
			jPanel_preferences.setLayout(new FlowLayout());
			jPanel_preferences.add(jTextPane_opt0, null);
			jPanel_preferences.add(jLabel_opt1, null);
			jPanel_preferences.add(getJSlider_opt1(), null);
			jPanel_preferences.add(getJCheckBox_opt1(), null);
			jPanel_preferences.add(jLabel_opt2, null);
			jPanel_preferences.add(getJSlider_opt2(), null);
			jPanel_preferences.add(getJCheckBox_opt2(), null);
			jPanel_preferences.add(jLabel_opt3, null);
			jPanel_preferences.add(getJSlider_opt3(), null);
			jPanel_preferences.add(getJCheckBox_opt3(), null);
			jPanel_preferences.add(jLabel_opt4, null);
			jPanel_preferences.add(getJSlider_opt4(), null);
			jPanel_preferences.add(getJCheckBox_opt4(), null);
			jPanel_preferences.add(jLabel_opt5, null);
			jPanel_preferences.add(getJSlider_opt5(), null);
			jPanel_preferences.add(getJCheckBox_opt5(), null);
			jPanel_preferences.add(jLabel_opt6, null);
			jPanel_preferences.add(getJSlider_opt6(), null);
			jPanel_preferences.add(getJCheckBox_opt6(), null);
			jTextPane_opt0.setBackground(jPanel_preferences.getBackground());
		}
		return jPanel_preferences;
	}

	/**
	 * This method initializes jSlider_opt1	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt1() {
		if (jSlider_opt1 == null) {
			jSlider_opt1 = new JSlider();
			jSlider_opt1.setMinimum(0);
			jSlider_opt1.setMaximum(6);
			jSlider_opt1.setMajorTickSpacing(1);
			jSlider_opt1.createStandardLabels(1);
			jSlider_opt1.setSnapToTicks(true);
			jSlider_opt1.setPaintTicks(true);
			jSlider_opt1.setPaintLabels(true);
			jSlider_opt1.setPaintTrack(true);
			jSlider_opt1.setValue(5);
			jSlider_opt1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					commitSliderValue(jSlider_opt1);
				}
			});
			lesSliders.add(jSlider_opt1);
		}
		return jSlider_opt1;
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
					//TODO
					if (checkSliderValues()) {
						Vector<Integer> values = new Vector<Integer> ();
						for (int i=0; i < lesSliders.size(); i++) {
							if (lesSliders.get(i).isEnabled()) {
								values.add(new Integer(lesSliders.get(i).getValue()));
							}
						}
						Collections.sort(values);
						Vector<Preference> pref = new Vector<Preference>();
						for (int i=0; i < values.size(); i++) {
							int j=0;
							while (lesSliders.get(j).getValue() != values.get(i) && j < lesSliders.size()) {
								j++;
							}
							switch (j) {
								case VILLES_EVITER: pref.add(Preference.VillesAEviter); break;
								case VILLES_ETAPES: pref.add(Preference.Villes); break;
								case RADARS: pref.add(Preference.Radars); break;
								case PAYANT: pref.add(Preference.Payant); break;
								case VITESSE: pref.add(Preference.Vitesse); break;
								case TOURISTIQUE: pref.add(Preference.Touristique); break;
								default: break;
							}
							
							j=0;
						}
						
						progps.setPreferences(pref);
						refreshInitValues();
						
						dispose();
					}
				}
			});
		}
		return jButton_ok;
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
					// TODO
					setInitValues();
					dispose();
				}
			});
		}
		return jButton_cancel;
	}

	/**
	 * This method initializes jSlider_opt2	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt2() {
		if (jSlider_opt2 == null) {
			jSlider_opt2 = new JSlider();
			jSlider_opt2.setMajorTickSpacing(1);
			jSlider_opt2.setMinimum(0);
			jSlider_opt2.setMaximum(6);
			jSlider_opt2.setPaintLabels(true);
			jSlider_opt2.setPaintTicks(true);
			jSlider_opt2.setPaintTrack(true);
			jSlider_opt2.setSnapToTicks(true);
			jSlider_opt2.setValue(6);
			jSlider_opt2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					commitSliderValue(jSlider_opt2);
				}
			});
			lesSliders.add(jSlider_opt2);
		}
		return jSlider_opt2;
	}

	/**
	 * This method initializes jSlider_opt3	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt3() {
		if (jSlider_opt3 == null) {
			jSlider_opt3 = new JSlider();
			jSlider_opt3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					commitSliderValue(jSlider_opt3);
				}
			});
			jSlider_opt3.setMajorTickSpacing(1);
			jSlider_opt3.setMinimum(0);
			jSlider_opt3.setMaximum(6);
			jSlider_opt3.setPaintLabels(true);
			jSlider_opt3.setPaintTicks(true);
			jSlider_opt3.setPaintTrack(true);
			jSlider_opt3.setSnapToTicks(true);
			jSlider_opt3.setValue(1);
			lesSliders.add(jSlider_opt3);
		}
		return jSlider_opt3;
	}

	/**
	 * This method initializes jSlider_opt4	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt4() {
		if (jSlider_opt4 == null) {
			jSlider_opt4 = new JSlider();
			jSlider_opt4.setMajorTickSpacing(1);
			jSlider_opt4.setMinimum(0);
			jSlider_opt4.setMaximum(6);
			jSlider_opt4.setPaintLabels(true);
			jSlider_opt4.setPaintTicks(true);
			jSlider_opt4.setPaintTrack(true);
			jSlider_opt4.setSnapToTicks(true);
			jSlider_opt4.setValue(2);
			jSlider_opt4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					commitSliderValue(jSlider_opt4);
				}
			});
			lesSliders.add(jSlider_opt4);
		}
		return jSlider_opt4;
	}

	/**
	 * This method initializes jSlider_opt5	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt5() {
		if (jSlider_opt5 == null) {
			jSlider_opt5 = new JSlider();
			jSlider_opt5.setMajorTickSpacing(1);
			jSlider_opt5.setMinimum(0);
			jSlider_opt5.setMaximum(6);
			jSlider_opt5.setPaintLabels(true);
			jSlider_opt5.setPaintTicks(true);
			jSlider_opt5.setPaintTrack(true);
			jSlider_opt5.setSnapToTicks(true);
			jSlider_opt5.setValue(3);
			jSlider_opt5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					commitSliderValue(jSlider_opt5);
				}
			});
			lesSliders.add(jSlider_opt5);
		}
		return jSlider_opt5;
	}

	/**
	 * This method initializes jSlider_opt6	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_opt6() {
		if (jSlider_opt6 == null) {
			jSlider_opt6 = new JSlider();
			jSlider_opt6.setMajorTickSpacing(1);
			jSlider_opt6.setMinimum(0);
			jSlider_opt6.setMaximum(6);
			jSlider_opt6.setPaintLabels(true);
			jSlider_opt6.setPaintTicks(true);
			jSlider_opt6.setPaintTrack(true);
			jSlider_opt6.setSnapToTicks(true);
			jSlider_opt6.setValue(4);
			jSlider_opt6.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					commitSliderValue(jSlider_opt6);
				}
			});
			lesSliders.add(jSlider_opt6);
		}
		return jSlider_opt6;
	}

	/**
	 * This method initializes jCheckBox_opt1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_opt1() {
		if (jCheckBox_opt1 == null) {
			jCheckBox_opt1 = new JCheckBox();
			if (jSlider_opt1.isEnabled()) {
				jCheckBox_opt1.setSelected(true);
			}
			else jCheckBox_opt1.setSelected(false);
			jCheckBox_opt1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jSlider_opt1.isEnabled()) {
						jSlider_opt1.setEnabled(false);
					}
					else {
						jSlider_opt1.setEnabled(true);
						jSlider_opt1.setValue(0);
					}
				}
			});
		}
		return jCheckBox_opt1;
	}

	/**
	 * This method initializes jCheckBox_opt2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_opt2() {
		if (jCheckBox_opt2 == null) {
			jCheckBox_opt2 = new JCheckBox();
		}
		if (jSlider_opt2.isEnabled()) {
			jCheckBox_opt2.setSelected(true);
		}
		else jCheckBox_opt2.setSelected(false);
		jCheckBox_opt2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jSlider_opt2.isEnabled()) {
					jSlider_opt2.setEnabled(false);
				}
				else {
					jSlider_opt2.setEnabled(true);
					jSlider_opt2.setValue(0);
				}
			}
		});
		return jCheckBox_opt2;
	}

	/**
	 * This method initializes jCheckBox_opt3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_opt3() {
		if (jCheckBox_opt3 == null) {
			jCheckBox_opt3 = new JCheckBox();
		}
		if (jSlider_opt3.isEnabled()) {
			jCheckBox_opt3.setSelected(true);
		}
		else jCheckBox_opt3.setSelected(false);
		jCheckBox_opt3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jSlider_opt3.isEnabled()) {
					jSlider_opt3.setEnabled(false);
				}
				else {
					jSlider_opt3.setEnabled(true);
					jSlider_opt3.setValue(0);
				}
			}
		});
		return jCheckBox_opt3;
	}

	/**
	 * This method initializes jCheckBox_opt4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_opt4() {
		if (jCheckBox_opt4 == null) {
			jCheckBox_opt4 = new JCheckBox();
		}
		if (jSlider_opt4.isEnabled()) {
			jCheckBox_opt4.setSelected(true);
		}
		else jCheckBox_opt4.setSelected(false);
		jCheckBox_opt4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jSlider_opt4.isEnabled()) {
					jSlider_opt4.setEnabled(false);
				}
				else {
					jSlider_opt4.setEnabled(true);
					jSlider_opt4.setValue(0);
				}
			}
		});
		return jCheckBox_opt4;
	}

	/**
	 * This method initializes jCheckBox_opt5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_opt5() {
		if (jCheckBox_opt5 == null) {
			jCheckBox_opt5 = new JCheckBox();
		}
		if (jSlider_opt5.isEnabled()) {
			jCheckBox_opt5.setSelected(true);
		}
		else jCheckBox_opt5.setSelected(false);
		jCheckBox_opt5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jSlider_opt5.isEnabled()) {
					jSlider_opt5.setEnabled(false);
				}
				else {
					jSlider_opt5.setEnabled(true);
					jSlider_opt5.setValue(0);
				}
			}
		});
		return jCheckBox_opt5;
	}

	/**
	 * This method initializes jCheckBox_opt6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_opt6() {
		if (jCheckBox_opt6 == null) {
			jCheckBox_opt6 = new JCheckBox();
		}
		if (jSlider_opt6.isEnabled()) {
			jCheckBox_opt6.setSelected(true);
		}
		else jCheckBox_opt6.setSelected(false);
		jCheckBox_opt6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jSlider_opt6.isEnabled()) {
					jSlider_opt6.setEnabled(false);
				}
				else {
					jSlider_opt6.setEnabled(true);
					jSlider_opt2.setValue(0);
				}
			}
		});
		return jCheckBox_opt6;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
