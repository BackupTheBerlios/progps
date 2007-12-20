package com.ifips.walletOptimiser.algo;

import com.ifips.walletOptimiser.*;

public class VNS extends Algorithme {
	private Solution maSolution;
	private int tailleVoisinage;
	
	public VNS(Probleme pb){
		super(pb);
//		maSolution = monProbleme.getSolutionInitial();
		tailleVoisinage = this.pbCourant.getFonctionObjective().getLaVariable().getDimension()/4;
	}
	
	public Solution resoudre() {
		return maSolution;
		
	}
	
	
}
