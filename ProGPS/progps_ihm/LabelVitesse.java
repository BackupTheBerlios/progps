package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelVitesse extends JLabel {

	public LabelVitesse(int vit) {
		super();
		setIcon(new ImageIcon("C://progps_images//panneau" + vit + "_small.png"));
		setPreferredSize(new Dimension(25,25));
		setToolTipText("Ce tronçon est limité à " + vit + " km/h");
	}
}