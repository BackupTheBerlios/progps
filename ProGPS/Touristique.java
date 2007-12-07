
public class Touristique extends Etat {
	
	private String descriptif;
	
	public Touristique(Troncon tr, String d) {
		super(tr);
		this.descriptif=d;
	}
}