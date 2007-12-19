package com.ifips.walletOptimiser;

public class ContrainteSuperieur extends Contrainte{

	public ContrainteSuperieur(Fonction gauche, int droite){
		partieDroite = droite;
		partieGauche = gauche;
	}
	
}
