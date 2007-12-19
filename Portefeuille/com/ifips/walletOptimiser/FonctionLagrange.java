package com.ifips.walletOptimiser;

import java.util.List;

public class FonctionLagrange extends Fonction {
	
	private Contrainte contrainteRelaxe;

	public FonctionLagrange(Variable v, List<Double> cst, Contrainte cr) throws Exception {
		super(v,cst);
		this.contrainteRelaxe=cr;
	}
	
	
	public double getValeur(List<Double> valeurs, double lambda) throws Exception{
		if(valeurs.size()!=laVariable.getDimension())
			throw new Exception("Le vecteur de valeur n'a pas la même dimension que le vecteur variable");
		// Calcul de la valeur
		int i=0;
		double res=0.0;
		for (Double uneValeur : valeurs) {
			res+=uneValeur*mesPoids.get(i);
			i++;
		}
		res+=this.contrainteRelaxe.partieGauche.getValeur(valeurs);
		res-=this.contrainteRelaxe.partieDroite;
		return res;
	}
	
}
