


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
	private Route saRoute;
	//private List<Etat> setEtats = new Vector<Etat>();
	
	public void genererValeursAleatoires(){
		// 50 <= Vitesse <= 130 
		vitesse=Math.round((float)Math.random()*80)+50;
		// 0 <= Longueur <= 300
		longueur=Math.round((float)Math.random()*300);
	}

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
	
	public Route getSaRoute() {
		return saRoute;
	}

	public void setSaRoute(Route saRoute) {
		this.saRoute = saRoute;
	}
}