package com.ifips.walletOptimiser.algo;

import java.util.Random;

import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;

public class RecuitSimule extends Algorithme {
	private double tempInitiale;
	private int nbrIterationParPaliers=10;

	public RecuitSimule(Probleme p) {
		super(p);
	}

	@Override
	public Solution resoudre() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean kirkPatrick(){
		// Méthode de recherche de sol initiale par l'aléatoire
		Algorithme algoSolInit = new Aleatoire(pbCourant);
		
		double txAccept=0.0;
		while(txAccept<0.8){
			System.out.println("Recherche une solution Initale");
			solCourante=algoSolInit.resoudre();
			System.out.println("Solution Initale trouvée");
			txAccept=0.0;
			tempInitiale=0.01;
			int i=0;
			int mvtPositifsTotaux=0;
			int mvtPositifsAcceptes=0;
			
			while(i<nbrIterationParPaliers){
				Solution solutionCandidate=null;
				try {
					solutionCandidate=solCourante.getSolutionVoisine(1+(solCourante.getNombreDeVariables()/10), 0.01);
				} catch (Exception e) { e.printStackTrace(); return false; }
				
				// Teste si on conserve la solution
				if(solutionCandidate!=null && solutionCandidate.getCout()<solCourante.getCout()){
					// Conserve la solution
					solCourante=solutionCandidate;
				}else{
					// Test si on conserve
					mvtPositifsTotaux++;
					double degradation=solutionCandidate.getCout()-solCourante.getCout();
					Random rand=new Random();
					
					if(rand.nextDouble() <= Math.exp(-degradation/tempInitiale)){
						solCourante=solutionCandidate;
						mvtPositifsAcceptes++;
					}
				}
				i++;
			}
			txAccept=mvtPositifsAcceptes/mvtPositifsTotaux;
			if(txAccept<0.8)
				tempInitiale=tempInitiale*2;
			System.out.println(txAccept);
		}
		return true;
	}
	
}
