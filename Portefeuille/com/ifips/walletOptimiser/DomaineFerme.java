package com.ifips.walletOptimiser;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DomaineFerme extends Domaine {
	List<Double> elements;
	
	public DomaineFerme(List<Double> elems) {
		elements = elems;
	}

	@Override
	public boolean estDansDomaine(double valeur) {
		return (elements.contains(valeur));
	}

	@Override
	public double getValeurAleatoire(double valeurInit, double variationMax) {
		Random randomise=new Random();
		return elements.get(randomise.nextInt(elements.size()));
	}

	@Override
	public void afficher() {
		System.out.print("{");
		for (Iterator iter = elements.iterator(); iter.hasNext();) {
			Double element = (Double) iter.next();
			System.out.print(element);
			System.out.print(" ");
		}
		System.out.println("}");
	}

}
