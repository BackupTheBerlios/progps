package com.ifips.walletOptimiser.algo;

import java.util.*;

import com.ifips.walletOptimiser.*;


public class Lagrange extends Algorithme {

	
	private Solution solDuale;
	private FonctionLagrange fctLagrangienne;
	private Probleme dual;
	private Probleme sousPb;
	private Contrainte contrainteRelaxe;
	
	
	
	
	private Lagrange(Probleme pbCourant, Contrainte contrainteRelaxe) throws Exception {
		super(pbCourant);
		this.sousPb=pbCourant;
		this.contrainteRelaxe=contrainteRelaxe;
		this.fctLagrangienne=new FonctionLagrange(pbCourant.getFonctionObjective().getLaVariable(), pbCourant.getFonctionObjective().getMesPoids(), contrainteRelaxe);
		List<Double>l = new ArrayList<Double>();
		l.add(0.0);
		this.dual=new Probleme(new Fonction(new Variable("w",1), l));
	}
	
	
	public Solution resoudre() {
		double lambda=0.0;
		try {
			Aleatoire ale=new Aleatoire(sousPb);
			double z=this.fctLagrangienne.getValeur(ale.resoudre().getValeursDeVariable(sousPb.getFonctionObjective().getLaVariable()), lambda);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
