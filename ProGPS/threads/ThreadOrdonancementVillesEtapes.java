package threads;

import java.util.*;

import noyau.MyWeightedMultigraph;

public class ThreadOrdonancementVillesEtapes<Ville, Troncon> extends Thread {
	private MyWeightedMultigraph<Ville, Troncon> graph=null;
	private Ville villeDep = null;
	private Ville villeArr = null;
	private Set<Ville> nonOrdonnees = null;
	private List<Ville> ordonnees = null;
	
	public ThreadOrdonancementVillesEtapes(
			MyWeightedMultigraph<Ville, Troncon> graph,
			Set<Ville> nonOrd){
		this.graph=graph;
		nonOrdonnees=nonOrd;
	}

	/**
	 * Méthode pour lire le retour du thread
	 * @return null si le calcul n'est pas fini, 
	 *  	sinon les villes dans le meilleur ordre 
	 */
	public List<Ville> getVillesOrdonnees(){
		return ordonnees;
	}
	
	/**
	 * Méthode pour modifier les paramètres du thread
	 * @param graph : Le réseau routier
	 * @param villeDep : La ville de départ de l'iti
	 * @param villeArr : Villeille d'arrivée de l'iti
	 * @param nonOrdonnees : un Set de villes étapes (peut être null)
	 */
	public void setVillesEtapes(
			Ville villeDep,
			Ville villeArr, 
			Set<Ville> nonOrdonnees) {
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.nonOrdonnees = nonOrdonnees;
	}

	public void run() {
		while( !isInterrupted()) {
			// 
		}    		
	}
}
