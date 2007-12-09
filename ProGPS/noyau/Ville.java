package noyau;

public class Ville {
	private String idVille;
	private String nomVille;
	private boolean dispoVille;
	private int typeVille;
	private boolean touristique;

	/** Constructeur de ville
	 * 
	 * @param nomVille
	 */
	public Ville(String nomVille) {
		this.nomVille = nomVille;
	}
	/** Constructeur de ville
	 * 
	 * @param nomVille
	 * @param typeVille
	 * @param touristique
	 */
	public Ville(String nomVille, int typeVille, boolean touristique) {
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