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

	public boolean ajouterTroncon(Troncon unT){
		return sesTroncons.add(unT);
	}

	public int getIdRoute() {
		return idRoute;
	}
	
	public boolean isDispoRoute() {
		int cpt=0;
		for (Troncon t : this.sesTroncons) {
			if (!t.isDispo())
				cpt++;
		}
		return !(cpt==this.sesTroncons.size());
	}
	
	
	public void setType(int t) {
		this.typeRoute=t;
	}
	
	public void setNom(String n) {
		this.nomRoute=n;
	}
	public void setDispoRoute(boolean b) {
		for (Troncon t : this.sesTroncons) {
			t.setDispo(b);
		}
	}

	public String getNomRoute() {
		return nomRoute;
	}
	
	public int getTypeRoute() {
		return typeRoute;
	}

//	public boolean modifierEtatTroncon(String ville1, String ville2, String route) {
//		throw new UnsupportedOperationException();
//	}
//
//	public boolean supprimerTroncon(boolean ville1, String ville2) {
//		throw new UnsupportedOperationException();
//	}

//	public Troncon[] toSesTronconsArray() {
//		Troncon[] lSesTroncons_Temp = new Troncon[this.sesTroncons.size()];
//		this.sesTroncons.toArray(lSesTroncons_Temp);
//		return lSesTroncons_Temp;
//	}
	
	public List<Troncon> getSesTroncons() {
		return this.sesTroncons;
	}

}