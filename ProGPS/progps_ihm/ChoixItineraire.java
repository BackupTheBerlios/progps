/*
 * jPanel_AffichageItineraire.java
 *
 * Created on 14 novembre 2007, 00:29
 */

package progps_ihm;

import java.awt.*;

import javax.swing.*;
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

public class ChoixItineraire extends JPanel {

	private JLabel jLabel_Distance_1;
	private JLabel jLabel_Distance_2;
	private JLabel jLabel_Distance_3;
	private JLabel jLabel_Duree_1;
	private JLabel jLabel_Duree_2;
	private JLabel jLabel_Duree_3;
	private JLabel jLabel_Preference_1;
	private JLabel jLabel_Preference_2;
	private JLabel jLabel_Preference_3;
	private JLabel jLabel_Prix_1;
	private JLabel jLabel_Prix_2;
	private JLabel jLabel_Prix_3;
	private JLabel jLabel_Titre_1;
	private JLabel jLabel_Titre_2;
	private JLabel jLabel_Titre_3;
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
	private JLabel jLabel_viol_1 = null;
	private JLabel jLabel_viol_2 = null;
	private JLabel jLabel_viol_3 = null;
	private JLabel jLabel_viol_4 = null;
	private JLabel jLabel_viol_5 = null;
	private JLabel jLabel_viol_6 = null;
	private JPanel jPanel_Haut = null;
	private JLabel jLabel_haut = null;   

	public ChoixItineraire() {
		initComponents();
	}

	private void initComponents() {
		jLabel_viol_6 = new JLabel();
		jLabel_viol_6.setText(" ");
		jLabel_viol_5 = new JLabel();
		jLabel_viol_5.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_viol_5.setForeground(Color.RED);
		jLabel_viol_5.setText("Limitation mini : 90 km/h");
		jLabel_viol_4 = new JLabel();
		jLabel_viol_4.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_viol_4.setForeground(Color.RED);
		jLabel_viol_4.setText("Limitation mini : 50 km/h");
		jLabel_viol_3 = new JLabel();
		jLabel_viol_3.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_viol_3.setForeground(Color.RED);
		jLabel_viol_3.setText("Radars : 3");
		jLabel_viol_2 = new JLabel();
		jLabel_viol_2.setText(" ");
		jLabel_viol_1 = new JLabel();
		jLabel_viol_1.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_viol_1.setForeground(Color.RED);
		jLabel_viol_1.setText("Radars : 2");
		jPanel_Droite = new JPanel();
		jPanel_Droite.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jPanel_RecapChoix_1 = new JPanel();
		jPanel_RecapitulatifChoix_1 = new JPanel();
		jLabel_Titre_1 = new JLabel();
		jLabel_Distance_1 = new JLabel();
		jLabel_Distance_1.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Duree_1 = new JLabel();
		jLabel_Duree_1.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Prix_1 = new JLabel();
		jLabel_Prix_1.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Preference_1 = new JLabel();
		jLabel_Preference_1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,12));
		jPanel_Itineraire_1 = new JPanel();
		jScrollPane_Itineraire_1 = new JScrollPane();
		jPanel_Milieu = new JPanel();
		jPanel_Milieu.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jPanel_RecapChoix_2 = new JPanel();
		jPanel_RecapitulatifChoix_2 = new JPanel();
		jLabel_Titre_2 = new JLabel();
		jLabel_Distance_2 = new JLabel();
		jLabel_Distance_2.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Duree_2 = new JLabel();
		jLabel_Duree_2.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Prix_2 = new JLabel();
		jLabel_Prix_2.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Preference_2 = new JLabel();
		jLabel_Preference_2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,12));
		jPanel_Itineraire_2 = new JPanel();
		jScrollPane_Itineraire_2 = new JScrollPane();
		jPanel_Gauche = new JPanel();
		jPanel_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jPanel_RecapChoix_3 = new JPanel();
		jPanel_RecapitulatifChoix_3 = new JPanel();
		jLabel_Titre_3 = new JLabel();
		jLabel_Distance_3 = new JLabel();
		jLabel_Distance_3.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Duree_3 = new JLabel();
		jLabel_Duree_3.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Prix_3 = new JLabel();
		jLabel_Prix_3.setFont(new Font("Arial",Font.PLAIN,12));
		jLabel_Preference_3 = new JLabel();
		jLabel_Preference_3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,12));
		
		jPanel_Itineraire_3 = new JPanel();
		jScrollPane_Itineraire_3 = new JScrollPane();
		
//      Construction du noeud racine.
        DefaultMutableTreeNode myRoot = new DefaultMutableTreeNode("Ville de départ : Paris");
         
//       Construction des différents noeuds de l'arbre.
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
        troncon = new DefaultMutableTreeNode("Chaumont -> Besançon");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Ville d'arrivée : Aix-en-Provence");
        myRoot.add(etape);
             
//         Construction du modèle de l'arbre.
        DefaultTreeModel myModel = new DefaultTreeModel(myRoot);
         
//         Construction de l'arbre.
        jTree_Itineraire_1 = new JTree(myModel);
        jTree_Itineraire_1.addMouseListener(new java.awt.event.MouseListener() {
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
        	public void mousePressed(java.awt.event.MouseEvent e) {
        	}
        	public void mouseReleased(java.awt.event.MouseEvent e) {
        	}
        	public void mouseEntered(java.awt.event.MouseEvent e) {
        	}
        	public void mouseExited(java.awt.event.MouseEvent e) {
        	}
        });
        
        myRoot = new DefaultMutableTreeNode("Ville de départ : Paris");
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
        troncon = new DefaultMutableTreeNode("Dijon -> Besançon");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Ville d'arrivée : Aix-en-Provence");
        //etape = new DefaultMutableTreeNode(new Noeuds("Chemin",new ImageIcon("Icone/gps_small.png")));
        myRoot.add(etape);
        myModel = new DefaultTreeModel(myRoot);
        
        jTree_Itineraire_2 = new JTree(myModel);
        jTree_Itineraire_2.addMouseListener(new java.awt.event.MouseListener() {
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
        	public void mousePressed(java.awt.event.MouseEvent e) {
        	}
        	public void mouseReleased(java.awt.event.MouseEvent e) {
        	}
        	public void mouseEntered(java.awt.event.MouseEvent e) {
        	}
        	public void mouseExited(java.awt.event.MouseEvent e) {
        	}
        });
        
        
        myRoot = new DefaultMutableTreeNode("Ville de départ : Paris");
        etape = new DefaultMutableTreeNode("Autoroute A6");
        myRoot.add(etape);
        troncon = new DefaultMutableTreeNode("Paris -> Dijon");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Dijon -> Lyon");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Lyon -> Aix-en-Provence");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Ville d'arrivée : Aix-en-Provence");
        myRoot.add(etape);
        myModel = new DefaultTreeModel(myRoot);
        
        jTree_Itineraire_3 = new JTree(myModel);
        jTree_Itineraire_3.addMouseListener(new java.awt.event.MouseListener() {
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
        	public void mousePressed(java.awt.event.MouseEvent e) {
        	}
        	public void mouseReleased(java.awt.event.MouseEvent e) {
        	}
        	public void mouseEntered(java.awt.event.MouseEvent e) {
        	}
        	public void mouseExited(java.awt.event.MouseEvent e) {
        	}
        });
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		jPanel_Droite.setLayout(new BoxLayout(jPanel_Droite, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_1.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_1.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_1, BoxLayout.Y_AXIS));

		jLabel_Titre_1.setText("Récapitulatif");
		jPanel_RecapitulatifChoix_1.add(jLabel_Titre_1);

		jLabel_Distance_1.setText("Distance : 850 km");
		jPanel_RecapitulatifChoix_1.add(jLabel_Distance_1);

		jLabel_Duree_1.setText("Durée : 8 h 25 min 00 sec");
		jPanel_RecapitulatifChoix_1.add(jLabel_Duree_1);

		jLabel_Prix_1.setText("Prix : 13 € 20");
		jPanel_RecapitulatifChoix_1.add(jLabel_Prix_1);

		jLabel_Preference_1.setText("Préférences violées :");
		jPanel_RecapitulatifChoix_1.add(jLabel_Preference_1);

		jPanel_RecapitulatifChoix_1.add(jLabel_viol_5, null);
		jPanel_RecapitulatifChoix_1.add(jLabel_viol_6, null);
		jPanel_RecapChoix_1.add(jPanel_RecapitulatifChoix_1, BorderLayout.CENTER);

		jPanel_Droite.add(jPanel_RecapChoix_1);

		jPanel_Itineraire_1.setLayout(new BorderLayout());

		jScrollPane_Itineraire_1.setViewportView(jTree_Itineraire_1);

		jPanel_Itineraire_1.add(jScrollPane_Itineraire_1, BorderLayout.CENTER);

		jPanel_Droite.add(jPanel_Itineraire_1);

		jPanel_Milieu.setLayout(new BoxLayout(jPanel_Milieu, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_2.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_2.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_2, BoxLayout.Y_AXIS));

		jLabel_Titre_2.setText("Récapitulatif");
		jPanel_RecapitulatifChoix_2.add(jLabel_Titre_2);

		jLabel_Distance_2.setText("Distance : 710 km");
		jPanel_RecapitulatifChoix_2.add(jLabel_Distance_2);

		jLabel_Duree_2.setText("Durée : 7 h 00 min 00 sec");
		jPanel_RecapitulatifChoix_2.add(jLabel_Duree_2);

		jLabel_Prix_2.setText("Prix : 25 € 50");
		jPanel_RecapitulatifChoix_2.add(jLabel_Prix_2);

		jLabel_Preference_2.setText("Préférences violées :");
		jPanel_RecapitulatifChoix_2.add(jLabel_Preference_2);

		jPanel_RecapitulatifChoix_2.add(jLabel_viol_3, null);
		jPanel_RecapitulatifChoix_2.add(jLabel_viol_4, null);
		jPanel_RecapChoix_2.add(jPanel_RecapitulatifChoix_2, BorderLayout.NORTH);

		jPanel_Milieu.add(jPanel_RecapChoix_2);

		jPanel_Itineraire_2.setLayout(new BorderLayout());

		jScrollPane_Itineraire_2.setViewportView(jTree_Itineraire_2);

		jPanel_Itineraire_2.add(jScrollPane_Itineraire_2, BorderLayout.CENTER);

		jPanel_Milieu.add(jPanel_Itineraire_2);

		jPanel_Gauche.setLayout(new BoxLayout(jPanel_Gauche, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_3.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_3.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_3, BoxLayout.Y_AXIS));

		jLabel_Titre_3.setText("Récapitulatif");
		jPanel_RecapitulatifChoix_3.add(jLabel_Titre_3);

		jLabel_Distance_3.setText("Distance : 680 km");
		jPanel_RecapitulatifChoix_3.add(jLabel_Distance_3);

		jLabel_Duree_3.setText("Durée : 6 h 55 min 00 sec");
		jPanel_RecapitulatifChoix_3.add(jLabel_Duree_3);

		jLabel_Prix_3.setText("Prix : 29 € 50");
		jPanel_RecapitulatifChoix_3.add(jLabel_Prix_3);

		jLabel_Preference_3.setText("Préférences violées : ");
		jPanel_RecapitulatifChoix_3.add(jLabel_Preference_3);

		jPanel_RecapitulatifChoix_3.add(jLabel_viol_1, null);
		jPanel_RecapitulatifChoix_3.add(jLabel_viol_2, null);
		jPanel_RecapChoix_3.add(jPanel_RecapitulatifChoix_3, BorderLayout.CENTER);

		jPanel_Gauche.add(jPanel_RecapChoix_3);

		jPanel_Itineraire_3.setLayout(new BorderLayout());

		jScrollPane_Itineraire_3.setViewportView(jTree_Itineraire_3);

		jPanel_Itineraire_3.add(jScrollPane_Itineraire_3, BorderLayout.CENTER);

		jPanel_Gauche.add(jPanel_Itineraire_3);

		DefaultTreeCellRenderer myRenderer = new DefaultTreeCellRenderer();
		
//		 Changement de l'icône pour les feuilles de l'arbre.
		myRenderer.setLeafIcon(new ImageIcon("C://progps_images//pas.png"));
//		 Changement de l'icône pour les noeuds fermés.
		myRenderer.setClosedIcon(new ImageIcon("C://progps_images//route_icone.png"));
//		 Changement de l'icône pour les noeuds ouverts.
		myRenderer.setOpenIcon(new ImageIcon("C://progps_images//route_icone.png"));
		 
//		 Application de l'afficheur à l'arbre.
		jTree_Itineraire_1.setCellRenderer(myRenderer);
		jTree_Itineraire_2.setCellRenderer(myRenderer);
		jTree_Itineraire_3.setCellRenderer(myRenderer);
		
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
			jButton_Choix.setText("Choisir cet itinéraire");
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
			jLabel_haut.setText("Choisissez votre itinéraire :");
			jLabel_haut.setPreferredSize(new Dimension(200,40));
			jLabel_haut.setHorizontalAlignment(JLabel.CENTER);
			jPanel_Haut = new JPanel();
			jPanel_Haut.setLayout(new FlowLayout());
			jPanel_Haut.add(jLabel_haut, null);
		}
		return jPanel_Haut;
	} 
}
