package noyau;

public class Admin {
	private String nomAdmin;
	private String mdp;
	SingletonProgps theProgps;
	
	public Admin(SingletonProgps leProGPS){
		theProgps=leProGPS;
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
	
	public boolean besoinRafraichirIti(Ville villeDevientIndispo){
		// Si la ville devient indispo et que l'user a son itinéraire qui y passe
		for (Troncon unTroncon : theProgps.getSonUser().getItineraireCourant().getLesTroncons()) {
			if(unTroncon.getSesVilles().contains(villeDevientIndispo))
				return true;
		}
		return false;
	}
	
	public boolean besoinRafraichirIti(Troncon tronconDevientIndispo){
		// Si la ville devient indispo et que l'user a son itinéraire qui y passe
		for (Troncon unTroncon : theProgps.getSonUser().getItineraireCourant().getLesTroncons()) {
			if(unTroncon.equals(tronconDevientIndispo))
				return true;
		}
		return false;
	}
	
	public boolean besoinRafraichirIti(Route routeDevientIndispo){
		// Si la ville devient indispo et que l'user a son itinéraire qui y passe
		for (Troncon unTroncon : theProgps.getSonUser().getItineraireCourant().getLesTroncons()) {
			if(unTroncon.getSaRoute().equals(routeDevientIndispo))
				return true;
		}
		return false;
	}
	
	public Itineraire rafraichirItineraireVille(){
		// Si la ville devient indispo, on fait recalculer l'user
		theProgps.getSonUser().rafraichirItineraire();
		return theProgps.getSonUser().getItineraireCourant();
	}
}