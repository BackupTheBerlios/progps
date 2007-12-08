import java.util.List;
import java.util.Vector;

public class Itineraire {
	private int longueurTotal=0;
	private int nbRadars=0;
	private int prix=0;
	private int distanceTouristique=0;
	private int vitesseMin=0;
	private int vitesseMax=0;
	private Troncon tronconCourant=null;
	private List<Troncon> lesTroncons = new Vector<Troncon>();
	
	public Ville getVilleSuivante(Ville derniereVilleTraversé) {
		throw new UnsupportedOperationException();
	}

	public Itineraire refraichirItineraire() {
		throw new UnsupportedOperationException();
	}

	public void setTronconCourant(Troncon tronconCourant) {
		this.tronconCourant = tronconCourant;
	}

	public Troncon getTronconCourant() {
		return this.tronconCourant;
	}

	public void addUnTroncon(Troncon unTroncon) {
		this.lesTroncons.add(unTroncon);
		//TODO Modifier tous les compteurs !
		longueurTotal+=unTroncon.getLongueur();
		
	}

	public void removeUnTroncon(Troncon unTroncon) {
		this.lesTroncons.remove(unTroncon);
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
}