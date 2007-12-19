package com.ifips.walletOptimiser;

import java.util.Iterator;
import java.util.List;

public abstract class Contrainte {
	protected Fonction partieGauche;

	protected int partieDroite;

	public int getPartieDroite() {
		return partieDroite;
	}

	public Fonction getPartieGauche() {
		return partieGauche;
	}

	public int calculerPartieGauche(List<Double> valeur, Variable variable)
			throws Exception {
		int position;
		int i = 0;
		double[] mesVal;
		int somme = 0;
		if (valeur.size() != variable.getDimension()) {
			throw new Exception(
					"Contrainte taille valeur = " + valeur.size() +
					" taille variable " + variable.getDimension() +
					" : Le nombre de variable et le nombre de valeur proposé n'est pas égale.");
		}
		for (Iterator it = partieGauche.getMesVariables().getMesNomVariables()
				.iterator(); it.hasNext();) {
			String element = (String) it.next();
			if (!variable.contains(element)) {
				throw new Exception(
						"Contrainte : La solution proposé ne donne pas de valeur pour toutes les variables de la contrainte.");
			}
		}
		mesVal = new double[partieGauche.getMesVariables().getDimension()];
		for (Iterator it = variable.getMesNomVariables().iterator(); it
				.hasNext();) {
			String element = (String) it.next();
			position = partieGauche.getMesVariables().getPosition(element);
			if (position != -1) {
				mesVal[position] = valeur.get(i);
			}
			i++;
		}
		for (int j = 0; j < partieGauche.getMesPoids().getDimension(); j++) {
			somme += partieGauche.getMesPoids().getValeur(j) * mesVal[j];
		}
		return somme;
	}

	public void afficher() {
		partieGauche.afficher();
		if(this.getClass()==ContrainteEgale.class){
			System.out.print(" = ");
		}else if (this.getClass()==ContrainteInferieur.class) {
			System.out.print(" < ");
		}else {
			System.out.print(" > ");
		}
		System.out.println(partieDroite);
		
	}
	
	public void ajouterVariable(String nomVariable, double valeurVariable) {
		try {
			partieGauche.getMesVariables().addLast(nomVariable);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		partieGauche.getMesPoids().addLast(valeurVariable);
	}
	
}
