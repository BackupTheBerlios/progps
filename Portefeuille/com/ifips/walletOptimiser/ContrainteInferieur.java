package com.ifips.walletOptimiser;

public class ContrainteInferieur extends Contrainte{
	
	public ContrainteInferieur(Fonction gauche, int droite){
		partieDroite = droite;
		partieGauche = gauche;
	}
	
}
