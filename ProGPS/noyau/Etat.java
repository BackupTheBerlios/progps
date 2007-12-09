package noyau;


public abstract class Etat {
	private Troncon sonTroncon;
	
	public Etat(Troncon t) {
		this.sonTroncon=t;
	}
}