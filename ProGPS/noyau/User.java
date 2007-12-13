package noyau;

import java.util.*;

import exceptions.ExceptionRecherche;

import threads.ThreadOrdonancementVillesEtapes;

public class User {
	private Ville villeSuivante;
	private SingletonProgps theProgps;
	
	private ThreadOrdonancementVillesEtapes<Ville, Troncon> threadOrd;
	
	private Ville villeD;
	private Ville villeA;
	private Set<Ville> villesAEviter = new HashSet<Ville>();
	private Set<Ville> villesEtapes = new HashSet<Ville>();
	private List<Preference> sesPreferences = new Vector<Preference>();
	private Itineraire itineraireCourant;
	private List<Itineraire> itineraireCalcules = new Vector<Itineraire>();
	private List<Ville> villesTraversees = new Vector<Ville>();
	
	
	public boolean calculerIti(){
		try {
			itineraireCalcules=theProgps.graph.trouver3Chemins(villeD, villeA, villesAEviter, villesEtapes);
			return true;
		} catch (ExceptionRecherche e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public User(SingletonProgps leSingleton) {
		theProgps=leSingleton;
		threadOrd=new ThreadOrdonancementVillesEtapes<Ville, Troncon>(theProgps.graph, null, null, null);
	}
	
	public boolean choisirItineraire(Itineraire iti) {
		throw new UnsupportedOperationException();
	}

	public void demandeItineraire() {
		throw new UnsupportedOperationException();
	}

	public void calculItineraire() {
		throw new UnsupportedOperationException();
	}

	public String localisation(String ville) {
		throw new UnsupportedOperationException();
	}

	public void finItineraire() {
		throw new UnsupportedOperationException();
	}

	public void rafraichirItineraire(Troncon t) {
		throw new UnsupportedOperationException();
	}

	public void rafraichirItineraire(Ville v) {
		throw new UnsupportedOperationException();
	}

	public void rafraichirItineraire(Route r) {
		throw new UnsupportedOperationException();
	}

	public void addVilleEtapes(Ville villeEtapes) {
		this.villesEtapes.add(villeEtapes);
	}

	public void removeVilleEtapes(Ville villeEtapes) {
		this.villesEtapes.remove(villeEtapes);
	}

	public Ville[] toVilleEtapesArray() {
		Ville[] lVilleEtapes_Temp = new Ville[this.villesEtapes.size()];
		this.villesEtapes.toArray(lVilleEtapes_Temp);
		return lVilleEtapes_Temp;
	}

	public void setVilleSuivante(Ville villeSuivante) {
		// TODO
		this.villeSuivante = villeSuivante;
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

//	public Ville[] toVillesAEviterArray() {
//		Ville[] lVillesAEviter_Temp = new Ville[this.villesAEviter.size()];
//		this.villesAEviter.toArray(lVillesAEviter_Temp);
//		return lVillesAEviter_Temp;
//	}

	
	//prend un tableau déjà trié de préférences et les ajoute à celles de l'utilisateur
	//à clément de renvoyer un tableau deja trié avec l'interface
	public void setSesPreferences(List<Preference> l) {
		this.sesPreferences=l;
	}



	public void setItineraireCourant(Itineraire itineraireCourant) {
		this.itineraireCourant = itineraireCourant;
	}

	public Itineraire getItineraireCourant() {
		return this.itineraireCourant;
	}

	public void addItineraireCalcules(Itineraire itineraireCalcules) {
		this.itineraireCalcules.add(itineraireCalcules);
	}

	public void removeItineraireCalcules(Itineraire itineraireCalcules) {
		this.itineraireCalcules.remove(itineraireCalcules);
	}

//	public Itineraire[] toItineraireCalculesArray() {
//		Itineraire[] lItineraireCalcules_Temp = new Itineraire[this.itineraireCalcules.size()];
//		this.itineraireCalcules.toArray(lItineraireCalcules_Temp);
//		return lItineraireCalcules_Temp;
//	}

	public void addVillesTraversees(Ville villesTraversees) {
		this.villesTraversees.add(villesTraversees);
	}

	public void removeVillesTraversees(Ville villesTraversees) {
		this.villesTraversees.remove(villesTraversees);
	}

	public Ville[] toVillesTraverseesArray() {
		Ville[] lVillesTraversees_Temp = new Ville[this.villesTraversees.size()];
		this.villesTraversees.toArray(lVillesTraversees_Temp);
		return lVillesTraversees_Temp;
	}

	public void setVilleEtapes(Set<Ville> villeEtapes) {
		this.villesEtapes = villeEtapes;
		theProgps.graph.setEtapes(villeEtapes);
	}
}