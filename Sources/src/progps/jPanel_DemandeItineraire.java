package progps;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class jPanel_DemandeItineraire extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 1L;
    private JButton jButton_AjouterVillesAEviter;
    private JButton jButton_AjouterVillesEtapes;
    private JButton jButton_DemandeItineraire;
    private JButton jButton_RetirerVillesEtapes;
    private JButton jButton_SupprimerVillesAEviter;
    private JCheckBox jCheckBox_Autoroutes;
    private JCheckBox jCheckBox_Departementales;
    private JCheckBox jCheckBox_Nationales;
    private JCheckBox jCheckBox_Payant;
    private JCheckBox jCheckBox_Radar;
    private JCheckBox jCheckBox_Touristique;
    private JComboBox jComboBox_VilleArriver;
    private JComboBox jComboBox_VilleDepart;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel_DureeDistance;
    private JLabel jLabel_Max;
    private JLabel jLabel_Min;
    private JLabel jLabel_TypeRoute;
    private JLabel jLabel_VilleArriver;
    private JLabel jLabel_VilleDepart;
    private JLabel jLabel_Vitesse;
    private JList jList_ListeDesVilles;
    private JList jList_VilleEviter;
    private JList jList_VillesEtapes;
    private JPanel jPanel1_Radar;
    private JPanel jPanel_Bas;
    private JPanel jPanel_Centre;
    private JPanel jPanel_ChoixDureeDistance;
    private JPanel jPanel_ChoixTypeRoute;
    private JPanel jPanel_ChoixVitesse;
    private JPanel jPanel_DepartArriver;
    private JPanel jPanel_DeplacerVillesEtapes;
    private JPanel jPanel_DeplacerVillesEviter;
    private JPanel jPanel_DureeDistance;
    private JPanel jPanel_Haut;
    private JPanel jPanel_ListeDesVilles;
    private JPanel jPanel_Payant;
    private JPanel jPanel_Titre;
    private JPanel jPanel_Touristique;
    private JPanel jPanel_TypeRoute;
    private JPanel jPanel_VillesAEviter;
    private JPanel jPanel_VillesEtapes;
    private JPanel jPanel_Vitesse;
    private JRadioButton jRadioButton_Distance;
    private JRadioButton jRadioButton_Duree;
    private JScrollPane jScrollPane_ListeDesVilles;
    private JScrollPane jScrollPane_VillesAEviter;
    private JScrollPane jScrollPane_VillesEtapes;
    private JTextField jTextField_Max;
    private JTextField jTextField_Min; 
	public jPanel_DemandeItineraire() {
        initComponents();
    }
    
    private void initComponents() {
        jPanel_Haut = new JPanel();
        jPanel_DepartArriver = new JPanel();
        jLabel_VilleDepart = new JLabel();
        jComboBox_VilleDepart = new JComboBox();
        jLabel_VilleArriver = new JLabel();
        jComboBox_VilleArriver = new JComboBox();
        jPanel1_Radar = new JPanel();
        jCheckBox_Radar = new JCheckBox();
        jPanel_Touristique = new JPanel();
        jCheckBox_Touristique = new JCheckBox();
        jPanel_Payant = new JPanel();
        jCheckBox_Payant = new JCheckBox();
        jPanel_TypeRoute = new JPanel();
        jLabel_TypeRoute = new JLabel();
        jPanel_ChoixTypeRoute = new JPanel();
        jCheckBox_Nationales = new JCheckBox();
        jCheckBox_Departementales = new JCheckBox();
        jCheckBox_Autoroutes = new JCheckBox();
        jPanel_Vitesse = new JPanel();
        jLabel_Vitesse = new JLabel();
        jPanel_ChoixVitesse = new JPanel();
        jTextField_Min = new JTextField();
        jLabel_Min = new JLabel();
        jTextField_Max = new JTextField();
        jLabel_Max = new JLabel();
        jPanel_DureeDistance = new JPanel();
        jLabel_DureeDistance = new JLabel();
        jPanel_ChoixDureeDistance = new JPanel();
        jRadioButton_Duree = new JRadioButton();
        jRadioButton_Distance = new JRadioButton();
        jPanel_Titre = new JPanel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jPanel_Centre = new JPanel();
        jPanel_VillesEtapes = new JPanel();
        jScrollPane_VillesEtapes = new JScrollPane();
        jList_VillesEtapes = new JList();
        jPanel_DeplacerVillesEtapes = new JPanel();
        jButton_AjouterVillesEtapes = new JButton();
        jButton_RetirerVillesEtapes = new JButton();
        jPanel_ListeDesVilles = new JPanel();
        jScrollPane_ListeDesVilles = new JScrollPane();
        jList_ListeDesVilles = new JList();
        jPanel_DeplacerVillesEviter = new JPanel();
        jButton_AjouterVillesAEviter = new JButton();
        jButton_SupprimerVillesAEviter = new JButton();
        jPanel_VillesAEviter = new JPanel();
        jScrollPane_VillesAEviter = new JScrollPane();
        jList_VilleEviter = new JList();
        jPanel_Bas = new JPanel();
        jButton_DemandeItineraire = new JButton();

        setLayout(new java.awt.BorderLayout());

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel_Haut.setLayout(new GridLayout(8, 0));

        jPanel_DepartArriver.setLayout(new GridLayout());

        jLabel_VilleDepart.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel_VilleDepart.setText("Ville de d\u00e9part : ");
        jPanel_DepartArriver.add(jLabel_VilleDepart);

        jComboBox_VilleDepart.setModel(new DefaultComboBoxModel(new String[] { "Paris", "Orsay", "Bures sur Yvette", "Gif sur Yvette", "Besan\u00e7on", "Belfort", "Montb\u00e9liard", "Sochaux", "Pontarlier", "Marseille", "Aix en Provance", "Monaco", "Lille", "Toulouse", "Lyon", "Saint Etienne" }));
        jPanel_DepartArriver.add(jComboBox_VilleDepart);

        jLabel_VilleArriver.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel_VilleArriver.setText("Ville d'arriv\u00e9 : ");
        jPanel_DepartArriver.add(jLabel_VilleArriver);

        jComboBox_VilleArriver.setModel(new DefaultComboBoxModel(new String[] { "Paris", "Orsay", "Bures sur Yvette", "Gif sur Yvette", "Besan\u00e7on", "Belfort", "Montb\u00e9liard", "Sochaux", "Pontarlier", "Marseille", "Aix en Provance", "Monaco", "Lille", "Toulouse", "Lyon", "Saint Etienne" }));
        jPanel_DepartArriver.add(jComboBox_VilleArriver);

        jPanel_Haut.add(jPanel_DepartArriver);

        jPanel1_Radar.setLayout(new GridLayout());

        jCheckBox_Radar.setText("Eviter les radars");
        jCheckBox_Radar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox_Radar.setMargin(new Insets(0, 0, 0, 0));
        jPanel1_Radar.add(jCheckBox_Radar);

        jPanel_Haut.add(jPanel1_Radar);

        jPanel_Touristique.setLayout(new GridLayout());

        jCheckBox_Touristique.setText("Eviter les tron\u00e7ons et villes touristiques");
        jCheckBox_Touristique.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox_Touristique.setMargin(new Insets(0, 0, 0, 0));
        jPanel_Touristique.add(jCheckBox_Touristique);

        jPanel_Haut.add(jPanel_Touristique);

        jPanel_Payant.setLayout(new GridLayout());

        jCheckBox_Payant.setText("Eviter les tron\u00e7ons payants");
        jCheckBox_Payant.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox_Payant.setMargin(new Insets(0, 0, 0, 0));
        jPanel_Payant.add(jCheckBox_Payant);

        jPanel_Haut.add(jPanel_Payant);

        jPanel_TypeRoute.setLayout(new BorderLayout());

        jLabel_TypeRoute.setText("Favoriser les : ");
        jPanel_TypeRoute.add(jLabel_TypeRoute, BorderLayout.WEST);

        jPanel_ChoixTypeRoute.setLayout(new GridLayout());

        jCheckBox_Nationales.setText("Nationales");
        jCheckBox_Nationales.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox_Nationales.setMargin(new Insets(0, 0, 0, 0));
        jPanel_ChoixTypeRoute.add(jCheckBox_Nationales);

        jCheckBox_Departementales.setText("Departementales");
        jCheckBox_Departementales.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox_Departementales.setMargin(new Insets(0, 0, 0, 0));
        jPanel_ChoixTypeRoute.add(jCheckBox_Departementales);

        jCheckBox_Autoroutes.setText("Autoroutes");
        jCheckBox_Autoroutes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox_Autoroutes.setMargin(new Insets(0, 0, 0, 0));
        jPanel_ChoixTypeRoute.add(jCheckBox_Autoroutes);

        jPanel_TypeRoute.add(jPanel_ChoixTypeRoute, BorderLayout.CENTER);

        jPanel_Haut.add(jPanel_TypeRoute);

        jPanel_Vitesse.setLayout(new BorderLayout());

        jLabel_Vitesse.setText("Vitesse :");
        jPanel_Vitesse.add(jLabel_Vitesse, BorderLayout.WEST);

        jPanel_ChoixVitesse.setLayout(new BoxLayout(jPanel_ChoixVitesse, BoxLayout.X_AXIS));

        jPanel_ChoixVitesse.add(jTextField_Min);

        jLabel_Min.setText("minimal");
        jPanel_ChoixVitesse.add(jLabel_Min);

        jLabel_Max.setText("maximal");
        jPanel_ChoixVitesse.add(jTextField_Max, jTextField_Max.getName());
        jPanel_ChoixVitesse.add(jLabel_Max);

        jPanel_Vitesse.add(jPanel_ChoixVitesse, BorderLayout.CENTER);

        jPanel_Haut.add(jPanel_Vitesse);

        jPanel_DureeDistance.setLayout(new BorderLayout());

        jLabel_DureeDistance.setText("Option de recherche : ");
        jPanel_DureeDistance.add(jLabel_DureeDistance, BorderLayout.WEST);

        jPanel_ChoixDureeDistance.setLayout(new BoxLayout(jPanel_ChoixDureeDistance, BoxLayout.X_AXIS));

        jRadioButton_Duree.setText("Dur\u00e9e minimum");
        jRadioButton_Duree.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton_Duree.setMargin(new Insets(0, 0, 0, 0));
        jPanel_ChoixDureeDistance.add(jRadioButton_Duree);

        jRadioButton_Distance.setText("Distance minimum");
        jRadioButton_Distance.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton_Distance.setMargin(new Insets(0, 0, 0, 0));
        jPanel_ChoixDureeDistance.add(jRadioButton_Distance);

        jPanel_DureeDistance.add(jPanel_ChoixDureeDistance, BorderLayout.CENTER);

        jPanel_Haut.add(jPanel_DureeDistance);

        jPanel_Titre.setLayout(new GridLayout(0, 2));

        jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel10.setText("Villes Etapes : ");
        jPanel_Titre.add(jLabel10);

        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setText("Villes a \u00e9viter :");
        jLabel11.setFocusable(false);
        jPanel_Titre.add(jLabel11);

        jPanel_Haut.add(jPanel_Titre);

        add(jPanel_Haut, BorderLayout.NORTH);

        jPanel_Centre.setLayout(new GridLayout(0, 5));

        jPanel_VillesEtapes.setLayout(new BorderLayout());

        jList_VillesEtapes.setModel(new AbstractListModel() {
            String[] strings = { "Lyon", "Saint Etienne" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane_VillesEtapes.setViewportView(jList_VillesEtapes);

        jPanel_VillesEtapes.add(jScrollPane_VillesEtapes, BorderLayout.CENTER);

        jPanel_Centre.add(jPanel_VillesEtapes);

        jPanel_DeplacerVillesEtapes.setLayout(new BoxLayout(jPanel_DeplacerVillesEtapes, BoxLayout.Y_AXIS));

        jButton_AjouterVillesEtapes.setText("<<");
        jPanel_DeplacerVillesEtapes.add(jButton_AjouterVillesEtapes);

        jButton_RetirerVillesEtapes.setText(">>");
        jPanel_DeplacerVillesEtapes.add(jButton_RetirerVillesEtapes);

        jPanel_Centre.add(jPanel_DeplacerVillesEtapes);

        jPanel_ListeDesVilles.setLayout(new BorderLayout());

        jList_ListeDesVilles.setModel(new AbstractListModel() {
            String[] strings = { "Paris", "Orsay", "Bures sur Yvette", "Gif sur Yvette", "Besan\u00e7on", "Belfort", "Montb\u00e9liard", "Sochaux", "Pontarlier", "Marseille", "Aix en Provance", "Monaco", "Lille", "Toulouse", "Lyon", "Saint Etienne" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane_ListeDesVilles.setViewportView(jList_ListeDesVilles);

        jPanel_ListeDesVilles.add(jScrollPane_ListeDesVilles, BorderLayout.CENTER);

        jPanel_Centre.add(jPanel_ListeDesVilles);

        jPanel_DeplacerVillesEviter.setLayout(new BoxLayout(jPanel_DeplacerVillesEviter, BoxLayout.Y_AXIS));

        jButton_AjouterVillesAEviter.setText(">>");
        jPanel_DeplacerVillesEviter.add(jButton_AjouterVillesAEviter);

        jButton_SupprimerVillesAEviter.setText("<<");
        jPanel_DeplacerVillesEviter.add(jButton_SupprimerVillesAEviter);

        jPanel_Centre.add(jPanel_DeplacerVillesEviter);

        jPanel_VillesAEviter.setLayout(new BorderLayout());

        jList_VilleEviter.setModel(new AbstractListModel() {
            String[] strings = { "Bures sur Yvette", "Gif sur Yvette" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane_VillesAEviter.setViewportView(jList_VilleEviter);

        jPanel_VillesAEviter.add(jScrollPane_VillesAEviter, BorderLayout.CENTER);

        jPanel_Centre.add(jPanel_VillesAEviter);

        add(jPanel_Centre, BorderLayout.CENTER);

        jButton_DemandeItineraire.setText("Calculer les itineraires");
        jPanel_Bas.add(jButton_DemandeItineraire);

        add(jPanel_Bas, BorderLayout.SOUTH);

    }
    
    private void formMouseClicked(MouseEvent evt) {                                  
    }                                 
    
                       
               
    
}
