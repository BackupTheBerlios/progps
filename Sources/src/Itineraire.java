import java.util.List;
import java.util.Vector;

public class Itineraire {
	private int longueurTotal;
	private int nbRadars;
	private int prix;
	private int distanceTouristique;
	private int vitesseMin;
	private int vitesseMax;
	private Troncon tronconCourant;
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

	public void addLesTroncons(Troncon lesTroncons) {
		this.lesTroncons.add(lesTroncons);
	}

	public void removeLesTroncons(Troncon lesTroncons) {
		this.lesTroncons.remove(lesTroncons);
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