import java.util.List;
import java.util.Vector;

public class SingletonProgps {
	private Object singletonProgps;
	private List<Ville> sesVilles = new Vector<Ville>();
	private List<Route> sesRoutes = new Vector<Route>();
	private List<Admin> sesAdmins = new Vector<Admin>();
	private List<User> sesUtilisateurs = new Vector<User>();

	public SingletonProgps getInstance() {
		throw new UnsupportedOperationException();
	}

	public void rafraichirItineraireRoute(String nomRoute) {
		throw new UnsupportedOperationException();
	}

	public void rafraichirItineraireTroncon(String ville1, String ville2, String nomRoute) {
		throw new UnsupportedOperationException();
	}

	public void rafraichirItineraireVille(String nomVille) {
		throw new UnsupportedOperationException();
	}

	public Itineraire creerItineraire(String villeD, String villeA, String villeAEviter, String villeEtapes) {
		throw new UnsupportedOperationException();
	}

	public Ville[] toSesVillesArray() {
		Ville[] lSesVilles_Temp = new Ville[this.sesVilles.size()];
		this.sesVilles.toArray(lSesVilles_Temp);
		return lSesVilles_Temp;
	}

	public Route[] toSesRoutesArray() {
		Route[] lSesRoutes_Temp = new Route[this.sesRoutes.size()];
		this.sesRoutes.toArray(lSesRoutes_Temp);
		return lSesRoutes_Temp;
	}
}