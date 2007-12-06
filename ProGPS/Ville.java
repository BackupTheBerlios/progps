
public class Ville {
	private String idVille;
	private String nomVille;
	private boolean dispoVille;
	private int typeVille;
	private boolean touristique;

	/** Constructeur de ville
	 * Ne vérifie pas si une ville porte déjà le même nom !
	 * TODO Ajouter la vérification d'unicité
	 * 
	 * @param nomVille
	 * @param typeVille
	 * @param touristique
	 */
	public Ville(String nomVille, int typeVille, boolean touristique) {
		super();
		this.nomVille = nomVille;
		this.typeVille = typeVille;
		this.touristique = touristique;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public String getNomVille() {
		return this.nomVille;
	}

	public void setDispoVille(boolean dispoVille) {
		this.dispoVille = dispoVille;
	}

	public boolean isDispoVille() {
		return this.dispoVille;
	}

	public void setTypeVille(int typeVille) {
		this.typeVille = typeVille;
	}

	public int getTypeVille() {
		return this.typeVille;
	}
	
	public String toString(){
		return nomVille;
	}
}