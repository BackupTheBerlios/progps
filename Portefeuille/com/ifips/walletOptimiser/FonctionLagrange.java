package com.ifips.walletOptimiser;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class FonctionLagrange extends Fonction {
	
	private Contrainte contrainteRelaxe;

	public FonctionLagrange(Variable v, List<Double> cst, Contrainte cr) throws Exception {
		super(v,cst);
		contrainteRelaxe=cr;
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
		res+=contrainteRelaxe.partieGauche.getValeur(valeurs);
		if (contrainteRelaxe instanceof ContrainteInferieur)
			res-=contrainteRelaxe.partieDroite;
		else if (contrainteRelaxe instanceof ContrainteSuperieur)
			res+=contrainteRelaxe.partieDroite;
		else
			throw new Exception("FonctionLagrange : Impossible de relaxer une contrainte d'égalité.");
		return res;
	}
	
}
