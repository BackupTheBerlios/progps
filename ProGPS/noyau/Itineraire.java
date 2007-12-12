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
	
	public Ville getVilleSuivante(Ville lastVilleTrav) {
		int i=0;
		Ville v1 = (Ville)lesTroncons.get(0).getSesVilles().toArray()[0];
		Ville v2 = (Ville)lesTroncons.get(0).getSesVilles().toArray()[1];
		while (lastVilleTrav != v1 && lastVilleTrav != v2) {
			i++;
			v1 = (Ville)lesTroncons.get(i).getSesVilles().toArray()[0];
			v2 = (Ville)lesTroncons.get(i).getSesVilles().toArray()[1];
		}
		
		if (i == lesTroncons.size()) {		// On est sur le dernier troncon, la prochaine ville traversée est donc la ville d'arrivée
			if (lastVilleTrav == v1) {
				return v2;
			}
			else return v1;
		}
		else {
			Troncon troncSuiv = lesTroncons.get(i+1);
			// Si la dernière ville traversée est sur le troncon suivant, alors la prochaine ville est l'autre ville du troncon suivant
			if (lastVilleTrav == (Ville)troncSuiv.getSesVilles().toArray()[0]) {
				return (Ville)troncSuiv.getSesVilles().toArray()[1]; 
			}
			else if (lastVilleTrav == (Ville)troncSuiv.getSesVilles().toArray()[1]) {
				return (Ville)troncSuiv.getSesVilles().toArray()[0]; 
			}
			// Sinon la prochaine ville est l'autre ville du troncon courant
			else if (lastVilleTrav == v1) {
				return v2;
			}
			else if (lastVilleTrav == v2) {
				return v1;
			}
		}
		return null;
		
	}
	
	public String getTempsTotal() {
		String temps = "";
		int time = 0;
		for (int i=0; i < lesTroncons.size(); i++) {
			time += (((float)lesTroncons.get(i).getLongueur()/(float)lesTroncons.get(i).getVitesse())*3600);
		}
		int h = time/3600;
		int m = (time%3600)/60;
		int s = (time%3600)%60;
		
		temps += h + "h" + m + "m" + s + "s";
		
		return temps;
	}
	
	
}