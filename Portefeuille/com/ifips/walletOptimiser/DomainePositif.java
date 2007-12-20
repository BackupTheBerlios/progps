package com.ifips.walletOptimiser;

import java.util.Random;

public class DomainePositif extends Domaine {
	private static DomainePositif instance = null;
	
	private DomainePositif(){}
	
	public static DomainePositif getInstance(){
		if(instance==null)
			instance = new DomainePositif();
		return instance;
	}
	
	@Override
	public boolean estDansDomaine(double valeur) {
		return (valeur>=0);
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

	@Override
	public void afficher() {
		System.out.println("Réel positif.");	
	}
}
