package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelTouristique extends JLabel {

	public LabelTouristique() {
		super();
		setIcon(new ImageIcon("C://progps_images//eiffel_small.png"));
		setPreferredSize(new Dimension(23,30));
		setToolTipText("Ce tronçon est touristique");
	}
}
