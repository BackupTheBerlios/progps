package progps_ihm;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class TabInfos extends JPanel implements TableCellRenderer {
	
	private int rowNumber;
	
	public TabInfos(int r) {
		super();
		rowNumber = r;
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);

		//this.setPreferredSize(new Dimension(100,40));
		//setBorder(UIManager.getBorder("TableHeader.cellBorder"));
	}

	public java.awt.Component getTableCellRendererComponent(
			JTable table, Object value,
			boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		removeAll();
		
		String[] result = ((String)value).split("/");
		
		JLabel empty = new JLabel();
		empty.setPreferredSize(new Dimension(200,35));
		
		JPanel cont = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(4);
		layout.setVgap(0);
		cont.setLayout(layout);
		
		for (int i=0; i<result.length; i++) {
			if(result[i].equals("payant")) {
				cont.add(new LabelPayant());
			}
			else if (result[i].equals("radar")) {
				cont.add(new LabelRadar());
			}
			else if (result[i].equals("touristique")) {
				cont.add(new LabelTouristique());
			}
			else if (result[i].equals("50")) {
				cont.add(new LabelVitesse(50));
			}
			else if (result[i].equals("90")) {
				cont.add(new LabelVitesse(90));
			}
			else if (result[i].equals("110")) {
				cont.add(new LabelVitesse(110));
			}
			else if (result[i].equals("130")) {
				cont.add(new LabelVitesse(130));
			}
		}
		
		if (row < rowNumber) {
			cont.setBackground(java.awt.Color.LIGHT_GRAY);
			for (int i=0; i<cont.getComponentCount(); i++) {
				cont.getComponent(i).setEnabled(false);
			}
		}
		else if (row == rowNumber) {
			cont.setBackground(java.awt.Color.ORANGE);
		}
		else {
			cont.setBackground(java.awt.Color.WHITE);
		}
		
		cont.add(empty);
		add(cont);
		return this;
	}
	
	public void paintComponent(java.awt.Graphics g){
		super.paintComponents(g);
	}
}
