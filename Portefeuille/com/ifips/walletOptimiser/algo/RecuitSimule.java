package com.ifips.walletOptimiser.algo;

import java.util.Random;

import com.ifips.walletOptimiser.Probleme;
import com.ifips.walletOptimiser.Solution;

public class RecuitSimule extends Algorithme {
	private boolean tempAuto=true;
	private double tempInitiale;
	private double tempMini=0.0001;
	private int nbrIterationParPaliers=100;
	private double coeffDecroissance=0.95;

	public RecuitSimule(Probleme p) {
		super(p);
	}

	@Override
	public Solution resoudre() {
		if(tempAuto)
			if(!this.kirkPatrick())
				fenetreDeSortie.ajouterTexteJournal("Recuit Simul� : Impossible de d�terminer la temp�rature initiale");
		
		Solution meilleureSol = this.solCourante;
		if(meilleureSol==null){
			Algorithme algoSolInit = new Aleatoire(this.pbCourant);
			algoSolInit.setFenetreDeSortie(this.fenetreDeSortie);
			fenetreDeSortie.ajouterTexteJournal("Recherche une solution Initale");
			this.solCourante=algoSolInit.resoudre();
			fenetreDeSortie.ajouterTexteJournal("Solution Initale trouv�e");
		}
		
		Solution solutionCandidate;
		double temperatureCourante=this.tempInitiale;
		Random rand=new Random();
		
		while(temperatureCourante>this.tempMini){
			int i=0;
			while(i<this.nbrIterationParPaliers){
				try {
					solutionCandidate=this.solCourante.getSolutionVoisine(0.1);
				} catch (Exception e) { e.printStackTrace(); return null;}
				
				// Si la nvelle solution est meilleure
				if(solutionCandidate.getCout()<this.solCourante.getCout()){
					this.solCourante=solutionCandidate;
					if(this.solCourante.getCout()<meilleureSol.getCout())
						meilleureSol=this.solCourante;
				}else{
					// Teste si on conserve une solution moins bonne
					double degradation=solutionCandidate.getCout()-this.solCourante.getCout();
					if(rand.nextDouble()<=Math.exp(-degradation/temperatureCourante))
						this.solCourante=solutionCandidate;
				}
				i++;
			}
			temperatureCourante=temperatureCourante*this.coeffDecroissance;
			fenetreDeSortie.ajouterTexteJournal("Diminution de la temp�rature � : "+temperatureCourante);
			fenetreDeSortie.ajouterTexteJournal("Meilleure solution actuelle : "+meilleureSol.getCout());
		}
		solCourante=meilleureSol;
		ecrireSolution();
		return solCourante;
	}

	public boolean kirkPatrick(){
		// M�thode de recherche de sol initiale par l'al�atoire
		Algorithme algoSolInit = new Aleatoire(this.pbCourant);
		algoSolInit.setFenetreDeSortie(this.fenetreDeSortie);
		fenetreDeSortie.ajouterTexteJournal("M�thode de KirkPatrick");
		fenetreDeSortie.ajouterTexteJournal("Recherche une solution Initale");
		this.solCourante=algoSolInit.resoudre();
		fenetreDeSortie.ajouterTexteJournal("Solution Initale trouv�e");
		Random rand;
		this.tempInitiale=0.1;
		
		double txAccept=0.0;
		while(txAccept<0.8){
			txAccept=0.0;
			int i=0;
			int mvtPositifsTotaux=1;
			int mvtPositifsAcceptes=1;
			
			while(i<this.nbrIterationParPaliers){
				Solution solutionCandidate=null;
				try {
					solutionCandidate=this.solCourante.getSolutionVoisine(0.1);
				} catch (Exception e) { e.printStackTrace(); return false; }
				
				// Teste si on conserve la solution
				if(solutionCandidate!=null && solutionCandidate.getCout()<this.solCourante.getCout()){
					// Conserve la solution
					this.solCourante=solutionCandidate;
				}else{
					// Test si on conserve
					mvtPositifsTotaux++;
					double degradation=solutionCandidate.getCout()-this.solCourante.getCout();
					rand=new Random();
					if(rand.nextDouble() <= Math.exp((-degradation)/this.tempInitiale)){
						this.solCourante=solutionCandidate;
						mvtPositifsAcceptes++;
					}
				}
				i++;
			}
			txAccept=(double)mvtPositifsAcceptes/(double)mvtPositifsTotaux;
			if(txAccept<0.8)
				this.tempInitiale=this.tempInitiale*2;
		}
		fenetreDeSortie.ajouterTexteJournal("Temp�rature initiale selon KirkPatrick : "+this.tempInitiale);
		return true;
	}

	public void setCoeffDecroissance(int coeffDec) {
		this.coeffDecroissance = coeffDec/100.0;
	}

	public void setNbrIterationParPaliers(int nbrIterationParPaliers) {
		this.nbrIterationParPaliers = nbrIterationParPaliers;
	}

	public void setTempAuto(boolean tempAuto) {
		this.tempAuto = tempAuto;
	}

	public void setTempInitiale(double tempInitiale) {
		this.tempInitiale = tempInitiale;
	}

	public void setTempMini(double tempMini) {
		this.tempMini = tempMini;
	}
	
}
