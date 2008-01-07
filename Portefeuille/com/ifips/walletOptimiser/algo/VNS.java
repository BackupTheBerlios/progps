package com.ifips.walletOptimiser.algo;

import java.util.ArrayList;

import com.ifips.walletOptimiser.*;

public class VNS extends Algorithme {
	private int tailleVoisinage;
	private int distanceMaxVoisinage = 4;
	private int proportionMaxVariation = 10;

	public VNS(Probleme pb){
		super(pb);
		this.tailleVoisinage = 10;
//		System.out.println("Recherche une solution Initale");
//		Aleatoire algoSolInit = new Aleatoire(pb);
//		this.solCourante=algoSolInit.resoudre();
//		System.out.println("Solution Initale trouvée");
	}

	public Solution resoudre() {
		System.out.println("Recherche une solution Initale");
		Aleatoire algoSolInit = new Aleatoire(this.pbCourant);
		algoSolInit.setFenetreDeSortie(this.fenetreDeSortie);
		this.solCourante=algoSolInit.resoudre();
		System.out.println("Solution Initale trouvée");
		
		int distance = 1;
		int i = 0;
		Solution meilleurVoisin = null;
		Solution unVoisin;
		ArrayList<Solution> voisins = new ArrayList<Solution>();
		//Solution solCourante = maSolution;

		while (distance < this.distanceMaxVoisinage) {

			voisins = this.solCourante.getSolutionsVoisines(this.tailleVoisinage, proportionMaxVariation/100.0);	
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

			if (meilleurVoisin.getCout() < this.solCourante.getCout()) {
				this.solCourante = meilleurVoisin;
			}
			else {
				distance++;
//				proportionMaxVariation = distance*0.1;	// le voisinage augmente avec la proportion de variation
			}

		}

		return this.solCourante;

	}

	public void setDistanceMaxVoisinage(int distanceMaxVoisinage) {
		this.distanceMaxVoisinage = distanceMaxVoisinage;
	}


}