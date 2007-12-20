package com.ifips.walletOptimiser;

import java.util.List;

public class FonctionConstante extends Fonction {
	private Double valeur;
	
	public FonctionConstante(double valeur) {
		this.valeur = valeur;
	}

	double getValeur(List<Double> valeurs){
		return valeur.doubleValue();
	}
	
	@Override
	public void afficher() {
		System.out.print(valeur);
	}
}
