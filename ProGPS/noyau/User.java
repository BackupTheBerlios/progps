package noyau;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import threads.ThreadOrdonancementVillesEtapes;

public class User {
	private Ville villeSuivante;
	private SingletonProgps theProgps;
	
	private ThreadOrdonancementVillesEtapes<Ville, Troncon> threadOrd;
	
	private Ville villeD;
	private Ville villeA;
	private Set<Ville> villesAEviter = new HashSet<Ville>();
	private Set<Ville> villesEtapes = new HashSet<Ville>();
//	private List<Preference> sesPreferences = new Vector<Preference>();
	private Itineraire itineraireCourant;
	private List<Itineraire> itineraireCalcules = new Vector<Itineraire>();
	private List<Ville> villesTraversees = new Vector<Ville>();
	
	
	public boolean calculerIti(){
		try {
			List<Ville> listeVilleEtape=null;
			listeVilleEtape=threadOrd.getVillesOrdonnees();
			// Tant que le thread n'a pas fini.
			while (listeVilleEtape==null) {
				Thread.sleep(500);
				listeVilleEtape=threadOrd.getVillesOrdonnees();
			}
			itineraireCalcules=theProgps.graph.trouver3Chemins(villeD, villeA, villesAEviter, listeVilleEtape);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public User(SingletonProgps leSingleton) {
		theProgps=leSingleton;
		threadOrd=new ThreadOrdonancementVillesEtapes<Ville, Troncon>(theProgps.graph, null, null, null);
		threadOrd.start();
	}

	public void addVilleEtapes(Ville villeEtapes) {
		this.villesEtapes.add(villeEtapes);
		// On indique au thread
		threadOrd.setVillesEtapes(villeD, villeA, this.villesEtapes);
	}

	public void removeVilleEtapes(Ville villeEtapes) {
		this.villesEtapes.remove(villeEtapes);
		// On indique au thread
		threadOrd.setVillesEtapes(villeD, villeA, this.villesEtapes);
	}

	public List<Itineraire> getItineraireCalcules() {
		return itineraireCalcules;
	}

	public List<Ville> getVillesTraversees() {
		return villesTraversees;
	}

	public Ville getVilleSuivante() {
		return this.villeSuivante;
	}

	public void setVilleD(Ville villeD) {
		this.villeD = villeD;
		threadOrd.setVillesEtapes(villeD, villeA, villesAEviter);
	}

	public Ville getVilleD() {
		return this.villeD;
	}

	public void setVilleA(Ville villeA) {
		this.villeA = villeA;
		threadOrd.setVillesEtapes(villeD, villeA, villesEtapes);
	}

	public Ville getVilleA() {
		return this.villeA;
	}

	public void addVilleAEviter(Ville villeAEviter) {
		this.villesAEviter.add(villeAEviter);
		theProgps.graph.addVilleAEviter(villeAEviter);
	}

	public void removeVilleAEviter(Ville villeAEviter) {
		this.villesAEviter.remove(villeAEviter);
		theProgps.graph.removeVilleAEviter(villeAEviter);
	}
	
	//prend un tableau déjà trié de préférences et les ajoute à celles de l'utilisateur
	//à GUI de trier les préférences
	public void setSesPreferences(List<Preference> l) {
		this.theProgps.graph.setPreferences(l);
	}
	
	public List<Preference> getPreferences(){
		return this.theProgps.graph.getPreferences();
	}

	public void activerPreference(Preference p){
		this.theProgps.graph.activerPref(p);
	}
	
	public void desactiverPreference(Preference p){
		this.theProgps.graph.desactiverPref(p);
	}
	
	public void setItineraireCourant(Itineraire itineraireCourant) {
		this.itineraireCourant = itineraireCourant;
		villeD=itineraireCourant.getVilleDep();
		villeA=itineraireCourant.getVilleArr();
		villeSuivante=itineraireCourant.getVilleSuivante(villeD);
	}

	public Itineraire getItineraireCourant() {
		return this.itineraireCourant;
	}
	
	public boolean avancerA(Ville v){
		this.villesEtapes.add(v);
		if(!v.equals(villeSuivante)){
			try {
				// Les villes étapes n'incluent plus les villes par lesquelle l'utilisateur est passé
				villesEtapes.removeAll(villesTraversees);
				threadOrd.setVillesEtapes(villeD, villeA, villesEtapes);
				
				List<Ville> listeVilleEtape=null;
				// Tant que le thread n'a pas fini.
				while (listeVilleEtape==null) {
					listeVilleEtape=threadOrd.getVillesOrdonnees();
				}
				itineraireCourant=theProgps.graph.trouverLeChemin(v, villeA, villesAEviter, listeVilleEtape);
			} catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
		}
		return true;
	}

	public void setVilleEtapes(Set<Ville> villeEtapes) {
		this.villesEtapes = villeEtapes;
	}
}