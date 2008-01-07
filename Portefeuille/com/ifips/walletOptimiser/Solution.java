package com.ifips.walletOptimiser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Solution{
	private Probleme monProbleme;
	private ArrayList<Variable> sesVariables;
	private ArrayList<ArrayList<Double>> sesValeurs;


	public Solution(Probleme p) {
		this.monProbleme = p;
	}
	
	public Solution(Probleme p,ArrayList<Variable> var, ArrayList<ArrayList<Double>> val) throws Exception {
		this.monProbleme = p;
		if(var.size()!=val.size())
			throw new Exception("Solution : impossible de créer une solution qui n'a pas les valeurs pour toutes les variables");

		// Vérification que les vecteurs de valeurs ont la mm dim que les variables
		int i=0;
		for (ArrayList<Double> listValeurs : val) {
			if(listValeurs.size()!=var.get(i).getDimension())
				throw new Exception("Solution : un vecteur de valeur n'a pas la même dimension que la variable");
		}
		
		this.sesVariables=var;
		this.sesValeurs=val;
	}
	
	
	public int getNombreDeVariables(){
		return this.sesValeurs.size();
	}
	
	public void setSolution(ArrayList<Variable> variables, ArrayList<ArrayList<Double>> valeurs) throws Exception {
		// Vérification sur le nbr de vecteurs de valeurs et le nbr de variables
		if(variables.size()!=valeurs.size())
			throw new Exception("Solution : Le nombre de variables et le nombre de vecteurs de valeurs n'est pas identique.");
		
		// Vérification sur la taille des vecteurs de valeurs et la dim. des variables
		int i=0;
		for (List<Double> unVecteur : valeurs) {
			if(unVecteur.size()!=variables.get(i).getDimension())
				throw new Exception("Solution : La taille du vecteur de valeurs n'est pas la même que la dimension de la variable "+variables.get(i).getNom()+".");
		}
		
		this.sesValeurs = valeurs;
		this.sesVariables = variables;
	}

	public boolean estAdmissible() throws Exception {
		int i;
		int j;
		for (Contrainte uneContrainte : this.monProbleme.getMesContraintes()) {
			i=this.sesVariables.indexOf(uneContrainte.getPartieGauche().getLaVariable());
			if(i==-1)
				throw new Exception("Solution : Variable de la contrainte non trouvée dans les variables de la solution : "+uneContrainte.getPartieGauche().getLaVariable().getNom());
			if(uneContrainte.getPartieDroite() instanceof FonctionConstante){
				// La partie droite ne contient pas de variable
				if(!uneContrainte.estRespectee(this.sesValeurs.get(i),null))
					return false;
			}else{
				// La partie droite contient une variable
				j=this.sesVariables.indexOf(uneContrainte.getPartieDroite().getLaVariable());
				if(j==-1)
					throw new Exception("Solution : Variable de la contrainte non trouvée dans les variables de la solution : "+uneContrainte.getPartieDroite().getLaVariable().getNom());
				if(!uneContrainte.estRespectee(this.sesValeurs.get(i),this.sesValeurs.get(j)))
					return false;
			}
		}
		return true;
	}

	public void afficher() {
		int i=0;
		for (Variable uneVariable : this.sesVariables) {
			for (int j = 0; j < uneVariable.getDimension(); j++) {
				System.out.println(uneVariable.getNom()+"["+j+"]="+this.sesValeurs.get(i).get(j));
			}
			i++;
		}
	}
	
	public String toString() {
		String ret="";
		int i=0;
		for (Variable uneVariable : this.sesVariables) {
			for (int j = 0; j < uneVariable.getDimension(); j++) {
				ret=ret+(uneVariable.getNom()+"["+j+"]="+this.sesValeurs.get(i).get(j)+"\n");
			}
			i++;
		}
		if(ret.length()>1)
			return ret;
		return new String("Erreur : solution illisible");
	}

	public double getCout() {
		
		// Recherche la variable utilisée pour la fct obj
		Variable laVariable=this.monProbleme.getFonctionObjective().getLaVariable();
		int i=this.sesVariables.indexOf(laVariable);
		// TODO tester si le indexOf a retourné qqch
		if(i==-1)
			return Double.MAX_VALUE;
			
		
		// Demande la valeur de la fct obj selon le vecteur de valeur
		try {
			return this.monProbleme.getFonctionObjective().getValeur(this.sesValeurs.get(i));
		} catch (Exception e) {
			e.printStackTrace();
			return Double.MAX_VALUE;
		}
	}

	public int getNbContrainteRespecter() throws Exception {
		int cpt=0;
		int i;
		int j;
		for (Contrainte uneContrainte : this.monProbleme.getMesContraintes()) {
			i=this.sesVariables.indexOf(uneContrainte.getPartieGauche().getLaVariable());
			if(i==-1)
				throw new Exception("Solution : Variable de la contrainte non trouvée dans les variables de la solution : "+uneContrainte.getPartieGauche().getLaVariable().getNom());
			if(uneContrainte.getPartieDroite() instanceof FonctionConstante){
				// La partie droite ne contient pas de variable
				if(uneContrainte.estRespectee(this.sesValeurs.get(i),null))
					cpt++;
			}else{
				// La partie droite contient une variable
				j=this.sesVariables.indexOf(uneContrainte.getPartieDroite().getLaVariable());
				if(j==-1)
					throw new Exception("Solution : Variable de la contrainte non trouvée dans les variables de la solution : "+uneContrainte.getPartieDroite().getLaVariable().getNom());
				if(uneContrainte.estRespectee(this.sesValeurs.get(i),this.sesValeurs.get(j)))
					cpt++;
			}
		}
		return cpt;
	}

	public ArrayList<Double> getValeursDeVariable(Variable v) throws Exception {
		int i=this.sesVariables.indexOf(v);
		if(i==-1)
			throw new Exception("Solution : La variable demandée est inconnue de la solution.");
		return this.sesValeurs.get(i);
	}

	public Solution getSolutionVoisine(double variationMax) throws Exception{
		int nbrDeVariablesModifiees=1+(this.getNombreDeVariables()/4);
		
		ArrayList<ArrayList<Double>> lesValeurs=this.sesValeurs;
		Solution res=new Solution(this.monProbleme, this.sesVariables, lesValeurs);
		
		Random randomise=new Random();
		ArrayList<Double> unVecteur;
		do{
			// On prend les valeurs identique à la solution actuelle
			lesValeurs=new ArrayList<ArrayList<Double>>(this.sesValeurs);
			
			// On modifie autant de variables que demandé
			for (int i = 0; i < nbrDeVariablesModifiees; i++) {
				int j=randomise.nextInt(this.sesVariables.size());
				unVecteur = new ArrayList<Double>(lesValeurs.get(j));
				int k=0;
				for (Object element : unVecteur) {
					Double uneVal = (Double) element;
//					uneVal=uneVal+(randomise.nextDouble()*variationMax)-(randomise.nextDouble()*variationMax);
					uneVal = this.sesVariables.get(j).getMonDomaine().getValeurAleatoire(uneVal, variationMax);
					unVecteur.set(k, uneVal);
					k++;
				}
				lesValeurs.set(j, unVecteur);
			}
			res.setSolution(this.sesVariables, lesValeurs);
		}while(!res.estAdmissible() || this.getDistanceAvec(res)<0.001);
		return res;
	}
	
	public double getDistanceAvec(Solution s){
		double distance=0.0;
		int i=0;
		for (ArrayList<Double> unVecteurDeLaSol : this.sesValeurs) {
			ArrayList<Double> unVecteurCorrespondant=s.sesValeurs.get(i);
			int j=0;
			for (Double uneValeur : unVecteurDeLaSol) {
				distance+=Math.abs(uneValeur-unVecteurCorrespondant.get(j));
				j++;
			}
			i++;
		}
		return distance;
	}
	
	public ArrayList<Solution> getSolutionsVoisines(int nbrVoisins, double variationMax){
		ArrayList<Solution> result = new ArrayList<Solution>();
		while(result.size()<nbrVoisins) {
			try {
				result.add(this.getSolutionVoisine(variationMax));
			} catch (Exception e) {
				System.out.println("Erreur lors de la génération du voisinage...");
			}
		}
		return result;
	}
}
