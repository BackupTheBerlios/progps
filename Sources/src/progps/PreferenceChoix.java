package progps;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

public class PreferenceChoix extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButton_Ajout_Choix = null;
	/**
	 * This is the default constructor
	 */
	public PreferenceChoix() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridy = 2;
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
		this.add(getJButton_Ajout_Choix(), gridBagConstraints);
	}

	/**
	 * This method initializes jButton_Ajout_Choix	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Ajout_Choix() {
		if (jButton_Ajout_Choix == null) {
			jButton_Ajout_Choix = new JButton();
			jButton_Ajout_Choix.setText("Ajouter une préférence");
		}
		return jButton_Ajout_Choix;
	}

}
