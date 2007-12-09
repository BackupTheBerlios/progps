package progps_ihm;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JWindow;

public class WaitPanel extends JWindow {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JLabel jLabel_center = null;

	/**
	 * @param owner
	 */
	public WaitPanel(Frame owner) {
		super(owner);
		initialize();
		//setPreferredSize(new Dimension(32,32));
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
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
			jLabel_center = new JLabel();
			jLabel_center.setText("");
			jLabel_center.setHorizontalAlignment(JLabel.CENTER);
			jLabel_center.setIcon(new ImageIcon("C://progps_images//wait.gif"));
			jContentPane.setLayout(new BorderLayout());
			//jContentPane.setOpaque(false);
			jContentPane.setBackground(new Color(255,255,255));
			jContentPane.add(jLabel_center, BorderLayout.CENTER);
		}
		return jContentPane;
	}

}
