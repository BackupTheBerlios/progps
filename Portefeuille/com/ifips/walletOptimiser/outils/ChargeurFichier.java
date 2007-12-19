package com.ifips.walletOptimiser.outils;

import java.io.*;

import com.ifips.*;

public class ChargeurFichier {

	public ChargeurFichier(String nom){
		BufferedReader position=null;
		
		try {
			position = new BufferedReader(new FileReader((nom)));
		} catch (Exception e) {
			System.err.println("Fichier introuvable : "+nom);
		}

		String ligne;
		try {
			while((ligne=position.readLine())!= null){
				
			}
		} catch (IOException e) {
			System.err.println("Erreur sur la lecture du fichier.");
		}
	}
	
	
}
