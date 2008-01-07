package com.ifips.walletOptimiser;

import java.util.ArrayList;
import java.util.List;

public class Fonction {
	protected Variable laVariable;
	protected ArrayList<Double> mesPoids;
	
	protected Fonction(){};
	
	public Fonction(Variable v, List<Double> cst) throws Exception{
		if(v.getDimension()!=cst.size())
			throw new Exception("Impossible de cr�er la fonction : le vecteur variable et celui de constante n'ont pas la m�me dimension.");
		laVariable = v;
		mesPoids = (ArrayList<Double>) cst;
	}
	
	public Variable getLaVariable() {
		return laVariable;
	}

	public ArrayList<Double> getMesPoids() {
		return mesPoids;
	}

	public void afficher() {
		int i=0;
		for (Double poids : mesPoids) {
			System.out.print("+ "+poids+"*"+laVariable.getNom()+"["+i+"] ");
			i++;
		}	
	}
	
	public String toString(){
		String ret=new String();
		int i=0;
		for (Double poids : mesPoids) {
			ret=ret.concat("+ "+poids+"*"+laVariable.getNom()+"["+i+"] ");
			i++;
		}	
		return ret;
	}
	
	double getValeur(List<Double> valeurs) throws Exception{
		if(valeurs.size()!=laVariable.getDimension())
			throw new Exception("Le vecteur de valeur n'a pas la m�me dimension que le vecteur variable");
		// Calcul de la valeur
		int i=0;
		double res=0.0;
		for (Double uneValeur : valeurs) {
			res+=uneValeur*mesPoids.get(i);
			i++;
		}
		return res;
	}

//	public void ajouterVariable(String nomVariable, double valeurVariable) {
//		try {
//			laVariable.addLast(nomVariable);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		
//		mesPoids.addLast(valeurVariable);
//	}
}
