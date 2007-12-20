package com.ifips.walletOptimiser.algo;

import com.ifips.walletOptimiser.*;

public abstract class Algorithme {
	protected Probleme pbCourant;
	protected Solution solCourante;
	
	public Algorithme(Probleme p){
		pbCourant=p;
	}
	
	public void setPbCourant(Probleme p) {
		pbCourant=p;
	}
	
	public abstract Solution resoudre();

}
