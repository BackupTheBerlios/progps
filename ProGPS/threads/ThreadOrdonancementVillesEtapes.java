package threads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import noyau.Itineraire;
import noyau.MyWeightedMultigraph;
import noyau.Ville;

public class ThreadOrdonancementVillesEtapes<V, T> extends Thread  {
	private MyWeightedMultigraph graph=null;
	private Ville villeDep = null;
	private Ville villeArr = null;
	private Set<Ville> nonOrdonnees = new HashSet<Ville>();
	private List<Ville> ordonnees = new ArrayList<Ville>();
	private boolean upToDate = false;
	private boolean aEteModifie = false;
	private Set<Ville> nonOrdonneesModif=null;
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
		ordonnees=new ArrayList<Ville>();
	}

	/**
	 * Méthode pour lire le retour du thread
	 * @return null si le calcul n'est pas fini, 
	 *  	sinon les villes dans le meilleur ordre 
	 */
	public List<Ville> getVillesOrdonnees(){
		if(nonOrdonneesModif.size()==0)
			return new ArrayList<Ville>();
		if (upToDate) {
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
		this.nonOrdonneesModif = new HashSet<Ville>(nonOrdonnees);
		upToDate=false;
		aEteModifie=true;
	}

	public void run() {
		while( !isInterrupted()) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println(e.toString());
			}
			if(!upToDate && graph!=null && villeDep!=null && villeArr!=null && nonOrdonneesModif.size()==1){
				nonOrdonnees=nonOrdonneesModif;
				ordonnees=new ArrayList<Ville>(nonOrdonnees);
				upToDate=true;
			}
			if (!upToDate && graph!=null && villeDep!=null && villeArr!=null && nonOrdonneesModif.size()>1) {

				nonOrdonnees=new HashSet<Ville>(nonOrdonneesModif);
				aEteModifie=false;
				ordonnees = new ArrayList<Ville>();
				int minVille;
				collection = new TreeMap<Integer, Ville>();

				this.triCheminsAPartirDe(villeDep);
				// Liste toutes les villes etape
				while (!this.nonOrdonnees.isEmpty() && !aEteModifie) {
					minVille=collection.firstKey();
					this.ordonnees.add(collection.get(minVille));
					this.nonOrdonnees.remove(collection.get(minVille));

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
}
