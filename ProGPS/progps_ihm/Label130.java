package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label130 extends JLabel {

	public Label130() {
		super();
		setIcon(new ImageIcon("C://progps_images//panneau130_small.png"));
		setPreferredSize(new Dimension(25,25));
		setToolTipText("Ce tronçon est limité à 130 km/h");
	}
}