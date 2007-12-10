package progps_ihm;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class FenetreAPropos extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton_ok = null;

	private JLabel jLabel_title = null;

	private JTextPane jTextPane_apropos = null;

	private JLabel jLabel_logo = null;

	private JPanel jPanel_ok = null;

	/**
	 * @param owner
	 */
	public FenetreAPropos(Frame owner) {
		super(owner);
		initialize();
		setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(480, 220);
		this.setTitle("A propos de ProGPS...");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_logo = new JLabel();
			jLabel_logo.setIcon(new ImageIcon("C://progps_images//logo.jpg"));
			jLabel_logo.setPreferredSize(new Dimension(135,135));
			
			jLabel_title = new JLabel();
			jLabel_title.setText("ProGPS v1.0");
			jLabel_title.setHorizontalAlignment(JLabel.CENTER);
			jLabel_title.setBackground(Color.WHITE);
			
			jContentPane = new JPanel();
			BorderLayout bl = new BorderLayout();
			bl.setHgap(4);
			bl.setVgap(2);
			jContentPane.setLayout(bl);
			jContentPane.add(jLabel_title, BorderLayout.NORTH);
			jContentPane.add(getJTextPane_apropos(), BorderLayout.CENTER);
			jContentPane.setBackground(Color.WHITE);
			jContentPane.add(jLabel_logo, BorderLayout.WEST);
			jContentPane.add(getJPanel_ok(), BorderLayout.SOUTH);
		}
		return jContentPane;
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
					dispose();
				}
			});
		}
		return jButton_ok;
	}

	/**
	 * This method initializes jTextPane_apropos	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_apropos() {
		if (jTextPane_apropos == null) {
			jTextPane_apropos = new JTextPane();
			jTextPane_apropos.setAlignmentY(JTextPane.RIGHT_ALIGNMENT);
			jTextPane_apropos.setText("ProGPS est un système de calcul d'itinéraires.\n" +
					"Ce programme a été codé par :\n" +
					"BERTHOMME Olivier\n" +
					"DUBOIS Mickaël\n" +
					"LERICHE Clément\n" +
					"VAN DROMME Julien\n" +
					"...dans le cadre du projet de génie logiciel de la troisième année du cycle ingénieur de l'IFIPS, 2007-2008.");
			jTextPane_apropos.setEditable(false);
		}
		return jTextPane_apropos;
	}

	/**
	 * This method initializes jPanel_ok	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_ok() {
		if (jPanel_ok == null) {
			jPanel_ok = new JPanel();
			jPanel_ok.setBackground(Color.WHITE);
			jPanel_ok.setLayout(new GridBagLayout());
			jPanel_ok.add(getJButton_ok(), new GridBagConstraints());
		}
		return jPanel_ok;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
