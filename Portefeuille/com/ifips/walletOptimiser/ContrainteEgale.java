package com.ifips.walletOptimiser;

import java.util.ArrayList;

public class ContrainteEgale extends Contrainte {

	public ContrainteEgale(Fonction gauche, Fonction droite) throws Exception {
		super(gauche, droite);
	}

	@Override
	public void afficher() {
		partieGauche.afficher();
		System.out.print("=");
		partieDroite.afficher();
	}

	@Override
	public boolean estRespectee(ArrayList<Double> vecteurVarGauche, ArrayList<Double> vecteurVarDroite) {
		try {
			return partieGauche.getValeur(vecteurVarGauche)==partieDroite.getValeur(vecteurVarDroite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
