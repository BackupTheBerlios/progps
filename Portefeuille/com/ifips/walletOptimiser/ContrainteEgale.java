package com.ifips.walletOptimiser;

public class ContrainteEgale extends Contrainte {
	
	public ContrainteEgale(Fonction gauche, int droite){
		partieDroite = droite;
		partieGauche = gauche;
	}

}
