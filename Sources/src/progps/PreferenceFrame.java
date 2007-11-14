package progps;

import java.util.LinkedList;

public class PreferenceFrame extends javax.swing.JFrame {
    
    public PreferenceFrame() {
        initComponents();
    }

    private void initComponents() {
    	String[] liste = {"Prix","Radar","Villes à éviter","Villes étapes","Vitesse","Type de route","Touristique"};
    	LinkedList<String> choix = new LinkedList<String>();
    	choix.add("Prix");
    	choix.add("Radar");
    	choix.add("Vitesse");
    	choix.add("Type de route");

        preferencePanel1 = new PreferencePanel(liste,choix);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(preferencePanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreferenceFrame().setVisible(true);
            }
        });
    }
    
    private PreferencePanel preferencePanel1;    
}
