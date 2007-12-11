package noyau;


public class Touristique extends Etat {
	
	private String descriptif;
	
	public Touristique(String d) {
		super();
		this.descriptif=d;
	}
	
	public String toString() {
		return "touristique";
	}
	
}