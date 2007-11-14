package progps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTable;

public class FenetrePreferences extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	/**
	 * This is the default constructor
	 */
	public FenetrePreferences() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(448, 320);
		this.setContentPane(getJContentPane());
		this.setTitle("Preferences");
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
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
