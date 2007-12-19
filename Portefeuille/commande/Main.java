package commande;

import java.util.ArrayList;

import com.ifips.walletOptimiser.Contrainte;
import com.ifips.walletOptimiser.ContrainteEgale;
import com.ifips.walletOptimiser.ContrainteSuperieur;
import com.ifips.walletOptimiser.Fonction;
import com.ifips.walletOptimiser.FonctionQuadratique;
import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;
import com.ifips.walletOptimiser.Variable;
import com.ifips.walletOptimiser.algo.Aleatoire;

public class Main {

	private static Probleme genererProbleme1(){
		Probleme leProb;
		Fonction f1;
		Contrainte a1;
		
		// Déclaration des variables
		Variable variableX=new Variable("x", 2);
		Variable variableY=new Variable("y", 2);
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
//		try {
//			f1=new Fonction(variableX, identite);
//			a1=new ContrainteEgale(f1, 1.0);
//			leProb.ajouterContrainte(a1);
//		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1b
		ArrayList<Double> mu=new ArrayList<Double>();
		mu.add(20.0);
		mu.add(21.0);
		try {
			f1=new Fonction(variableX, mu);
			a1=new ContrainteSuperieur(f1, 200.0);
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1c
		try {
			f1=new Fonction(variableY, identite);
			a1=new ContrainteSuperieur(f1, 3.0);
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
		
		leProb.afficherProbleme();
		Aleatoire algoAleat=new Aleatoire(leProb);
		
		Solution solInitiale=algoAleat.resoudre();
		if(solInitiale!=null)
			solInitiale.afficher();
		System.out.println("fini");
		
		return null;
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
				
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Notre PB :");
		
		genererProbleme1();
		
		
		
//		constante.add(1);
//		constante.add(2);
//		constante.add(3);
//		constante.add(2);
//		constante.add(4);
//		constante.add(1);
//		
//		variable.add("x1");
//		variable.add("x2");
//		variable.add("x3");
//		variable.add("x4");
//		variable.add("x5");
//		variable.add("x6");
//		
//		fonctionObjective = new Fonction(variable, constante);
//		monProbleme = new Probleme(fonctionObjective);
//		
//		constante = new Constante();
//		variable = new Variable();
//		constante.add(1);
//		constante.add(4);
//		constante.add(3);
//
//		variable.add("x1");
//		variable.add("x2");
//		variable.add("x6");
//		
//		f1 = new Fonction(variable, constante);
//		
//		c1 = new ContrainteInferieur(f1, 0);
//		
//		monProbleme.ajouterContrainte(c1);
//		c1 = new ContrainteInferieur(f1, 30);
//		
//		monProbleme.ajouterContrainte(c1);
//		uneSolution = new Solution(monProbleme);
//		
//		
//		variable = new Variable();
//		valeur.add(0.0);
//		valeur.add(1.0);
//		valeur.add(1.0);
//		valeur.add(1.0);
//		valeur.add(1.0);
//		valeur.add(1.0);
//		
//		variable.add("x2");
//		variable.add("x1");
//		variable.add("x3");
//		variable.add("x4");
//		variable.add("x5");
//		variable.add("x6");
//		
//		monProbleme.afficherProbleme();
//		
//		uneSolution.setSolution(valeur,variable);
//		//monProbleme.getFonctionObjective().ajouterVariable("x7",9);
//		
//		System.out.println("Solution :");
//		uneSolution.afficher();
//		if(uneSolution.estAdmissible()){
//			System.out.println("Cette solution est admissible.");
//			int cout = uneSolution.getCout();
//			System.out.println("Cout de cette solution : " + cout);
//		}else 
//			System.out.println("Cette solution n'est pas admissible.");
//		//uneSolution = monProbleme.getSolutionInitial();
		}

}
