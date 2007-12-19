package commande;

import java.util.*;

import com.ifips.walletOptimiser.Constante;
import com.ifips.walletOptimiser.Contrainte;
import com.ifips.walletOptimiser.ContrainteInferieur;
import com.ifips.walletOptimiser.ContrainteSuperieur;
import com.ifips.walletOptimiser.Fonction;
import com.ifips.walletOptimiser.Operande;
import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;
import com.ifips.walletOptimiser.Variable;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Solution uneSolution;
		Probleme monProbleme;
		Fonction fonctionObjective;
		Fonction f1;
		Constante constante = new Constante();
		Variable variable = new Variable();
		List<Double> valeur = new Vector<Double>();
		Contrainte c1;
		
		
		
		
		constante.add(1);
		constante.add(2);
		constante.add(3);
		constante.add(2);
		constante.add(4);
		constante.add(1);
		
		variable.add("x1");
		variable.add("x2");
		variable.add("x3");
		variable.add("x4");
		variable.add("x5");
		variable.add("x6");
		
		fonctionObjective = new Fonction(variable, constante);
		monProbleme = new Probleme(fonctionObjective);
		
		constante = new Constante();
		variable = new Variable();
		constante.add(1);
		constante.add(4);
		constante.add(3);

		variable.add("x1");
		variable.add("x2");
		variable.add("x6");
		
		f1 = new Fonction(variable, constante);
		
		c1 = new ContrainteInferieur(f1, 0);
		
		monProbleme.ajouterContrainte(c1);
		c1 = new ContrainteInferieur(f1, 30);
		
		monProbleme.ajouterContrainte(c1);
		uneSolution = new Solution(monProbleme);
		
		
		variable = new Variable();
		valeur.add(0.0);
		valeur.add(1.0);
		valeur.add(1.0);
		valeur.add(1.0);
		valeur.add(1.0);
		valeur.add(1.0);
		
		variable.add("x2");
		variable.add("x1");
		variable.add("x3");
		variable.add("x4");
		variable.add("x5");
		variable.add("x6");
		
		monProbleme.afficherProbleme();
		
		uneSolution.setSolution(valeur,variable);
		//monProbleme.getFonctionObjective().ajouterVariable("x7",9);
		
		System.out.println("Solution :");
		uneSolution.afficher();
		if(uneSolution.estAdmissible()){
			System.out.println("Cette solution est admissible.");
			int cout = uneSolution.getCout();
			System.out.println("Cout de cette solution : " + cout);
		}else 
			System.out.println("Cette solution n'est pas admissible.");
		//uneSolution = monProbleme.getSolutionInitial();
		}

}
