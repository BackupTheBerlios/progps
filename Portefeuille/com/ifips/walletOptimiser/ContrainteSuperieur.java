package com.ifips.walletOptimiser;

import java.util.ArrayList;

public class ContrainteSuperieur extends Contrainte{

	public ContrainteSuperieur(Fonction gauche, double droite) throws Exception {
		super(gauche, droite);
	}

	@Override
	public void afficher() {
		partieGauche.afficher();
		System.out.print(">"+partieDroite);
	}
	
	@Override
	public boolean estRespectee(ArrayList<Double> vecteurVarGauche) {
		try {
			return partieGauche.getValeur(vecteurVarGauche)>=partieDroite;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
