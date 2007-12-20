package com.ifips.walletOptimiser;

public abstract class Domaine {
	public abstract boolean estDansDomaine(double valeur);
	public abstract double getValeurAleatoire(double valeurInit, double variationMax);
	public abstract void afficher();
}
