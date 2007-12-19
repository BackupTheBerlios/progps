package com.ifips.walletOptimiser;

import java.util.Iterator;

public class Fonction {
	private Variable mesVariables;
	private Constante mesPoids;
	
	private Fonction(){};
	
	public Fonction(Variable v, Constante cst) throws Exception{
		if(v.getDimension()==cst.getDimension()){
			
		}else 
			throw new Exception("Fonction : Dimension nom approprié.");
		mesVariables = v;
		mesPoids = cst;
	}

	public Variable getMesVariables() {
		return mesVariables;
	}

	public Constante getMesPoids() {
		return mesPoids;
	}

	public void afficher() {
		int i=0;
		for (Iterator iter = mesVariables.getMesNomVariables().iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			System.out.print(" + (" + (mesPoids.getValeur(i)) + ") * " + element);
			i++;
		}		
	}

	public void ajouterVariable(String nomVariable, double valeurVariable) {
		try {
			mesVariables.addLast(nomVariable);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		mesPoids.addLast(valeurVariable);
	}
}
