package noyau;

public class Touristique extends Etat {
	
	private String descriptif;
	private static Touristique instance;

	private Touristique() {
	}

	public synchronized static Touristique getInstance() {
		if (null == instance) {
			instance = new Touristique();
		}
		return instance;
	}
		
	public String toString() {
		return "touristique";
	}
	
}