package progps_ihm;

import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class TableDataModel extends DefaultTableModel {

	public TableDataModel() {
		
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	
}
