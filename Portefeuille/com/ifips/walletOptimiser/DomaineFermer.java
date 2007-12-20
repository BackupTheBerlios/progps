package com.ifips.walletOptimiser;

import java.util.List;
import java.util.Random;

public class DomaineFermer extends Domaine {
	List<Double> elements;
	
	public DomaineFermer(List<Double> elems) {
		elements = elems;
	}

	@Override
	public boolean estDansDomaine(double valeur) {
		return (elements.contains(valeur));
	}

	@Override
	public double getValeurAleatoire(double valeurInit, double variationMax) {
		Random randomise=new Random();
		return elements.get((int)randomise.nextFloat()*elements.size());
	}

}
