package commande;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.ifips.walletOptimiser.Solution;
import com.ifips.walletOptimiser.Variable;
import com.ifips.walletOptimiser.algo.Aleatoire;
import com.ifips.walletOptimiser.algo.RecuitSimule;

public class Main {

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
//		try {
//			f1=new Fonction(variableX, identite);
//			a1=new ContrainteEgale(f1, 1.0);
//			leProb.ajouterContrainte(a1);
//		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1b
		ArrayList<Double> mu=new ArrayList<Double>();
		mu.add(1.0);
		mu.add(1.0);
		try {
			f1=new Fonction(variableX, mu);
			a1=new ContrainteEgale(f1, new FonctionConstante(1.0));
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1c
		try {
			f1=new Fonction(variableY, identite);
			a1=new ContrainteSuperieur(f1, new FonctionConstante(1.0));
			leProb.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
		//Contrainte 1d
		
		ArrayList<Double> epsilon=new ArrayList<Double>();
		ArrayList<Double>delta=new ArrayList<Double>();
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
		
		
		
		
		leProb.afficherProbleme();
//		RecuitSimule recuit=new RecuitSimule(leProb);
//		System.out.println(recuit.kirkPatrick());
		
		
		Aleatoire algoAleat=new Aleatoire(leProb);
//		
//		Solution solInitiale=algoAleat.resoudre();
//		if(solInitiale!=null)
//			solInitiale.afficher();
//		System.out.println("fini");
//		
		return null;
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
				
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
