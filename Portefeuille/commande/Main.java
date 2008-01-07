package commande;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.ifips.walletOptimiser.Contrainte;
import com.ifips.walletOptimiser.ContrainteEgale;
import com.ifips.walletOptimiser.ContrainteInferieur;
import com.ifips.walletOptimiser.ContrainteSuperieur;
import com.ifips.walletOptimiser.Domaine;
import com.ifips.walletOptimiser.DomaineBorne;
import com.ifips.walletOptimiser.DomaineFerme;
import com.ifips.walletOptimiser.Fonction;
import com.ifips.walletOptimiser.FonctionConstante;
import com.ifips.walletOptimiser.FonctionQuadratique;
import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.ProblemeDeterministe;
import com.ifips.walletOptimiser.Solution;
import com.ifips.walletOptimiser.Variable;
import com.ifips.walletOptimiser.algo.Aleatoire;
import com.ifips.walletOptimiser.algo.Lagrange;
import com.ifips.walletOptimiser.algo.MonCPLEX;
import com.ifips.walletOptimiser.algo.RecuitSimule;
import com.ifips.walletOptimiser.algo.VNS;
import com.ifips.walletOptimiser.fenetrePrincipale.FenetreIHM;
import com.ifips.walletOptimiser.outils.ChargeurFichier;

public class Main {
	
	private static FenetreIHM fen = new FenetreIHM();
	private static RecuitSimule algoRecuit = null;
	private static VNS algoVNS = null;
	private static Lagrange algoLagr = null;
	private static MonCPLEX algoCPLEX = null;

	private static Probleme genererProbleme1(){
		Probleme leProb;
		Fonction f1;
		Fonction f2;
		Contrainte a1;
		Domaine domaineY;
		Domaine domaineX = new DomaineBorne(0.0,1.0);
		ArrayList<Double> dY=new ArrayList<Double>();
		dY.add(0.0);
		dY.add(1.0);
		domaineY = new DomaineFerme(dY);
		
		
		// Déclaration des variables
		Variable variableX=new Variable("x", 2, domaineX);
		Variable variableY=new Variable("y", 2, domaineY);
		// Fonction Obj
		ArrayList<Double> sigma=new ArrayList<Double>();
		sigma.add(1.0);
		sigma.add(2.0);
		sigma.add(3.0);
		sigma.add(4.0);
		FonctionQuadratique foncObj=null;
		try {
			foncObj=new FonctionQuadratique(variableX, variableX, sigma);
		} catch (Exception e) {	e.printStackTrace(); }
		leProb=new Probleme(foncObj);
		
		
		// Contrainte 1a
		ArrayList<Double> identite=new ArrayList<Double>();
		identite.add(1.0);
		identite.add(1.0);
		try {
			f1=new Fonction(variableX, identite);
			a1=new ContrainteEgale(f1, new FonctionConstante(1.0));
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1b
		ArrayList<Double> mu=new ArrayList<Double>();
		mu.add(2.0);
		mu.add(2.0);
		try {
			f1=new Fonction(variableX, mu);
			a1=new ContrainteSuperieur(f1, new FonctionConstante(1.0));
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1c
		try {
			f1=new Fonction(variableY, identite);
			a1=new ContrainteEgale(f1, new FonctionConstante(2.0));
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
		//Contrainte 1d		
		ArrayList<Double> epsilon=new ArrayList<Double>();
		ArrayList<Double> delta=new ArrayList<Double>();
		ArrayList<Double> constante=new ArrayList<Double>();
		
		for(int i = 0; i<variableX.getDimension(); i++){
			epsilon=new ArrayList<Double>();
			delta=new ArrayList<Double>();
			constante=new ArrayList<Double>();
			for(int j = 0; j<variableX.getDimension(); j++){
				epsilon.add(0.0);
				delta.add(0.0);
				constante.add(0.0);
			}
			epsilon.set(i, 0.1);
			constante.set(i, 1.0);
			delta.set(i,0.9);
			try{
				f1 = new Fonction(variableY,epsilon);
				f2 = new Fonction(variableX, constante);
				a1 = new ContrainteInferieur(f1,f2);
				leProb.ajouterContrainte(a1);
				f1 = new Fonction(variableY,delta);
				a1 = new ContrainteInferieur(f2,f1);
				leProb.ajouterContrainte(a1);
			}catch(Exception e) { e.printStackTrace(); }
		}
		// Fin contrainte 1d
		
		
		leProb.afficherProbleme();
		
		Aleatoire algoAleat=new Aleatoire(leProb);
		Solution solInitiale=algoAleat.resoudre();
		
		System.out.println("Solution trouvée aléatoirement");
		if(solInitiale!=null)
			solInitiale.afficher();
		System.out.println("+ Coût de cette solution : "+algoAleat.getSolCourante().getCout());
		
		RecuitSimule algoRecuit=new RecuitSimule(leProb);
		
		// MODIF CLEM
		fen.setRecuit(algoRecuit);
		
		algoRecuit.resoudre();
		System.out.println("Solution trouvée par la méthode du recuit");
		algoRecuit.getSolCourante().afficher();
		System.out.println("+ Coût de cette solution : "+algoRecuit.getSolCourante().getCout());
		
		VNS algoVNS = new VNS(leProb);
		
		// MODIF CLEM
		fen.setVNS(algoVNS);
		
		algoVNS.resoudre();
		System.out.println("Solution trouvée par la méthode de VNS");
		algoVNS.getSolCourante().afficher();
		System.out.println("+ Coût de cette solution : "+algoVNS.getSolCourante().getCout());
		
		System.out.println("Fin.");
		
		return null;
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ChargeurFichier reader = new ChargeurFichier("fichiers/DAX.txt");
		ProblemeDeterministe pbDet = new ProblemeDeterministe(2/*reader.getNbrTitres()*/);
		fen.setFonctionObjectif(pbDet.getLeProbleme().getFonctionObjective().toString());
		fen.setContraintes(pbDet.contraintesToString());
		
		// Création des objets de résolution
		algoRecuit=new RecuitSimule(pbDet.getLeProbleme());
		algoRecuit.setFenetreDeSortie(fen);
		fen.setRecuit(algoRecuit);
		
		algoVNS=new VNS(pbDet.getLeProbleme());
		algoVNS.setFenetreDeSortie(fen);
		fen.setVNS(algoVNS);

//		algoLagr=new Lagrange(pbDet.getLeProbleme(),pbDet.getContrainteRelaxee());
//		fen.setLagrange(algoLagr);
		
//		algoCPLEX=new MonCPLEX(pbDet.getLeProbleme());
//		fen.setCPLEX(algoCPLEX);
		
		//genererProbleme1();
		
		fen.setVisible(true);
	}
}
