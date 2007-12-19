package com.ifips.walletOptimiser.algo;

import com.ifips.walletOptimiser.*;


public class Lagrange extends Algorithme {

	
	private Solution solDuale;
	private FonctionLagrange fctLagrangienne;
	private Probleme dual;
	private Probleme sousPb;
	private Contrainte contrainteRelaxe;
	
	
	
	
	private Lagrange(Probleme pbCourant, Contrainte contrainteRelaxe) throws Exception {
		this.sousPb=pbCourant;
		this.contrainteRelaxe=contrainteRelaxe;
		this.fctLagrangienne=new FonctionLagrange(pbCourant.getFonctionObjective().getLaVariable(), pbCourant.getFonctionObjective().getMesPoids(), contrainteRelaxe);
	}
	
	
	public Solution resoudre() {
		double lambda=0.0;
		double z=this.fctLagrangienne.getValeur(sousPb.getSolutionInitiale()., lambda)
		
	}
	
	private void initialiserDual() {
		
	}
	
	private void ajouterContrainteDual(Solution s) {
		
	}
	
	public boolean verifierOptimalite() {
		return true;
	}
	
	
}
