package com.ifips.walletOptimiser.algo;

import com.ifips.walletOptimiser.*;


public class Lagrange extends Algorithme {

	
	private Solution solDuale;
	private Fonction fctLagrangienne;
	private Probleme dual;
	private Probleme sousPb;
	private Contrainte contrainteRelaxe;
	
	
	
	
	private Lagrange(Probleme pbCourant, Contrainte contrainteRelaxe) {
		
	}
	
	public Solution resoudre() {
		return null;
	}
	
	private void initialiserDual() {
		
	}
	
	private void ajouterContrainteDual(Solution s) {
		
	}
	
	public boolean verifierOptimalite() {
		return true;
	}
	
	
}
