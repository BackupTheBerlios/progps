package com.ifips.walletOptimiser.algo;

import java.util.ArrayList;

import com.ifips.walletOptimiser.*;

public class VNS extends Algorithme {
	private int tailleVoisinage;
	private int distanceMaxVoisinage = 4;

	public VNS(Probleme pb){
		super(pb);
		tailleVoisinage = 10;
		System.out.println("Recherche une solution Initale");
		Aleatoire algoSolInit = new Aleatoire(pb);
		solCourante=algoSolInit.resoudre();
		System.out.println("Solution Initale trouvée");
	}

	public Solution resoudre() {
		int distance = 1;
		double proportion = distance*0.1;
		int i = 0;
		Solution meilleurVoisin = null;
		Solution unVoisin;
		ArrayList<Solution> voisins = new ArrayList<Solution>();
		//Solution solCourante = maSolution;

		while (distance < distanceMaxVoisinage) {

			voisins = solCourante.getSolutionsVoisines(tailleVoisinage, proportion);	
			// on calcule les solutions dans le voisinage de la solution courante
			// --> 1/4 des variables de la solution varient selon une proportion
			if(voisins==null || voisins.size()==0){
				System.err.println("Impossible de créer le voisinage.");
				return null;
			}
			meilleurVoisin = voisins.get(0);
			i = voisins.size();


			while (i > 0) {
				i--;
				unVoisin = voisins.get(i);

				try {
					if (unVoisin.getCout() < meilleurVoisin.getCout()) {
						meilleurVoisin = unVoisin;
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			if (meilleurVoisin.getCout() < solCourante.getCout()) {
				solCourante = meilleurVoisin;
			}
			else {
				distance++;
				proportion = distance*0.1;	// le voisinage augmente avec la proportion de variation
			}

		}

		return solCourante;

	}


}