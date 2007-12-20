package com.ifips.walletOptimiser.algo;

import java.util.ArrayList;

import com.ifips.walletOptimiser.*;

public class VNS extends Algorithme {
	private Solution maSolution;
	private int tailleVoisinage;
	private int distanceMaxVoisinage = 4;
	
	public VNS(Probleme pb){
		super(pb);
		//maSolution = monProbleme.getSolutionInitial();
		tailleVoisinage = this.pbCourant.getFonctionObjective().getLaVariable().getDimension()/4;
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
			
			try {
				voisins = maSolution.calculerVoisinage(proportion);	// on calcule les solutions dans le voisinage de la solution courante
																	// --> 1/4 des variables de la solution varient selon une proportion
				meilleurVoisin = voisins.get(0);
				i = voisins.size();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
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
			
			if (meilleurVoisin.getCout() < maSolution.getCout()) {
				maSolution = meilleurVoisin;
			}
			else {
				distance++;
				proportion = distance*0.1;	// le voisinage augmente avec la proportion de variation
			}
				
		}
		
		return maSolution;
		
	}
	
	
}