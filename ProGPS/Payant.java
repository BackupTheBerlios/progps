import noyau.Etat;
import noyau.Troncon;


public class Payant extends Etat {
	private float tarif;
	
	public Payant(float t) {
		super();
		this.tarif=t;
	}
	
	public String toString() {
		return "payant";
	}
	
	
}