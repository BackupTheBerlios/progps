package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label90 extends JLabel {

	public Label90() {
		super();
		setIcon(new ImageIcon("C://progps_images//panneau90_small.png"));
		setPreferredSize(new Dimension(25,25));
		setToolTipText("Ce tronçon est limité à 90 km/h");
	}
}