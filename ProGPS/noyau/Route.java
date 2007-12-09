package noyau;

import java.util.List;
import java.util.Vector;




public class Route {
	private Object idRoute;
	private String nomRoute;
	private int typeRoute;
	private List<Troncon> sesTroncons = new Vector<Troncon>();

	/** Constructeur de route
	 * Ne vérifie pas si une route a déjà le même nom !
	 * 
	 * @param nomRoute
	 * @param typeRoute
	 */
	public Route(String nomRoute, int typeRoute) {
		super();
		this.nomRoute = nomRoute;
		this.typeRoute = typeRoute;
	}
	
	public boolean ajouterTroncon(String ville1, String ville2, int vitesse, boolean touristique, boolean radar, int prix, int longueur) {
		throw new UnsupportedOperationException();
	}

	public boolean supprimerTroncon(boolean ville1, String ville2) {
		throw new UnsupportedOperationException();
	}

	public boolean modifierEtatTroncon(String ville1, String ville2, String route) {
		throw new UnsupportedOperationException();
	}

	public Troncon[] toSesTronconsArray() {
		Troncon[] lSesTroncons_Temp = new Troncon[this.sesTroncons.size()];
		this.sesTroncons.toArray(lSesTroncons_Temp);
		return lSesTroncons_Temp;
	}

}