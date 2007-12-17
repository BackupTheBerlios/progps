package progps_ihm;

import noyau.*;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class AdminPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private SingletonProgps progps = null;
	private Admin admin = null;
	
	private JTabbedPane jTabbedPane_adminTabs = null;
	private JPanel jPanel_adminInfos = null;
	private JPanel jPanel_adminVilles = null;
	private JLabel jLabel_adminInfos1 = null;
	private JLabel jLabel_adminNbVilles = null;
	private JLabel jLabel_adminInfos2 = null;
	private JLabel jLabel_adminNbRoutes = null;
	private JLabel jLabel_adminInfos3 = null;
	private JLabel jLabel_adminNbTroncons = null;
	private JLabel jLabel_adminInfos4 = null;
	private JLabel jLabel_adminVillesIndispo = null;
	private JLabel jLabel_empty2 = null;
	private JLabel jLabel_adminRoutesIndispo = null;
	private JLabel jLabel_adminTronconsIndispo = null;
	private JPanel jPanel_adminTabInfosIndispo = null;
	private JLabel jLabel_empty3 = null;
	private JLabel jLabel_empty5 = null;
	private JButton jButton_adminAddVille = null;
	private JComboBox jComboBox_adminVilles = null;
	private JButton jButton_adminModifVille = null;
	private JButton jButton_adminIndispoVille = null;
	private JLabel jLabel_empty6 = null;
	private JLabel jLabel_empty7 = null;
	private JPanel jPanel_adminRoutes = null;
	private JButton jButton_adminAddRoute = null;
	private JComboBox jComboBox_adminRoutes = null;
	private JButton jButton_adminModifRoute = null;
	private JButton jButton_adminIndispoRoute = null;
	private JLabel jLabel_empty8 = null;
	private JLabel jLabel_empty9 = null;
	private JPanel jPanel_adminTroncons = null;
	private JButton jButton_adminAddTroncon = null;
	private JComboBox jComboBox_adminTroncons = null;
	private JButton jButton_adminModifTroncon = null;
	private JButton jButton_adminIndispoTroncon = null;
	private JLabel jLabel_empty10 = null;
	private JLabel jLabel_empty11 = null;
	private JComboBox jComboBox_adminRoutesTroncons = null;
	private JScrollPane jScrollPane_adminVillesIndispo = null;
	private JList jList_adminVillesIndispo = null;
	private JLabel jLabel_adminTronconsRoutes = null;
	private JLabel jLabel_empty12 = null;
	private JScrollPane jScrollPane_adminRoutesIndispo = null;
	private JList jList_adminRoutesIndispo = null;
	private Vector<String> routesIndispo = null;  //  @jve:decl-index=0:
	private Vector<String> villesIndispo = null;  //  @jve:decl-index=0:
	private Vector<String> tronconsIndispo = null; //  @jve:decl-index=0:
	private JScrollPane jScrollPane_adminTronconsIndispo = null;
	private JList jList_adminTronconsIndispo = null;
	private JLabel jLabel_empty = null;
	private JLabel jLabel_empty1 = null;
	private JLabel jLabel_empty4 = null;
	private JPanel jPanel_detailsTroncon = null;
	private JScrollPane jScrollPane_detailsTroncon = null;
	private JTextPane jTextPane_detailsTroncon = null;
	private JPanel jPanel_detailsRoute = null;
	private JLabel jLabel_empty13 = null;
	private JScrollPane jScrollPane_detailsRoute = null;
	private JTextPane jTextPane_detailsRoute = null;
	private JPanel jPanel_detailsVille = null;
	private JScrollPane jScrollPane_detailsVille = null;
	private JTextPane jTextPane_detailsVille = null;
	private JLabel jLabel_empty14 = null;
	
	/**
	 * This is the default constructor
	 */
	public AdminPanel(SingletonProgps pro, Admin a) {
		super();
		progps = pro;
		admin = a;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridx = 0;
		this.setSize(770, 480);
		this.setLayout(new GridBagLayout());
		this.add(getJTabbedPane_adminTabs(), gridBagConstraints);
	}
	
	/**
	 * Remplit tous les champs lors de l'instanciation du panel
	 */
	public void remplirChamps() {
		// Liste des villes
		DefaultComboBoxModel modVilles = new DefaultComboBoxModel();
		ArrayList<String> lesVilles = new ArrayList<String>();
		for (int i=0; i < progps.getVilles().size(); i++) {
			lesVilles.add(progps.getVilles().get(i).getNomVille());
		}
		Collections.sort(lesVilles);
		for (int i=0; i < lesVilles.size(); i++) {
			modVilles.addElement(lesVilles.get(i));
		}
		jComboBox_adminVilles.setModel(modVilles);
		
		// Affichage première ville
		Ville tmp = null;
		try {
			tmp = progps.getVille((String)jComboBox_adminVilles.getSelectedItem());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		String inf[] = new String[3];
		int t = tmp.getTypeVille();
		switch(t) {
			case Ville.PETITE: inf[0] = "petite"; break;
			case Ville.MOYENNE: inf[0] = "moyenne"; break;
			case Ville.GRANDE: inf[0] = "grande"; break;
		}
		
		if (tmp.isTouristique()) {
			inf[1] = "oui";
		}
		else inf[1] = "non";
		
		if (tmp.isDispoVille()) {
			inf[2] = "disponible";
			jButton_adminIndispoVille.setText("Rendre cette ville indisponible");
		}
		else {
			inf[2] = "indisponible";
			jButton_adminIndispoVille.setText("Rendre cette ville disponible");
		}
		
		remplirDetailsVille(inf);
		
		// Liste des routes
		DefaultComboBoxModel modRoutes = new DefaultComboBoxModel();
		Vector<String> lesRoutes = new Vector<String>();
		for (int i=0; i < progps.getRoutes().size(); i++) {
			lesRoutes.add(progps.getRoutes().get(i).getNomRoute());
		}
		Collections.sort(lesRoutes);
		for (int i=0; i < lesRoutes.size(); i++) {
			modRoutes.addElement(lesRoutes.get(i));
		}
		jComboBox_adminRoutes.setModel(modRoutes);
		
		// Affichage première route
		Route tmpR = null;
		try {
			tmpR = progps.getRoute((String)jComboBox_adminRoutes.getSelectedItem());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		String inf2[] = new String[3];
		int t2 = tmpR.getTypeRoute();
		switch(t2) {
			case Route.AUTOROUTE: inf2[0] = "autoroute"; break;
			case Route.NATIONALE: inf2[0] = "nationale"; break;
			case Route.DEPARTEMENTALE: inf2[0] = "départementale"; break;
		}
		
		if (tmpR.isDispoRoute()) {
			inf2[1] = "disponible";
			jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
		}
		else {
			inf2[1] = "indisponible";
			jButton_adminIndispoRoute.setText("Rendre cette route disponible");
		}
		
		remplirDetailsRoute(inf2);
		
		// Liste des routes pour les troncons
		DefaultComboBoxModel modRoutes2 = new DefaultComboBoxModel(lesRoutes);
		jComboBox_adminRoutesTroncons.setModel(modRoutes2);
		
		// Affichage premier tronçon
		Route tmpR2 = progps.getRoute((String)jComboBox_adminRoutesTroncons.getSelectedItem());
		DefaultComboBoxModel mod = new DefaultComboBoxModel();
		for (int i=0; i < tmpR2.getSesTroncons().size(); i++) {
			mod.addElement(((Ville)tmpR2.getSesTroncons().get(i).getSesVilles().toArray()[0]).getNomVille() + " <-> " + ((Ville)tmpR2.getSesTroncons().get(i).getSesVilles().toArray()[1]).getNomVille());
		}
		jComboBox_adminTroncons.setModel(mod);
		
		Troncon tr = null;
		String[] result = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
		try {
			tr = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), result[0], result[2]);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		String inf3[] = new String[6];
		
		inf3[0] = "" + tr.getLongueur();
		
		if (tr.isTouristique()) {
			inf3[1] = "oui";
		}
		else inf3[1] = "non";
		
		if (tr.isPayant()) {
			inf3[2] = "oui";
		}
		else inf3[2] = "non";
		
		if (tr.isRadar()) {
			inf3[3] = "oui";
		}
		else inf3[3] = "non";
		
		inf3[4] = "" + tr.getVitesse();
		
		if (tr.isDispo()) {
			inf3[5] = "disponible";
			jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
		}
		else {
			inf3[5] = "indisponible";
			jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
		}
		
		remplirDetailsTroncon(inf3);
	}
	
	private void nouvelleVille() {
		AjoutVille ajV = new AjoutVille((Frame)(this.getTopLevelAncestor()),jButton_adminAddVille,progps);
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		ajV.setLocation(location);
		ajV.setVisible(true);
		jButton_adminAddVille.setEnabled(false);
	}
	
	private void nouvelleRoute() {
		AjoutRoute ajV = new AjoutRoute((Frame)(this.getTopLevelAncestor()),jButton_adminAddRoute,progps);
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		ajV.setLocation(location);
		ajV.setVisible(true);
		jButton_adminAddRoute.setEnabled(false);
	}
	
	private void nouveauTroncon() {
		AjoutTroncon ajT = new AjoutTroncon((Frame)(this.getTopLevelAncestor()),jButton_adminAddTroncon, (String)jComboBox_adminRoutesTroncons.getSelectedItem(), progps);
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		ajT.setLocation(location);
		ajT.setVisible(true);
		jButton_adminAddTroncon.setEnabled(false);
	}
	
	private void modificationVille() {
		ModifVille modV = new ModifVille((Frame)(this.getTopLevelAncestor()), jButton_adminModifVille, progps, (String)jComboBox_adminVilles.getSelectedItem());
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		modV.setLocation(location);
		modV.setVisible(true);
		jButton_adminModifVille.setEnabled(false);
	}
	
	private void modificationRoute() {
		ModifRoute modR = new ModifRoute((Frame)(this.getTopLevelAncestor()), jButton_adminModifRoute, progps, (String)jComboBox_adminRoutes.getSelectedItem());
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		modR.setLocation(location);
		modR.setVisible(true);
		jButton_adminModifRoute.setEnabled(false);
	}
	
	private void modificationTroncon() {
		ModifTroncon modT = new ModifTroncon((Frame)(this.getTopLevelAncestor()), jButton_adminModifTroncon, progps, (String)jComboBox_adminRoutesTroncons.getSelectedItem(), (String)jComboBox_adminTroncons.getSelectedItem());
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation();
		modT.setLocation(location);
		modT.setVisible(true);
		jButton_adminModifTroncon.setEnabled(false);
	}
	
	public void refreshListeVilles() {
		jTextPane_detailsVille.setText("");
		DefaultComboBoxModel modVilles = new DefaultComboBoxModel();
		ArrayList<String> lesVilles = new ArrayList<String>();
		for (int i=0; i < progps.getVilles().size(); i++) {
			lesVilles.add(progps.getVilles().get(i).getNomVille());
		}
		Collections.sort(lesVilles);
		for (int i=0; i < lesVilles.size(); i++) {
			modVilles.addElement(lesVilles.get(i));
		}
		jComboBox_adminVilles.setModel(modVilles);
	}
	
	public void refreshListeRoutes() {
		jTextPane_detailsRoute.setText("");
		DefaultComboBoxModel modRoutes = new DefaultComboBoxModel();
		Vector<String> lesRoutes = new Vector<String>();
		for (int i=0; i < progps.getRoutes().size(); i++) {
			lesRoutes.add(progps.getRoutes().get(i).getNomRoute());
		}
		Collections.sort(lesRoutes);
		for (int i=0; i < lesRoutes.size(); i++) {
			modRoutes.addElement(lesRoutes.get(i));
		}
		jComboBox_adminRoutes.setModel(modRoutes);
		
		// Liste des routes pour les troncons
		DefaultComboBoxModel modRoutes2 = new DefaultComboBoxModel(lesRoutes);
		jComboBox_adminRoutesTroncons.setModel(modRoutes2);
	}
	
	public void refreshListeTroncons() {
		jTextPane_detailsTroncon.setText("");
		Route tmpR = progps.getRoute((String)jComboBox_adminRoutesTroncons.getSelectedItem());
		DefaultComboBoxModel mod = new DefaultComboBoxModel();
		for (int i=0; i < tmpR.getSesTroncons().size(); i++) {
			mod.addElement((String)((Ville)tmpR.getSesTroncons().get(i).getSesVilles().toArray()[0]).getNomVille() + " <-> " + (String)((Ville)tmpR.getSesTroncons().get(i).getSesVilles().toArray()[1]).getNomVille());
		}
		jComboBox_adminTroncons.setModel(mod);
	}

	public void remplirDetailsVille(String[] infos) {
		jTextPane_detailsVille.setText("");
		
		String[] initString =
		{ (String)jComboBox_adminVilles.getSelectedItem() + " :\n\n",
				"Type : " + infos[0] + "\n",
				"Touristique : " + infos[1] + "\n",
				"Cette ville est " + infos[2]
		};
		
		String color;
		if (infos[2].equals("disponible")) {
			color = "green";
		}
		else color = "red";

		String[] initStyles =
		{ "bold",
		  "regular",
		  "regular",
		  color
		};

		StyledDocument doc = jTextPane_detailsVille.getStyledDocument();
		addStylesToDocument(doc);

		try {
			for (int i=0; i < initString.length; i++) {
				doc.insertString(doc.getLength(), initString[i],
						doc.getStyle(initStyles[i]));
			}
		} catch (BadLocationException ble) {
			System.err.println("Impossible d'insérer le texte dans le TextPane.");
		}
	}
	
	public void remplirDetailsRoute(String[] infos) {
		jTextPane_detailsRoute.setText("");
		
		String[] initString =
		{ (String)jComboBox_adminRoutes.getSelectedItem() + " :\n\n",
				"Type : " + infos[0] + "\n",
				"Cette route est " + infos[1]
		};
		
		String color;
		if (infos[1].equals("disponible")) {
			color = "green";
		}
		else color = "red";

		String[] initStyles =
		{ "bold",
		  "regular",
		  color
		};

		StyledDocument doc = jTextPane_detailsRoute.getStyledDocument();
		addStylesToDocument(doc);

		try {
			for (int i=0; i < initString.length; i++) {
				doc.insertString(doc.getLength(), initString[i],
						doc.getStyle(initStyles[i]));
			}
		} catch (BadLocationException ble) {
			System.err.println("Impossible d'insérer le texte dans le TextPane.");
		}
	}
	
	
	public void remplirDetailsTroncon(String[] infos) {
		jTextPane_detailsTroncon.setText("");
		
		String[] initString =
		{ (String)jComboBox_adminTroncons.getSelectedItem() + " :\n\n",
				"Distance : " + infos[0] + "\n",
				"Touristique : " + infos[1] + "\n",
				"Payant : " + infos[2] + "\n",
				"Radars : " + infos[3] + "\n",
				"Limitation de vitesse : " + infos[4] + "\n\n",
				"Ce tronçon est " + infos[5]
		};
		
		String color;
		if (infos[5].equals("disponible")) {
			color = "green";
		}
		else color = "red";

		String[] initStyles =
		{ "bold",
		  "regular",
		  "regular",
		  "regular",
		  "regular",
		  "regular",
		  color
		};

		StyledDocument doc = jTextPane_detailsTroncon.getStyledDocument();
		addStylesToDocument(doc);

		try {
			for (int i=0; i < initString.length; i++) {
				doc.insertString(doc.getLength(), initString[i],
						doc.getStyle(initStyles[i]));
			}
		} catch (BadLocationException ble) {
			System.err.println("Impossible d'insérer le texte dans le TextPane.");
		}
	}
	
	protected void addStylesToDocument(StyledDocument doc) {
		// Initialize some styles.
        Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

        Style regular = doc.addStyle("regular", def);
        StyleConstants.setFontFamily(def, "SansSerif");

        Style s = doc.addStyle("italic", regular);
        StyleConstants.setItalic(s, true);

        s = doc.addStyle("bold", regular);
        StyleConstants.setBold(s, true);

        s = doc.addStyle("red", regular);
        StyleConstants.setForeground(s, Color.RED);
        
        s = doc.addStyle("green", regular);
        StyleConstants.setForeground(s, Color.GREEN);
	}
	
	
	private void verifRoute(String nom) {
		Route r = progps.getRoute(nom);
		DefaultListModel mod = new DefaultListModel();
		int i=0;
		while (i < r.getSesTroncons().size() && !r.getSesTroncons().get(i).isDispo()) {
			i++;
		}
		if (i == r.getSesTroncons().size()) {
			routesIndispo.add(r.getNomRoute());
		}
		else {
			routesIndispo.remove(r.getNomRoute());
		}
		Collections.sort(routesIndispo);
		for (int j=0; j < routesIndispo.size(); j++) {
			mod.addElement(routesIndispo.get(j));
		}
		jList_adminRoutesIndispo.setModel(mod);
		
		if (((String)jComboBox_adminRoutes.getSelectedItem()).equals(nom)) {
			Route tmp = r;
		
			String inf[] = new String[3];
			int t = tmp.getTypeRoute();
			switch(t) {
				case Route.AUTOROUTE: inf[0] = "autoroute"; break;
				case Route.NATIONALE: inf[0] = "nationale"; break;
				case Route.DEPARTEMENTALE: inf[0] = "départementale"; break;
			}
			
			if (tmp.isDispoRoute()) {
				inf[1] = "disponible";
				jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
			}
			else {
				inf[1] = "indisponible";
				jButton_adminIndispoRoute.setText("Rendre cette route disponible");
			}
			
			remplirDetailsRoute(inf);
		}
	}
	
	/**
	 * This method initializes jTabbedPane_adminTabs	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_adminTabs() {
		if (jTabbedPane_adminTabs == null) {
			jTabbedPane_adminTabs = new JTabbedPane();
			jTabbedPane_adminTabs.addTab("Informations", null, getJPanel_adminInfos(), null);
			jTabbedPane_adminTabs.addTab("Villes", null, getJPanel_adminVilles(), null);
			jTabbedPane_adminTabs.addTab("Routes", null, getJPanel_adminRoutes(), null);
			jTabbedPane_adminTabs.addTab("Tronçons", null, getJPanel_adminTroncons(), null);
		}
		return jTabbedPane_adminTabs;
	}

	/**
	 * This method initializes jPanel_adminInfos	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminInfos() {
		if (jPanel_adminInfos == null) {
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 10;
			gridBagConstraints22.gridy = 0;
			jLabel_empty5 = new JLabel();
			jLabel_empty5.setText("                             ");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 0;
			jLabel_empty3 = new JLabel();
			jLabel_empty3.setText("                             ");
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 3;
			gridBagConstraints20.gridy = 0;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 4;
			gridBagConstraints19.gridy = 0;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 8;
			gridBagConstraints17.gridy = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 1;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 9;
			gridBagConstraints7.gridy = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 5;
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 7;
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridwidth = 9;
			gridBagConstraints18.gridheight = 1;
			gridBagConstraints18.gridy = 2;
			jLabel_adminTronconsIndispo = new JLabel();
			jLabel_adminTronconsIndispo.setText("Tronçons indisponibles : ");
			jLabel_adminRoutesIndispo = new JLabel();
			jLabel_adminRoutesIndispo.setText("Routes indisponibles : ");
			jLabel_empty2 = new JLabel();
			jLabel_empty2.setText(" ");
			jLabel_adminVillesIndispo = new JLabel();
			jLabel_adminVillesIndispo.setText("Villes indisponibles : ");
			jLabel_adminInfos4 = new JLabel();
			jLabel_adminInfos4.setText(" tronçons dans la base.");
			jLabel_adminNbTroncons = new JLabel();
			jLabel_adminNbTroncons.setForeground(new Color(0,176,52));
			jLabel_adminNbTroncons.setText(progps.getNbTronconsTotal() + "");
			jLabel_adminNbTroncons.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_adminNbTroncons.setPreferredSize(new Dimension(60,16));
			jLabel_adminInfos3 = new JLabel();
			jLabel_adminInfos3.setText(" routes, et ");
			jLabel_adminNbRoutes = new JLabel();
			jLabel_adminNbRoutes.setForeground(new Color(0,176,52));
			jLabel_adminNbRoutes.setText(progps.getRoutes().size() + " ");
			jLabel_adminNbRoutes.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_adminNbRoutes.setPreferredSize(new Dimension(60,16));
			jLabel_adminInfos2 = new JLabel();
			jLabel_adminInfos2.setText(" villes, ");
			jLabel_adminNbVilles = new JLabel();
			jLabel_adminNbVilles.setText(progps.getVilles().size()+ " ");
			jLabel_adminNbVilles.setForeground(new Color(0,176,52));
			jLabel_adminNbVilles.setPreferredSize(new Dimension(60,16));
			jLabel_adminNbVilles.setHorizontalAlignment(JLabel.RIGHT);
			jLabel_adminInfos1 = new JLabel();
			jLabel_adminInfos1.setText("Il y a actuellement ");
			jPanel_adminInfos = new JPanel();
			jPanel_adminInfos.setLayout(new GridBagLayout());
			jPanel_adminInfos.add(getJPanel_adminTabInfosIndispo(), gridBagConstraints18);
			jPanel_adminInfos.add(jLabel_adminNbTroncons, gridBagConstraints17);
			jPanel_adminInfos.add(jLabel_adminInfos1, gridBagConstraints11);
			jPanel_adminInfos.add(jLabel_adminNbVilles, gridBagConstraints20);
			jPanel_adminInfos.add(jLabel_adminInfos2, gridBagConstraints19);
			jPanel_adminInfos.add(jLabel_adminInfos3, gridBagConstraints5);
			jPanel_adminInfos.add(jLabel_adminNbRoutes, gridBagConstraints4);
			jPanel_adminInfos.add(jLabel_adminInfos4, gridBagConstraints7);
			jPanel_adminInfos.add(jLabel_empty2, gridBagConstraints8);
			jPanel_adminInfos.add(jLabel_empty3, gridBagConstraints21);
			jPanel_adminInfos.add(jLabel_empty5, gridBagConstraints22);
		}
		return jPanel_adminInfos;
	}

	/**
	 * This method initializes jPanel_adminVilles	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminVilles() {
		if (jPanel_adminVilles == null) {
			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			gridBagConstraints52.gridx = 1;
			gridBagConstraints52.gridy = 3;
			jLabel_empty14 = new JLabel();
			jLabel_empty14.setPreferredSize(new Dimension(100, 10));
			jLabel_empty14.setText(" ");
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 1;
			gridBagConstraints51.gridy = 4;
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 0;
			gridBagConstraints28.gridy = 1;
			jLabel_empty7 = new JLabel();
			jLabel_empty7.setText("                                  ");
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 3;
			gridBagConstraints27.gridy = 1;
			jLabel_empty6 = new JLabel();
			jLabel_empty6.setText("                                  ");
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 2;
			gridBagConstraints26.gridy = 2;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 2;
			gridBagConstraints25.gridy = 1;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints24.gridy = 2;
			gridBagConstraints24.weightx = 1.0;
			gridBagConstraints24.gridheight = 1;
			gridBagConstraints24.gridx = 1;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 1;
			gridBagConstraints23.gridy = 0;
			jPanel_adminVilles = new JPanel();
			jPanel_adminVilles.setLayout(new GridBagLayout());
			jPanel_adminVilles.add(getJButton_adminAddVille(), gridBagConstraints23);
			jPanel_adminVilles.add(getJComboBox_adminVilles(), gridBagConstraints24);
			jPanel_adminVilles.add(getJButton_adminModifVille(), gridBagConstraints25);
			jPanel_adminVilles.add(getJButton_adminIndispoVille(), gridBagConstraints26);
			jPanel_adminVilles.add(jLabel_empty6, gridBagConstraints27);
			jPanel_adminVilles.add(jLabel_empty7, gridBagConstraints28);
			jPanel_adminVilles.add(getJPanel_detailsVille(), gridBagConstraints51);
			jPanel_adminVilles.add(jLabel_empty14, gridBagConstraints52);
		}
		return jPanel_adminVilles;
	}

	/**
	 * This method initializes jPanel_adminTabInfosIndispo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminTabInfosIndispo() {
		if (jPanel_adminTabInfosIndispo == null) {
			GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
			gridBagConstraints42.fill = GridBagConstraints.BOTH;
			gridBagConstraints42.gridy = 2;
			gridBagConstraints42.weightx = 1.0;
			gridBagConstraints42.weighty = 1.0;
			gridBagConstraints42.gridx = 2;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 1;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.weighty = 1.0;
			gridBagConstraints16.gridx = 2;
			GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
			gridBagConstraints43.fill = GridBagConstraints.BOTH;
			gridBagConstraints43.gridy = 0;
			gridBagConstraints43.weightx = 1.0;
			gridBagConstraints43.weighty = 1.0;
			gridBagConstraints43.gridx = 2;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 0;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.weighty = 1.0;
			gridBagConstraints14.gridx = 2;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.weighty = 1.0;
			gridBagConstraints10.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = -1;
			gridBagConstraints1.gridy = -1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = -1;
			gridBagConstraints2.gridy = -1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = -1;
			gridBagConstraints3.gridy = -1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = -1;
			gridBagConstraints6.gridy = -1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridwidth = 1;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridwidth = 1;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridwidth = 1;
			gridBagConstraints15.gridy = 2;
			gridBagConstraints15.gridx = 1;
			jPanel_adminTabInfosIndispo = new JPanel();
			jPanel_adminTabInfosIndispo.setLayout(new GridBagLayout());
			jPanel_adminTabInfosIndispo.add(jLabel_adminTronconsIndispo, gridBagConstraints15);
			jPanel_adminTabInfosIndispo.add(jLabel_adminRoutesIndispo, gridBagConstraints12);
			jPanel_adminTabInfosIndispo.add(jLabel_adminVillesIndispo, gridBagConstraints9);
			jPanel_adminTabInfosIndispo.add(getJScrollPane_adminVillesIndispo(), gridBagConstraints43);
			jPanel_adminTabInfosIndispo.add(getJScrollPane_adminRoutesIndispo(), gridBagConstraints16);
			jPanel_adminTabInfosIndispo.add(getJScrollPane_adminTronconsIndispo(), gridBagConstraints42);
		}
		return jPanel_adminTabInfosIndispo;
	}

	/**
	 * This method initializes jButton_adminAddVille	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminAddVille() {
		if (jButton_adminAddVille == null) {
			jButton_adminAddVille = new JButton();
			jButton_adminAddVille.setText("Ajouter une ville");
			jButton_adminAddVille.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nouvelleVille();
				}
			});
			
		}
		return jButton_adminAddVille;
	}
	
	public JButton getAddVille() {
		return jButton_adminAddVille;
	}

	/**
	 * This method initializes jComboBox_adminVilles	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminVilles() {
		if (jComboBox_adminVilles == null) {
			jComboBox_adminVilles = new JComboBox();
			jComboBox_adminVilles.setPreferredSize(new Dimension(200,10));
			jComboBox_adminVilles.setBackground(Color.WHITE);
			jComboBox_adminVilles.setForeground(Color.BLUE);
			jComboBox_adminVilles.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					Ville tmp = null;
					try {
						tmp = progps.getVille((String)jComboBox_adminVilles.getSelectedItem());
					}
					catch (Exception exc) {
						exc.printStackTrace();
					}
					
					String inf[] = new String[3];
					int t = tmp.getTypeVille();
					switch(t) {
						case Ville.PETITE: inf[0] = "petite"; break;
						case Ville.MOYENNE: inf[0] = "moyenne"; break;
						case Ville.GRANDE: inf[0] = "grande"; break;
					}
					
					if (tmp.isTouristique()) {
						inf[1] = "oui";
					}
					else inf[1] = "non";
					
					if (tmp.isDispoVille()) {
						inf[2] = "disponible";
						jButton_adminIndispoVille.setText("Rendre cette ville indisponible");
					}
					else {
						inf[2] = "indisponible";
						jButton_adminIndispoVille.setText("Rendre cette ville disponible");
					}
					
					remplirDetailsVille(inf);
				}
			});
		}
		return jComboBox_adminVilles;
	}

	/**
	 * This method initializes jButton_adminModifVille	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminModifVille() {
		if (jButton_adminModifVille == null) {
			jButton_adminModifVille = new JButton();
			jButton_adminModifVille.setText("Modifier cette ville");
			jButton_adminModifVille.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificationVille();
				}
			});
		}
		return jButton_adminModifVille;
	}

	/**
	 * This method initializes jButton_adminIndispoVille	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminIndispoVille() {
		if (jButton_adminIndispoVille == null) {
			jButton_adminIndispoVille = new JButton();
			jButton_adminIndispoVille.setText("Rendre cette ville indisponible");
			jButton_adminIndispoVille
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (jButton_adminIndispoVille.getText().equals("Rendre cette ville indisponible")) {
								int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre la ville " + jComboBox_adminVilles.getSelectedItem() + " indisponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
								if (rep == JOptionPane.YES_OPTION) {
									Ville tmp = null;
									try {
										tmp = progps.getVille((String)jComboBox_adminVilles.getSelectedItem());
										tmp.setDispoVille(false);
										
										// Vérification si on doit modifier l'itineraire courant
										if (admin.besoinRafraichirIti(tmp)) {
											Itineraire newIti = admin.rafraichirItineraire();
											((FenetrePrincipale)getTopLevelAncestor()).rafraichirItineraire(newIti);
											((FenetrePrincipale)getTopLevelAncestor()).setItineraireModifie(true);
										}
									}
									catch (Exception exc) {
										exc.printStackTrace();
									}
									jButton_adminIndispoVille.setText("Rendre cette ville disponible");
									
									String inf[] = new String[3];
									int t = tmp.getTypeVille();
									switch(t) {
										case Ville.PETITE: inf[0] = "petite"; break;
										case Ville.MOYENNE: inf[0] = "moyenne"; break;
										case Ville.GRANDE: inf[0] = "grande"; break;
									}
									
									if (tmp.isTouristique()) {
										inf[1] = "oui";
									}
									else inf[1] = "non";
									
									if (tmp.isDispoVille()) {
										inf[2] = "disponible";
									}
									else inf[2] = "indisponible";
									
									remplirDetailsVille(inf);
									
									villesIndispo.add(tmp.getNomVille());
									Collections.sort(villesIndispo);
									DefaultListModel mod = new DefaultListModel();
									for (int i=0; i < villesIndispo.size(); i++) {
										mod.addElement(villesIndispo.get(i));
									}
									jList_adminVillesIndispo.setModel(mod);
									
								}
							}
							else {
								int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre la ville " + jComboBox_adminVilles.getSelectedItem() + " disponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
								if (rep == JOptionPane.YES_OPTION) {
									Ville tmp = null;
									try {
										tmp = progps.getVille((String)jComboBox_adminVilles.getSelectedItem());
										tmp.setDispoVille(true);
									}
									catch (Exception exc) {
										exc.printStackTrace();
									}
									jButton_adminIndispoVille.setText("Rendre cette ville indisponible");
									
									String inf[] = new String[3];
									int t = tmp.getTypeVille();
									switch(t) {
										case Ville.PETITE: inf[0] = "petite"; break;
										case Ville.MOYENNE: inf[0] = "moyenne"; break;
										case Ville.GRANDE: inf[0] = "grande"; break;
									}
									
									if (tmp.isTouristique()) {
										inf[1] = "oui";
									}
									else inf[1] = "non";
									
									if (tmp.isDispoVille()) {
										inf[2] = "disponible";
									}
									else inf[2] = "indisponible";
									
									remplirDetailsVille(inf);
									
									villesIndispo.remove(tmp.getNomVille());
									Collections.sort(villesIndispo);
									DefaultListModel mod = new DefaultListModel();
									for (int i=0; i < villesIndispo.size(); i++) {
										mod.addElement(villesIndispo.get(i));
									}
									jList_adminVillesIndispo.setModel(mod);
								}
							}
						}
					});
		}
		return jButton_adminIndispoVille;
	}

	/**
	 * This method initializes jPanel_adminRoutes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminRoutes() {
		if (jPanel_adminRoutes == null) {
			GridBagConstraints gridBagConstraints50 = new GridBagConstraints();
			gridBagConstraints50.gridx = 1;
			gridBagConstraints50.gridy = 4;
			jLabel_empty13 = new JLabel();
			jLabel_empty13.setPreferredSize(new Dimension(100, 10));
			jLabel_empty13.setText(" ");
			GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
			gridBagConstraints49.gridx = 1;
			gridBagConstraints49.gridy = 5;
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.gridx = 0;
			gridBagConstraints34.gridy = 2;
			jLabel_empty9 = new JLabel();
			jLabel_empty9.setText("                                  ");
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.gridx = 3;
			gridBagConstraints33.gridy = 2;
			jLabel_empty8 = new JLabel();
			jLabel_empty8.setText("                                  ");
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 2;
			gridBagConstraints32.gridy = 3;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 2;
			gridBagConstraints31.gridy = 2;
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints30.gridx = 1;
			gridBagConstraints30.gridy = 3;
			gridBagConstraints30.weightx = 1.0;
			gridBagConstraints30.gridheight = 1;
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 1;
			gridBagConstraints29.gridy = 1;
			jPanel_adminRoutes = new JPanel();
			jPanel_adminRoutes.setLayout(new GridBagLayout());
			jPanel_adminRoutes.add(getJButton_adminAddRoute(), gridBagConstraints29);
			jPanel_adminRoutes.add(getJComboBox_adminRoutes(), gridBagConstraints30);
			jPanel_adminRoutes.add(getJButton_adminModifRoute(), gridBagConstraints31);
			jPanel_adminRoutes.add(getJButton_adminIndispoRoute(), gridBagConstraints32);
			jPanel_adminRoutes.add(jLabel_empty8, gridBagConstraints33);
			jPanel_adminRoutes.add(jLabel_empty9, gridBagConstraints34);
			jPanel_adminRoutes.add(getJPanel_detailsRoute(), gridBagConstraints49);
			jPanel_adminRoutes.add(jLabel_empty13, gridBagConstraints50);
		}
		return jPanel_adminRoutes;
	}

	/**
	 * This method initializes jButton_adminAddRoute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminAddRoute() {
		if (jButton_adminAddRoute == null) {
			jButton_adminAddRoute = new JButton();
			jButton_adminAddRoute.setText("Ajouter une route");
			jButton_adminAddRoute.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nouvelleRoute();
				}
			});
		}
		return jButton_adminAddRoute;
	}

	/**
	 * This method initializes jComboBox_adminRoutes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminRoutes() {
		if (jComboBox_adminRoutes == null) {
			jComboBox_adminRoutes = new JComboBox();
			jComboBox_adminRoutes.setPreferredSize(new Dimension(200, 10));
			jComboBox_adminRoutes.setBackground(Color.WHITE);
			jComboBox_adminRoutes.setForeground(Color.BLUE);
			jComboBox_adminRoutes.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					// TODO
					Route tmp = null;
					try {
						tmp = progps.getRoute((String)jComboBox_adminRoutes.getSelectedItem());
					}
					catch (Exception exc) {
						exc.printStackTrace();
					}
					
					String inf[] = new String[3];
					int t = tmp.getTypeRoute();
					switch(t) {
						case Route.AUTOROUTE: inf[0] = "autoroute"; break;
						case Route.NATIONALE: inf[0] = "nationale"; break;
						case Route.DEPARTEMENTALE: inf[0] = "départementale"; break;
					}
					
					if (tmp.isDispoRoute()) {
						inf[1] = "disponible";
						jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
					}
					else {
						inf[1] = "indisponible";
						jButton_adminIndispoRoute.setText("Rendre cette route disponible");
					}
					
					remplirDetailsRoute(inf);
				}
			});
		}
		return jComboBox_adminRoutes;
	}

	/**
	 * This method initializes jButton_adminModifRoute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminModifRoute() {
		if (jButton_adminModifRoute == null) {
			jButton_adminModifRoute = new JButton();
			jButton_adminModifRoute.setText("Modifier cette route");
			jButton_adminModifRoute.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificationRoute();
				}
			});
		}
		return jButton_adminModifRoute;
	}

	/**
	 * This method initializes jButton_adminIndispoRoute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminIndispoRoute() {
		if (jButton_adminIndispoRoute == null) {
			jButton_adminIndispoRoute = new JButton();
			jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
			jButton_adminIndispoRoute
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (jButton_adminIndispoRoute.getText().equals("Rendre cette route indisponible")) {
								int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre la route " + jComboBox_adminRoutes.getSelectedItem() + " indisponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
								if (rep == JOptionPane.YES_OPTION) {
									Route tmp = null;
									try {
										tmp = progps.getRoute((String)jComboBox_adminRoutes.getSelectedItem());
										tmp.setDispoRoute(false);
										
										// Vérification si on doit modifier l'itineraire courant
										if (admin.besoinRafraichirIti(tmp)) {
											Itineraire newIti = admin.rafraichirItineraire();
											((FenetrePrincipale)getTopLevelAncestor()).rafraichirItineraire(newIti);
											((FenetrePrincipale)getTopLevelAncestor()).setItineraireModifie(true);
										}
									}
									catch (Exception exc) {
										exc.printStackTrace();
									}
								
									String inf[] = new String[3];
									int t = tmp.getTypeRoute();
									switch(t) {
										case Route.AUTOROUTE: inf[0] = "autoroute"; break;
										case Route.NATIONALE: inf[0] = "nationale"; break;
										case Route.DEPARTEMENTALE: inf[0] = "départementale"; break;
									}
									
									if (tmp.isDispoRoute()) {
										inf[1] = "disponible";
										jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
									}
									else {
										inf[1] = "indisponible";
										jButton_adminIndispoRoute.setText("Rendre cette route disponible");
									}
									
									remplirDetailsRoute(inf);
									
									routesIndispo.add(tmp.getNomRoute());
									Collections.sort(routesIndispo);
									DefaultListModel mod = new DefaultListModel();
									for (int i=0; i < routesIndispo.size(); i++) {
										mod.addElement(routesIndispo.get(i));
									}
									jList_adminRoutesIndispo.setModel(mod);
									
									for (int i=0; i < tmp.getSesTroncons().size(); i++) {
										tronconsIndispo.add((String)jComboBox_adminRoutes.getSelectedItem() + " : [" + (String)((Ville)tmp.getSesTroncons().get(i).getSesVilles().toArray()[0]).getNomVille() + " <-> " + (String)((Ville)tmp.getSesTroncons().get(i).getSesVilles().toArray()[1]).getNomVille() + "]");
									}
									Collections.sort(tronconsIndispo);
									DefaultListModel mod2 = new DefaultListModel();
									for (int i=0; i < tronconsIndispo.size(); i++) {
										mod2.addElement(tronconsIndispo.get(i));
									}
									jList_adminTronconsIndispo.setModel(mod2);
									
									if (((String)jComboBox_adminRoutesTroncons.getSelectedItem()).equals((String)jComboBox_adminRoutes.getSelectedItem())) {
										Troncon tmp2 = null;
										String[] result = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
										try {
											tmp2 = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), result[0], result[2]);
										}
										catch (Exception exc) {
											exc.printStackTrace();
										}
										
										String inf2[] = new String[6];
										
										inf2[0] = "" + tmp2.getLongueur();
										
										if (tmp2.isTouristique()) {
											inf2[1] = "oui";
										}
										else inf2[1] = "non";
										
										if (tmp2.isPayant()) {
											inf2[2] = "oui";
										}
										else inf2[2] = "non";
										
										if (tmp2.isRadar()) {
											inf2[3] = "oui";
										}
										else inf2[3] = "non";
										
										inf2[4] = "" + tmp2.getVitesse();
										
										if (tmp2.isDispo()) {
											inf2[5] = "disponible";
											jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
										}
										else {
											inf2[5] = "indisponible";
											jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
										}
										
										remplirDetailsTroncon(inf2);
									}
								}
							}
							else {
								int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre la route " + jComboBox_adminRoutes.getSelectedItem() + " disponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
								if (rep == JOptionPane.YES_OPTION) {
									Route tmp = null;
									try {
										tmp = progps.getRoute((String)jComboBox_adminRoutes.getSelectedItem());
										tmp.setDispoRoute(true);
									}
									catch (Exception exc) {
										exc.printStackTrace();
									}
									jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
									
									String inf[] = new String[3];
									int t = tmp.getTypeRoute();
									switch(t) {
										case Route.AUTOROUTE: inf[0] = "autoroute"; break;
										case Route.NATIONALE: inf[0] = "nationale"; break;
										case Route.DEPARTEMENTALE: inf[0] = "départementale"; break;
									}
									
									if (tmp.isDispoRoute()) {
										inf[1] = "disponible";
										jButton_adminIndispoRoute.setText("Rendre cette route indisponible");
									}
									else {
										inf[1] = "indisponible";
										jButton_adminIndispoRoute.setText("Rendre cette route disponible");
									}
									
									remplirDetailsRoute(inf);
									
									routesIndispo.remove(tmp.getNomRoute());
									Collections.sort(routesIndispo);
									DefaultListModel mod = new DefaultListModel();
									for (int i=0; i < routesIndispo.size(); i++) {
										mod.addElement(routesIndispo.get(i));
									}
									jList_adminRoutesIndispo.setModel(mod);
									
									for (int i=0; i < tmp.getSesTroncons().size(); i++) {
										tronconsIndispo.remove((String)jComboBox_adminRoutes.getSelectedItem() + " : [" + (String)((Ville)tmp.getSesTroncons().get(i).getSesVilles().toArray()[0]).getNomVille() + " <-> " + (String)((Ville)tmp.getSesTroncons().get(i).getSesVilles().toArray()[1]).getNomVille() + "]");
									}
									Collections.sort(tronconsIndispo);
									DefaultListModel mod2 = new DefaultListModel();
									for (int i=0; i < tronconsIndispo.size(); i++) {
										mod2.addElement(tronconsIndispo.get(i));
									}
									jList_adminTronconsIndispo.setModel(mod2);
									
									if (((String)jComboBox_adminRoutesTroncons.getSelectedItem()).equals((String)jComboBox_adminRoutes.getSelectedItem())) {
										Troncon tmp2 = null;
										String[] result = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
										try {
											tmp2 = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), result[0], result[2]);
										}
										catch (Exception exc) {
											exc.printStackTrace();
										}
										
										String inf2[] = new String[6];
										
										inf2[0] = "" + tmp2.getLongueur();
										
										if (tmp2.isTouristique()) {
											inf2[1] = "oui";
										}
										else inf2[1] = "non";
										
										if (tmp2.isPayant()) {
											inf2[2] = "oui";
										}
										else inf2[2] = "non";
										
										if (tmp2.isRadar()) {
											inf2[3] = "oui";
										}
										else inf2[3] = "non";
										
										inf2[4] = "" + tmp2.getVitesse();
										
										if (tmp2.isDispo()) {
											inf2[5] = "disponible";
											jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
										}
										else {
											inf2[5] = "indisponible";
											jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
										}
										
										remplirDetailsTroncon(inf2);
									}
								}
							}
						}
					});
		}
		return jButton_adminIndispoRoute;
	}

	/**
	 * This method initializes jPanel_adminTroncons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_adminTroncons() {
		if (jPanel_adminTroncons == null) {
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 2;
			gridBagConstraints13.gridy = 8;
			GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
			gridBagConstraints48.gridx = 2;
			gridBagConstraints48.gridy = 0;
			jLabel_empty4 = new JLabel();
			jLabel_empty4.setPreferredSize(new Dimension(100, 50));
			jLabel_empty4.setText(" ");
			GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
			gridBagConstraints47.gridx = 2;
			gridBagConstraints47.gridy = 7;
			jLabel_empty1 = new JLabel();
			jLabel_empty1.setPreferredSize(new Dimension(100, 10));
			jLabel_empty1.setText(" ");
			GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
			gridBagConstraints46.gridx = 2;
			gridBagConstraints46.gridy = 9;
			jLabel_empty = new JLabel();
			jLabel_empty.setPreferredSize(new Dimension(100,50));
			jLabel_empty.setText(" ");
			GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
			gridBagConstraints45.gridx = 2;
			gridBagConstraints45.gridy = 3;
			jLabel_empty12 = new JLabel();
			jLabel_empty12.setText("                  ");
			jLabel_empty12.setPreferredSize(new Dimension(100,30));
			GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
			gridBagConstraints44.gridx = 2;
			gridBagConstraints44.gridy = 1;
			jLabel_adminTronconsRoutes = new JLabel();
			jLabel_adminTronconsRoutes.setText("Choisir une route :");
			GridBagConstraints gridBagConstraints39 = new GridBagConstraints();
			gridBagConstraints39.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints39.gridy = 2;
			gridBagConstraints39.weightx = 1.0;
			gridBagConstraints39.gridx = 2;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.gridy = 5;
			jLabel_empty11 = new JLabel();
			jLabel_empty11.setText("                                  ");
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.gridx = 4;
			gridBagConstraints40.gridy = 5;
			jLabel_empty10 = new JLabel();
			jLabel_empty10.setText("                                  ");
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 3;
			gridBagConstraints38.gridy = 6;
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 3;
			gridBagConstraints37.gridy = 5;
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints36.gridx = 2;
			gridBagConstraints36.gridy = 6;
			gridBagConstraints36.weightx = 1.0;
			gridBagConstraints36.gridheight = 1;
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.gridx = 3;
			gridBagConstraints35.gridy = 2;
			jPanel_adminTroncons = new JPanel();
			jPanel_adminTroncons.setLayout(new GridBagLayout());
			jPanel_adminTroncons.add(getJButton_adminAddTroncon(), gridBagConstraints35);
			jPanel_adminTroncons.add(getJComboBox_adminTroncons(), gridBagConstraints36);
			jPanel_adminTroncons.add(getJButton_adminModifTroncon(), gridBagConstraints37);
			jPanel_adminTroncons.add(getJButton_adminIndispoTroncon(), gridBagConstraints38);
			jPanel_adminTroncons.add(jLabel_empty10, gridBagConstraints40);
			jPanel_adminTroncons.add(jLabel_empty11, gridBagConstraints41);
			jPanel_adminTroncons.add(getJComboBox_adminRoutesTroncons(), gridBagConstraints39);
			jPanel_adminTroncons.add(jLabel_adminTronconsRoutes, gridBagConstraints44);
			jPanel_adminTroncons.add(jLabel_empty12, gridBagConstraints45);
			jPanel_adminTroncons.add(jLabel_empty, gridBagConstraints46);
			jPanel_adminTroncons.add(jLabel_empty1, gridBagConstraints47);
			jPanel_adminTroncons.add(jLabel_empty4, gridBagConstraints48);
			jPanel_adminTroncons.add(getJPanel_detailsTroncon(), gridBagConstraints13);
		}
		return jPanel_adminTroncons;
	}

	/**
	 * This method initializes jButton_adminAddTroncon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminAddTroncon() {
		if (jButton_adminAddTroncon == null) {
			jButton_adminAddTroncon = new JButton();
			jButton_adminAddTroncon.setText("Ajouter un troncon");
			jButton_adminAddTroncon.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nouveauTroncon();
				}
			});
		}
		return jButton_adminAddTroncon;
	}

	/**
	 * This method initializes jComboBox_adminTroncons	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminTroncons() {
		if (jComboBox_adminTroncons == null) {
			jComboBox_adminTroncons = new JComboBox();
			jComboBox_adminTroncons.setPreferredSize(new Dimension(200, 20));
			jComboBox_adminTroncons.setBackground(Color.WHITE);
			jComboBox_adminTroncons.setForeground(Color.BLUE);
			jComboBox_adminTroncons.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					//TODO
					Troncon tmp = null;
					String[] result = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
					try {
						tmp = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), result[0], result[2]);
					}
					catch (Exception exc) {
						exc.printStackTrace();
					}
					
					String inf[] = new String[6];
					
					inf[0] = "" + tmp.getLongueur();
					
					if (tmp.isTouristique()) {
						inf[1] = "oui";
					}
					else inf[1] = "non";
					
					if (tmp.isPayant()) {
						inf[2] = "oui";
					}
					else inf[2] = "non";
					
					if (tmp.isRadar()) {
						inf[3] = "oui";
					}
					else inf[3] = "non";
					
					inf[4] = "" + tmp.getVitesse();
					
					if (tmp.isDispo()) {
						inf[5] = "disponible";
						jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
					}
					else {
						inf[5] = "indisponible";
						jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
					}
					
					remplirDetailsTroncon(inf);
				}
			});
		}
		return jComboBox_adminTroncons;
	}

	/**
	 * This method initializes jButton_adminModifTroncon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminModifTroncon() {
		if (jButton_adminModifTroncon == null) {
			jButton_adminModifTroncon = new JButton();
			jButton_adminModifTroncon.setText("Modifier ce tronçon");
			jButton_adminModifTroncon
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							modificationTroncon();
						}
					});
		}
		return jButton_adminModifTroncon;
	}

	/**
	 * This method initializes jButton_adminIndispoTroncon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_adminIndispoTroncon() {
		if (jButton_adminIndispoTroncon == null) {
			jButton_adminIndispoTroncon = new JButton();
			jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
			jButton_adminIndispoTroncon
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (jButton_adminIndispoTroncon.getText().equals("Rendre ce tronçon indisponible")) {
								int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre le tronçon [" + (String)jComboBox_adminTroncons.getSelectedItem() + "] de la route " + jComboBox_adminRoutesTroncons.getSelectedItem() + " indisponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
								if (rep == JOptionPane.YES_OPTION) {
									Troncon tmp = null;
									try {
										String res[] = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
										tmp = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), res[0], res[2]);
										tmp.setDispo(false);
										
										// Vérification si on doit modifier l'itineraire courant
										if (admin.besoinRafraichirIti(tmp)) {
											Itineraire newIti = admin.rafraichirItineraire();
											((FenetrePrincipale)getTopLevelAncestor()).rafraichirItineraire(newIti);
											((FenetrePrincipale)getTopLevelAncestor()).setItineraireModifie(true);
										}
									}
									catch (Exception exc) {
										exc.printStackTrace();
									}
								
									String inf[] = new String[6];
									
									inf[0] = "" + tmp.getLongueur();
									
									if (tmp.isTouristique()) {
										inf[1] = "oui";
									}
									else inf[1] = "non";
									
									if (tmp.isPayant()) {
										inf[2] = "oui";
									}
									else inf[2] = "non";
									
									if (tmp.isRadar()) {
										inf[3] = "oui";
									}
									else inf[3] = "non";
									
									inf[4] = "" + tmp.getVitesse();
									
									if (tmp.isDispo()) {
										inf[5] = "disponible";
										jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
									}
									else {
										inf[5] = "indisponible";
										jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
									}
									
									remplirDetailsTroncon(inf);
									
									
									tronconsIndispo.add((String)jComboBox_adminRoutesTroncons.getSelectedItem() + " : [" + (String)jComboBox_adminTroncons.getSelectedItem() + "]");
									Collections.sort(tronconsIndispo);
									DefaultListModel mod = new DefaultListModel();
									for (int i=0; i < tronconsIndispo.size(); i++) {
										mod.addElement(tronconsIndispo.get(i));
									}
									jList_adminTronconsIndispo.setModel(mod);
									
									verifRoute((String)jComboBox_adminRoutesTroncons.getSelectedItem());									
								}
							}
							else {
								int rep = JOptionPane.showConfirmDialog(new Frame(), "Voulez-vous vraiment rendre le tronçon [" + (String)jComboBox_adminTroncons.getSelectedItem() + "] de la route " + jComboBox_adminRoutesTroncons.getSelectedItem() + " disponible ?", "Confirmation", JOptionPane.YES_NO_OPTION);
								if (rep == JOptionPane.YES_OPTION) {
									Troncon tmp = null;
									try {
										String res[] = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
										tmp = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), res[0], res[2]);
										tmp.setDispo(true);
									}
									catch (Exception exc) {
										exc.printStackTrace();
									}
								
									String inf[] = new String[6];
									
									inf[0] = "" + tmp.getLongueur();
									
									if (tmp.isTouristique()) {
										inf[1] = "oui";
									}
									else inf[1] = "non";
									
									if (tmp.isPayant()) {
										inf[2] = "oui";
									}
									else inf[2] = "non";
									
									if (tmp.isRadar()) {
										inf[3] = "oui";
									}
									else inf[3] = "non";
									
									inf[4] = "" + tmp.getVitesse();
									
									if (tmp.isDispo()) {
										inf[5] = "disponible";
										jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
									}
									else {
										inf[5] = "indisponible";
										jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
									}
									
									remplirDetailsTroncon(inf);
									
									tronconsIndispo.remove((String)jComboBox_adminRoutesTroncons.getSelectedItem() + " : [" + (String)jComboBox_adminTroncons.getSelectedItem() + "]");
									Collections.sort(tronconsIndispo);
									DefaultListModel mod = new DefaultListModel();
									for (int i=0; i < tronconsIndispo.size(); i++) {
										mod.addElement(tronconsIndispo.get(i));
									}
									jList_adminTronconsIndispo.setModel(mod);
									
									verifRoute((String)jComboBox_adminRoutesTroncons.getSelectedItem());
								}
							}
						}
					});
		}
		return jButton_adminIndispoTroncon;
	}

	/**
	 * This method initializes jComboBox_adminRoutesTroncons	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_adminRoutesTroncons() {
		if (jComboBox_adminRoutesTroncons == null) {
			jComboBox_adminRoutesTroncons = new JComboBox();
			jComboBox_adminRoutesTroncons.setBackground(Color.WHITE);
			jComboBox_adminRoutesTroncons.setForeground(Color.BLUE);
			jComboBox_adminRoutesTroncons.setPreferredSize(new Dimension(200, 20));
			jComboBox_adminRoutesTroncons
					.addItemListener(new java.awt.event.ItemListener() {
						public void itemStateChanged(java.awt.event.ItemEvent e) {
							jTextPane_detailsTroncon.setText("");
							Route tmp = progps.getRoute((String)jComboBox_adminRoutesTroncons.getSelectedItem());
							DefaultComboBoxModel mod = new DefaultComboBoxModel();
							for (int i=0; i < tmp.getSesTroncons().size(); i++) {
								mod.addElement(((Ville)tmp.getSesTroncons().get(i).getSesVilles().toArray()[0]).getNomVille() + " <-> " + ((Ville)tmp.getSesTroncons().get(i).getSesVilles().toArray()[1]).getNomVille());
							}
							jComboBox_adminTroncons.setModel(mod);
							
							Troncon t = null;
							String[] result = ((String)jComboBox_adminTroncons.getSelectedItem()).split(" ");
							try {
								t = progps.getTroncon((String)jComboBox_adminRoutesTroncons.getSelectedItem(), result[0], result[2]);
							}
							catch (Exception exc) {
								exc.printStackTrace();
							}
							
							String inf[] = new String[6];
							
							inf[0] = "" + t.getLongueur();
							
							if (t.isTouristique()) {
								inf[1] = "oui";
							}
							else inf[1] = "non";
							
							if (t.isPayant()) {
								inf[2] = "oui";
							}
							else inf[2] = "non";
							
							if (t.isRadar()) {
								inf[3] = "oui";
							}
							else inf[3] = "non";
							
							inf[4] = "" + t.getVitesse();
							
							if (t.isDispo()) {
								inf[5] = "disponible";
								jButton_adminIndispoTroncon.setText("Rendre ce tronçon indisponible");
							}
							else {
								inf[5] = "indisponible";
								jButton_adminIndispoTroncon.setText("Rendre ce tronçon disponible");
							}
							
							remplirDetailsTroncon(inf);
						}
					});
		}
		return jComboBox_adminRoutesTroncons;
	}

	/**
	 * This method initializes jScrollPane_adminVillesIndispo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_adminVillesIndispo() {
		if (jScrollPane_adminVillesIndispo == null) {
			jScrollPane_adminVillesIndispo = new JScrollPane();
			jScrollPane_adminVillesIndispo.setPreferredSize(new Dimension(200, 120));
			jScrollPane_adminVillesIndispo.setViewportView(getJList_adminVillesIndispo());
		}
		return jScrollPane_adminVillesIndispo;
	}

	/**
	 * This method initializes jList_adminVillesIndispo	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_adminVillesIndispo() {
		if (jList_adminVillesIndispo == null) {
			jList_adminVillesIndispo = new JList(getVillesIndispo());
			jList_adminVillesIndispo.setForeground(Color.RED);
		}
		return jList_adminVillesIndispo;
	}

	/**
	 * This method initializes jScrollPane_adminRoutesIndispo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_adminRoutesIndispo() {
		if (jScrollPane_adminRoutesIndispo == null) {
			jScrollPane_adminRoutesIndispo = new JScrollPane();
			jScrollPane_adminRoutesIndispo.setPreferredSize(new Dimension(200, 120));
			jScrollPane_adminRoutesIndispo.setViewportView(getJList_adminRoutesIndispo());
		}
		return jScrollPane_adminRoutesIndispo;
	}

	/**
	 * This method initializes routesIndispo	
	 * 	
	 * @return java.util.Vector	
	 */
	private Vector getRoutesIndispo() {
		if (routesIndispo == null) {
			routesIndispo = new Vector();
		}
		return routesIndispo;
	}
	
	/**
	 * This method initializes routesIndispo	
	 * 	
	 * @return java.util.Vector	
	 */
	private Vector getVillesIndispo() {
		if (villesIndispo == null) {
			villesIndispo = new Vector();
		}
		return villesIndispo;
	}

	/**
	 * This method initializes jList_adminRoutesIndispo	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_adminRoutesIndispo() {
		if (jList_adminRoutesIndispo == null) {
			jList_adminRoutesIndispo = new JList(getRoutesIndispo());
			jList_adminRoutesIndispo.setForeground(Color.RED);
		}
		return jList_adminRoutesIndispo;
	}

	/**
	 * This method initializes jScrollPane_adminTronconsIndispo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_adminTronconsIndispo() {
		if (jScrollPane_adminTronconsIndispo == null) {
			jScrollPane_adminTronconsIndispo = new JScrollPane();
			jScrollPane_adminTronconsIndispo.setPreferredSize(new Dimension(200, 120));
			jScrollPane_adminTronconsIndispo.setViewportView(getJList_adminTronconsIndispo());
		}
		return jScrollPane_adminTronconsIndispo;
	}

	/**
	 * This method initializes tronconsIndispo	
	 * 	
	 * @return java.util.Vector	
	 */
	private Vector getTronconsIndispo() {
		if (tronconsIndispo == null) {
			tronconsIndispo = new Vector();
		}
		return tronconsIndispo;
	}

	/**
	 * This method initializes jList_adminTronconsIndispo	
	 * 	
	 * @return javax.swing.JList	
	 */
	public JList getJList_adminTronconsIndispo() {
		if (jList_adminTronconsIndispo == null) {
			jList_adminTronconsIndispo = new JList(getTronconsIndispo());
			jList_adminTronconsIndispo.setForeground(Color.RED);
		}
		return jList_adminTronconsIndispo;
	}

	/**
	 * This method initializes jPanel_detailsTroncon	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_detailsTroncon() {
		if (jPanel_detailsTroncon == null) {
			jPanel_detailsTroncon = new JPanel();
			jPanel_detailsTroncon.setLayout(new FlowLayout());
			jPanel_detailsTroncon.setPreferredSize(new Dimension(250,110));
			jPanel_detailsTroncon.add(getJScrollPane_detailsTroncon(), null);
		}
		return jPanel_detailsTroncon;
	}

	/**
	 * This method initializes jScrollPane_detailsTroncon	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_detailsTroncon() {
		if (jScrollPane_detailsTroncon == null) {
			jScrollPane_detailsTroncon = new JScrollPane();
			jScrollPane_detailsTroncon.setViewportView(getJTextPane_detailsTroncon());
			jScrollPane_detailsTroncon.setPreferredSize(new Dimension(200,100));
		}
		return jScrollPane_detailsTroncon;
	}

	/**
	 * This method initializes jTextPane_detailsTroncon	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_detailsTroncon() {
		if (jTextPane_detailsTroncon == null) {
			jTextPane_detailsTroncon = new JTextPane();
			jTextPane_detailsTroncon.setEditable(false);
			jTextPane_detailsTroncon.setBackground(Color.WHITE);
		}
		return jTextPane_detailsTroncon;
	}

	/**
	 * This method initializes jPanel_detailsRoute	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_detailsRoute() {
		if (jPanel_detailsRoute == null) {
			jPanel_detailsRoute = new JPanel();
			jPanel_detailsRoute.setLayout(new FlowLayout());
			jPanel_detailsRoute.setPreferredSize(new Dimension(250,110));
			jPanel_detailsRoute.add(getJScrollPane_detailsRoute(), null);
		}
		return jPanel_detailsRoute;
	}

	/**
	 * This method initializes jScrollPane_detailsRoute	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_detailsRoute() {
		if (jScrollPane_detailsRoute == null) {
			jScrollPane_detailsRoute = new JScrollPane();
			jScrollPane_detailsRoute.setPreferredSize(new Dimension(200, 100));
			jScrollPane_detailsRoute.setViewportView(getJTextPane_detailsRoute());
		}
		return jScrollPane_detailsRoute;
	}

	/**
	 * This method initializes jTextPane_detailsRoute	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_detailsRoute() {
		if (jTextPane_detailsRoute == null) {
			jTextPane_detailsRoute = new JTextPane();
			jTextPane_detailsRoute.setBackground(Color.WHITE);
			jTextPane_detailsRoute.setEditable(false);
		}
		return jTextPane_detailsRoute;
	}

	/**
	 * This method initializes jPanel_detailsVille	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_detailsVille() {
		if (jPanel_detailsVille == null) {
			jPanel_detailsVille = new JPanel();
			jPanel_detailsVille.setLayout(new FlowLayout());
			jPanel_detailsVille.setPreferredSize(new Dimension(250, 110));
			jPanel_detailsVille.add(getJScrollPane_detailsVille(), null);
		}
		return jPanel_detailsVille;
	}

	/**
	 * This method initializes jScrollPane_detailsVille	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_detailsVille() {
		if (jScrollPane_detailsVille == null) {
			jScrollPane_detailsVille = new JScrollPane();
			jScrollPane_detailsVille.setPreferredSize(new Dimension(200, 100));
			jScrollPane_detailsVille.setViewportView(getJTextPane_detailsVille());
		}
		return jScrollPane_detailsVille;
	}

	/**
	 * This method initializes jTextPane_detailsVille	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_detailsVille() {
		if (jTextPane_detailsVille == null) {
			jTextPane_detailsVille = new JTextPane();
			jTextPane_detailsVille.setBackground(Color.WHITE);
			jTextPane_detailsVille.setEditable(false);
		}
		return jTextPane_detailsVille;
	}
	
	public Vector<String> getListeTronconsIndispo() {
		return tronconsIndispo;
	}


}
