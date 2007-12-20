package com.ifips.walletOptimiser;

import java.util.Random;

public class DomaineBorne extends Domaine {
	
	private double borneSup;
	private double borneInf;
	
	public DomaineBorne(double inf, double sup){
		borneInf=inf;
		borneSup=sup;
	}

	@Override
	public boolean estDansDomaine(double valeur) {
		return (valeur>=borneInf && valeur<=borneSup);
	}

	@Override
	public double getValeurAleatoire(double valeurInit, double variationMax) {
		Random randomise=new Random();
		double valeurRetour;
		do{
			valeurRetour=new Double(valeurInit);
			valeurRetour += (randomise.nextDouble()*variationMax) - (randomise.nextDouble()*variationMax);
		}while(!estDansDomaine(valeurRetour));
		return valeurRetour;
	}

	public double getBorneSup() {
		return borneSup;
	}

	public double getBorneInf() {
		return borneInf;
	}

	@Override
	public void afficher() {
		System.out.print("["+borneInf + " , " + borneSup + "]");
	}

}
