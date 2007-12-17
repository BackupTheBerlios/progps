package progps_ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import noyau.Admin;

import java.awt.GridBagConstraints;

public class FenetreAdminPass extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Admin admin = null;

	private JPanel jContentPane = null;

	private JLabel jLabel_north = null;

	private JPanel jPanel_center = null;

	private JLabel jLabel_old = null;

	private JPasswordField jPasswordField_old = null;

	private JLabel jLabel_new = null;

	private JPasswordField jPasswordField_new = null;

	private JLabel jLabel_confirmnew = null;

	private JPasswordField jPasswordField_confirmnew = null;

	private JPanel jPanel_south = null;

	private JButton jButton_cancel = null;

	private JButton jButton_ok = null;

	/**
	 * This is the default constructor
	 */
	public FenetreAdminPass(Admin a) {
		super();
		admin = a;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(275, 270);
		this.setContentPane(getJContentPane());
		this.setTitle("Mot de passe administration");
		this.setIconImage(this.getToolkit().getImage("C://progps_images//gps_small.png"));
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_north = new JLabel();
			jLabel_north.setPreferredSize(new Dimension(150, 40));
			jLabel_north.setText("Changer le mot de passe administrateur");
			jLabel_north.setHorizontalAlignment(JLabel.CENTER);
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(jLabel_north, BorderLayout.NORTH);
			jContentPane.add(getJPanel_center(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_south(), BorderLayout.SOUTH);
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
			jLabel_confirmnew = new JLabel();
			jLabel_confirmnew.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_confirmnew.setText("Confirmez le mot de passe :");
			jLabel_confirmnew.setPreferredSize(new Dimension(200, 20));
			jLabel_new = new JLabel();
			jLabel_new.setFont(new Font("Arial", Font.PLAIN, 12));
			jLabel_new.setText("Nouveau mot de passe :");
			jLabel_new.setPreferredSize(new Dimension(200, 20));
			jLabel_old = new JLabel();
			jLabel_old.setText("Ancien mot de passe :");
			jLabel_old.setPreferredSize(new Dimension(200,20));
			jLabel_old.setFont(new Font("Arial",Font.PLAIN,12));
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new FlowLayout());
			jPanel_center.add(jLabel_old, null);
			jPanel_center.add(getJPasswordField_old(), null);
			jPanel_center.add(jLabel_new, null);
			jPanel_center.add(getJPasswordField_new(), null);
			jPanel_center.add(jLabel_confirmnew, null);
			jPanel_center.add(getJPasswordField_confirmnew(), null);
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jPasswordField_old	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField_old() {
		if (jPasswordField_old == null) {
			jPasswordField_old = new JPasswordField();
			jPasswordField_old.setPreferredSize(new Dimension(200,20));
		}
		return jPasswordField_old;
	}

	/**
	 * This method initializes jPasswordField_new	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField_new() {
		if (jPasswordField_new == null) {
			jPasswordField_new = new JPasswordField();
			jPasswordField_new.setPreferredSize(new Dimension(200, 20));
		}
		return jPasswordField_new;
	}

	/**
	 * This method initializes jPasswordField_confirmnew	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField_confirmnew() {
		if (jPasswordField_confirmnew == null) {
			jPasswordField_confirmnew = new JPasswordField();
			jPasswordField_confirmnew.setPreferredSize(new Dimension(200, 20));
		}
		return jPasswordField_confirmnew;
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
			jPanel_south.add(getJButton_cancel(), new GridBagConstraints());
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
					String newpass = new String(jPasswordField_new.getPassword());
					String confirm = new String(jPasswordField_confirmnew.getPassword());
					if(!newpass.equals(confirm)) {
						JOptionPane.showMessageDialog(new Frame(), "Erreur : le nouveau mot de passe et sa confirmation ne correspondent pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
						jPasswordField_confirmnew.requestFocus();
					}
					else if (!new String(jPasswordField_old.getPassword()).equals(admin.getMdp())) {
						JOptionPane.showMessageDialog(new Frame(), "Erreur : l'ancien mot de passe est incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
						jPasswordField_old.requestFocus();
					}
					else if (!new String(jPasswordField_confirmnew.getPassword()).matches("[a-zA-Z0-9]+")){
						JOptionPane.showMessageDialog(new Frame(), "Erreur : nouveau mot de passe incorrect.\nIl doit comporter seulement des caractères alphanumériques sans espaces.", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else {
						admin.setMdp(new String(jPasswordField_confirmnew.getPassword()));
						JOptionPane.showMessageDialog(new Frame(), "Le mot de passe a bien été changé !", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
			});
		}
		return jButton_ok;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
