package com.ifips.walletOptimiser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Probleme {
	private Fonction fonctionObjective;
	private List<Contrainte> mesContraintes;
	
	public Probleme(Fonction fctObj){
		fonctionObjective = fctObj;
		mesContraintes = new ArrayList<Contrainte>();		
	}
	
	public void ajouterContrainte(Contrainte c) throws Exception{
//		for (Iterator it = c.partieGauche.getLaVariable().getMesNomVariables().iterator(); it.hasNext();) {
//			String el = (String) it.next();
//			if(!fonctionObjective.getLaVariable().contains(el)){
//				throw new Exception("Probleme " + el +
//						" : Tentative d'ajout de contrainte ayant de variable incunnu du problème.");
//			}
//		}
		mesContraintes.add(c);		
	}

	public Fonction getFonctionObjective() {
		return fonctionObjective;
	}

	public List<Contrainte> getMesContraintes() {
		return mesContraintes;
	}
	
	public void afficherProbleme(){
		System.out.println("Fonction objective : ");
		fonctionObjective.afficher();
		System.out.println();
		System.out.println("Sous les contraintes : ");
		for (Iterator iter = mesContraintes.iterator(); iter.hasNext();) {
			Contrainte element = (Contrainte) iter.next();
			element.afficher();
			System.out.println();
		}
	}
	
//	public Solution getSolutionInitiale() {
//		// TODO ben tout...
//		return new Solution(this);
//	}

//		public Solution getSolutionInitial() {
//		int i = 0;
//		Solution solutionRetour = new Solution(this);
//		LinkedList<Double> valeur = new LinkedList<Double>();
//		String variableAModifier;
//		double valeurModifiante = 0;
//		long debut,fin;
//		int nbContrainteRealise;
//		int nbtest = 0;
//		for (Iterator iter = fonctionObjective.getLaVariable().getMesNomVariables().iterator(); iter.hasNext();) {
//			String element = (String) iter.next();
//			valeur.add(0.0);
//		}
//		try {
//			solutionRetour.setSolution(valeur, fonctionObjective.getLaVariable());
//			while(!solutionRetour.estAdmissible()){
//				nbContrainteRealise = solutionRetour.getNbContrainteRespecter();
//				variableAModifier = fonctionObjective.getLaVariable().getMesNomVariables().get(i);
//				debut = System.currentTimeMillis();
//				nbtest = 0;
//				do{
//					valeurModifiante += 0.00001;
//					solutionRetour.modifierVariable(variableAModifier,i);
//					nbtest++;
//					fin = System.currentTimeMillis();
//					//System.out.println((fin-debut));
//				}while((fin-debut)<200 || nbContrainteRealise<solutionRetour.getNbContrainteRespecter());
//				
//				i++;
//				valeurModifiante=0;
//				System.out.println("nombre de test : " + nbtest);
//				System.out.println("nb contrainte satisfaite " + nbContrainteRealise);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// TODO Auto-generated method stub
//		return solutionRetour;
//	}

}
