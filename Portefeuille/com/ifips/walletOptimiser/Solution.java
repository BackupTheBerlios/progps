package com.ifips.walletOptimiser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
	private Probleme monProbleme;
	private ArrayList<Variable> sesVariables;
	private ArrayList<ArrayList<Double>> sesValeurs;
	private Variable variable;


	public Solution(Probleme p) {
		monProbleme = p;
	}
	
	public Solution(Probleme p,ArrayList<Variable> var, ArrayList<ArrayList<Double>> val) throws Exception {
		monProbleme = p;
		if(var.size()!=val.size())
			throw new Exception("Solution : impossible de cr�er une solution qui n'a pas les valeurs pour toutes les variables");

		// V�rification que les vecteurs de valeurs ont la mm dim que les variables
		int i=0;
		for (ArrayList<Double> listValeurs : val) {
			if(listValeurs.size()!=var.get(i).getDimension())
				throw new Exception("Solution : un vecteur de valeur n'a pas la m�me dimension que la variable");
		}
		
		sesVariables=var;
		sesValeurs=val;
	}
	

	public void setSolution(ArrayList<Variable> variables, ArrayList<ArrayList<Double>> valeurs) throws Exception {
		// V�rification sur le nbr de vecteurs de valeurs et le nbr de variables
		if(variables.size()!=valeurs.size())
			throw new Exception("Solution : Le nombre de variables et le nombre de vecteurs de valeurs n'est pas identique.");
		
		// V�rification sur la taille des vecteurs de valeurs et la dim. des variables
		int i=0;
		for (List<Double> unVecteur : valeurs) {
			if(unVecteur.size()!=variables.get(i).getDimension())
				throw new Exception("Solution : La taille du vecteur de valeurs n'est pas la m�me que la dimension de la variable "+variables.get(i).getNom()+".");
		}
		
		
//		int compteurVariable = 0;
//		
//		if (val.size() != var.getDimension()) {
//			throw new Exception(
//					"Solution : Le nombre de variable et le nombre de valeur propos� n'est pas �gale.");
//		}
//		
//		
//		for (Iterator it = var.getMesNomVariables().iterator(); it.hasNext();) {
//			String element = (String) it.next();
//			if (!monProbleme.getFonctionObjective().getLaVariable()
//					.contains(element)) {
//				throw new Exception(
//						"Solution : Une variable dans solution propos� est in�xistante dans le probl�me.");
//			}
//			compteurVariable++;
//		}
//
//		
//		if (compteurVariable!=monProbleme.getFonctionObjective().getLaVariable().getDimension()) {
//			throw new Exception(
//					"Solution : La solution propos� ne donne pas de valeur pour toutes les variables du probl�me.");
//		}
		sesValeurs = valeurs;
		sesVariables = variables;
	}

	public boolean estAdmissible() throws Exception {
		int i;
//		int j;
		for (Contrainte uneContrainte : monProbleme.getMesContraintes()) {
			i=sesVariables.indexOf(uneContrainte.getPartieGauche().getLaVariable());
//			j=sesVariables.indexOf(uneContrainte.getPartieDroite().getLaVariable());
			if(i==-1)
				throw new Exception("Variable de la contrainte non trouv�e dans les variables de la solution");
			if(!uneContrainte.estRespectee(sesValeurs.get(i)))
				return false;
		}
		return true;
//		
//		int partieGauche;
//		boolean valeurRetour=true;
//		for (Iterator it = monProbleme.getMesContraintes().iterator(); it.hasNext();) {
//			Contrainte element = (Contrainte) it.next();
//			partieGauche=element.calculerPartieGauche(valeur, variable);
//			if(element.getClass()==ContrainteEgale.class){
//				valeurRetour = valeurRetour && (partieGauche == element.getPartieDroite());
//			}else if(element.getClass()==ContrainteSuperieur.class){
//				valeurRetour = valeurRetour && (partieGauche > element.getPartieDroite());
//			}else if(element.getClass()==ContrainteInferieur.class){
//				valeurRetour = valeurRetour && (partieGauche < element.getPartieDroite());
//			}else{
//				throw new Exception("Solution : Contrainte non prise en charge");
//			}
//		}
//		return valeurRetour;
	}

	public void afficher() {
		int i=0;
		for (Variable uneVariable : sesVariables) {
			for (int j = 0; j < uneVariable.getDimension(); j++) {
				System.out.println(uneVariable.getNom()+"["+j+"]="+sesValeurs.get(i).get(j));
			}
			i++;
		}
		
//		int i=0;
//		for (Iterator iter = variable.getMesNomVariables().iterator(); iter.hasNext();) {
//			String element = (String) iter.next();
//			System.out.print(element + " = " + valeur.get(i) +"; ");
//			i++;
//		}
//		System.out.println();
//		if(!tousDefini()){
//			System.err.println("Attention cette solution ne donne pas de valeur � toutes les variables");
//		}
		
	}

	public double getCout() throws Exception {
		
		// Recherche la variable utilis�e pour la fct obj
		Variable laVariable=monProbleme.getFonctionObjective().getLaVariable();
		int i=sesVariables.indexOf(laVariable);
		// TODO tester si le indexOf a retourn� qqch
		if(i!=i)
			throw new Exception("Solution : La variable de la fonction objectif n'a pas �t� trouv�e dans la liste des variables de la solution");
		
		// Demande la valeur de la fct obj selon le vecteur de valeur
		return monProbleme.getFonctionObjective().getValeur(sesValeurs.get(i));
		
		
//		int i=0;
//		int position;
//		int somme = 0;
//		double[] mesVal;
//		if(valeur.size()!=0){
//			if(tousDefini()){
//			mesVal = new double[monProbleme.getFonctionObjective().getLaVariable().getDimension()];
//			for (Iterator it = variable.getMesNomVariables().iterator(); it.hasNext();) {
//				String element = (String) it.next();
//				position = monProbleme.getFonctionObjective().getLaVariable().getPosition(element);
//				mesVal[position] = valeur.get(i);
//				i++;
//			}
//			for (int j = 0; j < valeur.size(); j++) {
//				somme += monProbleme.getFonctionObjective().getMesPoids().getValeur(j) * mesVal[j];
//			}
//			return somme;
//			}else 
//				throw new Exception("Solution : Solution incomplete.");
//		}else{
//			throw new Exception("Solution : Aucune valeur de solution n'a �t� fournie.");
//		}
		
	}

//	private boolean tousDefini() {
//		for (Iterator iter = monProbleme.getFonctionObjective().getLaVariable().getMesNomVariables().iterator(); iter.hasNext();) {
//			String element = (String) iter.next();
//			if(!variable.contains(element))
//				return false;
//		}
//		return true;
//	}

	public int getNbContrainteRespecter() throws Exception {
		int i;
//		int j;
		int cpt=0;
		for (Contrainte uneContrainte : monProbleme.getMesContraintes()) {
			i=sesVariables.indexOf(uneContrainte.getPartieGauche().getLaVariable());
//			j=sesVariables.indexOf(uneContrainte.getPartieDroite().getLaVariable());
			if(i==-1)
				throw new Exception("Variable de la contrainte non trouv�e dans les variables de la solution");
			if(uneContrainte.estRespectee(sesValeurs.get(i)))
				cpt++;
		}
		return cpt;
//		
//		
//		
//		int partieGauche;
//		int valeurRetour=0;
//		for (Iterator it = monProbleme.getMesContraintes().iterator(); it.hasNext();) {
//			Contrainte element = (Contrainte) it.next();
//			partieGauche=element.calculerPartieGauche(valeur, variable);
//			if(element.getClass()==ContrainteEgale.class){
//				if(partieGauche == element.getPartieDroite())
//					valeurRetour++;
//			}else if(element.getClass()==ContrainteSuperieur.class){
//				if(partieGauche > element.getPartieDroite())
//					valeurRetour++;
//			}else if(element.getClass()==ContrainteInferieur.class){
//				if(partieGauche < element.getPartieDroite())
//					valeurRetour++;
//			}else{
//				throw new Exception("Solution : Contrainte non prise en charge");
//			}
//		}
//		return valeurRetour;
	}

//	public void modifierVariable(String variableAModifier, double valeur) {
//		int position = variable.getPosition(variableAModifier);
//		this.valeur.set(position, valeur);
//	}

}
