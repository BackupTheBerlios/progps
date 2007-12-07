public class Admin {
	private String nomAdmin;
	private String mdp;
	SingletonProgps unnamed_SingletonProgps_;

	private boolean ajouterRoute(String nom, String typeRoute) {
		throw new UnsupportedOperationException();
	}

	private boolean ajouterVille(String nom, int type, boolean touristique, boolean dispoVille) {
		throw new UnsupportedOperationException();
	}

	private boolean ajouterTroncon(String ville1, String ville2, String nomRoute, int vitesse, boolean touristique, int radar, int prix, int longueur) {
		throw new UnsupportedOperationException();
	}

	private boolean supprimerVille(String nom) {
		throw new UnsupportedOperationException();
	}

	private boolean supprimerRoute(String nomRoute) {
		throw new UnsupportedOperationException();
	}

	private boolean supprimerTroncon(String ville1, String ville2, String nomRoute) {
		throw new UnsupportedOperationException();
	}

	private boolean modiferEtatVille(String nom, boolean etat) {
		throw new UnsupportedOperationException();
	}

	private boolean modifierEtatTroncon(String ville1, String ville2, String nomRoute, boolean etat) {
		throw new UnsupportedOperationException();
	}

	private boolean modifierVille(String nomAnc, int typeAnc, boolean touristiqueAnc, String nomNew, int typeNew, boolean touristiqueNew) {
		throw new UnsupportedOperationException();
	}

	private boolean modifierRoute(String nomAnc, int typeAnc, String nomNew, int typeNew) {
		throw new UnsupportedOperationException();
	}

	private boolean modifierTroncon(String ville1, String ville2, String nomRoute, int vitesse, boolean touristique, boolean radar, boolean payant, int longueur) {
		throw new UnsupportedOperationException();
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getNomAdmin() {
		return this.nomAdmin;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMdp() {
		return this.mdp;
	}
}