package noyau;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import exceptions.ExceptionRecherche;

public class Troncon 
	extends DefaultWeightedEdge
	{
	private int vitesse;
	private int longueur;
	private boolean dispo;
	private Route saRoute;
	private List<Etat> sesEtats = new ArrayList<Etat>();
	private Route route;
	private Ville ville1;
	private Ville ville2;
	
	public Troncon() {
	}
	
	public Troncon(int vitesse, int longueur, boolean dispo, Route route2, Ville ville1, Ville ville2, LinkedList<Etat> sesEtats) {
		super();
		this.vitesse = vitesse;
		this.longueur = longueur;
		this.dispo = dispo;
		this.route = route2;
		this.ville1 = ville1;
		this.ville2 = ville2;
		this.sesEtats = sesEtats;
	}

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
		Set villes = new HashSet<Ville>();
		villes.add(ville1);
		villes.add(ville2);
		return villes;
	}

	
	public List<Etat> getSesEtats() {
		return this.sesEtats;
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
		return (ville1.equals(laVille) || ville2.equals(laVille));
	}
	
	public boolean isRelieVille(Set<Ville> lesVilles) {
		for (Iterator iter = lesVilles.iterator(); iter.hasNext();) {
			Ville uneVille = (Ville) iter.next();
			if (this.isRelieVille(uneVille)) return true;
		}
		return false;
	}

	public void setSesVilles(Ville ville1, Ville ville2) {
		this.ville1=ville1;
		this.ville2=ville2;
	}
	
	public void addEtat(Etat e) throws ExceptionRecherche {
		Iterator<Etat> it = this.sesEtats.iterator();
		Etat et;
		while (it.hasNext()) {
			et=(Etat)it.next();
			if (et.name().equals(e.name()))
				throw new ExceptionRecherche("Ce tron�on est deja classifi� comme "+e.name()+".");
		}
		this.sesEtats.add(e);
	}
	
	
	//renvoit true si l'�tat a �t� supprim�, false s'il n'a pas �t� trouv�
	public boolean removeEtat(String s) {
		Iterator<Etat> it = this.sesEtats.iterator();
		Etat et;
		while (it.hasNext()) {
			et=(Etat)it.next();
			if (et.name().equals(s)) {
				this.sesEtats.remove(et);
				return true;
			}
		}
		return false;
	}
	
	public boolean isPayant() {
		Iterator<Etat> it = this.sesEtats.iterator();
		Etat et;
		while (it.hasNext()) {
			et=(Etat)it.next();
			if (et.name().equals("Payant"))
				return true;
		}
		return false;
	}
	
	public boolean isTouristique() {
		Iterator<Etat> it = this.sesEtats.iterator();
		Etat et;
		while (it.hasNext()) {
			et=(Etat)it.next();
			if (et.name().equals("Touristique"))
				return true;
		}
		return false;
	}
	
	public boolean isRadar() {
		Iterator<Etat> it = this.sesEtats.iterator();
		Etat et;
		while (it.hasNext()) {
			et=(Etat)it.next();
			if (et.name().equals("Radar"))
				return true;
		}
		return false;
	}

	public void setSesEtats(List<Etat> setEtats) {
		this.sesEtats = setEtats;
	}
	
}