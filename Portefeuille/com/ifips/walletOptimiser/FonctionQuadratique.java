package com.ifips.walletOptimiser;

import java.util.List;

public class FonctionQuadratique extends Fonction {

	private Variable variable2;
	
	public FonctionQuadratique(Variable v1, Variable v2, List<Double> cst) throws Exception {
		super(v1, cst);
		variable2=v2;
	}

	public Variable getVariable2() {
		return this.variable2 ;
	}
	
	public void afficher() {
		int i=0;
		for (Double poids : mesPoids) {
			System.out.print("+ "+poids+"*"+laVariable.getNom()+"["+i+"] ");
			i++;
		}	
	}
	
}
