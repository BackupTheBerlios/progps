package noyau;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Troncon 
	extends DefaultWeightedEdge
	{
	private int vitesse;
	private int longueur;
	private boolean dispo;
	private List<Ville> sesVilles = new Vector<Ville>();
	private Route saRoute;
	private List<Etat> setEtats = new Vector<Etat>();
	
	public void genererValeursAleatoires(){
		Random rand = new Random();
		// 50 <= Vitesse <= 130 
		vitesse=Math.round(rand.nextFloat()*80)+50;
		// 0 <= Longueur <= 300
		longueur=Math.round(rand.nextFloat()*300);
		// Dispo ou non
		dispo=(rand.nextBoolean());
	}

	public Set<Ville> getSesVilles() {
		Set villes = new HashSet<Ville>(sesVilles);
		return villes;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getVitesse() {
		return this.vitesse;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLongueur() {
		return this.longueur;
	}
	
	public Route getSaRoute() {
		return saRoute;
	}

	public void setSaRoute(Route saRoute) {
		this.saRoute = saRoute;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public boolean isRelieVille(Ville laVille) {
		return sesVilles.contains(laVille);
	}
	
	public boolean isRelieVille(Set<Ville> lesVilles) {
		for (Iterator iter = lesVilles.iterator(); iter.hasNext();) {
			Ville uneVille = (Ville) iter.next();
			if (sesVilles.contains(uneVille)) return true;
		}
		return false;
	}

	public void setSesVilles(Ville ville1, Ville ville2) {
		List<Ville> lesVilles = new ArrayList<Ville>();
		lesVilles.add(ville1);
		lesVilles.add(ville2);
		this.sesVilles = lesVilles;
	}
	
	public void addEtat(Etat e) {
		this.setEtats.add(e);
	}
}