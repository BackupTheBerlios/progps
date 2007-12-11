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
import javax.swing.JWindow;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;


public class AjoutRoute extends JWindow {

	private static final long serialVersionUID = 1L;

	private JButton ownerButton = null;
	
	private JPanel jContentPane = null;

	private JTextField jTextField_north = null;

	private JPanel jPanel_south = null;

	private JButton jButton_cancel = null;

	private JButton jButton_ok = null;

	private JPanel jPanel_center = null;

	private JLabel jLabel_nomRoute = null;

	private JTextField jTextField_nomRoute = null;

	private JLabel jLabel_typeRoute = null;

	private JComboBox jComboBox_typeRoute = null;

	/**
	 * @param owner
	 */
	public AjoutRoute(Frame owner, JButton but) {
		super(owner);
		ownerButton = but;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(270, 130);
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
			jTextField_north.setText("Ajout d'une route dans la base");
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
					//TODO
					
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
			jLabel_typeRoute = new JLabel();
			jLabel_typeRoute.setFont(new Font("Arial",Font.PLAIN,12));
			jLabel_typeRoute.setText("Type de la route : ");
			jLabel_nomRoute = new JLabel();
			jLabel_nomRoute.setText("Nom de la route : ");
			jLabel_nomRoute.setFont(new Font("Arial",Font.PLAIN,12));
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new FlowLayout());
			jPanel_center.add(jLabel_nomRoute, null);
			jPanel_center.add(getJTextField_nomRoute(), null);
			jPanel_center.add(jLabel_typeRoute, null);
			jPanel_center.add(getJComboBox_typeRoute(), null);
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jTextField_nomRoute	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_nomRoute() {
		if (jTextField_nomRoute == null) {
			jTextField_nomRoute = new JTextField();
			jTextField_nomRoute.setPreferredSize(new Dimension(150,18));
		}
		return jTextField_nomRoute;
	}

	/**
	 * This method initializes jComboBox_typeRoute	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_typeRoute() {
		if (jComboBox_typeRoute == null) {
			jComboBox_typeRoute = new JComboBox();
			jComboBox_typeRoute.setBackground(Color.WHITE);
			jComboBox_typeRoute.setPreferredSize(new Dimension(150,20));
			jComboBox_typeRoute.addItem("Départementale");
			jComboBox_typeRoute.addItem("Nationale");
			jComboBox_typeRoute.addItem("Autoroute");
			jComboBox_typeRoute.addItem("Autre");
		}
		return jComboBox_typeRoute;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
