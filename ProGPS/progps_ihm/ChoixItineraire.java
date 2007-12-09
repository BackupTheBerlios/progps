package progps_ihm;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class ChoixItineraire extends JPanel {

	private JPanel jPanel_Gauche;
	private JPanel jPanel_Droite;
	private JPanel jPanel_Itineraire_1;
	private JPanel jPanel_Itineraire_2;
	private JPanel jPanel_Itineraire_3;
	private JPanel jPanel_Milieu;
	private JPanel jPanel_RecapChoix_1;
	private JPanel jPanel_RecapChoix_2;
	private JPanel jPanel_RecapChoix_3;
	private JPanel jPanel_RecapitulatifChoix_1;
	private JPanel jPanel_RecapitulatifChoix_2;
	private JPanel jPanel_RecapitulatifChoix_3;
	private JScrollPane jScrollPane_Itineraire_1;
	private JScrollPane jScrollPane_Itineraire_2;
	private JScrollPane jScrollPane_Itineraire_3;
	private JTree jTree_Itineraire_1;
	private JTree jTree_Itineraire_2;
	private JTree jTree_Itineraire_3;
	private JPanel jPanel_Content = null;
	private JPanel jPanel_Centre = null;
	private JPanel jPanel_Bas = null;
	private JButton jButton_Choix = null;
	private JPanel jPanel_Haut = null;
	private JLabel jLabel_haut = null;
	private JTextPane jTextPane_recap3 = null;
	private JScrollPane jScrollPane_recap_3 = null;
	private JScrollPane jScrollPane_recap_2 = null;
	private JTextPane jTextPane_recap2 = null;
	private JScrollPane jScrollPane_recap_1 = null;
	private JTextPane jTextPane_recap1 = null;   

	public ChoixItineraire() {
		initComponents();
	}

	/**
	 * Remplir les informations d'un r�capitulatif
	 * @param num 3=gauche,2=centre,1=droite
	 * @param String[] Infos : Distance, dur�e, prix (seulement les valeurs, ex : "25�50")
	 * @param String[] Preferences viol�es (texte complet, ex : "Radars : 3")
	 */
	public void remplirRecap(int num, String[] infos, String[] viols) {
		String v = "";
		for(int i=0; i<viols.length;i++) {
			v += viols[i];
			v += "\n";
		}
		String[] initString =
		{ "R�capitulatif :\n",            //regular
				"Distance : " + infos[0] + "\n",                                   //italic
				"Dur�e : " + infos[1] + "\n",                                    //bold
				"Prix : " + infos[0] + "\n\n",                                      //small
				"Pr�f�rences viol�es : \n",                                //large
				v
		};

		String[] initStyles =
		{ "bold",
		  "regular",
		  "regular",
		  "regular",
		  "bold_italic",
		  "red",
		};

		StyledDocument doc = null;
		
		try {
			switch(num){
				case 1: doc = jTextPane_recap1.getStyledDocument(); break;
				case 2: doc = jTextPane_recap2.getStyledDocument(); break;
				case 3: doc = jTextPane_recap3.getStyledDocument(); break;
				default: throw new Exception("Erreur : le num�ro du r�capitulatif doit etre compris entre 1 et 3");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		addStylesToDocument(doc);

		try {
			for (int i=0; i < initString.length; i++) {
				doc.insertString(doc.getLength(), initString[i],
						doc.getStyle(initStyles[i]));
			}
		} catch (BadLocationException ble) {
			System.err.println("Impossible d'ins�rer le texte dans le TextPane.");
		}
	}
	
	protected void addStylesToDocument(StyledDocument doc) {
		// Initialize some styles.
        Style def = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);

        Style regular = doc.addStyle("regular", def);
        StyleConstants.setFontFamily(def, "SansSerif");

        Style s = doc.addStyle("italic", regular);
        StyleConstants.setItalic(s, true);

        s = doc.addStyle("bold", regular);
        StyleConstants.setBold(s, true);
        
        s = doc.addStyle("bold_italic", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setItalic(s, true);

        s = doc.addStyle("red", regular);
        StyleConstants.setForeground(s, Color.RED);
	}

	private void initComponents() {
		jPanel_Droite = new JPanel();
		jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jPanel_RecapChoix_1 = new JPanel();
		jPanel_RecapitulatifChoix_1 = new JPanel();
		jPanel_Itineraire_1 = new JPanel();
		jScrollPane_Itineraire_1 = new JScrollPane();
		jPanel_Milieu = new JPanel();
		jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jPanel_RecapChoix_2 = new JPanel();
		jPanel_RecapitulatifChoix_2 = new JPanel();
		jPanel_Itineraire_2 = new JPanel();
		jScrollPane_Itineraire_2 = new JScrollPane();
		jPanel_Gauche = new JPanel();
		jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jPanel_RecapChoix_3 = new JPanel();
		jPanel_RecapitulatifChoix_3 = new JPanel();

		jPanel_Itineraire_3 = new JPanel();
		jScrollPane_Itineraire_3 = new JScrollPane();

		initArbres();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		jPanel_Droite.setLayout(new BoxLayout(jPanel_Droite, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_1.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_1.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_1, BoxLayout.Y_AXIS));

		jPanel_RecapitulatifChoix_1.add(getJScrollPane_recap_1(), null);
		jPanel_RecapChoix_1.add(jPanel_RecapitulatifChoix_1, BorderLayout.CENTER);

		jPanel_Droite.add(jPanel_RecapChoix_1);

		jPanel_Itineraire_1.setLayout(new BorderLayout());

		jScrollPane_Itineraire_1.setViewportView(jTree_Itineraire_1);

		jPanel_Itineraire_1.add(jScrollPane_Itineraire_1, BorderLayout.CENTER);

		jPanel_Droite.add(jPanel_Itineraire_1);

		jPanel_Milieu.setLayout(new BoxLayout(jPanel_Milieu, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_2.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_2.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_2, BoxLayout.Y_AXIS));

		jPanel_RecapitulatifChoix_2.add(getJScrollPane_recap_2(), null);
		jPanel_RecapChoix_2.add(jPanel_RecapitulatifChoix_2, BorderLayout.CENTER);

		jPanel_Milieu.add(jPanel_RecapChoix_2);

		jPanel_Itineraire_2.setLayout(new BorderLayout());

		jScrollPane_Itineraire_2.setViewportView(jTree_Itineraire_2);

		jPanel_Itineraire_2.add(jScrollPane_Itineraire_2, BorderLayout.CENTER);

		jPanel_Milieu.add(jPanel_Itineraire_2);

		jPanel_Gauche.setLayout(new BoxLayout(jPanel_Gauche, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_3.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_3.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_3, BoxLayout.Y_AXIS));

		jPanel_RecapitulatifChoix_3.add(getJScrollPane_recap_3(), null);
		jPanel_RecapChoix_3.add(jPanel_RecapitulatifChoix_3, BorderLayout.CENTER);

		jPanel_Gauche.add(jPanel_RecapChoix_3);

		jPanel_Itineraire_3.setLayout(new BorderLayout());

		jScrollPane_Itineraire_3.setViewportView(jTree_Itineraire_3);

		jPanel_Itineraire_3.add(jScrollPane_Itineraire_3, BorderLayout.CENTER);

		jPanel_Gauche.add(jPanel_Itineraire_3);
		
		jTree_Itineraire_1.setBackground(Color.LIGHT_GRAY);
		jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jTree_Itineraire_1.setEnabled(false);
		jTree_Itineraire_2.setBackground(Color.LIGHT_GRAY);
		jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jTree_Itineraire_2.setEnabled(false);
		jTree_Itineraire_3.setBackground(Color.WHITE);
		jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		this.add(getJPanel_Content(), null);
	}
	
	public void initArbres() {
//		Construction du noeud racine.
		DefaultMutableTreeNode myRoot = new DefaultMutableTreeNode("Ville de d�part : Paris");

//		Construction des diff�rents noeuds de l'arbre.
		DefaultMutableTreeNode etape = new DefaultMutableTreeNode("Autoroute A5");
		myRoot.add(etape);
		DefaultMutableTreeNode troncon = new DefaultMutableTreeNode("Paris -> Melun");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Melun -> Troyes");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Troyes -> Chaumont");
		etape.add(troncon);
		etape = new DefaultMutableTreeNode("Departementale D81");
		myRoot.add(etape);
		troncon = new DefaultMutableTreeNode("Chaumont -> Besan�on");
		etape.add(troncon);
		etape = new DefaultMutableTreeNode("Ville d'arriv�e : Aix-en-Provence");
		myRoot.add(etape);

//		Construction du mod�le de l'arbre.
		DefaultTreeModel myModel = new DefaultTreeModel(myRoot);

//		Construction de l'arbre.
		jTree_Itineraire_1 = new JTree(myModel);
		jTree_Itineraire_1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jTree_Itineraire_2.setBackground(Color.LIGHT_GRAY);
				jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				jTree_Itineraire_2.setEnabled(false);
				jTree_Itineraire_3.setBackground(Color.LIGHT_GRAY);
				jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				jTree_Itineraire_3.setEnabled(false);
				jTree_Itineraire_1.setBackground(Color.WHITE);
				jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				jTree_Itineraire_1.setEnabled(true);
			}
		});

		myRoot = new DefaultMutableTreeNode("Ville de d�part : Paris");
		etape = new DefaultMutableTreeNode("Autoroute A5");
		myRoot.add(etape);
		troncon = new DefaultMutableTreeNode(" Paris -> Melun");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Melun -> Troyes");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Troyes -> Chaumont");
		etape.add(troncon);
		etape = new DefaultMutableTreeNode("Autoroute A6");
		myRoot.add(etape);
		troncon = new DefaultMutableTreeNode("Chaumont -> Dijon");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Dijon -> Besan�on");
		etape.add(troncon);
		etape = new DefaultMutableTreeNode("Ville d'arriv�e : Aix-en-Provence");
		//etape = new DefaultMutableTreeNode(new Noeuds("Chemin",new ImageIcon("Icone/gps_small.png")));
		myRoot.add(etape);
		myModel = new DefaultTreeModel(myRoot);

		jTree_Itineraire_2 = new JTree(myModel);
		jTree_Itineraire_2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jTree_Itineraire_1.setBackground(Color.LIGHT_GRAY);
				jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				jTree_Itineraire_1.setEnabled(false);
				jTree_Itineraire_3.setBackground(Color.LIGHT_GRAY);
				jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				jTree_Itineraire_3.setEnabled(false);
				jTree_Itineraire_2.setBackground(Color.WHITE);
				jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				jTree_Itineraire_2.setEnabled(true);
			}
		});


		myRoot = new DefaultMutableTreeNode("Ville de d�part : Paris");
		etape = new DefaultMutableTreeNode("Autoroute A6");
		myRoot.add(etape);
		troncon = new DefaultMutableTreeNode("Paris -> Dijon");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Dijon -> Lyon");
		etape.add(troncon);
		troncon = new DefaultMutableTreeNode("Lyon -> Aix-en-Provence");
		etape.add(troncon);
		etape = new DefaultMutableTreeNode("Ville d'arriv�e : Aix-en-Provence");
		myRoot.add(etape);
		myModel = new DefaultTreeModel(myRoot);

		jTree_Itineraire_3 = new JTree(myModel);
		jTree_Itineraire_3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jTree_Itineraire_1.setBackground(Color.LIGHT_GRAY);
				jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
				jTree_Itineraire_1.setEnabled(false);
				jTree_Itineraire_2.setBackground(Color.LIGHT_GRAY);
				jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				jTree_Itineraire_2.setEnabled(false);
				jTree_Itineraire_3.setBackground(Color.WHITE);
				jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				jTree_Itineraire_3.setEnabled(true);
			}
		});
		
		DefaultTreeCellRenderer myRenderer = new DefaultTreeCellRenderer();

//		Changement de l'ic�ne pour les feuilles de l'arbre.
		myRenderer.setLeafIcon(new ImageIcon("C://progps_images//pas.png"));
//		Changement de l'ic�ne pour les noeuds ferm�s.
		myRenderer.setClosedIcon(new ImageIcon("C://progps_images//route_icone.png"));
//		Changement de l'ic�ne pour les noeuds ouverts.
		myRenderer.setOpenIcon(new ImageIcon("C://progps_images//route_icone.png"));

//		Application de l'afficheur � l'arbre.
		jTree_Itineraire_1.setCellRenderer(myRenderer);
		jTree_Itineraire_2.setCellRenderer(myRenderer);
		jTree_Itineraire_3.setCellRenderer(myRenderer);

		
	}

	/**
	 * This method initializes jPanel_Content	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Content() {
		if (jPanel_Content == null) {
			jPanel_Content = new JPanel();
			jPanel_Content.setLayout(new BorderLayout());
			jPanel_Content.add(getJPanel_Centre(), BorderLayout.CENTER);
			jPanel_Content.add(getJPanel_Bas(), BorderLayout.SOUTH);
			jPanel_Content.add(getJPanel_Haut(), BorderLayout.NORTH);
		}
		return jPanel_Content;
	}

	/**
	 * This method initializes jPanel_Centre	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Centre() {
		if (jPanel_Centre == null) {
			jPanel_Centre = new JPanel();
			jPanel_Centre.setLayout(new BoxLayout(getJPanel_Centre(), BoxLayout.X_AXIS));
			jPanel_Centre.add(Box.createRigidArea(new Dimension(5,0)));
			jPanel_Centre.add(jPanel_Gauche, null);
			jPanel_Centre.add(Box.createRigidArea(new Dimension(5,0)));
			jPanel_Centre.add(jPanel_Milieu, null);
			jPanel_Centre.add(Box.createRigidArea(new Dimension(5,0)));
			jPanel_Centre.add(jPanel_Droite, null);
			jPanel_Centre.add(Box.createRigidArea(new Dimension(5,0)));
			//jPanel_Centre.setPreferredSize(new Dimension(700,400));
		}
		return jPanel_Centre;
	}

	/**
	 * This method initializes jPanel_Bas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Bas() {
		if (jPanel_Bas == null) {
			jPanel_Bas = new JPanel();
			jPanel_Bas.setLayout(new FlowLayout());
			jPanel_Bas.add(getJButton_Choix(), null);
		}
		return jPanel_Bas;
	}

	/**
	 * This method initializes jButton_Choix	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Choix() {
		if (jButton_Choix == null) {
			jButton_Choix = new JButton();
			jButton_Choix.setText("Choisir cet itin�raire");
		}
		return jButton_Choix;
	}

	/**
	 * This method initializes jPanel_Haut	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Haut() {
		if (jPanel_Haut == null) {
			jLabel_haut = new JLabel();
			jLabel_haut.setText("Choisissez votre itin�raire :");
			jLabel_haut.setPreferredSize(new Dimension(200,40));
			jLabel_haut.setHorizontalAlignment(JLabel.CENTER);
			jPanel_Haut = new JPanel();
			jPanel_Haut.setLayout(new FlowLayout());
			jPanel_Haut.add(jLabel_haut, null);
		}
		return jPanel_Haut;
	}

	/**
	 * This method initializes jTextPane_recap3	
	 * 	
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane_recap3() {
		if (jTextPane_recap3 == null) {
			jTextPane_recap3 = new JTextPane();
			jTextPane_recap3.setEditable(false);
			jTextPane_recap3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTree_Itineraire_1.setBackground(Color.LIGHT_GRAY);
					jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					jTree_Itineraire_1.setEnabled(false);
					jTree_Itineraire_2.setBackground(Color.LIGHT_GRAY);
					jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					jTree_Itineraire_2.setEnabled(false);
					jTree_Itineraire_3.setBackground(Color.WHITE);
					jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					jTree_Itineraire_3.setEnabled(true);
				}
			});
			
			String[] infos = {"710 kms","7h00m00s","25�50"};
			String[] viols = {"Radars : 3","Limitation : 110 km/h"};
			remplirRecap(3,infos,viols);
		}
		return jTextPane_recap3;
	}

	/**
	 * This method initializes jScrollPane_recap_3	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_recap_3() {
		if (jScrollPane_recap_3 == null) {
			jScrollPane_recap_3 = new JScrollPane();
			//jScrollPane_recap_3.setPreferredSize(new Dimension(150,100));
			jScrollPane_recap_3.setViewportView(getJTextPane_recap3());
		}
		return jScrollPane_recap_3;
	}

	/**
	 * This method initializes jScrollPane_recap_2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_recap_2() {
		if (jScrollPane_recap_2 == null) {
			jScrollPane_recap_2 = new JScrollPane();
			jScrollPane_recap_2.setViewportView(getJTextPane_recap2());
		}
		return jScrollPane_recap_2;
	}

	/**
	 * This method initializes jTextPane_recap2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_recap2() {
		if (jTextPane_recap2 == null) {
			jTextPane_recap2 = new JTextPane();
			jTextPane_recap2.setEditable(false);
			jTextPane_recap2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTree_Itineraire_1.setBackground(Color.LIGHT_GRAY);
					jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					jTree_Itineraire_1.setEnabled(false);
					jTree_Itineraire_3.setBackground(Color.LIGHT_GRAY);
					jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					jTree_Itineraire_3.setEnabled(false);
					jTree_Itineraire_2.setBackground(Color.WHITE);
					jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					jTree_Itineraire_2.setEnabled(true);
				}
			});
			
			String[] infos = {"710 kms","7h00m00s","25�50"};
			String[] viols = {"Radars : 3","Limitation : 110 km/h"};
			remplirRecap(2,infos,viols);
		}
		return jTextPane_recap2;
	}

	/**
	 * This method initializes jScrollPane_recap_1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_recap_1() {
		if (jScrollPane_recap_1 == null) {
			jScrollPane_recap_1 = new JScrollPane();
			jScrollPane_recap_1.setViewportView(getJTextPane_recap1());
		}
		return jScrollPane_recap_1;
	}

	/**
	 * This method initializes jTextPane_recap1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_recap1() {
		if (jTextPane_recap1 == null) {
			jTextPane_recap1 = new JTextPane();
			jTextPane_recap1.setEditable(false);
			jTextPane_recap1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTree_Itineraire_2.setBackground(Color.LIGHT_GRAY);
					jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					jTree_Itineraire_2.setEnabled(false);
					jTree_Itineraire_3.setBackground(Color.LIGHT_GRAY);
					jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					jTree_Itineraire_3.setEnabled(false);
					jTree_Itineraire_1.setBackground(Color.WHITE);
					jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					jTree_Itineraire_1.setEnabled(true);
				}
			});
			
			String[] infos = {"710 kms","7h00m00s","25�50"};
			String[] viols = {"Radars : 3","Limitation : 110 km/h"};
			remplirRecap(1,infos,viols);
		}
		return jTextPane_recap1;
	} 
}
