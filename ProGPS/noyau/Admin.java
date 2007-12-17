package noyau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Admin {
	private String nomAdmin;
	private String mdp = null;
	SingletonProgps theProgps;
	
	public Admin(SingletonProgps leProGPS){
		theProgps=leProGPS;
		
		File fichier = new File(".//admin.dat");
		try {
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne = br.readLine();
			br.close();
			mdp = ligne;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		if (mdp == null) {
			mdp = "progps";
			try {
				FileWriter fw = new FileWriter(fichier, false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter fichierSortie = new PrintWriter(bw); 
				fichierSortie.println(mdp);
				fichierSortie.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getNomAdmin() {
		return this.nomAdmin;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
		File fichier = new File(".//admin.dat");
		try {
			FileWriter fw = new FileWriter(fichier, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw); 
			fichierSortie.println(mdp);
			fichierSortie.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public String getMdp() {
		return this.mdp;
	}
	
	public boolean besoinRafraichirIti(Ville villeDevientIndispo){
		// Si la ville devient indispo et que l'user a son itinéraire qui y passe
		for (Troncon unTroncon : theProgps.getSonUser().getItineraireCourant().getLesTroncons()) {
			if(unTroncon.getSesVilles().contains(villeDevientIndispo))
				return true;
		}
		return false;
	}
	
	public boolean besoinRafraichirIti(Troncon tronconDevientIndispo){
		// Si la ville devient indispo et que l'user a son itinéraire qui y passe
		for (Troncon unTroncon : theProgps.getSonUser().getItineraireCourant().getLesTroncons()) {
			if(unTroncon.equals(tronconDevientIndispo))
				return true;
		}
		return false;
	}
	
	public boolean besoinRafraichirIti(Route routeDevientIndispo){
		// Si la ville devient indispo et que l'user a son itinéraire qui y passe
		for (Troncon unTroncon : theProgps.getSonUser().getItineraireCourant().getLesTroncons()) {
			if(unTroncon.getSaRoute().equals(routeDevientIndispo))
				return true;
		}
		return false;
	}
	
	public Itineraire rafraichirItineraire(){
		// on fait recalculer l'user
		theProgps.getSonUser().rafraichirItineraire();
		return theProgps.getSonUser().getItineraireCourant();
	}
}