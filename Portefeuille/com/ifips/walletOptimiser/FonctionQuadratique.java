package com.ifips.walletOptimiser;

import java.util.ArrayList;

public class FonctionQuadratique extends Fonction {

	private Variable laVariable2;
	
	public FonctionQuadratique(Variable v1, Variable v2, ArrayList<Double> cst) throws Exception {
		if(v1.getDimension()!=v2.getDimension())
			throw new Exception("Fonction Quadratique : Les deux variables n'ont pas la même dimension");
		if((v1.getDimension()+v2.getDimension())!=cst.size())
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
			System.out.print("+ "+poids+"*"+laVariable.getNom()+"["+i+"] "+"*"+laVariable2.getNom()+"["+j+"]");
			j++;
			if(j==laVariable.getDimension()){
				j=0;
				i++;
			}
		}
	}
	
}
