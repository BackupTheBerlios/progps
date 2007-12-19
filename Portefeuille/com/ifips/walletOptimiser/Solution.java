package com.ifips.walletOptimiser;

import java.util.Iterator;
import java.util.List;

public class Solution {
	private Probleme monProbleme;

	private List<Double> valeur;

	private Variable variable;


	public Solution(Probleme p) {
		monProbleme = p;
	}

	public void setSolution(List<Double> val, Variable var) throws Exception {
		int compteurVariable = 0;
		
		if (val.size() != var.getDimension()) {
			throw new Exception(
					"Solution : Le nombre de variable et le nombre de valeur proposé n'est pas égale.");
		}
		
		
		for (Iterator it = var.getMesNomVariables().iterator(); it.hasNext();) {
			String element = (String) it.next();
			if (!monProbleme.getFonctionObjective().getMesVariables()
					.contains(element)) {
				throw new Exception(
						"Solution : Une variable dans solution proposé est inéxistante dans le problème.");
			}
			compteurVariable++;
		}

		
		if (compteurVariable!=monProbleme.getFonctionObjective().getMesVariables().getDimension()) {
			throw new Exception(
					"Solution : La solution proposé ne donne pas de valeur pour toutes les variables du problème.");
		}
		valeur = val;
		variable = var;
	}

	public boolean estAdmissible() throws Exception {
		int partieGauche;
		boolean valeurRetour=true;
		for (Iterator it = monProbleme.getMesContraintes().iterator(); it.hasNext();) {
			Contrainte element = (Contrainte) it.next();
			partieGauche=element.calculerPartieGauche(valeur, variable);
			if(element.getClass()==ContrainteEgale.class){
				valeurRetour = valeurRetour && (partieGauche == element.getPartieDroite());
			}else if(element.getClass()==ContrainteSuperieur.class){
				valeurRetour = valeurRetour && (partieGauche > element.getPartieDroite());
			}else if(element.getClass()==ContrainteInferieur.class){
				valeurRetour = valeurRetour && (partieGauche < element.getPartieDroite());
			}else{
				throw new Exception("Solution : Contrainte non prise en charge");
			}
		}
		return valeurRetour;
	}

	public void afficher() {
		int i=0;
		for (Iterator iter = variable.getMesNomVariables().iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			System.out.print(element + " = " + valeur.get(i) +"; ");
			i++;
		}
		System.out.println();
		if(!tousDefini()){
			System.err.println("Attention cette solution ne donne pas de valeur à toutes les variables");
		}
		
	}

	public int getCout() throws Exception {
		int i=0;
		int position;
		int somme = 0;
		double[] mesVal;
		if(valeur.size()!=0){
			if(tousDefini()){
			mesVal = new double[monProbleme.getFonctionObjective().getMesVariables().getDimension()];
			for (Iterator it = variable.getMesNomVariables().iterator(); it.hasNext();) {
				String element = (String) it.next();
				position = monProbleme.getFonctionObjective().getMesVariables().getPosition(element);
				mesVal[position] = valeur.get(i);
				i++;
			}
			for (int j = 0; j < valeur.size(); j++) {
				somme += monProbleme.getFonctionObjective().getMesPoids().getValeur(j) * mesVal[j];
			}
			return somme;
			}else 
				throw new Exception("Solution : Solution incomplete.");
		}else{
			throw new Exception("Solution : Aucune valeur de solution n'a été fournie.");
		}
		
	}

	private boolean tousDefini() {
		for (Iterator iter = monProbleme.getFonctionObjective().getMesVariables().getMesNomVariables().iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			if(!variable.contains(element))
				return false;
		}
		return true;
	}

	public int getNbContrainteRespecter() throws Exception {
		int partieGauche;
		int valeurRetour=0;
		for (Iterator it = monProbleme.getMesContraintes().iterator(); it.hasNext();) {
			Contrainte element = (Contrainte) it.next();
			partieGauche=element.calculerPartieGauche(valeur, variable);
			if(element.getClass()==ContrainteEgale.class){
				if(partieGauche == element.getPartieDroite())
					valeurRetour++;
			}else if(element.getClass()==ContrainteSuperieur.class){
				if(partieGauche > element.getPartieDroite())
					valeurRetour++;
			}else if(element.getClass()==ContrainteInferieur.class){
				if(partieGauche < element.getPartieDroite())
					valeurRetour++;
			}else{
				throw new Exception("Solution : Contrainte non prise en charge");
			}
		}
		return valeurRetour;
	}

	public void modifierVariable(String variableAModifier, double valeur) {
		int position = variable.getPosition(variableAModifier);
		this.valeur.set(position, valeur);
	}

}
