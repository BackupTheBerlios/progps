package progps_ihm;

import java.awt.Dimension;

import javax.swing.JLabel;

public class EmptyLabel extends JLabel {
	public EmptyLabel(int w, int h) {
		super();
		setPreferredSize(new Dimension(w,h));
	}
}
