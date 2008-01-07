package com.ifips.walletOptimiser.outils;

import java.io.*;

import com.ifips.*;

public class ChargeurFichier {
	private String chemin;
	private int nbrTitres;
	
	public ChargeurFichier(String nom){
		chemin=nom;
		nbrTitres=-1;
		
		BufferedReader position=null;
		
		try {
			position = new BufferedReader(new FileReader((nom)));
		} catch (Exception e) {
			System.err.println("Fichier introuvable : "+nom);
		}

		String ligne;
		try {
			ligne=position.readLine();
			nbrTitres=(Integer.parseInt(ligne.trim()));
//			while((ligne=position.readLine())!= null){
//				System.out.println(ligne);
//			}
		} catch (IOException e) {
			System.err.println("Erreur sur la lecture du fichier.");
		}
	}

	public int getNbrTitres() {
		return nbrTitres;
	}
	
	
}
