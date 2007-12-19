package com.ifips.walletOptimiser;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Constante extends Operande {
	private LinkedList<Double> valeur = new LinkedList<Double>();
	
	public int getDimension(){
		return valeur.size();
	}

	public void add(double i) {
		valeur.add(i);
	}

	public double getValeur(int i) {
		return valeur.get(i);
	}

	public void addLast(Double valeurVariable) {
		valeur.addLast(valeurVariable);
	}
}
