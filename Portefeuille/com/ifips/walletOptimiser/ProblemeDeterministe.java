package com.ifips.walletOptimiser;

import java.util.ArrayList;

public class ProblemeDeterministe {
	private Probleme leProbleme;
	private Contrainte contrainteRelaxee;

	public ProblemeDeterministe(int nbrTitres) {
		//	Création de la fonction Obj
		Domaine domaineX = new DomaineBorne(0.0,1.0);
		Variable variableX=new Variable("x", nbrTitres, domaineX);
		
		// Crée la matrice variance/co-variance (Identité)
		ArrayList<Double> sigma=new ArrayList<Double>();
		for (int i = 0; i < nbrTitres; i++) {
			for (int j = 0; j < nbrTitres; j++) {
				sigma.add(0.0);
				if(i==j) sigma.set(i*nbrTitres+j, 1.0);
			}			
		}
		FonctionQuadratique foncObj=null;
		try {
			foncObj=new FonctionQuadratique(variableX, variableX, sigma);
		} catch (Exception e) {	e.printStackTrace(); }
		leProbleme=new Probleme(foncObj);
		
		
		// Création des contraintes
		// Contrainte 1a
		Contrainte a1;
		Fonction f1;
		ArrayList<Double> identite=new ArrayList<Double>();
		for (int j = 0; j < nbrTitres; j++) {
			identite.add(1.0);
		}	
		try {
			f1=new Fonction(variableX, identite);
			a1=new ContrainteEgale(f1, new FonctionConstante(1.0));
			leProbleme.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
//		 Contrainte 1b
		ArrayList<Double> mu=new ArrayList<Double>();
		for (int j = 0; j < nbrTitres; j++) {
			mu.add(2.0);
		}
		try {
			f1=new Fonction(variableX, mu);
			a1=new ContrainteSuperieur(f1, new FonctionConstante(1.0));
			contrainteRelaxee=a1;
			leProbleme.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }

		
//		 Contrainte 1c
		Domaine domaineY;
		ArrayList<Double> dY=new ArrayList<Double>();
		dY.add(0.0);
		dY.add(1.0);
		domaineY = new DomaineFerme(dY);
		Variable variableY=new Variable("y", nbrTitres, domaineY);
		try {
			f1=new Fonction(variableY, identite);
			a1=new ContrainteEgale(f1, new FonctionConstante(2.0));
			leProbleme.ajouterContrainte(a1);
		} catch (Exception e) { e.printStackTrace(); }
		
//		Contrainte 1d
		Fonction f2;
		ArrayList<Double> epsilon=new ArrayList<Double>();
		ArrayList<Double> delta=new ArrayList<Double>();
		ArrayList<Double> constante=new ArrayList<Double>();
		
		for(int i = 0; i<nbrTitres; i++){
			epsilon		=new ArrayList<Double>();
			delta		=new ArrayList<Double>();
			constante	=new ArrayList<Double>();
			for(int j = 0; j<variableX.getDimension(); j++){
				epsilon.add(0.0);
				delta.add(0.0);
				constante.add(0.0);
			}
			epsilon.set(i, 0.1);
			constante.set(i, 1.0);
			delta.set(i,0.9);
			try{
				f1 = new Fonction(variableY,epsilon);
				f2 = new Fonction(variableX, constante);
				a1 = new ContrainteInferieur(f1,f2);
				leProbleme.ajouterContrainte(a1);
				f1 = new Fonction(variableY,delta);
				a1 = new ContrainteInferieur(f2,f1);
				leProbleme.ajouterContrainte(a1);
			}catch(Exception e) { e.printStackTrace(); }
		}
		// Fin contrainte 1d
	}

	public Probleme getLeProbleme() {
		return leProbleme;
	}

	public Contrainte getContrainteRelaxee() {
		return contrainteRelaxee;
	}

}
