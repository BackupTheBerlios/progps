import noyau.Etat;
import noyau.Troncon;


public class Payant extends Etat {
	private float tarif;
	
	public Payant(Troncon tr,float t) {
		super(tr);
		this.tarif=t;
	}
	
	
}