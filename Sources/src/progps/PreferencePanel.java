package progps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import progps.PreferenceChoixPanel;

public class PreferencePanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	public PreferencePanel(String[] choix, LinkedList<String> ordre) {
		super();
		initialize(choix,ordre);
	}

	public void ajout(Object choix){
		ordre.remove(choix);
		jPanel1.removeAll();
		jPanel2.removeAll();
		jPanel3.removeAll();
		jPanel1.repaint();
		jPanel2.repaint();
		jPanel3.repaint();
		removeAll();
		initialize(this.choix,ordre);
	}
	
	private void panelMouseClicked(MouseEvent evt) {
		System.out.println(((PreferenceChoixPanel)evt.getSource()).getOrdre());
	}

	public void supp(){
		ordre.add(choix[0]);
		jPanel1.removeAll();
		jPanel2.removeAll();
		jPanel3.removeAll();
		jPanel1.repaint();
		jPanel2.repaint();
		jPanel3.repaint();
		removeAll();
		initialize(this.choix,ordre);
	}


	private void initialize(String[] choix, LinkedList<String> ordre) {
		int i = 0;
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		listeChoix = new LinkedList<PreferenceChoixPanel>();
		
		this.ordre = ordre;
		this.choix = choix;
		
		
		for(i = 0; i < ordre.size();i++){
			listeChoix.add(new PreferenceChoixPanel(this,(i+1),ordre.get(i),choix));
			listeChoix.get(i).addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                panelMouseClicked(evt);
	            }
	        });
		}
		if(ordre.size()<7){
			listeChoix.add(new PreferenceChoixPanel(this,i+=1,choix));
		}
		System.out.println(listeChoix.size());
		setLayout(new java.awt.GridLayout(3, 0, 5, 5));

		jPanel1.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

		for(i = 0; (i < listeChoix.size() && i<3);i++){
			jPanel1.add(listeChoix.get(i));
		}

		add(jPanel1);

		jPanel2.setLayout(new java.awt.GridLayout(0, 3, 5, 5));
		
		for(i = 3; (i < listeChoix.size() && i<6);i++){
			jPanel2.add(listeChoix.get(i));
		}

		add(jPanel2);

		jPanel3.setLayout(new java.awt.GridLayout(0, 3, 5, 5));
		
		for(i = 6; (i < listeChoix.size() && i<7);i++){
			jPanel3.add(listeChoix.get(i));
		}

		add(jPanel3);

	}

	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private LinkedList<PreferenceChoixPanel> listeChoix;  //  @jve:decl-index=0:
	private LinkedList<String> ordre;  //  @jve:decl-index=0:
	private String[] choix;
}
