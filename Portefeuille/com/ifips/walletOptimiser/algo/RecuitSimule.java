package com.ifips.walletOptimiser.algo;

import java.util.Random;

import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;

public class RecuitSimule extends Algorithme {
	private double tempInitiale;
	private double tempMini=0.0001;
	private int nbrIterationParPaliers=100;
	private double coeffDecroissance=0.95;

	public RecuitSimule(Probleme p) {
		super(p);
	}

	@Override
	public Solution resoudre() {
		if(!this.kirkPatrick())
			System.err.println("Recuit Simulé : Impossible de déterminer la température initiale");
		
		Solution meilleureSol = solCourante;
		Solution solutionCandidate;
		double temperatureCourante=tempInitiale;
		Random rand=new Random();
		
		while(temperatureCourante>tempMini){
			int i=0;
			while(i<nbrIterationParPaliers){
				try {
					solutionCandidate=solCourante.getSolutionVoisine(1+(solCourante.getNombreDeVariables()/4), 0.1);
				} catch (Exception e) { e.printStackTrace(); return null;}
				
				// Si la nvelle solution est meilleure
				if(solutionCandidate.getCout()<solCourante.getCout()){
					solCourante=solutionCandidate;
					if(solCourante.getCout()<meilleureSol.getCout())
						meilleureSol=solCourante;
				}else{
					// Teste si on conserve une solution moins bonne
					double degradation=solutionCandidate.getCout()-solCourante.getCout();
					if(rand.nextDouble()<=Math.exp(-degradation/temperatureCourante))
						solCourante=solutionCandidate;
				}
				i++;
			}
			temperatureCourante=temperatureCourante*coeffDecroissance;
//			System.out.println("Diminution de la température. T="+temperatureCourante);
//			System.out.println("Cout de la sol : "+solCourante.getCout());
		}
		return meilleureSol;
	}

	public boolean kirkPatrick(){
		// Méthode de recherche de sol initiale par l'aléatoire
		Algorithme algoSolInit = new Aleatoire(pbCourant);
		System.out.println("Méthode de KirkPatrick");
		System.out.println("Recherche une solution Initale");
		solCourante=algoSolInit.resoudre();
		System.out.println("Solution Initale trouvée");
		Random rand;
		tempInitiale=0.1;
		
		double txAccept=0.0;
		while(txAccept<0.8){
			txAccept=0.0;
			int i=0;
			int mvtPositifsTotaux=1;
			int mvtPositifsAcceptes=1;
			
			while(i<nbrIterationParPaliers){
				Solution solutionCandidate=null;
				try {
					solutionCandidate=solCourante.getSolutionVoisine(1+(solCourante.getNombreDeVariables()/4), 0.1);
				} catch (Exception e) { e.printStackTrace(); return false; }
				
				// Teste si on conserve la solution
				if(solutionCandidate!=null && solutionCandidate.getCout()<solCourante.getCout()){
					// Conserve la solution
					solCourante=solutionCandidate;
				}else{
					// Test si on conserve
					mvtPositifsTotaux++;
					double degradation=solutionCandidate.getCout()-solCourante.getCout();
					rand=new Random();
					if(rand.nextDouble() <= Math.exp((-degradation)/tempInitiale)){
						solCourante=solutionCandidate;
						mvtPositifsAcceptes++;
					}
				}
				i++;
			}
			txAccept=(double)mvtPositifsAcceptes/(double)mvtPositifsTotaux;
			if(txAccept<0.8)
				tempInitiale=tempInitiale*2;
		}
		System.out.println("Température initiale : "+tempInitiale);
		return true;
	}
	
}
