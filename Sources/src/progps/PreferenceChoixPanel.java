package progps;

import javax.swing.JButton;

public class PreferenceChoixPanel extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 1L;
    public PreferenceChoixPanel() {
        initComponents();
    }
    
    public PreferenceChoixPanel(PreferencePanel p, int o, String c, String [] listeChoix) {
        initComponents();
        parent = p;
        jLabel_Order.setText(Integer.toString(o));
        jComboBox_Choix.setModel(new javax.swing.DefaultComboBoxModel(listeChoix));
        jComboBox_Choix.setSelectedItem(c);
    }
    
    public PreferenceChoixPanel(PreferencePanel p, int o, String [] listeChoix) {
        initComponents();
        parent = p;
        jLabel_Order.setText(Integer.toString(o));
        jComboBox_Choix.setModel(new javax.swing.DefaultComboBoxModel(listeChoix));
        jComboBox_Choix.setVisible(false);
        ajoute=false;
        jButton_Effet.setText("Ajouter une préférence");
    }
    

    public void setOrdre(int ordre){
        jLabel_Order.setText(Integer.toString(ordre));
    }
    
    public void setSupprimer(){
        ajoute=true;
        jComboBox_Choix.setVisible(true);
        parent.supp();
        jButton_Effet.setText("Supprimer la préférence");
    }
    
    public void setAjouter(){
        ajoute=false;
        jComboBox_Choix.setVisible(false);
        parent.ajout(jComboBox_Choix.getSelectedItem());
        jButton_Effet.setText("Ajouter une préférence");
    }
    
    public JButton getButton(){
        return jButton_Effet;
    }
    
    public int getOrdre(){
        return (Integer.getInteger(jLabel_Order.getText()));
    }
    
    public String getChoix(){
        return jComboBox_Choix.getSelectedItem().toString();
    }
    
    public void setChoix(String valeur){
        jComboBox_Choix.setSelectedItem(valeur);
    }
    

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton_Effet = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel_Order = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox_Choix = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        add(jPanel1, java.awt.BorderLayout.WEST);

        add(jPanel2, java.awt.BorderLayout.EAST);

        jButton_Effet.setText("Supprimer la pr\u00e9f\u00e9rence");
        jButton_Effet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EffetActionPerformed(evt);
            }
        });

        jPanel3.add(jButton_Effet);

        add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel4.add(jLabel_Order);

        add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.add(jComboBox_Choix);

        add(jPanel5, java.awt.BorderLayout.CENTER);

    }

    private void jButton_EffetActionPerformed(java.awt.event.ActionEvent evt) {
       if(ajoute){
           setAjouter();
       }else{
           setSupprimer();
       }
    }
    
    private boolean ajoute = true;
    private PreferencePanel parent;
    private javax.swing.JButton jButton_Effet;
    private javax.swing.JComboBox jComboBox_Choix;
    private javax.swing.JLabel jLabel_Order;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    
}
