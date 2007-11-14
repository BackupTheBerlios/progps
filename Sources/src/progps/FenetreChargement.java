package progps;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Frame;
import javax.swing.JWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import java.awt.color.*;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

public class FenetreChargement extends JWindow {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanel_logo = null;

	private JPanel jPanel_chargement = null;

	private JLabel jLabel_chargement = null;

	private JProgressBar jProgressBar_chargement = null;

	private JLabel jLabel_logo = null;

	/**
	 * @param owner
	 */
	public FenetreChargement(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(135, 177);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)tailleEcran.getWidth()/2,(int)tailleEcran.getHeight()/2);
		this.setContentPane(getJContentPane());
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		this.setAlwaysOnTop(true);
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
			jContentPane.add(getJPanel_logo(), BorderLayout.NORTH);
			jContentPane.add(getJPanel_chargement(), BorderLayout.CENTER);
			jContentPane.setBackground(Color.WHITE);
			jContentPane.setBorder(new LineBorder(Color.BLACK,1,false));
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_logo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_logo() {
		if (jPanel_logo == null) {
			jLabel_logo = new JLabel();
			jLabel_logo.setIcon(new ImageIcon("C:/logo.jpg"));
			
			jPanel_logo = new JPanel();
			jPanel_logo.setLayout(new BorderLayout());
			jPanel_logo.add(jLabel_logo, null);
			jPanel_logo.setSize(new Dimension(135,135));
		}
		return jPanel_logo;
	}

	/**
	 * This method initializes jPanel_chargement	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_chargement() {
		if (jPanel_chargement == null) {
			
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.CENTER);
			flowLayout.setHgap(5);
			flowLayout.setVgap(2);
			jLabel_chargement = new JLabel();
			jLabel_chargement.setFont(new Font("Verdana",Font.ITALIC,11));
			jLabel_chargement.setText("Chargement...");
			
			jPanel_chargement = new JPanel();
			jPanel_chargement.setLayout(flowLayout);
			jPanel_chargement.setSize(new Dimension(135,50));
			jPanel_chargement.setBackground(Color.WHITE);
			jPanel_chargement.add(jLabel_chargement, null);
			jPanel_chargement.add(getJProgressBar_chargement(), null);
		}
		return jPanel_chargement;
	}

	/**
	 * This method initializes jProgressBar_chargement	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar_chargement() {
		if (jProgressBar_chargement == null) {
			jProgressBar_chargement = new JProgressBar();
			jProgressBar_chargement.setPreferredSize(new Dimension(133,21));
			jProgressBar_chargement.setBackground(Color.WHITE);
			jProgressBar_chargement.setForeground(Color.ORANGE);
			jProgressBar_chargement.setStringPainted(true);
			jProgressBar_chargement.setValue(78);
		}
		return jProgressBar_chargement;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
