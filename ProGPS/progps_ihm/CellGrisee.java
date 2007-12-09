package progps_ihm;

import javax.swing.*;
import javax.swing.table.*;

public class CellGrisee extends DefaultTableCellRenderer {

	private int rowNumber;
	
	public CellGrisee(int r) {
		super();
		rowNumber = r;
		setHorizontalAlignment(JLabel.CENTER);
	}

	public java.awt.Component getTableCellRendererComponent(
			JTable table, Object value,
			boolean isSelected, boolean hasFocus,
			int row, int column) {

		java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if( row < rowNumber ) {
			cell.setBackground(java.awt.Color.LIGHT_GRAY);
		}
		else if (row == rowNumber){
			cell.setBackground(java.awt.Color.ORANGE);
		}
		else {
			cell.setBackground(java.awt.Color.WHITE);
		}
		
		return cell;
	}
}
