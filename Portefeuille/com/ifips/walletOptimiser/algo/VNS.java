package com.ifips.walletOptimiser.algo;

import com.ifips.walletOptimiser.*;

public class VNS extends Algorithme {
	private Solution maSolution;
	private Probleme monProbleme;
	private int tailleVoisinage;
	
	public VNS(Probleme pb){
		monProbleme = pb;
//		maSolution = monProbleme.getSolutionInitial();
		tailleVoisinage = monProbleme.getFonctionObjective().getLaVariable().getDimension()/4;
	}
	
	public Solution resoudre() {
		return maSolution;
		
	}
	
	
}
