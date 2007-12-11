package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelRadar extends JLabel {

	public LabelRadar() {
		super();
		setIcon(new ImageIcon("images//radar.jpg"));
		setPreferredSize(new Dimension(29,30));
		setToolTipText("Ce tronçon comporte un ou plusieurs radar(s)");
	}
}