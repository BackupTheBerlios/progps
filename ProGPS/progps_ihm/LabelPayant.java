package progps_ihm;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelPayant extends JLabel {

	public LabelPayant() {
		super();
		setIcon(new ImageIcon("images//euros_small.png"));
		setPreferredSize(new Dimension(49,30));
		setToolTipText("Ce tron�on est payant");
	}
}
