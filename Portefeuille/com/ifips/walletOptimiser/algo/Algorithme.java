package com.ifips.walletOptimiser.algo;

import com.ifips.walletOptimiser.*;
import com.ifips.walletOptimiser.fenetrePrincipale.FenetreIHM;

public abstract class Algorithme {
	protected Probleme pbCourant;
	protected Solution solCourante;
	protected FenetreIHM fenetreDeSortie;
	
	public Algorithme(Probleme p){
		pbCourant=p;
	}
	
	public void setPbCourant(Probleme p) {
		pbCourant=p;
	}
	
	public Solution getSolCourante() {
		return solCourante;
	}

	public void setSolCourante(Solution solCourante) {
		this.solCourante = solCourante;
	}

	public Probleme getPbCourant() {
		return pbCourant;
	}

	public abstract Solution resoudre();

	public void setFenetreDeSortie(FenetreIHM fenetreDeSortie) {
		this.fenetreDeSortie = fenetreDeSortie;
	}

}
