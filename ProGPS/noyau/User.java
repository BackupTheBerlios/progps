package noyau;

import java.util.ArrayList;
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

	private Itineraire itineraireCourant;
	private List<Itineraire> itineraireCalcules = new Vector<Itineraire>();

	private List<Ville> villesTraversees = new Vector<Ville>();
	private List<Troncon> tronconsTraverses = new ArrayList<Troncon>();

	private int vitesseMin=50;


	public void setVitesseMin(int vitesseMin) {
		this.vitesseMin = vitesseMin;
		theProgps.graph.setVitesseMin(vitesseMin);
	}

	public boolean calculerIti(){
		try {
			// Julien
			this.villesTraversees.clear();
			
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

	private void mettreAjourItiCourant(Itineraire nouvelItiASuivre){
		Itineraire nouveau = new Itineraire();
		
		nouveau.setVilleDepart(villeD);
		nouveau.setVilleArrivee(villeA);
		
		// On ajoute tous les troncons déjà visités
		for (Troncon unTronc : tronconsTraverses) {
			nouveau.addUnTroncon(unTronc);
		}
		
		nouveau.concat(nouvelItiASuivre);
		
		nouveau.setTronconCourant(getDernierTronconParcouru());
//		nouveau.setTronconCourant(nouvelItiASuivre.getTronconCourant());
		
		itineraireCourant=nouveau;
	}
	
	public boolean rafraichirItineraire(){
		Ville villeActuelle=getDerniereVilleTraversee();

		try {
			// Les villes étapes n'incluent plus les villes par lesquelle l'utilisateur est passé
			villesEtapes.removeAll(villesTraversees);
			threadOrd.setVillesEtapes(villeActuelle, villeA, villesEtapes);

			List<Ville> listeVilleEtape=null;
			// Tant que le thread n'a pas fini.
			while (listeVilleEtape==null) {
				listeVilleEtape=threadOrd.getVillesOrdonnees();
			}
			Itineraire nouvelItiASuivre=theProgps.graph.trouverLeChemin(villeActuelle, villeA, villesAEviter, listeVilleEtape);

			mettreAjourItiCourant(nouvelItiASuivre);
			
			// Met à jour la ville suivante
			villeSuivante=itineraireCourant.getVilleSuivante(villeActuelle);

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
		if(villeEtapes==null)
			return;
		this.villesEtapes.add(villeEtapes);
		// On indique au thread
		threadOrd.setVillesEtapes(villeD, villeA, this.villesEtapes);
	}

	public void removeVilleEtapes(Ville villeEtapes) {
		if(villeEtapes==null)
			return;
		this.villesEtapes.remove(villeEtapes);
		// On indique au thread
		threadOrd.setVillesEtapes(villeD, villeA, this.villesEtapes);
	}

	public Ville getDerniereVilleTraversee(){
		if(villesTraversees.size()==0)
			return villeD;
		else return villesTraversees.get(villesTraversees.size()-1);
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
		if(villeAEviter==null)
			return;
		this.villesAEviter.add(villeAEviter);
		theProgps.graph.addVilleAEviter(villeAEviter);
	}

	public void removeVilleAEviter(Ville villeAEviter) {
		if(villeAEviter==null)
			return;
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

	public void setItineraireCourant(Itineraire itineraireCourant){
		this.itineraireCourant = itineraireCourant;
		villeD=itineraireCourant.getVilleDep();
		villeA=itineraireCourant.getVilleArr();
		villeSuivante=itineraireCourant.getVilleSuivante(villeD);
	}

	public Itineraire getItineraireCourant() {
		return this.itineraireCourant;
	}

	public Set<Ville> getVillesAccessibles(){
		Ville villeActuelle=getDerniereVilleTraversee();

		Set<Ville> result=new HashSet<Ville>();

		Set<Troncon> lesTronconsAccessibles=theProgps.graph.edgesOf(villeActuelle);
		for (Troncon unTroncon : lesTronconsAccessibles) {
			result.addAll(unTroncon.getSesVilles());
		}

		result.remove(villeActuelle);
		return result;
	}

	public boolean avancerA(Ville v){

		if(!v.equals(villeSuivante)){
			Ville precedente=getDerniereVilleTraversee();

			// Ajoute la ville traversée
			this.villesTraversees.add(v);
			Set<Troncon> tousLesTroncons=theProgps.graph.getAllEdges(precedente, v);
			
			
			for (Troncon unTroncon : tousLesTroncons) {
				this.tronconsTraverses.add(unTroncon);
				break;
			}
			
			if(v.equals(villeA))
				return true;
			
			rafraichirItineraire();
		}else{
			// Ajoute la ville traversée
			this.villesTraversees.add(v);
//			Ajoute le troncon utilisé
			this.tronconsTraverses.add(itineraireCourant.getTronconCourant());
			// Teste si on est au bout de l'iti
			if(v.equals(villeA))
				return true;
			
			try {
				villeSuivante=itineraireCourant.getVilleSuivante(v);
				itineraireCourant.passerAuTronconSuivant();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public Troncon getDernierTronconParcouru(){
		if(tronconsTraverses.size()<1)
			return null;

		return tronconsTraverses.get(tronconsTraverses.size()-1);
	}

	public void setVilleEtapes(Set<Ville> villeEtapes) {
		this.villesEtapes = villeEtapes;
	}

	public void setPlusCourt(boolean b){
		theProgps.graph.setPlusCourt(b);
	}

	public int getVitesseMin() {
		return vitesseMin;
	}

	public Set<Ville> getVillesAEviter() {
		return villesAEviter;
	}


	public Set<Ville> getVillesEtapes() {
		return villesEtapes;
	}


}