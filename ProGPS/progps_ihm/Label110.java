package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label110 extends JLabel {

	public Label110() {
		super();
		setIcon(new ImageIcon("C://progps_images//panneau110_small.png"));
		setPreferredSize(new Dimension(25,25));
		setToolTipText("Ce tronçon est limité à 110 km/h");
	}
}