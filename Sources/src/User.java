import java.util.List;
import java.util.Vector;

public class User {
	private List<Ville> villeEtapes = new Vector<Ville>();
	private Ville villeSuivante;
	private SingletonProgps unnamed_SingletonProgps_;
	private Ville villeD;
	private Ville villeA;
	private List<Ville> villesAEviter = new Vector<Ville>();
	private List<Preferance> sesPreferences = new Vector<Preferance>();
	private Itineraire itineraireCourant;
	private List<Itineraire> itineraireCalcules = new Vector<Itineraire>();
	private List<Ville> villesTraversees = new Vector<Ville>();

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
		this.villeEtapes.add(villeEtapes);
	}

	public void removeVilleEtapes(Ville villeEtapes) {
		this.villeEtapes.remove(villeEtapes);
	}

	public Ville[] toVilleEtapesArray() {
		Ville[] lVilleEtapes_Temp = new Ville[this.villeEtapes.size()];
		this.villeEtapes.toArray(lVilleEtapes_Temp);
		return lVilleEtapes_Temp;
	}

	public void setVilleSuivante(Ville villeSuivante) {
		this.villeSuivante = villeSuivante;
	}

	public Ville getVilleSuivante() {
		return this.villeSuivante;
	}

	public void setVilleD(Ville villeD) {
		this.villeD = villeD;
	}

	public Ville getVilleD() {
		return this.villeD;
	}

	public void setVilleA(Ville villeA) {
		this.villeA = villeA;
	}

	public Ville getVilleA() {
		return this.villeA;
	}

	public void addVillesAEviter(Ville villesAEviter) {
		this.villesAEviter.add(villesAEviter);
	}

	public void removeVillesAEviter(Ville villesAEviter) {
		this.villesAEviter.remove(villesAEviter);
	}

	public Ville[] toVillesAEviterArray() {
		Ville[] lVillesAEviter_Temp = new Ville[this.villesAEviter.size()];
		this.villesAEviter.toArray(lVillesAEviter_Temp);
		return lVillesAEviter_Temp;
	}

	public void addSesPreferences(Preferance sesPreferences) {
		this.sesPreferences.add(sesPreferences);
	}

	public void removeSesPreferences(Preferance sesPreferences) {
		this.sesPreferences.remove(sesPreferences);
	}

	public Preferance[] toSesPreferencesArray() {
		Preferance[] lSesPreferences_Temp = new Preferance[this.sesPreferences.size()];
		this.sesPreferences.toArray(lSesPreferences_Temp);
		return lSesPreferences_Temp;
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

	public Itineraire[] toItineraireCalculesArray() {
		Itineraire[] lItineraireCalcules_Temp = new Itineraire[this.itineraireCalcules.size()];
		this.itineraireCalcules.toArray(lItineraireCalcules_Temp);
		return lItineraireCalcules_Temp;
	}

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
}