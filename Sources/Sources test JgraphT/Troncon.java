import java.util.List;
import java.util.Vector;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Troncon 
	extends DefaultWeightedEdge
	{
	private int vitesse;
	private int longueur;
	private boolean dispo;
	private List<Ville> sesVilles = new Vector<Ville>();
	//private List<Etat> setEtats = new Vector<Etat>();

	public Ville[] toSesVillesArray() {
		Ville[] lSesVilles_Temp = new Ville[this.sesVilles.size()];
		this.sesVilles.toArray(lSesVilles_Temp);
		return lSesVilles_Temp;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getVitesse() {
		return this.vitesse;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLongueur() {
		return this.longueur;
	}
}