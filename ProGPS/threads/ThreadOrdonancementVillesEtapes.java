package threads;

import java.util.*;

import exceptions.ExceptionGraph;
import exceptions.ExceptionRecherche;

import noyau.*;

public class ThreadOrdonancementVillesEtapes<V, T> extends Thread  {
	private MyWeightedMultigraph graph=null;
	private Ville villeDep = null;
	private Ville villeArr = null;
	private Set<Ville> nonOrdonnees = null;
	private List<Ville> ordonnees = null;
	private boolean upToDate = false;
	private boolean aEteModifie = false;
	private TreeMap<Integer, Ville> collection;
	
	public ThreadOrdonancementVillesEtapes(
			MyWeightedMultigraph graph,
			Ville villeDep,
			Ville villeArr, 
			Set<Ville> nonOrd){
		this.graph=graph;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		nonOrdonnees=nonOrd;
	}

	/**
	 * Méthode pour lire le retour du thread
	 * @return null si le calcul n'est pas fini, 
	 *  	sinon les villes dans le meilleur ordre 
	 */
	public List<Ville> getVillesOrdonnees(){
		if (upToDate && !aEteModifie) {
			return ordonnees;
		} else {
			return null;
		}
	}
	
	/**
	 * Méthode pour modifier les paramètres du thread
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
		upToDate=false;
		aEteModifie=true;
	}

	public void run() {
		while( !isInterrupted()) {
			if (!upToDate && graph!=null && villeDep!=null && villeArr!=null && nonOrdonnees!=null) {
				aEteModifie=false;
				ordonnees = new ArrayList<Ville>();
				int minVille;
				collection = new TreeMap<Integer, Ville>();
				this.triCheminsAPartirDe(villeDep);
				// Liste toutes les villes etape
				while (!this.nonOrdonnees.isEmpty()) {
					minVille=collection.firstKey();
					this.ordonnees.add(collection.get(minVille));
					this.nonOrdonnees.remove(minVille);
					this.triCheminsAPartirDe(collection.get(minVille));
				}
				// Si les paramètres n'ont pas changés, la recherche est à jour
				if (!aEteModifie)
					upToDate=true;
			}
		}
	}
	
	public void triCheminsAPartirDe(Ville v) {
		collection.clear();
		for (Ville uneVilleEtape : this.nonOrdonnees) {
			try {
				Itineraire leChemin = graph.trouverLeChemin(v, uneVilleEtape, null, null);
				collection.put(leChemin.getLongueurTotal(), uneVilleEtape);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*public int compare(Integer d1, Integer d2) {
		List<Integer> cles = new ArrayList<Integer>(collection.keySet());
		Integer v1, v2;
		v1=cles.get(d1);
		v2=cles.get(d2);
		if (v1>v2)
			return 1;
		else if (v2==v1)
			return 0;
		else return -1;
	}
	*/
}
