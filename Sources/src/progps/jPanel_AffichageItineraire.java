/*
 * jPanel_AffichageItineraire.java
 *
 * Created on 14 novembre 2007, 00:29
 */

package progps;

import java.awt.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class jPanel_AffichageItineraire extends JPanel {

	private JButton jButton_Itineraire_1;
	private JButton jButton_Itineraire_2;
	private JButton jButton_Itineraire_3;
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
	private JPanel jPanel_Bas;
	private JPanel jPanel_Haut;
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
	private JPanel jPanel_SelectionItineraire_1;
	private JPanel jPanel_SelectionItineraire_2;
	private JPanel jPanel_SelectionItineraire_3;
	private JScrollPane jScrollPane_Itineraire_1;
	private JScrollPane jScrollPane_Itineraire_2;
	private JScrollPane jScrollPane_Itineraire_3;
	private JTree jTree_Itineraire_1;
	private JTree jTree_Itineraire_2;
	private JTree jTree_Itineraire_3;   

	public jPanel_AffichageItineraire() {
		initComponents();
	}

	private void initComponents() {
		jPanel_Haut = new JPanel();
		jPanel_RecapChoix_1 = new JPanel();
		jPanel_RecapitulatifChoix_1 = new JPanel();
		jLabel_Titre_1 = new JLabel();
		jLabel_Distance_1 = new JLabel();
		jLabel_Duree_1 = new JLabel();
		jLabel_Prix_1 = new JLabel();
		jLabel_Preference_1 = new JLabel();
		jPanel_Itineraire_1 = new JPanel();
		jScrollPane_Itineraire_1 = new JScrollPane();
		jPanel_SelectionItineraire_1 = new JPanel();
		jButton_Itineraire_1 = new JButton();
		jPanel_Milieu = new JPanel();
		jPanel_RecapChoix_2 = new JPanel();
		jPanel_RecapitulatifChoix_2 = new JPanel();
		jLabel_Titre_2 = new JLabel();
		jLabel_Distance_2 = new JLabel();
		jLabel_Duree_2 = new JLabel();
		jLabel_Prix_2 = new JLabel();
		jLabel_Preference_2 = new JLabel();
		jPanel_Itineraire_2 = new JPanel();
		jScrollPane_Itineraire_2 = new JScrollPane();
		jPanel_SelectionItineraire_2 = new JPanel();
		jButton_Itineraire_2 = new JButton();
		jPanel_Bas = new JPanel();
		jPanel_RecapChoix_3 = new JPanel();
		jPanel_RecapitulatifChoix_3 = new JPanel();
		jLabel_Titre_3 = new JLabel();
		jLabel_Distance_3 = new JLabel();
		jLabel_Duree_3 = new JLabel();
		jLabel_Prix_3 = new JLabel();
		jLabel_Preference_3 = new JLabel();
		jPanel_Itineraire_3 = new JPanel();
		jScrollPane_Itineraire_3 = new JScrollPane();
		jPanel_SelectionItineraire_3 = new JPanel();
		jButton_Itineraire_3 = new JButton();
		
//      Construction du noeud racine.
        DefaultMutableTreeNode myRoot = new DefaultMutableTreeNode("Ville de départ : Paris");
         
//       Construction des différents noeuds de l'arbre.
        DefaultMutableTreeNode etape = new DefaultMutableTreeNode("Autoroute A5");
        myRoot.add(etape);
        DefaultMutableTreeNode troncon = new DefaultMutableTreeNode("Paris -> Melun");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Melun -> Troye");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Troye -> Chaumont");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Departementale D81");
        myRoot.add(etape);
        troncon = new DefaultMutableTreeNode("Chaumont -> Besançon");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Ville d'arrivé : Besançon");
        myRoot.add(etape);
             
//         Construction du modèle de l'arbre.
        DefaultTreeModel myModel = new DefaultTreeModel(myRoot);
         
//         Construction de l'arbre.
        jTree_Itineraire_1 = new JTree(myModel);
        
        myRoot = new DefaultMutableTreeNode("Ville de départ : Paris");
        etape = new DefaultMutableTreeNode("Autoroute A5");
        myRoot.add(etape);
        troncon = new DefaultMutableTreeNode(" Paris -> Melun");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Melun -> Troye");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Troye -> Chaumont");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Autoroute A6");
        myRoot.add(etape);
        troncon = new DefaultMutableTreeNode("Chaumont -> Dijon");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Dijon -> Besançon");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Ville d'arrivé : Besançon");
        myRoot.add(etape);
        myModel = new DefaultTreeModel(myRoot);
        
        jTree_Itineraire_2 = new JTree(myModel);
        
        
        myRoot = new DefaultMutableTreeNode("Ville de départ : Paris");
        etape = new DefaultMutableTreeNode("Autoroute A6");
        myRoot.add(etape);
        troncon = new DefaultMutableTreeNode("Paris -> Dijon");
        etape.add(troncon);
        troncon = new DefaultMutableTreeNode("Dijon -> Besançon");
        etape.add(troncon);
        etape = new DefaultMutableTreeNode("Ville d'arrivé : Besançon");
        myRoot.add(etape);
        myModel = new DefaultTreeModel(myRoot);
        
        jTree_Itineraire_3 = new JTree(myModel);

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		jPanel_Haut.setLayout(new BoxLayout(jPanel_Haut, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_1.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_1.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_1, BoxLayout.Y_AXIS));

		jLabel_Titre_1.setText("Recapitulatif");
		jPanel_RecapitulatifChoix_1.add(jLabel_Titre_1);

		jLabel_Distance_1.setText("Distance : 350 km");
		jPanel_RecapitulatifChoix_1.add(jLabel_Distance_1);

		jLabel_Duree_1.setText("Durée : 3 h 25 min 00 sec");
		jPanel_RecapitulatifChoix_1.add(jLabel_Duree_1);

		jLabel_Prix_1.setText("Prix : 13  20");
		jPanel_RecapitulatifChoix_1.add(jLabel_Prix_1);

		jLabel_Preference_1.setText("Préférence : 80 %");
		jPanel_RecapitulatifChoix_1.add(jLabel_Preference_1);

		jPanel_RecapChoix_1.add(jPanel_RecapitulatifChoix_1, BorderLayout.CENTER);

		jPanel_Haut.add(jPanel_RecapChoix_1);

		jPanel_Itineraire_1.setLayout(new BorderLayout());

		jScrollPane_Itineraire_1.setViewportView(jTree_Itineraire_1);

		jPanel_Itineraire_1.add(jScrollPane_Itineraire_1, BorderLayout.CENTER);

		jPanel_Haut.add(jPanel_Itineraire_1);

		jButton_Itineraire_1.setText("Choisir cet itineraire");
		jPanel_SelectionItineraire_1.add(jButton_Itineraire_1);

		jPanel_Haut.add(jPanel_SelectionItineraire_1);

		add(jPanel_Haut);

		jPanel_Milieu.setLayout(new BoxLayout(jPanel_Milieu, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_2.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_2.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_2, BoxLayout.Y_AXIS));

		jLabel_Titre_2.setText("Recapitulatif");
		jPanel_RecapitulatifChoix_2.add(jLabel_Titre_2);

		jLabel_Distance_2.setText("Distance : 390 km");
		jPanel_RecapitulatifChoix_2.add(jLabel_Distance_2);

		jLabel_Duree_2.setText("Dur\u00e9e : 3 h 00 min 00 sec");
		jPanel_RecapitulatifChoix_2.add(jLabel_Duree_2);

		jLabel_Prix_2.setText("Prix : 25  50");
		jPanel_RecapitulatifChoix_2.add(jLabel_Prix_2);

		jLabel_Preference_2.setText("Préférence : 76 %");
		jPanel_RecapitulatifChoix_2.add(jLabel_Preference_2);

		jPanel_RecapChoix_2.add(jPanel_RecapitulatifChoix_2, BorderLayout.NORTH);

		jPanel_Milieu.add(jPanel_RecapChoix_2);

		jPanel_Itineraire_2.setLayout(new BorderLayout());

		jScrollPane_Itineraire_2.setViewportView(jTree_Itineraire_2);

		jPanel_Itineraire_2.add(jScrollPane_Itineraire_2, BorderLayout.CENTER);

		jPanel_Milieu.add(jPanel_Itineraire_2);

		jButton_Itineraire_2.setText("Choisir cet itineraire");
		jPanel_SelectionItineraire_2.add(jButton_Itineraire_2);

		jPanel_Milieu.add(jPanel_SelectionItineraire_2);

		add(jPanel_Milieu);

		jPanel_Bas.setLayout(new BoxLayout(jPanel_Bas, BoxLayout.Y_AXIS));

		jPanel_RecapChoix_3.setLayout(new BorderLayout());

		jPanel_RecapitulatifChoix_3.setLayout(new BoxLayout(jPanel_RecapitulatifChoix_3, BoxLayout.Y_AXIS));

		jLabel_Titre_3.setText("Recapitulatif");
		jPanel_RecapitulatifChoix_3.add(jLabel_Titre_3);

		jLabel_Distance_3.setText("Distance : 380 km");
		jPanel_RecapitulatifChoix_3.add(jLabel_Distance_3);

		jLabel_Duree_3.setText("Durée : 2 h 55 min 00 sec");
		jPanel_RecapitulatifChoix_3.add(jLabel_Duree_3);

		jLabel_Prix_3.setText("Prix : 29  50");
		jPanel_RecapitulatifChoix_3.add(jLabel_Prix_3);

		jLabel_Preference_3.setText("Préférence : 70 %");
		jPanel_RecapitulatifChoix_3.add(jLabel_Preference_3);

		jPanel_RecapChoix_3.add(jPanel_RecapitulatifChoix_3, BorderLayout.CENTER);

		jPanel_Bas.add(jPanel_RecapChoix_3);

		jPanel_Itineraire_3.setLayout(new BorderLayout());

		jScrollPane_Itineraire_3.setViewportView(jTree_Itineraire_3);

		jPanel_Itineraire_3.add(jScrollPane_Itineraire_3, BorderLayout.CENTER);

		jPanel_Bas.add(jPanel_Itineraire_3);

		jButton_Itineraire_3.setText("Choisir cet itineraire");
		jPanel_SelectionItineraire_3.add(jButton_Itineraire_3);

		jPanel_Bas.add(jPanel_SelectionItineraire_3);

		add(jPanel_Bas);

	} 
}
