package com.ifips.walletOptimiser;

import java.util.ArrayList;
import java.util.List;

public class FonctionQuadratique extends Fonction {

	private Variable laVariable2;
	
	public FonctionQuadratique(Variable v1, Variable v2, ArrayList<Double> cst) throws Exception {
		if(v1.getDimension()!=v2.getDimension())
			throw new Exception("Fonction Quadratique : Les deux variables n'ont pas la m�me dimension");
		if((v1.getDimension()*v2.getDimension())!=cst.size())
			throw new Exception("Fonction Quadratique : La matrice de poids n'a pas la dimension voulue.");
		laVariable=v1;
		laVariable2=v2;
		mesPoids=cst;
	}

	public Variable getLaVariable2() {
		return this.laVariable2 ;
	}
	
	public void afficher() {
		int i=0;
		int j=0;
		for (Double poids : mesPoids) {
			System.out.print("+ "+poids+"*"+laVariable.getNom()+"["+i+"]*"+laVariable2.getNom()+"["+j+"]");
			j++;
			if(j==laVariable.getDimension()){
				j=0;
				i++;
			}
		}
	}
	
	public String toString() {
		String ret="";
		int i=0;
		int j=0;
		for (Double poids : mesPoids) {
			ret=ret+"+ "+poids+"*"+laVariable.getNom()+"["+i+"]*"+laVariable2.getNom()+"["+j+"]";
			j++;
			if(j==laVariable.getDimension()){
				j=0;
				i++;
			}
		}
		if(ret.length()>1)
			return ret.substring(1);
		return new String("Erreur");
	}
	
	double getValeur(List<Double> valeurs) throws Exception{
		if(valeurs.size()!=laVariable.getDimension() 
				|| valeurs.size()!=laVariable2.getDimension())
			throw new Exception("Fonction Quadratique : Un des vecteurs de valeurs n'a pas la m�me dimension que le vecteur de variable correspondant");
		// Calcul de la valeur
		int i=0;
		double res=0;
		int j=0;
		for (Double poids : mesPoids) {
			res+=poids*valeurs.get(i)*valeurs.get(j);
			j++;
			if(j==laVariable.getDimension()){
				j=0;
				i++;
			}
		}
		
		return res;
	}
	
}
