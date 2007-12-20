package com.ifips.walletOptimiser.algo;

import java.util.*;

import com.ifips.walletOptimiser.*;


public class Lagrange extends Algorithme {

	
	/*Resoudre() :Solution 
		 *double lambda := 0 
		 *Lagrangien(pbCourant, contrainteRelaxe) ; //initialise la fonction lagrangienne 
		 *sousPb = calculerSousPb(lambda) ; //les donn�es n�cessaires sont d�j� pr�sentes en attributs 
		 *initialiserDual() ; // initialise un dual vide, sans contraintes 
		 *MonCplex cPPrimal = new MonCplex(sousPb) ; 
		 *MonCPlex cPDual = new MonCplex(dual); 
		 *solCourante = cPPrimal.resoudre() ; ; // on utilise CPlex pour calculer X1 
		 *solDual = new Solution() ; //on cr�e une solution avec un coefficient lagrangien �gal � 0, sans co�t initial 
		 *loop 
		 *	ajouterContrainteDual(solCourante) ; // une contrainte est ajout�e dans le dual 
		 *	solDual = cPDual.resoudre() ; // met � jour la valeur de solDual (coeffLagrangien et cout) 
		 *	modifierCoeffLagrangien(lambda=solDual.getvalue(lambda)) ; 
		 *	solCourante = cPPrimal.resoudre() ; 
		 *	if (solCourante.getCout()==solDual.getCout()) // � plus ou moins un pourcentage r�gl� par l�utilisateur 
		 *		break ; 
		 *end loop 
		 *retourne solCourante ;
	*/
	private Solution solDuale;
	private FonctionLagrange fctLagrangienne;
	private Probleme dual;
	private Probleme sousPb;
	
	
	
	
	private Lagrange(Probleme pbCourant, Contrainte contrainteRelaxe) throws Exception {
		super(pbCourant);
		this.sousPb=pbCourant;
		this.fctLagrangienne=new FonctionLagrange(pbCourant.getFonctionObjective().getLaVariable(), pbCourant.getFonctionObjective().getMesPoids(), contrainteRelaxe);
	}
	
	
	public Solution resoudre() {
		double lambda=0.0;
		double z=0.0;
		try {
			Aleatoire ale=new Aleatoire(sousPb);
			solCourante=ale.resoudre();
			z=fctLagrangienne.getValeur(solCourante.getValeursDeVariable(sousPb.getFonctionObjective().getLaVariable()), lambda);
			initialiserDual();
			solDuale=new Solution(dual);
			while (solCourante.getCout()!=solDuale.getCout()) {
				ajouterContrainteDual(solCourante);
				ale.setPbCourant(dual);
				solDuale=ale.resoudre();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void initialiserDual() {
		List<Double>l = new ArrayList<Double>();
		l.add(0.0);
		try {
			dual=new Probleme(new Fonction(new Variable("w",1), l));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ajouterContrainteDual(Solution s) {
		// TODO la m�thode...
	}
	
	public boolean verifierOptimalite() {
		return true;
	}
	
	
}
