package com.ifips.walletOptimiser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Probleme {
	private Fonction fonctionObjective;
	private ArrayList<Contrainte> mesContraintes;
	
	public Probleme(Fonction fctObj){
		this.fonctionObjective = fctObj;
		this.mesContraintes = new ArrayList<Contrainte>();		
	}
	
	public void ajouterContrainte(Contrainte c) throws Exception{
		this.mesContraintes.add(c);		
	}

	public Fonction getFonctionObjective() {
		return this.fonctionObjective;
	}

	public List<Contrainte> getMesContraintes() {
		return this.mesContraintes;
	}
	
	public void afficherProbleme(){
		System.out.println("Fonction objective : ");
		this.fonctionObjective.afficher();
		System.out.println();
		System.out.println("Sous les contraintes : ");
		for (Object element0 : this.mesContraintes) {
			Contrainte element = (Contrainte) element0;
			element.afficher();
			System.out.println();
		}
		System.out.println("Domaines de définitions : ");
		for (Variable uneVar : getToutesLesVariables()) {
			System.out.print(uneVar.getNom()+" = ");
			uneVar.getMonDomaine().afficher();
		}
	}
	
	public ArrayList<Variable> getToutesLesVariables(){
		HashSet<Variable> setVar=new HashSet<Variable>();
		setVar.add(this.fonctionObjective.getLaVariable());
		for (Contrainte uneContrainte : this.mesContraintes) {
			setVar.add(uneContrainte.getPartieGauche().getLaVariable());
			if(!(uneContrainte.getPartieDroite() instanceof FonctionConstante)){
				setVar.add(uneContrainte.getPartieDroite().getLaVariable());
			}
		}
		return new ArrayList<Variable>(setVar); 
	}

}
