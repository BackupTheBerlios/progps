package noyau;

public class Payant extends Etat {
	private float tarif;
	
	private static Payant instance;

	private Payant() {
	}

	public synchronized static Payant getInstance() {
		if (null == instance) {
			instance = new Payant();
		}
		return instance;
	}
	
	public String toString() {
		return "payant";
	}
	
	
}