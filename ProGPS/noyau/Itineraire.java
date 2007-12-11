package noyau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class Itineraire {
	private Ville villeDepart;
	private Ville villeArrivee;
	private int longueurTotal=0;
	private int nbRadars=0;
	private int prix=0;
	private int distanceTouristique=0;
	private int vitesseMin=0;
	private int vitesseMax=0;
	private Troncon tronconCourant=null;
	private List<Troncon> lesTroncons = new ArrayList<Troncon>();
	


	public void setVilleArrivee(Ville villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}

	public Itineraire refraichirItineraire() {
		throw new UnsupportedOperationException();
	}

	public void setTronconCourant(Troncon tronconCourant) {
		this.tronconCourant = tronconCourant;
	}


	public void addUnTroncon(Troncon unTroncon) {
		this.lesTroncons.add(unTroncon);
		//TODO Modifier tous les compteurs !
		longueurTotal+=unTroncon.getLongueur();
	}

	public void removeUnTroncon(Troncon unTroncon) {
		this.lesTroncons.remove(unTroncon);
		// TODO modifier tous les compteurs
		longueurTotal-=unTroncon.getLongueur();
	}

	public Troncon[] toLesTronconsArray() {
		Troncon[] lLesTroncons_Temp = new Troncon[this.lesTroncons.size()];
		this.lesTroncons.toArray(lLesTroncons_Temp);
		return lLesTroncons_Temp;
	}

	public int getLongueurTotal() {
		return this.longueurTotal;
	}

	public int getNbRadars() {
		return this.nbRadars;
	}

	public int getPrix() {
		return this.prix;
	}

	public int getDistanceTouristique() {
		return this.distanceTouristique;
	}

	public void setVitesseMin(int vitesseMin) {
		this.vitesseMin = vitesseMin;
	}

	public int getVitesseMin() {
		return this.vitesseMin;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public int getVitesseMax() {
		return this.vitesseMax;
	}
	
	public String toString(){
		// TODO à completer
		String mess = "---- Description ----";
		mess +="\nLongueur : "+this.longueurTotal+" km";
		mess +="\nDepart : "+this.villeDepart.getNomVille();
		mess +="\nArrivee : "+this.villeArrivee.getNomVille();
		
		Ville derniereVilleVue = this.villeDepart;
		mess += "\nNbr d'étapes : "+lesTroncons.size();
		
		for (Iterator iter = lesTroncons.iterator(); iter.hasNext();) {
			Troncon unTroncon = (Troncon) iter.next();
			for (Iterator iterator = unTroncon.getSesVilles().iterator(); iterator.hasNext();) {
				Ville uneVilleReliee = (Ville) iterator.next();
				if (uneVilleReliee.equals(derniereVilleVue)) {
					mess += "\nPartir de "+derniereVilleVue.getNomVille();
					derniereVilleVue=((Ville) iterator.next());
					mess += " vers "+derniereVilleVue.getNomVille();
				} else {
					mess += "\nPartir de "+derniereVilleVue.getNomVille()+" vers "+uneVilleReliee.getNomVille();
					derniereVilleVue=uneVilleReliee;
					iterator.next();
				}
			}
		}
		return mess;
	}
	
	public Ville getVilleDep() {
		return this.villeDepart;
	}
	
	public Ville getVilleArr() {
		return this.villeArrivee;
	}
	
	public List<Troncon> getLesTroncons() {
		return this.lesTroncons;
	}
	
	public Troncon getTronconCourant() {
		return this.tronconCourant;
	}
	
	public int getLongueurTotale() {
		return this.longueurTotal;
	}
	

	
	
}