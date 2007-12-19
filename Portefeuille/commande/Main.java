package commande;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.ifips.walletOptimiser.Contrainte;
import com.ifips.walletOptimiser.ContrainteInferieur;
import com.ifips.walletOptimiser.Fonction;
import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;
import com.ifips.walletOptimiser.Variable;

public class Main {

//	private Probleme genererProbleme1(){
//		// Déclaration des variables
//		Variable variableX=new Variable("x", 5);
//		Variable variableY=new Variable("y", 5);
//	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Solution uneSolution;
		Probleme monProbleme;
		Fonction fonctionObjective;
		Fonction f1;
//		Constante constante = new Constante();
//		Variable variable = new Variable();
		List<Double> valeurs = new Vector<Double>();
		Contrainte c1;
		
		
		// Déclaration d'une variable
		Variable variableX=new Variable("x", 5);
		// Déclaration d'un vecteur de poids
		ArrayList<Double> vecteurPoids=new ArrayList<Double>();
		vecteurPoids.add(1.0);
		vecteurPoids.add(2.0);
		vecteurPoids.add(6.0);
		vecteurPoids.add(7.0);
		vecteurPoids.add(100.0);
		// Déclaration d'une fonction : x1 + 2x2 + 6x3 + 7x4 + 100x5
		fonctionObjective=new Fonction(variableX, vecteurPoids);
		// Déclaration d'un problème
		monProbleme=new Probleme(fonctionObjective);
		
		// Déclaration d'un autre vecteur poids
		vecteurPoids=new ArrayList<Double>();
		vecteurPoids.add(0.0);
		vecteurPoids.add(1.0);
		vecteurPoids.add(6.0);
		vecteurPoids.add(0.0);
		vecteurPoids.add(8.0);
		f1=new Fonction(variableX, vecteurPoids);
		//Ajoute une contrainte au pb
		monProbleme.ajouterContrainte(new ContrainteInferieur(f1, 10.0));
		
		monProbleme.afficherProbleme();
		
		// Création d'une solution
		ArrayList<Variable> listeDeVariables=new ArrayList<Variable>();
		listeDeVariables.add(variableX);
		// Création des valeurs de x
		ArrayList<Double> vecteurValeursX=new ArrayList<Double>();
		vecteurValeursX.add(10.0);
		vecteurValeursX.add(2.0);
		vecteurValeursX.add(0.0);
		vecteurValeursX.add(6.0);
		vecteurValeursX.add(1.0);
		// Création de la liste de vecteur
		ArrayList<ArrayList<Double>> listeDeVecteurValeur=new ArrayList<ArrayList<Double>>();
		listeDeVecteurValeur.add(vecteurValeursX);
		
		uneSolution=new Solution(monProbleme, listeDeVariables, listeDeVecteurValeur);
		
		System.out.println();
		System.out.println("**********");
		uneSolution.afficher();
		System.out.println("Est admissible : "+uneSolution.estAdmissible());
		System.out.println("Coût :"+uneSolution.getCout());
		
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
