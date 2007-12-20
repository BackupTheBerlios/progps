package com.ifips.walletOptimiser.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import com.ifips.walletOptimiser.Contrainte;
import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;
import com.ifips.walletOptimiser.Variable;

/**
 * Classe pour trouver alléatoirement une solution
 *
 */
public class Aleatoire extends Algorithme {

	public Aleatoire(Probleme p){
		super(p);
	}


	@Override
	public Solution resoudre() {
		solCourante=null;
		// Recherche de toutes les variables
		HashSet<Variable> varUtilisees=new HashSet<Variable>();
		varUtilisees.add(pbCourant.getFonctionObjective().getLaVariable());
		for (Contrainte uneContrainte : pbCourant.getMesContraintes()) {
			varUtilisees.add(uneContrainte.getPartieGauche().getLaVariable());
		}
		ArrayList<Variable> sesVariables=new ArrayList<Variable>(varUtilisees);
		int nbrDeVariablesModifiees=1+(sesVariables.size()/10);
		double variationMax=0.1;

		// Initialies tous les vecteurs à 0
		ArrayList<ArrayList<Double>> lesValeurs=new ArrayList<ArrayList<Double>>();
		int i=0;
		for (Variable uneVar : sesVariables) {
			ArrayList<Double> unVecteur=new ArrayList<Double>();
			for (int j = 0; j < uneVar.getDimension(); j++) {
				unVecteur.add(0.0);
			}
			lesValeurs.add(unVecteur);
			i++;
		}
		try{
			solCourante=new Solution(pbCourant, sesVariables, lesValeurs);

			Random randomise=new Random();

			ArrayList<Double> unVecteur;
			while(!solCourante.estAdmissible()){
				// On modifie autant de variables que demandé
				for (i = 0; i < nbrDeVariablesModifiees; i++) {
					int j=randomise.nextInt(sesVariables.size());
					unVecteur = lesValeurs.get(j);
					int k=0;
					for (Iterator iter = unVecteur.iterator(); iter.hasNext();) {
						Double uneVal = (Double) iter.next();
						//System.out.println(uneVal);
						uneVal = sesVariables.get(j).getMonDomaine().getValeurAleatoire(uneVal, variationMax);
						//uneVal=uneVal+(randomise.nextDouble()*variationMax)-(randomise.nextDouble()*variationMax);
						unVecteur.set(k, uneVal);
						k++;
					}
					lesValeurs.set(j, unVecteur);
				}
				solCourante.setSolution(sesVariables, lesValeurs);
			}
		}
		catch(Exception e){ System.err.println(e.getMessage());;}
		return solCourante;
	}

}
