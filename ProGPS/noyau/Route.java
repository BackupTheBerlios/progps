package noyau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class Route {
	public static final int AUTOROUTE = 0;
	public static final int NATIONALE = 1;
	public static final int DEPARTEMENTALE = 2;
	
	private int idRoute;
	private String nomRoute;
	private int typeRoute;
	private List<Troncon> sesTroncons = new ArrayList<Troncon>();

	public Route(int idRoute, String nomRoute, int typeRoute) {
		super();
		this.idRoute = idRoute;
		this.nomRoute = nomRoute;
		this.typeRoute = typeRoute;
	}
	
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

//	public void ajouterTroncon(String nomVille, String nomVille2, int intVitesse, int intLongueur, LinkedList<Etat> etats) throws Exception {
//		sesTroncons.add(new Troncon(intVitesse,intLongueur,true,this,SingletonProgps.getVille(nomVille),SingletonProgps.getVille(nomVille2),etats));
//	}

	public int getIdRoute() {
		return idRoute;
	}

	public String getNomRoute() {
		return nomRoute;
	}
	
	public int getTypeRoute() {
		return typeRoute;
	}

	public boolean modifierEtatTroncon(String ville1, String ville2, String route) {
		throw new UnsupportedOperationException();
	}

	public boolean supprimerTroncon(boolean ville1, String ville2) {
		throw new UnsupportedOperationException();
	}

	public Troncon[] toSesTronconsArray() {
		Troncon[] lSesTroncons_Temp = new Troncon[this.sesTroncons.size()];
		this.sesTroncons.toArray(lSesTroncons_Temp);
		return lSesTroncons_Temp;
	}

}