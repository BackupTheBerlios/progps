package noyau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class Itineraire {
	private Ville villeDepart;
	private Ville villeArrivee;
	private int longueurTotal=0;
	private int nbRadars=0;
	private int distancePayante=0;
	private int distanceTouristique=0;
	private int vitesseMin=Integer.MAX_VALUE;
	private int vitesseMax=Integer.MIN_VALUE;
	private double poidTotal=0.0;
	private Troncon tronconCourant=null;
	private List<Troncon> lesTroncons = new ArrayList<Troncon>();
	
	public Itineraire concat(Itineraire itiFin){
		villeArrivee=itiFin.villeArrivee;
		longueurTotal+=itiFin.getLongueurTotal();
		nbRadars+=itiFin.getNbRadars();
		distancePayante+=itiFin.getDistancePayante();
		distanceTouristique+=itiFin.getDistanceTouristique();
		if(itiFin.getVitesseMin()<this.vitesseMin)
			vitesseMin=itiFin.getVitesseMin();
		if(itiFin.getVitesseMax()>this.vitesseMax)
			vitesseMax=itiFin.getVitesseMax();
		lesTroncons.addAll(itiFin.getLesTroncons());		
		return this;
	}

	public void addUnTroncon(Troncon unTroncon) {
		if(lesTroncons.size()==0)
			tronconCourant=unTroncon;
		this.poidTotal+=(SingletonProgps.getInstance()).graph.getEdgeWeight(unTroncon);
		this.lesTroncons.add(unTroncon);
		longueurTotal+=unTroncon.getLongueur();
		if(unTroncon.isPayant())
			distancePayante+=unTroncon.getLongueur();
		if(unTroncon.isRadar())
			nbRadars++;
		if(unTroncon.isTouristique())
			distanceTouristique+=unTroncon.getLongueur();
		if(unTroncon.getVitesse()>vitesseMax)
			vitesseMax=unTroncon.getVitesse();
		if(unTroncon.getVitesse()<vitesseMin)
			vitesseMin=unTroncon.getVitesse();
	}

	public int getDistanceTouristique() {
		return this.distanceTouristique;
	}

	public List<Troncon> getLesTroncons() {
		return this.lesTroncons;
	}

	public int getLongueurTotal() {
		return this.longueurTotal;
	}


	public int getNbRadars() {
		return this.nbRadars;
	}

	public int getDistancePayante() {
		return this.distancePayante;
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

	public Troncon getTronconCourant() {
		return this.tronconCourant;
	}

	public Ville getVilleArr() {
		return this.villeArrivee;
	}

	public Ville getVilleDep() {
		return this.villeDepart;
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
		
		if (i == lesTroncons.size()-1) {		// On est sur le dernier troncon, la prochaine ville traversée est donc la ville d'arrivée
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

	public int getVitesseMax() {
		if(this.lesTroncons.size()>0)
		return this.vitesseMax;
		return -1;
	}

	public int getVitesseMin() {
		if(this.lesTroncons.size()>0)
		return this.vitesseMin;
		return -1;
	}

	public double getPoidTotal() {
		return poidTotal;
	}

	public void removeUnTroncon(Troncon unTroncon) {
		this.poidTotal-=(SingletonProgps.getInstance()).graph.getEdgeWeight(unTroncon);
		this.lesTroncons.remove(unTroncon);
		longueurTotal-=unTroncon.getLongueur();
		if(unTroncon.isPayant())
			distancePayante-=unTroncon.getLongueur();
		if(unTroncon.isRadar())
			nbRadars--;
		if(unTroncon.isTouristique())
			distanceTouristique-=unTroncon.getLongueur();
		if(this.lesTroncons.size()>0){
			vitesseMax=Integer.MIN_VALUE;
			vitesseMin=Integer.MAX_VALUE;
			for (Troncon unTr : this.lesTroncons) {
				if(unTr.getVitesse()>vitesseMax)
					vitesseMax=unTr.getVitesse();
				if(unTr.getVitesse()>vitesseMin)
					vitesseMin=unTr.getVitesse();
			}
		}
	}
	
	public void setTronconCourant(Troncon tronconCourant) {
		this.tronconCourant = tronconCourant;
	}
	
	public void setVilleArrivee(Ville villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	
	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}
	
	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
	public void setVitesseMin(int vitesseMin) {
		this.vitesseMin = vitesseMin;
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
				mess+=" sur route :"+unTroncon.getSaRoute().getNomRoute();
			}
		}
		return mess;
	}
	
	
	
	public int compteRadar() {
		int cpt=0;
		for (Troncon t : lesTroncons) {
			if (t.isRadar())
				cpt++;
		}
		return cpt;
	}
	
	public int comptePayant() {
		int cpt=0;
		for (Troncon t : lesTroncons) {
			if (t.isPayant())
				cpt++;
		}
		return cpt;
	}
	
	public int compteNonTouristique() {
		int cpt=0;
		for (Troncon t : lesTroncons) {
			for (Ville v : t.getSesVilles()) {
				if (!v.isTouristique())
					cpt++;
			}
			if (!t.isTouristique())
				cpt++;
		}
		return cpt;
	}
	
	public int compteVitesse() {
		int cpt=0;
		for (Troncon t : lesTroncons) {
			if (t.getVitesse()<SingletonProgps.getInstance().getSonUser().getVitesseMin())
				cpt++;
		}
		return cpt;
	}
	
	public int compteEviterViolees() {
		int cpt=0;
		for (Troncon t : lesTroncons) {
			if (t.isRelieVille(SingletonProgps.getInstance().getSonUser().getVillesAEviter()))
				cpt++;		
		}
		return cpt;
	}
	
	public int compteEtapesViolees() {
		Set<Ville> eTemp=SingletonProgps.getInstance().getSonUser().getVillesEtapes();
		for (Ville v : eTemp) {
			for (Troncon t : lesTroncons) {
				if (t.isRelieVille(v))
					eTemp.remove(v);
			}
		}
		return eTemp.size();
	}
	
	public Vector<Integer> getPrefViolees() {
		//Nb Radars, Nb non Touristique , Nb Vitesse violee, Nb villes etapes violees, Nb VillesAEviter violees, Nb troncons Payant
		Vector <Integer> v= new Vector<Integer>();
		List<Preference> ps = SingletonProgps.getInstance().graph.getPreferences();
		for (Preference p : ps) {
			if (!ps.contains(p))
				v.add(0);
			else {
				if (p.name().equals("Radars")) {
					v.add(this.compteRadar());
				}
				else if (p.name().equals("Touristique")) {
					v.add(this.compteNonTouristique());
				}
				else if (p.name().equals("Vitesse")) {
					v.add(this.compteVitesse());
				}
				else if (p.name().equals("Villes")) {
					v.add(this.compteEtapesViolees());
				}
				else if (p.name().equals("VillesAEviter")) {
					v.add(this.compteEviterViolees());
				}
				else if (p.name().equals("Payant")) {
					v.add(this.comptePayant());
				}
			}
		}
//		for (int i = 0; i < v.size(); i++) {
//			System.out.println(v.get(i));
//		}
		return v;
	}
	
	
}